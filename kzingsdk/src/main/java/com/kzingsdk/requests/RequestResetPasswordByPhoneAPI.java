package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SendSmsResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RequestResetPasswordByPhoneAPI extends CoreRequest {


    private String loginName = null;
    private String phone = null;
    private String playerPhoneCountry = null;
    private boolean requestVoice = false;
    private Boolean updatePhone = null;


    RequestResetPasswordByPhoneAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.requestResetPasswordByPhone;
    }

    @Override
    protected Observable<String> validateParams() {
        if (loginName == null) {
            return Observable.just("Login name is missing");
        }
        if (phone == null) {
            return Observable.just("Phone is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("name", loginName);
            jsonData.put("phone", phone);
            jsonData.put("playerPhoneCountry", playerPhoneCountry);
            jsonData.put("requestVoice", requestVoice);
            if (updatePhone != null)
                jsonData.put("updatePhone", updatePhone);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SendSmsResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SendSmsResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(sendSmsResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RequestResetPasswordByPhoneCallBack) kzingCallBack).onSuccess(sendSmsResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RequestResetPasswordByPhoneAPI addRequestResetPasswordByPhoneCallBack(RequestResetPasswordByPhoneCallBack requestResetPasswordByPhoneCallBack) {
        kzingCallBackList.add(requestResetPasswordByPhoneCallBack);
        return this;
    }

    public interface RequestResetPasswordByPhoneCallBack extends KzingCallBack {
        void onSuccess(SendSmsResult sendSmsResult);
    }

    public RequestResetPasswordByPhoneAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public RequestResetPasswordByPhoneAPI setParamPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setRequestVoice(boolean requestVoice) {
        this.requestVoice = requestVoice;
    }

    public RequestResetPasswordByPhoneAPI setPlayerPhoneCountry(String playerPhoneCountry) {
        this.playerPhoneCountry = playerPhoneCountry;
        return this;
    }

    public RequestResetPasswordByPhoneAPI setUpdatePhone(Boolean updatePhone) {
        this.updatePhone = updatePhone;
        return this;
    }
}
