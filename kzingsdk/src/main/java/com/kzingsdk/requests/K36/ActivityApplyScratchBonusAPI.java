package com.kzingsdk.requests.K36;

import android.content.Context;

import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ActivityApplyScratchBonusAPI extends BaseK36API {

    private String actid;
    private String dno;
    private String gpid;
    ActivityApplyScratchBonusAPI() {
        super();
    }

    @Override
    protected String getK36Action() {
        return Action.activityApplyScratchBonus;
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
            jsonData.put("id", actid);
            jsonData.put("dno", dno);
            jsonData.put("gpid", gpid);
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
                    ((ActivityApplyScratchBonusAPICallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ActivityApplyScratchBonusAPI addActivityApplyScratchBonusAPICallBack(ActivityApplyScratchBonusAPICallBack activityApplyScratchBonusAPICallBack) {
        kzingCallBackList.add(activityApplyScratchBonusAPICallBack);
        return this;
    }

    public ActivityApplyScratchBonusAPI setActid(String actid) {
        this.actid = actid;
        return this;
    }

    public ActivityApplyScratchBonusAPI setDno(String dno) {
        this.dno = dno;
        return this;
    }

    public ActivityApplyScratchBonusAPI setGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }

    public interface ActivityApplyScratchBonusAPICallBack extends KzingCallBack {
        void onSuccess();
    }

}
