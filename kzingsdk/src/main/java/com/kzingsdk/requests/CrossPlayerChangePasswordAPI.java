package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CrossPlayerChangePasswordAPI extends CoreRequest {

    private String userName = "";
    private String password = "";
    private String lastDigit = "";

    CrossPlayerChangePasswordAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.crossPlayerChangePassword;
    }

    @Override
    protected Observable<String> validateParams() {
//        if (password == null || password.length() == 0) {
//            return Observable.just("New Password is missing");
//        }
//        if (userName == null || userName.length() == 0) {
//            return Observable.just("Password is missing");
//        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("uname", userName);
            jsonData.put("pwd", password);
            jsonData.put("lastdigit", lastDigit);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(string -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ChangePasswordCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CrossPlayerChangePasswordAPI addLoginCallBack(ChangePasswordCallBack changePasswordCallBack) {
        kzingCallBackList.add(changePasswordCallBack);
        return this;
    }

    public CrossPlayerChangePasswordAPI setPassword(String password) {
        this.password = password;
        return this;
    }

    public CrossPlayerChangePasswordAPI setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public CrossPlayerChangePasswordAPI setLastDigit(String lastDigit) {
        this.lastDigit = lastDigit;
        return this;
    }

    public interface ChangePasswordCallBack extends KzingCallBack {
        void onSuccess();
    }

}

