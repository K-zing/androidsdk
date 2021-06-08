package com.kzingsdk.requests.K36;

import android.content.Context;

import com.kzingsdk.entity.K36.K36ActivityInfo;
import com.kzingsdk.requests.ActivitySignInAPI;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ActivityCheckRedeemAPI extends BaseK36API {

    ActivityCheckRedeemAPI() {
        super();
    }

    @Override
    protected String getK36Action() {
        return Action.activityCheckRedeem;
    }

    private String actid;

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
    public Observable<K36ActivityInfo> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    return K36ActivityInfo.newInstance(jsonResponse.optJSONObject("data").optJSONObject("result"));
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(k36ActivityInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ActivityCheckRedeemAPICallBack) kzingCallBack).onSuccess(k36ActivityInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ActivityCheckRedeemAPI addActivityCheckRedeemAPICallBack(ActivityCheckRedeemAPICallBack activityCheckRedeemAPICallBack) {
        kzingCallBackList.add(activityCheckRedeemAPICallBack);
        return this;
    }

    public interface ActivityCheckRedeemAPICallBack extends KzingCallBack {
        void onSuccess(K36ActivityInfo k36ActivityInfo);
    }


    public ActivityCheckRedeemAPI setActid(String actid) {
        this.actid = actid;
        return this;
    }

}
