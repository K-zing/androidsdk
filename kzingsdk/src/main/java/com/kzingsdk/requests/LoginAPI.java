package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MemberInfo;
import com.kzingsdk.entity.SocialRegisterPlatform;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

@Deprecated
public class LoginAPI extends CoreRequest {

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
    private String provider;
    private String providerId;

    LoginAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.login;
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
            if (provider != null) {
                jsonData.put("provider", provider);
            }
            if (providerId != null) {
                jsonData.put("providerid", providerId);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<MemberInfo> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            String vcToken = jsonResponse.optString("vc", "");
            String ccToken = jsonResponse.optString("cc", "");
            SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
            SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
            setLoginTokens(vcToken, ccToken);
            return MemberInfo.newInstance(jsonResponse);
        })
                .doOnNext(response -> {
                    new GetSiteDomainAPI()
                            .requestRx(context)
                            .subscribe(jsonResponse -> {
                            }, ignored -> {
                            });
                })
                ;
    }


    @Override
    public void request(Context context) {
        requestRx(context).subscribe(memberInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((LoginCallBack) kzingCallBack).onSuccess(memberInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public LoginAPI addLoginCallBack(LoginCallBack loginCallBack) {
        kzingCallBackList.add(loginCallBack);
        return this;
    }

    public LoginAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public LoginAPI setParamPassword(String password) {
        this.password = password;
        return this;
    }

    public LoginAPI setToken(String token) {
        this.token = token;
        return this;
    }

    public LoginAPI setSocialId(String socialId) {
        this.socialId = socialId;
        return this;
    }

    public LoginAPI setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public LoginAPI setPlatform(SocialRegisterPlatform platform) {
        this.platform = platform.name();
        return this;
    }

    public LoginAPI setCaptchaValidate(String captchaValidate) {
        this.captchaValidate = captchaValidate;
        return this;
    }

    public LoginAPI setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        return this;
    }

    public LoginAPI setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public LoginAPI setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public LoginAPI setProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public interface LoginCallBack extends KzingCallBack {
        void onSuccess(MemberInfo memberInfo);
    }
}

