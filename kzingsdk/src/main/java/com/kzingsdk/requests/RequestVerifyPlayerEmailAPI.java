package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SendEmailResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RequestVerifyPlayerEmailAPI extends CoreRequest {

    private String email = null;

    RequestVerifyPlayerEmailAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.requestVerifyPlayerEmail;
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
                    ((RequestVerifyPlayerEmailCallBack) kzingCallBack).onSuccess(sendEmailResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RequestVerifyPlayerEmailAPI addRequestVerifyPlayerEmailCallBack(RequestVerifyPlayerEmailCallBack requestVerifyPlayerEmailCallBack) {
        kzingCallBackList.add(requestVerifyPlayerEmailCallBack);
        return this;
    }

    public interface RequestVerifyPlayerEmailCallBack extends KzingCallBack {
        void onSuccess(SendEmailResult sendEmailResult);
    }

    public RequestVerifyPlayerEmailAPI setParamEmail(String email) {
        this.email = email;
        return this;
    }

}
