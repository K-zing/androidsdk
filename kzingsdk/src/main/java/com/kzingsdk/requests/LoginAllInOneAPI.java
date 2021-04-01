package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.AllInOneResult;
import com.kzingsdk.entity.SocialRegisterPlatform;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class LoginAllInOneAPI extends CoreRequest {

    LoginAllInOneAPI() {
        super();
    }

    //normal login
    private String loginName;
    private String password;

    //social login
    private String socialId;
    private String platform;
    private String token;

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

    public interface LoginAllInOneCallBack extends KzingCallBack {
        void onSuccess(AllInOneResult allInOneResult);
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

}

