package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.LoginWebApiResult;
import com.kzingsdk.entity.MemberInfo;
import com.kzingsdk.entity.SimpleApiResult;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class LoginWebApiAPI extends CoreRequest {

    private String loginName;
    private String password;
    private String captchaValidate = "";
    private String verifyCode = "";
    private String uuid = "";
    private String provider = "";
    private String providerId = "";
    private String forceResetPwdSmsCode = "";


    LoginWebApiAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.loginWebApi;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("playername", loginName);
            jsonData.put("password", password);
            jsonData.put("captchavalidate", captchaValidate);
            jsonData.put("verifycode", verifyCode);
            jsonData.put("jsessionid", getSessionId());
            if (uuid != null) {
                jsonData.put("uuid", uuid);
            }
            if (provider != null) {
                jsonData.put("provider", provider);
            }
            if (forceResetPwdSmsCode != null) {
                jsonData.put("forceresetpwdsmscode", forceResetPwdSmsCode);
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
    public Observable<LoginWebApiResult> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
                    LoginWebApiResult result = LoginWebApiResult.newInstance(jsonResponse);
                    if (result.getStatus() != 0) {
                        JSONObject dataObject = jsonResponse.optJSONObject("data");
                        if (dataObject != null) {
                            String vcToken = dataObject.optString("vc", "");
                            String ccToken = dataObject.optString("cc", "");
                            SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
                            SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
                            setLoginTokens(vcToken, ccToken);
                        }
                    }
                    return result;
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
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((LoginCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public interface LoginCallBack extends KzingCallBack {
        void onSuccess(LoginWebApiResult result);
    }

    public LoginWebApiAPI addLoginWebApiCallBack(LoginCallBack loginWebApiCallBack) {
        kzingCallBackList.add(loginWebApiCallBack);
        return this;
    }

    public LoginWebApiAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public LoginWebApiAPI setParamPassword(String password) {
        this.password = password;
        return this;
    }

    public LoginWebApiAPI setCaptchaValidate(String captchaValidate) {
        this.captchaValidate = captchaValidate;
        return this;
    }

    public LoginWebApiAPI setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        return this;
    }

    public LoginWebApiAPI setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public LoginWebApiAPI setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public LoginWebApiAPI setProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public LoginWebApiAPI setForceResetPwdSmsCode(String forceResetPwdSmsCode) {
        this.forceResetPwdSmsCode = forceResetPwdSmsCode;
        return this;
    }
}
