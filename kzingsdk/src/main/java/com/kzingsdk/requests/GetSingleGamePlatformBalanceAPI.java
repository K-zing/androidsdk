package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

import io.reactivex.Observable;

public class GetSingleGamePlatformBalanceAPI extends CoreRequest {

    GetSingleGamePlatformBalanceAPI() {
        super();
    }

    private String gpaccid;

    @Override
    protected String getAction() {
        return Action.getSingleGamePlatformBalance;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gpaccid", gpaccid);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<BigDecimal> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    return new BigDecimal(jsonResponse.optString("balance"));
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(balance -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSingleGamePlatformBalanceCallBack) kzingCallBack).onSuccess(balance);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetSingleGamePlatformBalanceAPI addGetSingleGamePlatformBalanceCallBack(GetSingleGamePlatformBalanceCallBack getAllGpBalanceCallBack) {
        kzingCallBackList.add(getAllGpBalanceCallBack);
        return this;
    }

    public interface GetSingleGamePlatformBalanceCallBack extends KzingCallBack {
        void onSuccess(BigDecimal balance);
    }

    public GetSingleGamePlatformBalanceAPI setGpaccid(String gpaccid) {
        this.gpaccid = gpaccid;
        return this;
    }
}
