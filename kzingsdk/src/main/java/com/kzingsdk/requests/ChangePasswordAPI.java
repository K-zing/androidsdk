package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ChangePasswordAPI extends CoreRequest {

    private String oldPassword = "";
    private String newPassword = "";

    ChangePasswordAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.changePassword;
    }

    @Override
    protected Observable<String> validateParams() {
        if (newPassword == null || newPassword.length() == 0) {
            return Observable.just("New Password is missing");
        }
        if (oldPassword == null || oldPassword.length() == 0) {
            return Observable.just("Password is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("password", oldPassword);
            jsonData.put("newpassword", newPassword);
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

    public ChangePasswordAPI addLoginCallBack(ChangePasswordCallBack changePasswordCallBack) {
        kzingCallBackList.add(changePasswordCallBack);
        return this;
    }

    public ChangePasswordAPI setParamNewPassword(String newpassword) {
        this.newPassword = newpassword;
        return this;
    }

    public ChangePasswordAPI setOldParamPassword(String oldPassword) {
        this.oldPassword = oldPassword;
        return this;
    }

    public interface ChangePasswordCallBack extends KzingCallBack {
        void onSuccess();
    }

}