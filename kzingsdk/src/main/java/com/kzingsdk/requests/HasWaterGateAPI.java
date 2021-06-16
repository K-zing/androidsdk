package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class HasWaterGateAPI extends CoreRequest {

    HasWaterGateAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.hasWaterGate;
    }

    private String gpAccountId;

    @Override
    protected Observable<String> validateParams() {
        if (gpAccountId == null || gpAccountId.length() == 0) {
            return Observable.just("GpAccountId is not valid");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gpaccountid", gpAccountId);
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
        requestRx(context).subscribe(activityContent -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((HasWaterGateCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public HasWaterGateAPI addHasWaterGateCallBack(HasWaterGateCallBack hasWaterGateCallBack) {
        kzingCallBackList.add(hasWaterGateCallBack);
        return this;
    }

    public interface HasWaterGateCallBack extends KzingCallBack {
        void onSuccess();
    }

    public HasWaterGateAPI setGpAccountId(String gpaccountid) {
        this.gpAccountId = gpaccountid;
        return this;
    }

}
