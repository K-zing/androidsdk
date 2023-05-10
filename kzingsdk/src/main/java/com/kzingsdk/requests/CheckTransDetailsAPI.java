package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CheckTransDetailsAPI extends CoreRequest {
    private String bbox;
    private String rules;



    CheckTransDetailsAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.checkTransDetails;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("bbox", bbox);
            jsonData.put("rules", rules);
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
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((CheckTransDetailsCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CheckTransDetailsAPI addCheckTransDetailsCallBack(CheckTransDetailsCallBack checkTransDetailsCallBack) {
        kzingCallBackList.add(checkTransDetailsCallBack);
        return this;
    }

    public interface CheckTransDetailsCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult result);
    }

    public String getBbox() {
        return bbox;
    }

    public CheckTransDetailsAPI setBbox(String bbox) {
        this.bbox = bbox;
        return this;
    }

    public String getRules() {
        return rules;
    }

    public CheckTransDetailsAPI setRules(String rules) {
        this.rules = rules;
        return this;
    }
}

