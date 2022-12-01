package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class TransferAllBalanceToGameAPI extends CoreRequest {

    private String gpid = "";

    TransferAllBalanceToGameAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.transferAllBalanceToGame;
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
    public Observable<SimpleApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SimpleApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((TransferAllBalanceToGameCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public TransferAllBalanceToGameAPI addTransferAllBalanceToGameCallBack(TransferAllBalanceToGameCallBack transferAllBalanceToGameCallBack) {
        kzingCallBackList.add(transferAllBalanceToGameCallBack);
        return this;
    }

    public String getGpid() {
        return gpid;
    }

    public TransferAllBalanceToGameAPI setGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }

    public interface TransferAllBalanceToGameCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }

}

