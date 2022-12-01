package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MemberInfo;
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
            return MemberInfo.newInstanceFromWebapi(jsonResponse);
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

    public interface LoginCallBack extends KzingCallBack {
        void onSuccess(MemberInfo memberInfo);
    }
}
