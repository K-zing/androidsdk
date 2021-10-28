package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CryptoRedeemTokenAPI extends CoreRequest {

    private String token;

    CryptoRedeemTokenAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.cryptoRedeemToken;
    }

    @Override
    public Observable<String> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }
    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("token", token);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public void request(Context context) {
        requestRx(context).subscribe(success -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((CryptoRedeemTokenCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CryptoRedeemTokenAPI addCryptoRedeemTokenCallBack(CryptoRedeemTokenCallBack cryptoRedeemTokenCallBack) {
        kzingCallBackList.add(cryptoRedeemTokenCallBack);
        return this;
    }

    public interface CryptoRedeemTokenCallBack extends KzingCallBack {
        void onSuccess(String success);
    }

    public CryptoRedeemTokenAPI setToken(String token) {
        this.token = token;
        return this;
    }
}

