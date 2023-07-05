package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.TransferGameToMainBalanceResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class TransferGameToMainBalanceAPI extends CoreRequest {
    private String gpid;

    TransferGameToMainBalanceAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.transferGameToMainBalance;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gpid", gpid);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<TransferGameToMainBalanceResult> requestRx(final Context context) {
        return super.baseExecute(context).map(TransferGameToMainBalanceResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((TransferGameToMainBalanceCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public TransferGameToMainBalanceAPI addTransferGameToMainBalanceCallBack(TransferGameToMainBalanceCallBack transferGameToMainBalanceCallBack) {
        kzingCallBackList.add(transferGameToMainBalanceCallBack);
        return this;
    }

    public interface TransferGameToMainBalanceCallBack extends KzingCallBack {
        void onSuccess(TransferGameToMainBalanceResult result);
    }

    public TransferGameToMainBalanceAPI setGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }
}

