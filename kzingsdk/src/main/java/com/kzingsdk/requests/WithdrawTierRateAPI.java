package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.WithdrawTierRateResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class WithdrawTierRateAPI extends CoreRequest {

    private String cryptoCurrency;
    private String requestAmount;

    WithdrawTierRateAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.withdrawTierRate;
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
            jsonData.put("requestamount", requestAmount);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<WithdrawTierRateResult> requestRx(final Context context) {
        return super.baseExecute(context).map(WithdrawTierRateResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((WithdrawTierRateCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public WithdrawTierRateAPI addWithdrawTierRateCallBack(WithdrawTierRateCallBack withdrawTierRateCallBack) {
        kzingCallBackList.add(withdrawTierRateCallBack);
        return this;
    }

    public interface WithdrawTierRateCallBack extends KzingCallBack {
        void onSuccess(WithdrawTierRateResult simpleApiResult);
    }

    public WithdrawTierRateAPI setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
        return this;
    }

    public WithdrawTierRateAPI setRequestAmount(String requestAmount) {
        this.requestAmount = requestAmount;
        return this;
    }
}

