package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SelfServiceFeedbackAPI extends CoreRequest {

    private String username;
    private String feedback;


    SelfServiceFeedbackAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.selfServiceFeedback;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("username", username);
            jsonData.put("feedback", feedback);
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
                    ((SelfServiceFeedbackCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SelfServiceFeedbackAPI addSelfServiceFeedbackCallBack(SelfServiceFeedbackCallBack selfServiceFeedbackCallBack) {
        kzingCallBackList.add(selfServiceFeedbackCallBack);
        return this;
    }

    public interface SelfServiceFeedbackCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }

    public SelfServiceFeedbackAPI setUsername(String username) {
        this.username = username;
        return this;
    }

    public SelfServiceFeedbackAPI setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }
}

