package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ActivitySignInAPI extends CoreRequest {

    private String actid;

    ActivitySignInAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.activitySignIn;
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
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityContent -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ActivitySignInCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ActivitySignInAPI addActivitySignInCallBack(ActivitySignInCallBack activitySignInCallBack) {
        kzingCallBackList.add(activitySignInCallBack);
        return this;
    }

    /**
     * @param actid From {@link com.kzingsdk.entity.ActivityItem} returned by {@link GetActivityListAPI}
     */
    public ActivitySignInAPI setActid(String actid) {
        this.actid = actid;
        return this;
    }

    public interface ActivitySignInCallBack extends KzingCallBack {
        void onSuccess();
    }

}
