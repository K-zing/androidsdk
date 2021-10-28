package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class PasswordVerifyAPI extends CoreRequest {

    private String password;

    PasswordVerifyAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.passwordVerify;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("pwd", password);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(success -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((PasswordVerifyCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public PasswordVerifyAPI addPasswordVerifyCallBack(PasswordVerifyCallBack passwordVerifyCallBack) {
        kzingCallBackList.add(passwordVerifyCallBack);
        return this;
    }

    public interface PasswordVerifyCallBack extends KzingCallBack {
        void onSuccess(String success);
    }

    public PasswordVerifyAPI setPassword(String password) {
        this.password = password;
        return this;
    }
}

