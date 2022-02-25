package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CheckActivityRedeemableAPI extends CoreRequest {

    CheckActivityRedeemableAPI() {
        super();
    }

    private String actid;

    @Override
    protected String getAction() {
        return Action.checkActivityRedeemable;
    }

    @Override
    protected Observable<String> validateParams() {
        if (actid == null || actid.length() == 0) {
            return Observable.just("ActID is not valid");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("actid", actid);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            return jsonResponse.optJSONObject("response").optBoolean("isRedeemable");
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(isRedeemable -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((CheckActivityRedeemableCallBack) kzingCallBack).onSuccess(isRedeemable);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CheckActivityRedeemableAPI addCheckActivityRedeemableCallBack(CheckActivityRedeemableCallBack checkGiftRedeembableCallBack) {
        kzingCallBackList.add(checkGiftRedeembableCallBack);
        return this;
    }

    public interface CheckActivityRedeemableCallBack extends KzingCallBack {
        void onSuccess(Boolean isRedeemable);
    }

    public CheckActivityRedeemableAPI setParamActid(String actid) {
        this.actid = actid;
        return this;
    }


}
