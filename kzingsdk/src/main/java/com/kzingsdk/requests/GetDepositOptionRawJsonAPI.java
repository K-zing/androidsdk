package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetDepositOptionRawJsonAPI extends CoreRequest {

    private boolean isV2 = false;

    GetDepositOptionRawJsonAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getDepositOption;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("isV2", isV2);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<JSONObject> requestRx(Context context) {
        return super.baseExecute(context);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(jsonObject -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetDepositOptionCallBack) kzingCallBack).onSuccess(jsonObject);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetDepositOptionRawJsonAPI addGetDepositOptionCallBack(GetDepositOptionCallBack getDepositOptionCallBack) {
        kzingCallBackList.add(getDepositOptionCallBack);
        return this;
    }

    public GetDepositOptionRawJsonAPI setV2(boolean v2) {
        isV2 = v2;
        return this;
    }

    public interface GetDepositOptionCallBack extends KzingCallBack {
        void onSuccess(JSONObject jsonObject);
    }
}
