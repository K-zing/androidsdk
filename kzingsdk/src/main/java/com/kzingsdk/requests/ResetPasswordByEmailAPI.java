package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ResetPasswordByEmailAPI extends CoreRequest {


    private String token = null;
    private String validateCode = null;
    private String loginName = null;
    private String password = null;

    ResetPasswordByEmailAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.resetPasswordByEmail;
    }

    @Override
    protected Observable<String> validateParams() {
        if (loginName == null) {
            return Observable.just("Login name is missing");
        }
        if (password == null) {
            return Observable.just("Password is missing");
        }
        if (token == null) {
            return Observable.just("Token is missing");
        }
        if (validateCode == null) {
            return Observable.just("Validate Code is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("token", token);
            jsonData.put("validateCode", validateCode);
            jsonData.put("name", loginName);
            jsonData.put("password", password);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<Boolean> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> true);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(success -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ResetPasswordByEmailCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ResetPasswordByEmailAPI addResetPasswordEmailCallBack(ResetPasswordByEmailCallBack resetPasswordByEmailCallBack) {
        kzingCallBackList.add(resetPasswordByEmailCallBack);
        return this;
    }

    public interface ResetPasswordByEmailCallBack extends KzingCallBack {
        void onSuccess(Boolean success);
    }

    public ResetPasswordByEmailAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public ResetPasswordByEmailAPI setParamPassword(String password) {
        this.password = password;
        return this;
    }

    public String getToken() {
        return token;
    }

    public ResetPasswordByEmailAPI setParamToken(String token) {
        this.token = token;
        return this;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public ResetPasswordByEmailAPI setParamValidateCode(String validateCode) {
        this.validateCode = validateCode;
        return this;
    }
}
