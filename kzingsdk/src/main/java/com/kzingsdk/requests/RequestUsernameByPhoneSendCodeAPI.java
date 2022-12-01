package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RequestUsernameResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RequestUsernameByPhoneSendCodeAPI extends CoreRequest {

    private String phone = null;
    private String uPhoneCountry = null;
    private boolean validateOnly = false;
    private boolean requestVoice = false;
    private Boolean updatePhone = null;


    RequestUsernameByPhoneSendCodeAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.requestUsernameByPhoneSendCode;
    }

    @Override
    protected Observable<String> validateParams() {
        if (phone == null) {
            return Observable.just("Phone is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("playerPhone", phone);
            jsonData.put("playerPhoneCountry", uPhoneCountry);
            jsonData.put("validateOnly", validateOnly);
            jsonData.put("requestVoice", requestVoice);
            if (updatePhone != null)
                jsonData.put("updatePhone", updatePhone);
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
                    ((RequestUsernameByPhoneSendCodeCallBack) kzingCallBack).onSuccess(requestUsernameResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RequestUsernameByPhoneSendCodeAPI addRequestUsernameByPhoneSendCodeCallBack(RequestUsernameByPhoneSendCodeCallBack requestUsernameByPhoneSendCodeCallBack) {
        kzingCallBackList.add(requestUsernameByPhoneSendCodeCallBack);
        return this;
    }

    public RequestUsernameByPhoneSendCodeAPI setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RequestUsernameByPhoneSendCodeAPI setValidateOnly(boolean validateOnly) {
        this.validateOnly = validateOnly;
        return this;
    }

    public RequestUsernameByPhoneSendCodeAPI setUPhoneCountry(String uPhoneCountry) {
        this.uPhoneCountry = uPhoneCountry;
        return this;
    }

    public boolean isRequestVoice() {
        return requestVoice;
    }

    public RequestUsernameByPhoneSendCodeAPI setRequestVoice(boolean requestVoice) {
        this.requestVoice = requestVoice;
        return this;
    }

    public RequestUsernameByPhoneSendCodeAPI setUpdatePhone(Boolean updatePhone) {
        this.updatePhone = updatePhone;
        return this;
    }

    public interface RequestUsernameByPhoneSendCodeCallBack extends KzingCallBack {
        void onSuccess(RequestUsernameResult requestUsernameResult);
    }
}
