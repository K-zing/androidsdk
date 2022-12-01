package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ActivityCanSignInResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ActivityCanSignInAPI extends CoreRequest {

    private String actid;

    ActivityCanSignInAPI() {
        super();

    }

    @Override
    protected String getAction() {
        return Action.activityCanSignIn;
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
    public Observable<ActivityCanSignInResult> requestRx(Context context) {
        return super.baseExecute(context).map(ActivityCanSignInResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityCanSignInResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ActivityCanSignInCallBack) kzingCallBack).onSuccess(activityCanSignInResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ActivityCanSignInAPI addActivityCanSignInCallBack(ActivityCanSignInCallBack activityCanSignInCallBack) {
        kzingCallBackList.add(activityCanSignInCallBack);
        return this;
    }

    /**
     * @param actid From {@link com.kzingsdk.entity.ActivityItem} returned by {@link GetActivityListAPI}
     */
    public ActivityCanSignInAPI setActid(String actid) {
        this.actid = actid;
        return this;
    }

    public interface ActivityCanSignInCallBack extends KzingCallBack {
        void onSuccess(ActivityCanSignInResult activityCanSignInResult);
    }

}
