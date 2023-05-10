package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CheckTransDetailsPartialAPI extends CoreRequest {
    private String bbox;
    private String playername;
    private String rules;



    CheckTransDetailsPartialAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.checkTransDetailsPartial;
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
            jsonData.put("playername", playername);
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
                    ((CheckTransDetailsPartialCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CheckTransDetailsPartialAPI addCheckTransDetailsPartialCallBack(CheckTransDetailsPartialCallBack checkTransDetailsPartialCallBack) {
        kzingCallBackList.add(checkTransDetailsPartialCallBack);
        return this;
    }

    public interface CheckTransDetailsPartialCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult result);
    }

    public String getBbox() {
        return bbox;
    }

    public CheckTransDetailsPartialAPI setBbox(String bbox) {
        this.bbox = bbox;
        return this;
    }

    public String getPlayername() {
        return playername;
    }

    public CheckTransDetailsPartialAPI setPlayername(String playername) {
        this.playername = playername;
        return this;
    }

    public String getRules() {
        return rules;
    }

    public CheckTransDetailsPartialAPI setRules(String rules) {
        this.rules = rules;
        return this;
    }
}

