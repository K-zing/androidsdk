package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ActivityContentResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetActivityContentAPI extends CoreRequest {

    private String actid;

    GetActivityContentAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getActivityContent;
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
    public Observable<ActivityContentResult> requestRx(Context context) {
        return super.baseExecute(context).map(ActivityContentResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityContentResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetActivityListContentCallBack) kzingCallBack).onSuccess(activityContentResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetActivityContentAPI addGetActivityListContentCallBack(GetActivityListContentCallBack getActivityListCallBack) {
        kzingCallBackList.add(getActivityListCallBack);
        return this;
    }

    /**
     * @param actid From {@link com.kzingsdk.entity.ActivityItem} returned by {@link GetActivityListAPI}
     */
    public GetActivityContentAPI setParamActid(String actid) {
        this.actid = actid;
        return this;
    }

    public interface GetActivityListContentCallBack extends KzingCallBack {
        void onSuccess(ActivityContentResult activityContentResult);
    }

}
