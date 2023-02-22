package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetDefaultTierRateResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetDefaultTierRateAPI extends CoreRequest {
    private String cryptoCurrency;
    private String adjType;

    GetDefaultTierRateAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getDefaultTierRate;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("cryptocurrency", cryptoCurrency);
            jsonData.put("adjtype", adjType);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<GetDefaultTierRateResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetDefaultTierRateResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetDefaultTierRateCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetDefaultTierRateAPI addGetDefaultTierRateCallBack(GetDefaultTierRateCallBack getDefaultTierRateCallBack) {
        kzingCallBackList.add(getDefaultTierRateCallBack);
        return this;
    }

    public interface GetDefaultTierRateCallBack extends KzingCallBack {
        void onSuccess(GetDefaultTierRateResult simpleApiResult);
    }

    public GetDefaultTierRateAPI setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
        return this;
    }

    public GetDefaultTierRateAPI setAdjType(String adjType) {
        this.adjType = adjType;
        return this;
    }
}

