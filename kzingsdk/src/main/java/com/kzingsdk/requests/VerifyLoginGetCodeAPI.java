package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class VerifyLoginGetCodeAPI extends CoreRequest {
    private String playerName;

    VerifyLoginGetCodeAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.verifyLoginGetCode;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("playername", playerName);
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
                    ((VerifyLoginGetCodeCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public VerifyLoginGetCodeAPI addVerifyLoginGetCodeCallBack(VerifyLoginGetCodeCallBack verifyLoginGetCodeCallBack) {
        kzingCallBackList.add(verifyLoginGetCodeCallBack);
        return this;
    }

    public interface VerifyLoginGetCodeCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }

    public VerifyLoginGetCodeAPI setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }
}

