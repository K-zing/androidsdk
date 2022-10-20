package com.kzingsdk.core;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.kzingsdk.BuildConfig;
import com.kzingsdk.requests.KzingCallBack;
import com.kzingsdk.requests.KzingRequestException;
import com.kzingsdk.requests.RequireCurrency;
import com.kzingsdk.util.Base64Utils;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.MD5Utils;
import com.kzingsdk.util.RSAUtils;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public abstract class CoreRequest {

    private static OkHttpClient okHttpClient;
    protected final String CLIENT_KEY_OBJECT_NAME = "key";
    protected final String PLATFORM_OBJECT_NAME = "os";
    protected final String DOMAIN_NAME = "sdkDomain";
    protected final String ACTION_OBJECT_NAME = "url";
    protected final String ACTION_OBJECT_NAME_D11 = "d11url";
    protected final String ACTION_OBJECT_NAME_K36 = "k36url";
    protected final String DATA_JSON_OBJECT_NAME = "data";
    protected final String SIGN_OBJECT_NAME = "sign";
    protected final String CLIENT_OBJECT_NAME = "aid";
    protected final String PLATFORM_NAME = "android";
    private static int requestTimeoutMs = 10 * 1000;

    protected boolean dynamicDomainChanged = false;
    private boolean usingDynamicDomain = false;
    private boolean ignoreStatusCode = false;
    private String choseDomain = "";
    private final int MAX_DOMAIN_USE = 200;
    private static int domainUsedCount = 0;
    private static String lastUsedIP = "";
    private static String nextIP = "";
    private static HashSet<String> failedIP = null;
    private static HashSet<String> dynamicDomainSet = new HashSet<>();

    private final ArrayList<String> PORT_LIST = new ArrayList<String>() {{
//        add("9496");
//        add("9587");
//        add("9999");
//        add("9487");
//        add("9119");
//        add("9190");
//        add("9250");
//        add("9009");
//        add("8888");
//        add("8998");
        add("");
    }};

    private final HashSet<String> API_URL_SET = new HashSet<String>() {{
//        add("https://miracle-apis-dev.qijixitong.com");
        String defaultIP = "https://tvwkkq8k9e7grjbw49pk.jumzxxtu3j.com";
        add(defaultIP);
        add("https://mcxyfv3tdbq9jap3vexg.jumzxxtu3j.com");
        add("https://21q3bnvp.ui2now.com");
        add("https://szburu19.semiconductorTech.net");
        add("https://weijinlai.com");
        add("https://hsrjah.com");
        add("https://nqj4hrthz4dtaytvbxnu.t8arxezlq7.com");
        add("https://nwlzzv.marnnfnzqpnz.com");
        add("https://arxzjq.epmmthxqvnfn.com");
        add("https://erpnfh.qutfdbjapxmd.com");
        add("https://xjgnfy.pzgktkvcwbch.com");
        add("https://pnoeee.draxetggrjqu.com");
    }};

    private final HashSet<String> API_URL_SET_BETTER = new HashSet<String>() {{
//        add("https://miracle-apis-dev.qijixitong.com");
        String defaultBetterIP = "https://fsr5vqdhsspsrtz6fl93.jumzxxtu3j.com/";
        add(defaultBetterIP);
        add("https://4jqz2j97.ui4now.com");
    }};

    protected ArrayList<KzingCallBack> kzingCallBackList = new ArrayList<>();
    private final String TAG = "CoreRequest";

    interface CallSDKService {
        @POST("/")
        @Headers("Content-Type: application/text")
        Observable<Response<String>> doRequestService(
                @Body RequestBody json);
    }

    /**
     * All callbacks will be ignored when using RXJava route.
     */
    public abstract Observable<?> requestRx(Context context);

    public abstract void request(Context context);

    protected abstract String getAction();

    protected String getD11Action() {
        return "";
    }

    protected String getK36Action() {
        return "";
    }

    /*
     *  Override if API need to validate params first. Empty means success.
     */
    protected Observable<String> validateParams() {
        return Observable.just("");
    }

    protected CoreRequest() {
        if (failedIP == null) {
            failedIP = new HashSet<>();
        }
    }


    private OkHttpClient getOkHttpClient() {
        if (okHttpClient == null
                || okHttpClient.connectionPool().connectionCount() == 0
                || requestTimeoutMs != KzingSDK.getInstance().getRequestTimeoutMs()
        ) {
            requestTimeoutMs = KzingSDK.getInstance().getRequestTimeoutMs();
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(requestTimeoutMs, TimeUnit.MILLISECONDS)
                    .readTimeout(requestTimeoutMs, TimeUnit.MILLISECONDS)
                    .writeTimeout(requestTimeoutMs, TimeUnit.MILLISECONDS)
                    .addInterceptor(chain -> {
                        Request request = chain.request().newBuilder()
                                .addHeader("User-Agent","KzingAndroidSDK:"+BuildConfig.VERSION_NAME)
                                .build();
                        showLogDebug(request);
                        return chain.proceed(request);
                    })
                    .build();
        }
        return okHttpClient;

    }

    private boolean isUseBetterUrl(Context context) {
        return SharePrefUtil.getString(context, Constant.Pref.USE_BETTER_URL, "0").equals("1");
    }

    private Observable<Retrofit> setupRetrofit(final Context context, final OkHttpClient client) {
        Observable<String> setupTask;
        if (lastUsedIP.equalsIgnoreCase("")) {
            setupTask = Observable.just(randomIPForFirstLoad(context));
            prepareNextIpBackground(context);
        } else if (domainUsedCount > MAX_DOMAIN_USE || failedIP.contains(lastUsedIP)) {
            setupTask = Observable.just(nextIP);
            prepareNextIpBackground(context);
            domainUsedCount = 0;
        } else {
            setupTask = Observable.just(lastUsedIP);
        }
        return setupTask.map(s -> {
            ++domainUsedCount;
            choseDomain = s;
            lastUsedIP = s;
            return new Retrofit.Builder()
                    .client(client)
                    .baseUrl(s)
                    .addConverterFactory(KzingConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        });
    }


    private HashSet<String> chooseDomainSet(Context context) {
        String domainJSONString = SharePrefUtil.getString(context, Constant.Pref.DOMAIN, null);
        HashSet<String> toFindSet = new HashSet<>();
        try {
            if (domainJSONString == null) {
                throw new JSONException("");
            }
            if (dynamicDomainSet.size() > 0 && !dynamicDomainChanged)
                return dynamicDomainSet;
            dynamicDomainChanged = false;
            failedIP.clear();
            JSONObject domainJSON = new JSONObject(domainJSONString);
            JSONObject defaultObject = domainJSON.optJSONObject("default");
            if (defaultObject == null) {
                throw new JSONException("");
            }
            JSONArray aArray = defaultObject.optJSONArray("A");
            if (aArray == null || aArray.length() <= 0) {
                throw new JSONException("");
            }
            for (int i = 0; i < aArray.length(); i++) {
                String domain = aArray.optString(i);
                toFindSet.add(domain);
            }
            JSONArray bArray = defaultObject.optJSONArray("B");
            if (bArray == null || bArray.length() <= 0) {
                return toFindSet;
            }
            for (int i = 0; i < bArray.length(); i++) {
                String domain = bArray.optString(i);
                toFindSet.add(domain);
            }
            if (toFindSet.size() <= 0) {
                throw new JSONException("");
            }
            usingDynamicDomain = true;
            dynamicDomainSet = toFindSet;
            return dynamicDomainSet;
        } catch (JSONException ignored) {
        }
        usingDynamicDomain = false;
        toFindSet = isUseBetterUrl(context) ? API_URL_SET_BETTER : API_URL_SET;
        toFindSet = toFindIpWithPortSet(toFindSet);
        return toFindSet;
    }

    private String randomIPForFirstLoad(Context context) {
        HashSet<String> toFindSet = getIPSet(context);
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int pos = random.nextInt(toFindSet.size());
        return new ArrayList<>(toFindSet).get(pos);
    }

    private HashSet<String> getIPSet(Context context) {
        HashSet<String> toFindSet;
        if (KzingSDK.getInstance().isUseCustomUrl()) {
            toFindSet = KzingSDK.getInstance().getCustomUrlSet();
        } else {
            toFindSet = chooseDomainSet(context);
        }
        return toFindSet;
    }

    private void prepareNextIpBackground(Context context) {
        HashSet<String> toFindSet = getIPSet(context);
        if (failedIP.equals(toFindSet) || failedIP.size() >= toFindSet.size()) {
            if (KzingSDK.getInstance().isUseCustomUrl()) {
                KzingSDK.getInstance().setUseCustomUrl(false);
                toFindSet = chooseDomainSet(context);
            }
            if (usingDynamicDomain) {
                usingDynamicDomain = false;
                dynamicDomainChanged = false;
                dynamicDomainSet.clear();
                toFindSet = chooseDomainSet(context);
            }
            failedIP.clear();
        }
        final HashSet<String> toFindSet2 = toFindSet;
        final HashMap<String, Long> ipSpeedMap = new HashMap<>();
        AsyncTask.execute(() -> {
            for (String ip : toFindSet2) {
                if (failedIP.contains(ip)) {
                    continue;
                }
                long time = System.currentTimeMillis();
                String result = pingIP(ip);
                if (!result.equals("")) {
                    ipSpeedMap.put(result, System.currentTimeMillis() - time);
                    if (nextIP.equals(""))
                        nextIP = ip;
                }
            }
            long ping = Long.MAX_VALUE;
            for (Map.Entry<String, Long> entry : ipSpeedMap.entrySet()) {
                if (entry.getValue() < ping) {
                    nextIP = entry.getKey();
                }
            }
        });
    }

    private HashSet<String> toFindIpWithPortSet(HashSet<String> toFindSet) {
        HashSet<String> toFindIpWithPortSet = new HashSet<>();
        for (String ip : toFindSet) {
            for (String port : PORT_LIST) {
                String pingIp = ip + (!KzingSDK.getInstance().isUseCustomUrl() && port.length() > 0 ? (":" + port) : "");
                toFindIpWithPortSet.add(pingIp);
            }
        }
        return toFindIpWithPortSet;
    }

    private String pingIP(final String ip) {
        try {
            URL toPingURL = new URL(ip);
            URLConnection connection = toPingURL.openConnection();
            connection.setConnectTimeout(2000);
            connection.connect();
            connection.getInputStream().close();
        } catch (Exception e) {
            return "";
        }
        return ip;
    }

    private void showLogDebug(Request request) throws IOException {
        log(request.toString());
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            Charset charset = StandardCharsets.UTF_8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            if (charset != null) {
                log(buffer.readString(charset));
            }
        } else {
            log("requestBody == null");
        }
    }

    protected JSONObject generateParamsJson() {
        try {
            JSONObject jsonData = new JSONObject();
            if (KzingSDK.getInstance().getVcToken() != null) {
                jsonData.put("vc", KzingSDK.getInstance().getVcToken());
            }
            if (KzingSDK.getInstance().getCcToken() != null) {
                jsonData.put("cc", KzingSDK.getInstance().getCcToken());
            }
            if (KzingSDK.getInstance().getLangCode() != null) {
                jsonData.put("langcode", KzingSDK.getInstance().getLangCode().name());
            }
            if (KzingSDK.getInstance().getAid() != null) {
                jsonData.put(CLIENT_OBJECT_NAME, KzingSDK.getInstance().getAid());
            }
            jsonData.put("device", "android");
            jsonData.put("platform", "an");
            jsonData.put("sdkversion", BuildConfig.VERSION_NAME);
            jsonData.put(DOMAIN_NAME, lastUsedIP);
            if (this instanceof RequireCurrency) {
                String currency = ((RequireCurrency) this).getCurrency();
                if (currency != null)
                    jsonData.put("currency", currency);
            }
            return jsonData;
        } catch (JSONException e) {
            throw new KzingException(e.getMessage());
        }
    }

    protected String generateEncryptedParams() {
        try {
            if (KzingSDK.getInstance().getBasicRsaKey() == null) {
                throw new KzingException("BasicRsaKey is not set yet.");
            }
            if (KzingSDK.getInstance().getMd5Key() == null) {
                throw new KzingException("MD5 Key is not set yet.");
            }
            JSONObject data = generateParamsJson();
            log("------");
            log(data.toString());
            String dataRSA;
            if (getAction().equals("c6ace99")) {
                dataRSA = data.toString();
            } else {
                if (KzingSDK.getInstance().getDataRsaKey() == null) {
                    throw new KzingException("DataRsaKey is not set yet.");
                }
                PublicKey publicKey = RSAUtils.getPublicKey(Base64Utils.decode(KzingSDK.getInstance().getDataRsaKey()));
                byte[] encryptByte = RSAUtils.encryptLongData(data.toString().getBytes(), publicKey);
                dataRSA = Base64Utils.encode(encryptByte);
            }
            JSONObject dataWithKey = new JSONObject();
            dataWithKey.put(DATA_JSON_OBJECT_NAME, dataRSA);
            dataWithKey.put(CLIENT_KEY_OBJECT_NAME, getApiKey());
            dataWithKey.put(ACTION_OBJECT_NAME, getAction());
            dataWithKey.put(ACTION_OBJECT_NAME_D11, getD11Action());
            dataWithKey.put(ACTION_OBJECT_NAME_K36, getK36Action());
            dataWithKey.put(PLATFORM_OBJECT_NAME, PLATFORM_NAME);
            dataWithKey.put(SIGN_OBJECT_NAME, MD5Utils.md5(dataRSA + KzingSDK.getInstance().getMd5Key()).toUpperCase());
            log(dataWithKey.toString());
            PublicKey publicKeyBasic = RSAUtils.getPublicKey(Base64Utils.decode(KzingSDK.getInstance().getBasicRsaKey()));
            byte[] encryptByteBasic = RSAUtils.encryptLongData(dataWithKey.toString().getBytes(), publicKeyBasic);
            return Base64Utils.encode(encryptByteBasic);
        } catch (JSONException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new KzingException(e.getMessage());
        }
    }

    private String getApiKey() {
        return KzingSDK.getInstance().getApiKey();
    }

    private Observable<Response<String>> initRequestService(Observable<Retrofit> retrofitObservable) {
        return retrofitObservable
                .map(retrofit -> retrofit.create(CallSDKService.class))
                .flatMap((Function<CallSDKService, Observable<Response<String>>>) callSDKService ->
                        callSDKService.doRequestService(RequestBody.create(MediaType.parse("application/json"), generateEncryptedParams()))
                );
    }

    protected Observable<JSONObject> baseExecute(Context context) {
        OkHttpClient client = getOkHttpClient();
        final Function<String, Observable<Response<String>>> checkParams = failMsg -> {
            if (failMsg.equals("")) {
                return initRequestService(setupRetrofit(context, client));
            } else
                throw new KzingException(failMsg);
        };
        Observable<Response<String>> baseExecuteFlow = validateParams()
                .timeout(KzingSDK.getInstance().getRequestTimeoutMs(), TimeUnit.MILLISECONDS)
                .flatMap(checkParams)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(showReturnLog);
        if (!ignoreStatusCode) {
            baseExecuteFlow = baseExecuteFlow.doOnNext(checkResponseCodes);
        }
        return baseExecuteFlow.map(mapToGetData);
    }

    private final Consumer<Response<String>> showReturnLog = response -> {
        if (response == null) {
            throw new KzingRequestException(null, null, "showReturnLog : response == null", choseDomain, "");
        }
        log("Result " + response.code() + " : " + response);
        log("Result body : " + response.body());
    };

    private final Consumer<Response<String>> checkResponseCodes = response -> {
        int statusCode = response.code();
        int kzingCode = 0;
        if (response.body() != null) {
            try {
                JSONObject responseJson = new JSONObject(response.body());
                kzingCode = responseJson.optInt("status", 0);
                String errorMsg = responseJson.optString("msg", "");
                String apiPath = responseJson.optString("apiPath", "");
                if (kzingCode != 0 && !errorMsg.isEmpty()) {
                    throw new KzingRequestException(statusCode, kzingCode, errorMsg, choseDomain, apiPath);
                }
            } catch (JSONException e) {
                throw new KzingRequestException(statusCode, kzingCode, "Unknown response error : " + response.body(), choseDomain, "");
            }
        }
        if (statusCode != 200 || kzingCode != 0) {
            failedIP.add(lastUsedIP);
            String errorBody = "";
            try {
                if (response.errorBody() != null) {
                    errorBody = response.errorBody().string();
                }
            } catch (IOException e) {
                errorBody = "Response is empty.";
            }
            throw new KzingRequestException(statusCode, kzingCode, errorBody, choseDomain, "");
        }
    };

    protected final Function<Response<String>, JSONObject> mapToGetData = stringResponse -> {
        String body = "";
        try {
            body = stringResponse.body();
            JSONObject responseJson = new JSONObject(body);
            if (responseJson.optJSONArray("data") != null) {
                JSONObject responseArrayJson = new JSONObject();
                responseArrayJson.put("data", responseJson.optJSONArray("data"));
                responseArrayJson.put("msg", responseJson.optString("msg", ""));
                return responseArrayJson;
            }
            if (responseJson.optJSONObject("data") != null) {
                JSONObject dataJSONObject = responseJson.optJSONObject("data");
                if (dataJSONObject.optString("msg", "").length() == 0) {
                    dataJSONObject.put("msg", responseJson.optString("msg", ""));
                }
                return responseJson.optJSONObject("data");
            }
            return new JSONObject();
        } catch (JSONException ignored) {
            throw new KzingException("Unknown response error : " + body);
        }
    };


    protected void setLoginTokens(String vcToken, String ccToken) {
        KzingSDK.getInstance().setCcToken(ccToken);
        KzingSDK.getInstance().setVcToken(vcToken);
    }

    protected void setSessionId(String sessionId) {
        KzingSDK.getInstance().setSessionId(sessionId);
    }

    public String getChoseDomain() {
        return choseDomain;
    }

    protected String getSessionId() {
        return KzingSDK.getInstance().getSessionId();
    }

    public void clearCallBackList() {
        kzingCallBackList = new ArrayList<>();
    }

    protected final Consumer<Throwable> defaultOnErrorConsumer = throwable -> {
        log(throwable.toString());
        if (kzingCallBackList.size() > 0) {
            for (KzingCallBack kzingCallBack : kzingCallBackList) {
                if (throwable instanceof KzingRequestException) {
                    kzingCallBack.onFailure((KzingRequestException) throwable);
                } else if (throwable instanceof KzingException) {
                    kzingCallBack.onFailure((KzingException) throwable);
                } else if (throwable instanceof java.net.ConnectException) {
                    failedIP.add(lastUsedIP);
                    kzingCallBack.onFailure(new KzingException(throwable.toString()));
                } else {
                    kzingCallBack.onFailure(new KzingException(throwable.toString()));
                }
            }
        }
    };

    public CoreRequest setIgnoreStatusCode(boolean ignoreStatusCode) {
        this.ignoreStatusCode = ignoreStatusCode;
        return this;
    }

    protected void log(String msg) {
        Log.d(TAG, msg);
    }

}
