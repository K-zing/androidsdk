package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.VerifyPlayerEmailResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class VerifyPlayerEmailAPI extends CoreRequest {

    private String email = null;
    private String validateCode = null;
    private String newEmail = null;

    VerifyPlayerEmailAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.verifyPlayerEmail;
    }

    @Override
    protected Observable<String> validateParams() {
        if (email == null) {
            return Observable.just("Email is missing");
        }
        if (validateCode == null) {
            return Observable.just("Validate Code is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("email", email);
            jsonData.put("validateCode", validateCode);
            if (newEmail != null) {
                jsonData.put("newemail", newEmail);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<VerifyPlayerEmailResult> requestRx(final Context context) {
        return super.baseExecute(context).map(VerifyPlayerEmailResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(success -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((VerifyPlayerEmailCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public VerifyPlayerEmailAPI addVerifyPlayerEmailCallBack(VerifyPlayerEmailCallBack verifyPlayerEmailCallBack) {
        kzingCallBackList.add(verifyPlayerEmailCallBack);
        return this;
    }

    public VerifyPlayerEmailAPI setParamEmail(String email) {
        this.email = email;
        return this;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public VerifyPlayerEmailAPI setParamValidateCode(String validateCode) {
        this.validateCode = validateCode;
        return this;
    }

    public VerifyPlayerEmailAPI setNewEmail(String newEmail) {
        this.newEmail = newEmail;
        return this;
    }

    public interface VerifyPlayerEmailCallBack extends KzingCallBack {
        void onSuccess(VerifyPlayerEmailResult verifyPlayerEmailResult);
    }
}
