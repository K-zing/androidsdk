package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ForgotPwdVerifyUsernameResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ForgotPwdVerifyUsernameAPI extends CoreRequest {

    private String username = null;

    ForgotPwdVerifyUsernameAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.forgotPwdVerifyUsername;
    }

    @Override
    protected Observable<String> validateParams() {
        if (username == null) {
            return Observable.just("Username is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("username", username);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ForgotPwdVerifyUsernameResult> requestRx(final Context context) {
        return super.baseExecute(context).map(ForgotPwdVerifyUsernameResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(forgotPwdVerifyUsernameResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ForgotPwdVerifyUsernameCallBack) kzingCallBack).onSuccess(forgotPwdVerifyUsernameResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ForgotPwdVerifyUsernameAPI addForgotPwdVerifyUsernameCallBack(ForgotPwdVerifyUsernameCallBack forgotPwdVerifyUsernameCallBack) {
        kzingCallBackList.add(forgotPwdVerifyUsernameCallBack);
        return this;
    }

    public ForgotPwdVerifyUsernameAPI setUsername(String username) {
        this.username = username;
        return this;
    }

    public interface ForgotPwdVerifyUsernameCallBack extends KzingCallBack {
        void onSuccess(ForgotPwdVerifyUsernameResult forgotPwdVerifyUsernameResult);
    }


}
