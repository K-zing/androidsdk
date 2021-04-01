package com.kzingsdk.core;

import android.content.Context;
import android.util.Log;

import com.kzingsdk.requests.KzingCallBack;
import com.kzingsdk.requests.KzingRequestException;
import com.kzingsdk.util.Base64Utils;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.MD5Utils;
import com.kzingsdk.util.RSAUtils;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;
import org.reactivestreams.Publisher;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
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
    protected final String ACTION_OBJECT_NAME = "url";
    protected final String DATA_JSON_OBJECT_NAME = "data";
    protected final String SIGN_OBJECT_NAME = "sign";
    protected final String CLIENT_OBJECT_NAME = "aid";
    protected final String PLATFORM_NAME = "android";
    private final int DOMAIN_USE_TIME = 200;
    private static int requestTimeoutMs = 10 * 1000;

    private String choseDomain = "";
    private static int domainUsedCount = 0;
    private static String lastUsedIP = "";
    private final String defaultIP = "https://tvwkkq8k9e7grjbw49pk.jumzxxtu3j.com";
    private final String defaultBetterIP = "https://fsr5vqdhsspsrtz6fl93.jumzxxtu3j.com/";
    private static HashSet<String> failedIP = null;
    private final ArrayList<String> API_URL_LIST = new ArrayList<String>() {{
        add(defaultIP);
        add("https://mcxyfv3tdbq9jap3vexg.jumzxxtu3j.com");
        add("https://21q3bnvp.ui2now.com");
        add("https://szburu19.semiconductorTech.net");
        add("https://weijinlai.com");
        add("https://hsrjah.com");
        add("https://nqj4hrthz4dtaytvbxnu.t8arxezlq7.com");
    }};

    private final ArrayList<String> API_URL_LIST_BETTER = new ArrayList<String>() {{
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
                                .addHeader("X-Kzing-APIs-Authorization", "AGnAiqwHF9B9EYFnCpfW324Tm3gSoODr")
                                .build();
                        return chain.proceed(request);
                    })
                    .addInterceptor(chain -> {
                        Request originalRequest = chain.request();
                        showLogDebug(originalRequest, chain);
                        return chain.proceed(originalRequest);
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
        if (lastUsedIP.equalsIgnoreCase("") || domainUsedCount > DOMAIN_USE_TIME || failedIP.contains(lastUsedIP)) {
            setupTask = findFastestIPTask(context);
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

    private Observable<String> findFastestIPTask(Context context) {
        ArrayList<String> toFindList = isUseBetterUrl(context) ? API_URL_LIST_BETTER : API_URL_LIST;
        if (failedIP.size() >= toFindList.size()) {
            failedIP.clear();
        }
        ArrayList<FutureTask<String>> futureTasks = createPingIPTasks(toFindList, failedIP);
        final ExecutorService executor = Executors.newFixedThreadPool(toFindList.size());
        String fastestIP = Flowable.fromIterable(futureTasks)
                .parallel(toFindList.size())
                .runOn(Schedulers.newThread())
                .flatMap((Function<FutureTask<String>, Publisher<String>>) futureTask -> {
                    executor.submit(futureTask);
                    return Flowable.fromFuture(futureTask, KzingSDK.getInstance().getPingCheckTimeoutMs(), TimeUnit.MILLISECONDS)
                            .onErrorReturnItem("")
                            .doOnNext(CoreRequest.this::log);
                })
                .sequential()
                .doOnNext(s -> {
                    if (executor != null && !executor.isShutdown()) {
                        executor.shutdown();
                    }
                    if (s.equals("")) {
                        throw new Exception();
                    }
                })
                .onErrorReturnItem(defaultIP)
                .blockingFirst();
        return Observable.just(fastestIP);
    }

    private ArrayList<FutureTask<String>> createPingIPTasks(ArrayList<String> ipList, HashSet<String> toCheckFailedSet) {
        ArrayList<FutureTask<String>> futureTasks = new ArrayList<>();
        for (int i = 0; i < ipList.size(); i++) {
            String ip = ipList.get(i);
            if (toCheckFailedSet.contains(ip)) {
                continue;
            }
            final FutureTask<String> future = new FutureTask<>(() -> {
                pingIP(ip);
                return ip;
            });
            futureTasks.add(future);
        }
        return futureTasks;
    }

    private Integer pingIP(final String ip) {
        int ping = Integer.MAX_VALUE;
        try {
            long startTime = System.currentTimeMillis();
            URL toPingURL = new URL(ip);
            URLConnection connection = toPingURL.openConnection();
            connection.setConnectTimeout(2000);
            connection.connect();
            connection.getInputStream().close();
            ping = (int) (System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            e.printStackTrace();
            log("pingIP IOException : " + e.getMessage() + " " + ip);
        }
        log("pingIP : " + ip + " - " + (ping == Integer.MAX_VALUE ? "Timeout" : ping + "ms"));
        return ping;
    }

    private String pickRandomIP() {
        Random rand = new Random();
        int randomNum = rand.nextInt(API_URL_LIST.size());
        log("pickRandomIP : " + API_URL_LIST.get(randomNum));
        return API_URL_LIST.get(randomNum);
    }

    private void showLogDebug(Request request, Interceptor.Chain chain) throws IOException {
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
            String dataRSA = "";
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
                .flatMap((Function<CallSDKService, Observable<Response<String>>>) callSDKService -> {
                    String requestParam = generateEncryptedParams();
                    Observable<Response<String>> responseObservable = callSDKService.doRequestService(RequestBody.create(MediaType.parse("application/json"), requestParam));
                    return responseObservable;
                });
    }

    protected Observable<JSONObject> baseExecute(Context context) {
        OkHttpClient client = getOkHttpClient();
        final Function<String, Observable<Response<String>>> checkParams = failMsg -> {
            if (failMsg.equals(""))
                return initRequestService(setupRetrofit(context, client));
            else
                throw new KzingException(failMsg);
        };
        return validateParams()
                .timeout(KzingSDK.getInstance().getRequestTimeoutMs(), TimeUnit.MILLISECONDS)
                .flatMap(checkParams)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(showReturnLog)
                .doOnNext(checkResponseCodes)
                .map(mapToGetData)
                ;
    }

    private final Consumer<Response<String>> showReturnLog = response -> {
        if (response == null) {
            throw new KzingRequestException(null, null, "showReturnLog : " + response.body(), choseDomain, "");
        }
        log("Result " + response.code() + " : " + response.toString());
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

    private final Function<Response<String>, JSONObject> mapToGetData = stringResponse -> {
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
                } else {
                    kzingCallBack.onFailure(new KzingException(throwable.toString()));
                }
            }
        }
    };

    protected void log(String msg) {
        Log.d(TAG, msg);
    }

}
