package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ValidateCaptchaAPI extends CoreRequest {

    private String verifyCode;
    private String captchaValidate;

    ValidateCaptchaAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.validateCaptcha;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("verifycode", verifyCode);
            jsonData.put("captchavalidate", captchaValidate);
            jsonData.put("jsessionid", getSessionId());
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
                    ((ValidateCaptchaCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ValidateCaptchaAPI addValidateCaptchaCallBack(ValidateCaptchaCallBack validateCaptchaCallBack) {
        kzingCallBackList.add(validateCaptchaCallBack);
        return this;
    }

    public interface ValidateCaptchaCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult result);
    }

    public ValidateCaptchaAPI setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        return this;
    }

    public ValidateCaptchaAPI setCaptchaValidate(String captchaValidate) {
        this.captchaValidate = captchaValidate;
        return this;
    }
}

