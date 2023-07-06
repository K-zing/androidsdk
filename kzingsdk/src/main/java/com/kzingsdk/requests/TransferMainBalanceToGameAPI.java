package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.TransferMainBalanceToGameResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class TransferMainBalanceToGameAPI extends CoreRequest {
    private String gpid;

    TransferMainBalanceToGameAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.transferMainBalanceToGame;
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
    public Observable<TransferMainBalanceToGameResult> requestRx(final Context context) {
        return super.baseExecute(context).map(TransferMainBalanceToGameResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((TransferMainBalanceToGameCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public TransferMainBalanceToGameAPI addTransferMainBalanceToGameCallBack(TransferMainBalanceToGameCallBack transferMainBalanceToGameCallBack) {
        kzingCallBackList.add(transferMainBalanceToGameCallBack);
        return this;
    }

    public interface TransferMainBalanceToGameCallBack extends KzingCallBack {
        void onSuccess(TransferMainBalanceToGameResult result);
    }

    public TransferMainBalanceToGameAPI setGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }
}

