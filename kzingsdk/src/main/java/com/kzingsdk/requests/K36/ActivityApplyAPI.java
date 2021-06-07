package com.kzingsdk.requests.K36;

import android.content.Context;

import com.kzingsdk.entity.K36.K36ActivityInfo;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ActivityApplyAPI extends BaseK36API {

    ActivityApplyAPI() {
        super();
    }

    @Override
    protected String getK36Action() {
        return Action.activityApply;
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
            jsonData.put("id", actid);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    return true;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ignored -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ActivityApplyAPICallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ActivityApplyAPI addActivityApplyAPICallBack(ActivityApplyAPICallBack activityApplyAPICallBack) {
        kzingCallBackList.add(activityApplyAPICallBack);
        return this;
    }

    public interface ActivityApplyAPICallBack extends KzingCallBack {
        void onSuccess();
    }


    public ActivityApplyAPI setActid(String actid) {
        this.actid = actid;
        return this;
    }

}
