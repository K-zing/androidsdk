package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class VerifyEmailCodeAPI extends CoreRequest {


    private String loginName = null;
    private String email = null;
    private String validateCode = null;


    VerifyEmailCodeAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.verifyEmailCode;
    }

    @Override
    protected Observable<String> validateParams() {
        if (loginName == null) {
            return Observable.just("Login name is missing");
        }
        if (email == null) {
            return Observable.just("Email is missing");
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
            jsonData.put("name", loginName);
            jsonData.put("email", email);
            jsonData.put("validateCode", validateCode);
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
                    ((VerifyEmailCodeCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public VerifyEmailCodeAPI addVerifyEmailCodeCallBack(VerifyEmailCodeCallBack verifyEmailCodeCallBack) {
        kzingCallBackList.add(verifyEmailCodeCallBack);
        return this;
    }

    public interface VerifyEmailCodeCallBack extends KzingCallBack {
        void onSuccess(Boolean success);
    }

    public VerifyEmailCodeAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public VerifyEmailCodeAPI setParamEmail(String email) {
        this.email = email;
        return this;
    }


    public String getValidateCode() {
        return validateCode;
    }

    public VerifyEmailCodeAPI setParamValidateCode(String validateCode) {
        this.validateCode = validateCode;
        return this;
    }
}
