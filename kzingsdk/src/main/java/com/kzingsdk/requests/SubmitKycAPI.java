package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;


public class SubmitKycAPI extends CoreRequest {

    private String kycType;
    private String image1;
    private String image2;

    SubmitKycAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitKyc;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("kyctype", kycType);
            jsonData.put("image1", image1);
            jsonData.put("image2", image2);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(success -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitKycCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitKycAPI addSubmitKycCallBack(SubmitKycAPI.SubmitKycCallBack submitKycCallBack) {
        kzingCallBackList.add(submitKycCallBack);
        return this;
    }

    public SubmitKycAPI setKycType(String kycType) {
        this.kycType = kycType;
        return this;
    }

    public SubmitKycAPI setImage1(String image1) {
        this.image1 = image1;
        return this;
    }

    public SubmitKycAPI setImage2(String image2) {
        this.image2 = image2;
        return this;
    }

    public interface SubmitKycCallBack extends KzingCallBack {
        void onSuccess(String success);
    }
}
