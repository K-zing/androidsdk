package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class MobileLoginGetCodeAPI extends CoreRequest {

    private String phone;
    private String countryCode;

    MobileLoginGetCodeAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.mobileLoginGetCode;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("phone", phone);
            jsonData.put("countrycode", countryCode);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            return jsonResponse.optString("msg");
        });
    }


    @Override
    public void request(Context context) {
        requestRx(context).subscribe(message -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((MobileLoginGetCodeCallBack) kzingCallBack).onSuccess(message);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public MobileLoginGetCodeAPI addLoginCallBack(MobileLoginGetCodeCallBack mobileLoginGetCodeCallBack) {
        kzingCallBackList.add(mobileLoginGetCodeCallBack);
        return this;
    }

    public MobileLoginGetCodeAPI setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public MobileLoginGetCodeAPI setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public interface MobileLoginGetCodeCallBack extends KzingCallBack {
        void onSuccess(String message);
    }


}

