package com.kzingsdk.core;

import android.app.Application;
import android.content.Context;

import com.kzingsdk.entity.LangCode;
import com.kzingsdk.entity.gameplatform.GamePlatformContainer;
import com.kzingsdk.entity.gameplatform.GamePlatformCreator;
import com.kzingsdk.requests.GetGameListAPI;
import com.kzingsdk.requests.KzingAPI;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by wing.lee@evergreensystemltd.com
 */
public final class KzingSDK {

    private static KzingSDK instance;
    private String vcToken;
    private String ccToken;
    private String aid;
    private String md5Key;
    private String dataRsaKey;
    private String basicRsaKey;
    private String apiKey;
    private String sessionId;
    private LangCode langCode = LangCode.CHS;

    private final int DEFAUL_REQUEST_TIMEOUT_MS = 1000 * 20;
    private final int DEFAUL_PING_CHECK_TIMEOUT_MS = 1000 * 2;
    private int requestTimeoutMs = DEFAUL_REQUEST_TIMEOUT_MS;
    private int pingCheckTimeoutMs = DEFAUL_PING_CHECK_TIMEOUT_MS;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private KzingSDK() {
    }

    void validate() {
        if (apiKey == null) {
            throw new KzingException("ApiKey is not set yet.");
        }
    }

    public synchronized static KzingSDK getInstance() {
        if (instance == null) {
            instance = new KzingSDK();
        }
        return instance;
    }

    /**
     * To start using KzingSDK, you need to register a API Key for you own app first.
     * Will automatically load cache if you did cached any encryption key by KzingSDK.
     * <p>
     * Please call {@link #setBasicRsaKey(String)} and {@link #setDataRsaKey(String)} after init to finish the basic setup. Get these keys from {@link KzingAPI#getBasicEncryptKey()} and {@link KzingAPI#getEncryptKey()}
     * <p>
     * Cache will not be load with this init function.
     *
     * @param apiKey API Key of your own APP. Please make sure it is private.
     */
    public void init(String apiKey) {
        init(apiKey, null);
    }

    /**
     * To start using KzingSDK, you need to register a API Key for you own app first.
     * Will automatically load cache if you did cached any encryption key by KzingSDK.
     * <p>
     * Please call {@link #setBasicRsaKey(String)} and {@link #setDataRsaKey(String)} after init to finish the basic setup.
     * Get these keys from {@link KzingAPI#getBasicEncryptKey()} and {@link KzingAPI#getEncryptKey()}
     * <p>
     * You may handle caching for both key yourself, or use {@link #cacheBasicRsaKey(Context)} and {@link #cacheDataRsaKey(Context)} provided by KzingSDK.
     *
     * @param context From {@link Application#getBaseContext()} is recommended. Cache will not be load if context is null.
     * @param apiKey  API Key of your own APP.
     */
    public void init(String apiKey, Context context) {
        this.apiKey = apiKey;
        if (context != null) {
            loadTokenCache(context);
            loadKeysCache(context);
            loadLangCodeCache(context);
        }
    }

    /**
     * Current API key will be replaced. Will need to update encryption keys after API key is replaced.
     *
     * @param apiKey New APIKey to replace the old key.
     **/
    public void replaceApiKey(String apiKey) {
        this.apiKey = apiKey;
    }


    public LangCode getLangCode() {
        return langCode;
    }

    public void setLangCode(LangCode langCode) {
        this.langCode = langCode;

    }

    public void cacheLangCode(Context context) {
        if (dataRsaKey != null) {
            SharePrefUtil.putString(context, Constant.Pref.LANGCODE, langCode.name());
        }
    }

    public String getDataRsaKey() {
        return dataRsaKey;
    }

    /**
     * Dynamic encrypt key which is necessary for all API call.
     *
     * @param dataRsaKey Get this key from {@link KzingAPI#getEncryptKey()}
     */
    public void setDataRsaKey(String dataRsaKey) {
        this.dataRsaKey = dataRsaKey;
    }

    public String getBasicRsaKey() {
        return basicRsaKey;
    }

    /**
     * Basic encrypt key which is necessary for all API call.
     *
     * @param basicRsaKey . Please make sure it is private.
     */
    public void setBasicRsaKey(String basicRsaKey) {
        this.basicRsaKey = basicRsaKey;
    }

    String getMd5Key() {
        return md5Key;
    }

    /**
     * MD5 key which is necessary for all API call.
     *
     * @param md5Key MD5 Key of your own APP. Please make sure it is private.
     */
    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key;
    }

    /**
     * Work only when {@link #getDataRsaKey()} is not null.
     */
    public void cacheDataRsaKey(Context context) {
        if (dataRsaKey != null) {
            SharePrefUtil.putString(context, Constant.Pref.DATAKEY, this.dataRsaKey);
        }
    }

    /**
     * Work only when {@link #getBasicRsaKey()} is not null.
     */
    public void cacheBasicRsaKey(Context context) {
        if (basicRsaKey != null) {
            SharePrefUtil.putString(context, Constant.Pref.BASICKEY, this.basicRsaKey);
        }
    }

    /**
     * Will clear both encryption key.
     */
    public void clearKeysCache(Context context) {
        SharePrefUtil.putString(context, Constant.Pref.BASICKEY, null);
        SharePrefUtil.putString(context, Constant.Pref.DATAKEY, null);
    }

    /**
     * @param context From {@link android.app.Application#getBaseContext()} is recommended. Will do nothing if context is null.
     */
    private void loadTokenCache(Context context) {
        if (context == null) {
            return;
        }
        String vc = SharePrefUtil.getString(context, Constant.Pref.VCTOKEN, null);
        setVcToken(vc);
        String cc = SharePrefUtil.getString(context, Constant.Pref.CCTOKEN, null);
        setCcToken(cc);
    }

    private void loadLangCodeCache(Context context) {
        if (context == null) {
            return;
        }
        LangCode langCode = LangCode.valueOfName(SharePrefUtil.getString(context, Constant.Pref.LANGCODE, LangCode.CHS.name()));
        setLangCode(langCode);
    }

    public void clearLangCodeCache(Context context) {
        if (context == null) {
            return;
        }
        SharePrefUtil.putString(context, Constant.Pref.LANGCODE, null);
    }


    /**
     * Clear player tokens. Logout locally without disabling the token on server. APIs for login only will fall to fail.
     */
    public void clearTokenCache(Context context) {
        if (context == null) {
            return;
        }
        SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, null);
        SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, null);
    }

    /**
     * Check if KzingSDK has player token saved.
     */
    public boolean hasToken() {
        return vcToken != null && ccToken != null;
    }

    /**
     * @param context From {@link android.app.Application#getBaseContext()} is recommended. Will do nothing if context is null.
     */
    private void loadKeysCache(Context context) {
        if (context == null) {
            return;
        }
        String basicRsaKey = SharePrefUtil.getString(context, Constant.Pref.BASICKEY, null);
        setBasicRsaKey(basicRsaKey);
        String dataRsaKey = SharePrefUtil.getString(context, Constant.Pref.DATAKEY, null);
        setDataRsaKey(dataRsaKey);
    }


    /**
     * Set you own user's login token to SDK without using  {@link KzingAPI#login()} without saving in shared preferences.
     * Use {@link KzingSDK#setCustomTokensWithCache(String, String, Context)} if you need to.
     *
     * @param ccToken
     * @param vcToken
     */
    public void setCustomTokens(String ccToken, String vcToken) {
        this.ccToken = ccToken;
        this.vcToken = vcToken;
    }

    /**
     * Set you own user's login token to SDK without using  {@link KzingAPI#login()} and save tokens in shared preferences.
     *
     * @param ccToken
     * @param vcToken
     * @param context
     */
    public void setCustomTokensWithCache(String ccToken, String vcToken, Context context) {
        setCustomTokens(ccToken, vcToken);
        if (context == null) {
            return;
        }
        SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
        SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
    }

    /**
     * Try do load gameplatforms from cache, only work when {@link KzingAPI#getGameList()} is called before. Return <b>null</b>if not exist.
     *
     * @param context      Will do nothing if context is null.
     * @param needSubGames Equal to {@link GetGameListAPI#setRequestSubGame(boolean)}.
     */
    public ArrayList<GamePlatformContainer> loadGamePlatformFromCache(Context context, boolean needSubGames) {
        if (context == null) {
            return null;
        }
        final GamePlatformCreator gamePlatformCreator = new GamePlatformCreator();
        String gamePlatformString = SharePrefUtil.getString(context, Constant.Pref.GAMEPLATFORM, null);
        String gamePlatformChildString = SharePrefUtil.getString(context, Constant.Pref.GAMEPLATFORMCHILD, null);
        JSONArray gamePlatformJSON;
        try {
            gamePlatformJSON = new JSONArray(gamePlatformString);
        } catch (JSONException e) {
            gamePlatformJSON = null;
        }
        JSONArray gamePlatformChildJSON = null;
        if (needSubGames) {
            try {
                gamePlatformChildJSON = new JSONArray(gamePlatformChildString);
            } catch (JSONException e) {
                gamePlatformChildJSON = null;
            }
        }
        return gamePlatformCreator
                .setContainerJsonArray(gamePlatformJSON)
                .setSubGameJsonObject(gamePlatformChildJSON)
                .build();
    }

    public String getApiKey() {
        return apiKey;
    }

    public int getRequestTimeoutMs() {
        return requestTimeoutMs;
    }

    public int getPingCheckTimeoutMs() {
        return pingCheckTimeoutMs;
    }

    public void setRequestTimeoutMs(int requestTimeoutMs) {
        this.requestTimeoutMs = requestTimeoutMs;
    }

    public void setPingCheckTimeoutMs(int pingCheckTimeoutMs) {
        this.pingCheckTimeoutMs = pingCheckTimeoutMs;
    }

    String getVcToken() {
        return vcToken;
    }

    void setVcToken(String vcToken) {
        this.vcToken = vcToken;
    }

    String getCcToken() {
        return ccToken;
    }

    void setCcToken(String ccToken) {
        this.ccToken = ccToken;
    }

    String getSessionId() {
        return sessionId;
    }

    void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }


}
