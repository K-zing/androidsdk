package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CheckAgentNameExistAPI extends CoreRequest {

    CheckAgentNameExistAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.checkAgentNameExist;
    }

    private String agentName;

    @Override
    protected Observable<String> validateParams() {
        if (agentName == null || agentName.length() == 0) {
            return Observable.just("Agent Name is not valid");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("name", agentName);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> jsonResponse.optBoolean("isExist", false));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(isExist -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((CheckAgentNameExistCallBack) kzingCallBack).onSuccess(isExist);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CheckAgentNameExistAPI addCheckAgentNameExistCallBack(CheckAgentNameExistAPI.CheckAgentNameExistCallBack checkAgentNameExistCallBack) {
        kzingCallBackList.add(checkAgentNameExistCallBack);
        return this;
    }

    public interface CheckAgentNameExistCallBack extends KzingCallBack {
        void onSuccess(Boolean isExist);
    }

    public CheckAgentNameExistAPI setParamAgentName(String agentName) {
        this.agentName = agentName;
        return this;
    }

}
