package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SendEmailResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RequestResetPasswordByEmailAPI extends CoreRequest {


    private String loginName = null;
    private String email = null;

    RequestResetPasswordByEmailAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.requestResetPasswordByEmail;
    }

    @Override
    protected Observable<String> validateParams() {
        if (loginName == null) {
            return Observable.just("Login name is missing");
        }
        if (email == null) {
            return Observable.just("Email is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("name", loginName);
            jsonData.put("email", email);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SendEmailResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SendEmailResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(sendEmailResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RequestResetPasswordByEmailCallBack) kzingCallBack).onSuccess(sendEmailResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RequestResetPasswordByEmailAPI addRequestResetPasswordByEmailCallBack(RequestResetPasswordByEmailCallBack requestResetPasswordByEmailCallBack) {
        kzingCallBackList.add(requestResetPasswordByEmailCallBack);
        return this;
    }

    public RequestResetPasswordByEmailAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public RequestResetPasswordByEmailAPI setParamEmail(String email) {
        this.email = email;
        return this;
    }

    public interface RequestResetPasswordByEmailCallBack extends KzingCallBack {
        void onSuccess(SendEmailResult sendEmailResult);
    }

}
