package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ChangeWithdrawPasswordAPI extends CoreRequest {

    private String accPassword = "";
    private String oldPassword = "";
    private String newPassword = "";
    ChangeWithdrawPasswordAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.changeWithdrawPassword;
    }

    @Override
    protected Observable<String> validateParams() {
        if (newPassword == null || newPassword.length() == 0) {
            return Observable.just("New Password is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("accPassword", accPassword);
            jsonData.put("old_withdrawpassword", oldPassword);
            jsonData.put("new_withdrawpassword", newPassword);
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

    public ChangeWithdrawPasswordAPI addLoginCallBack(ChangePasswordCallBack changePasswordCallBack) {
        kzingCallBackList.add(changePasswordCallBack);
        return this;
    }

    public ChangeWithdrawPasswordAPI setParamNewPassword(String newpassword) {
        this.newPassword = newpassword;
        return this;
    }

    public ChangeWithdrawPasswordAPI setParamOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
        return this;
    }

    public ChangeWithdrawPasswordAPI setParamAccPassword(String accPassword) {
        this.accPassword = accPassword;
        return this;
    }

    public interface ChangePasswordCallBack extends KzingCallBack {
        void onSuccess();
    }

}

