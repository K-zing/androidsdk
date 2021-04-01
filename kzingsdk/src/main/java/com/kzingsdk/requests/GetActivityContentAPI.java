package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLDecoder;

import io.reactivex.Observable;

public class GetActivityContentAPI extends CoreRequest {

    GetActivityContentAPI() {
        super();
    }

    private String actid ;

    @Override
    protected String getAction() {
        return Action.getActivityContent;
    }

    @Override
    protected Observable<String> validateParams() {
        if(actid == null || actid.length() == 0){
            return Observable.just("ActID is not valid");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson(){
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("actid",actid);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> URLDecoder.decode(jsonResponse.optString("response"), "UTF-8"));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityContent -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetActivityListContentCallBack) kzingCallBack).onSuccess(activityContent);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetActivityContentAPI addGetActivityListContentCallBack(GetActivityListContentCallBack getActivityListCallBack){
        kzingCallBackList.add(getActivityListCallBack);
        return this;
    }

    public interface GetActivityListContentCallBack extends KzingCallBack{
        void onSuccess(String htmlContent);
    }

    /**
     * @param actid From {@link com.kzingsdk.entity.ActivityItem} returned by {@link GetActivityListAPI}
     */
    public GetActivityContentAPI setParamActid(String actid) {
        this.actid = actid;
        return this;
    }

}
