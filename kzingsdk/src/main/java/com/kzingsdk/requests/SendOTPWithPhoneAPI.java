package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SendOTPWithPhoneResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SendOTPWithPhoneAPI extends CoreRequest {
    private String uphone;
    private String uphonecountry;



    SendOTPWithPhoneAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.sendOTPWithPhone;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("uphone", uphone);
            jsonData.put("uphonecountry", uphonecountry);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SendOTPWithPhoneResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SendOTPWithPhoneResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SendOTPWithPhoneCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SendOTPWithPhoneAPI addSendOTPWithPhoneCallBack(SendOTPWithPhoneCallBack sendOTPWithPhoneCallBack) {
        kzingCallBackList.add(sendOTPWithPhoneCallBack);
        return this;
    }

    public interface SendOTPWithPhoneCallBack extends KzingCallBack {
        void onSuccess(SendOTPWithPhoneResult result);
    }

    public String getUphone() {
        return uphone;
    }

    public SendOTPWithPhoneAPI setUphone(String uphone) {
        this.uphone = uphone;
        return this;
    }

    public String getUphonecountry() {
        return uphonecountry;
    }

    public SendOTPWithPhoneAPI setUphonecountry(String uphonecountry) {
        this.uphonecountry = uphonecountry;
        return this;
    }
}

