package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RequestUsernameResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RequestUsernameByPhoneAPI extends CoreRequest {

    private String phone = null;
    private String uPhoneCountry = null;
    private String validateCode = null;


    RequestUsernameByPhoneAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.requestUsernameByPhone;
    }

    @Override
    protected Observable<String> validateParams() {
        if (phone == null) {
            return Observable.just("Phone is missing");
        }
        if (validateCode == null) {
            return Observable.just("ValidateCode is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("playerPhone", phone);
            jsonData.put("playerPhoneCountry", uPhoneCountry);
            jsonData.put("validateCode", validateCode);
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
                    ((RequestUsernameByPhoneCallBack) kzingCallBack).onSuccess(requestUsernameResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RequestUsernameByPhoneAPI addRequestUsernameByPhoneCallBack(RequestUsernameByPhoneCallBack requestUsernameByPhoneCallBack) {
        kzingCallBackList.add(requestUsernameByPhoneCallBack);
        return this;
    }

    public interface RequestUsernameByPhoneCallBack extends KzingCallBack {
        void onSuccess(RequestUsernameResult requestUsernameResult);
    }

    public RequestUsernameByPhoneAPI setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RequestUsernameByPhoneAPI setValidateCode(String validateCode) {
        this.validateCode = validateCode;
        return this;
    }

    public RequestUsernameByPhoneAPI setUPhoneCountry(String uPhoneCountry) {
        this.uPhoneCountry = uPhoneCountry;
        return this;
    }

}
