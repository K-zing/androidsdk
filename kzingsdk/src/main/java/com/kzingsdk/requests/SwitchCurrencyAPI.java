package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONObject;

import io.reactivex.Observable;

public class SwitchCurrencyAPI extends CoreRequest implements RequireCurrency {

    private String currency;

    SwitchCurrencyAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.switchCurrency;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            JSONObject dataObject = jsonResponse.optJSONObject("data");
            if (dataObject != null) {
                return dataObject.optInt("status") == 1;
            }
            return false;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(isSuccess -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SwitchCurrencyCallBack) kzingCallBack).onSuccess(isSuccess);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SwitchCurrencyAPI addSwitchCurrencyCallBack(SwitchCurrencyCallBack switchCurrencyCallBack) {
        kzingCallBackList.add(switchCurrencyCallBack);
        return this;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    public SwitchCurrencyAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public interface SwitchCurrencyCallBack extends KzingCallBack {
        void onSuccess(Boolean isSuccess);
    }

}
