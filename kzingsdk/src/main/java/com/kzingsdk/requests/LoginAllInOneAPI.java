package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.AllInOneResult;
import com.kzingsdk.entity.SocialRegisterPlatform;
import com.kzingsdk.entity.gameplatform.GamePlatformType;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class LoginAllInOneAPI extends CoreRequest {

    //normal login
    private String loginName;
    private String password;
    //social login
    private String socialId;
    private String platform;
    private String token;
    private String captchaValidate = "";
    private String verifyCode = "";
    private String uuid = "";
    private Boolean showAll = false;
    private Boolean platformOnly = false;
    private GamePlatformType gpType = null;
    private Boolean showChild = false;
    private String provider = "";
    private String providerId = "";
    LoginAllInOneAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.loginAllInOne;
    }

    @Override
    protected Observable<String> validateParams() {
        if (loginName == null && password == null) {
            if (socialId == null) {
                return Observable.just("SocialId is missing");
            }
            if (platform == null) {
                return Observable.just("Platform is missing");
            }
            if (token == null) {
                return Observable.just("Token is missing");
            }
        } else {
            if (loginName == null) {
                return Observable.just("Login name is missing");
            }
            if (password == null) {
                return Observable.just("Password is missing");
            }
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (loginName == null && password == null) {
                jsonData.put("socialid", socialId);
                jsonData.put("splatform", platform);
                jsonData.put("token", token);
            } else {
                jsonData.put("playername", loginName);
                jsonData.put("password", password);
            }
            jsonData.put("captchaValidate", captchaValidate);
            jsonData.put("verifycode", verifyCode);
            jsonData.put("jsessionid", getSessionId());
            if (uuid != null) {
                jsonData.put("uuid", uuid);
            }
            jsonData.put("useEpGame", true);
            jsonData.put("useEpSiteInfo", false);
            jsonData.put("showall", showAll ? 1 : 0);
            jsonData.put("platformonly", platformOnly ? 1 : 0);
            jsonData.put("gptype", gpType == null ? 0 : gpType.getId());
            jsonData.put("showchild", showChild ? 1 : 0);
            if (provider != null) {
                jsonData.put("provider", provider);
            }
            if (providerId != null) {
                jsonData.put("providerid", providerId);
            }
            jsonData.put("useWebApi", true);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<AllInOneResult> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            AllInOneResult allInOneResult = AllInOneResult.newInstance(jsonResponse, context);
            String vcToken, ccToken;
            if (allInOneResult.isLogined()) {
                JSONObject memberInfoObject = jsonResponse.optJSONObject("memberInfo");
                vcToken = memberInfoObject.optString("vc", "");
                ccToken = memberInfoObject.optString("cc", "");
            } else {
                vcToken = "";
                ccToken = "";
            }
            SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
            SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
            setLoginTokens(vcToken, ccToken);
            return allInOneResult;
        });
    }


    @Override
    public void request(Context context) {
        requestRx(context).subscribe(allInOneResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((LoginAllInOneCallBack) kzingCallBack).onSuccess(allInOneResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public LoginAllInOneAPI addLoginAllInOneCallBack(LoginAllInOneCallBack loginAllInOneCallBack) {
        kzingCallBackList.add(loginAllInOneCallBack);
        return this;
    }

    public LoginAllInOneAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public LoginAllInOneAPI setParamPassword(String password) {
        this.password = password;
        return this;
    }

    public LoginAllInOneAPI setToken(String token) {
        this.token = token;
        return this;
    }

    public LoginAllInOneAPI setSocialId(String socialId) {
        this.socialId = socialId;
        return this;
    }

    public LoginAllInOneAPI setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public LoginAllInOneAPI setPlatform(SocialRegisterPlatform platform) {
        this.platform = platform.name();
        return this;
    }

    public LoginAllInOneAPI setCaptchaValidate(String captchaValidate) {
        this.captchaValidate = captchaValidate;
        return this;
    }

    public LoginAllInOneAPI setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        return this;
    }

    public LoginAllInOneAPI setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public LoginAllInOneAPI setShowAll(Boolean showAll) {
        this.showAll = showAll;
        return this;
    }

    public LoginAllInOneAPI setPlatformOnly(Boolean platformOnly) {
        this.platformOnly = platformOnly;
        return this;
    }

    /**
     * @param gpType Pass null to get all
     */
    public LoginAllInOneAPI setGpType(GamePlatformType gpType) {
        this.gpType = gpType;
        return this;
    }

    public LoginAllInOneAPI setShowChild(Boolean showChild) {
        this.showChild = showChild;
        return this;
    }

    public LoginAllInOneAPI setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public LoginAllInOneAPI setProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public interface LoginAllInOneCallBack extends KzingCallBack {
        void onSuccess(AllInOneResult allInOneResult);
    }
}

