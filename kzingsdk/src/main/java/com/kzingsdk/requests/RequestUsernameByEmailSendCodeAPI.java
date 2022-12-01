package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RequestUsernameResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RequestUsernameByEmailSendCodeAPI extends CoreRequest {

    private String email = null;
    private boolean validateOnly = false;


    RequestUsernameByEmailSendCodeAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.requestUsernameByEmailSendCode;
    }

    @Override
    protected Observable<String> validateParams() {
        if (email == null) {
            return Observable.just("Email is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("email", email);
            jsonData.put("validateOnly", validateOnly);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<RequestUsernameResult> requestRx(final Context context) {
        return super.baseExecute(context).map(RequestUsernameResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(requestUsernameResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RequestUsernameByEmailSendCodeCallBack) kzingCallBack).onSuccess(requestUsernameResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RequestUsernameByEmailSendCodeAPI addRequestUsernameByEmailSendCodeCallBack(RequestUsernameByEmailSendCodeCallBack requestUsernameByEmailSendCodeCallBack) {
        kzingCallBackList.add(requestUsernameByEmailSendCodeCallBack);
        return this;
    }

    public RequestUsernameByEmailSendCodeAPI setEmail(String email) {
        this.email = email;
        return this;
    }

    public RequestUsernameByEmailSendCodeAPI setValidateOnly(boolean validateOnly) {
        this.validateOnly = validateOnly;
        return this;
    }

    public interface RequestUsernameByEmailSendCodeCallBack extends KzingCallBack {
        void onSuccess(RequestUsernameResult requestUsernameResult);
    }

}
