package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ValidatePhoneAPI extends CoreRequest {
    private String loginName;
    private String phone;
    private String withCountryCode;

    ValidatePhoneAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.validatePhone;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("loginame", loginName);
            jsonData.put("phone", phone);
            jsonData.put("withcountrycode", withCountryCode);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SimpleApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SimpleApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ValidatePhoneCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ValidatePhoneAPI addValidatePhoneCallBack(ValidatePhoneCallBack validatePhoneCallBack) {
        kzingCallBackList.add(validatePhoneCallBack);
        return this;
    }

    public interface ValidatePhoneCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult result);
    }

    public ValidatePhoneAPI setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public ValidatePhoneAPI setWithCountryCode(String withCountryCode) {
        this.withCountryCode = withCountryCode;
        return this;
    }

    public ValidatePhoneAPI setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}

