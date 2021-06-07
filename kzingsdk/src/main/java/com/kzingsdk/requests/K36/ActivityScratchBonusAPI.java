package com.kzingsdk.requests.K36;

import android.content.Context;

import com.kzingsdk.entity.K36.K36ActivityInfo;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ActivityScratchBonusAPI extends BaseK36API {

    ActivityScratchBonusAPI() {
        super();
    }

    @Override
    protected String getK36Action() {
        return Action.activityScratchBonus;
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
                    return K36ActivityInfo.newInstance(jsonResponse.optJSONObject("result"));
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityScratchBonus -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ActivityScratchBonusCallBack) kzingCallBack).onSuccess(activityScratchBonus);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ActivityScratchBonusAPI addActivityScratchBonusCallBack(ActivityScratchBonusCallBack activityScratchBonusCallBack) {
        kzingCallBackList.add(activityScratchBonusCallBack);
        return this;
    }

    public interface ActivityScratchBonusCallBack extends KzingCallBack {
        void onSuccess(K36ActivityInfo activityScratchBonus);
    }

    public ActivityScratchBonusAPI setActid(String actid) {
        this.actid = actid;
        return this;
    }

}
