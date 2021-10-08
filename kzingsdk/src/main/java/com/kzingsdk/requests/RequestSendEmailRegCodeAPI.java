package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RequestSendEmailRegCodeAPI extends CoreRequest {

    private String email = null;
    private String validateCode = null;

    RequestSendEmailRegCodeAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.requestSendEmailRegCode;
    }

    @Override
    protected Observable<String> validateParams() {
        if (email == null) {
            return Observable.just("Email is missing");
        }
        if (validateCode == null) {
            return Observable.just("ValidateCode is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("email", email);
            jsonData.put("validateCode", validateCode);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<Integer> requestRx(final Context context) {
        return super.baseExecute(context)
                .map(jsonObject -> jsonObject.optInt("duration", 300));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(duration -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RequestSendEmailRegCodeCallBack) kzingCallBack).onSuccess(duration);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RequestSendEmailRegCodeAPI addRequestSendEmailRegCodeCallBack(RequestSendEmailRegCodeCallBack requestSendEmailRegCodeCallBack) {
        kzingCallBackList.add(requestSendEmailRegCodeCallBack);
        return this;
    }

    public interface RequestSendEmailRegCodeCallBack extends KzingCallBack {
        void onSuccess(Integer duration);
    }

    public RequestSendEmailRegCodeAPI setEmail(String email) {
        this.email = email;
        return this;
    }

    public RequestSendEmailRegCodeAPI setValidateCode(String validateCode) {
        this.validateCode = validateCode;
        return this;
    }

}
