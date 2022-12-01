package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SetDefaultCryptoWithdrawAddressAPI extends CoreRequest {

    private String wdBankId;
    private String network;

    SetDefaultCryptoWithdrawAddressAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.setDefaultCryptoWithdrawAddress;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("wdbankid", wdBankId);
            jsonData.put("network", network);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SimpleApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SimpleApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetTWDHistoryCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SetDefaultCryptoWithdrawAddressAPI addGetTWDHistoryCallBack(GetTWDHistoryCallBack getTWDHistoryCallBack) {
        kzingCallBackList.add(getTWDHistoryCallBack);
        return this;
    }

    public SetDefaultCryptoWithdrawAddressAPI setWdBankId(String wdBankId) {
        this.wdBankId = wdBankId;
        return this;
    }

    public SetDefaultCryptoWithdrawAddressAPI setNetwork(String network) {
        this.network = network;
        return this;
    }

    public interface GetTWDHistoryCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }
}

