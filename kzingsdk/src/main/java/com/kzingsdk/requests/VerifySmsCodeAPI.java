package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class VerifySmsCodeAPI extends CoreRequest {


    private String loginName = null;
    private String phone = null;
    private String validateCode = null;
    private String type = null;


    VerifySmsCodeAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.verifySmsCode;
    }

    @Override
    protected Observable<String> validateParams() {
        if (loginName == null) {
            return Observable.just("Login name is missing");
        }
        if (phone == null) {
            return Observable.just("Phone is missing");
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
            jsonData.put("phone", phone);
            jsonData.put("validateCode", validateCode);
            jsonData.put("type", type);
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
                    ((VerifySmsCodeCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public VerifySmsCodeAPI addVerifySmsCodeCallBack(VerifySmsCodeCallBack verifySmsCodeCallBack) {
        kzingCallBackList.add(verifySmsCodeCallBack);
        return this;
    }

    public VerifySmsCodeAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public VerifySmsCodeAPI setParamPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public VerifySmsCodeAPI setParamValidateCode(String validateCode) {
        this.validateCode = validateCode;
        return this;
    }

    public VerifySmsCodeAPI setType(String type) {
        this.type = type;
        return this;
    }

    public interface VerifySmsCodeCallBack extends KzingCallBack {
        void onSuccess(Boolean success);
    }
}
