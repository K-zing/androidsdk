package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class AppLinkInfoAPI extends CoreRequest {

    AppLinkInfoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.appLinkInfo;
    }

    private String gpid;

    @Override
    protected Observable<String> validateParams() {
        if(gpid == null || gpid.length() == 0){
            return Observable.just("GPID is not valid");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson(){
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gpid", gpid);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<JSONObject> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> jsonResponse.optJSONObject("response"));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(jsonResponse -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((AppLinkInfoCallBack) kzingCallBack).onSuccess(jsonResponse);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public AppLinkInfoAPI addAppLinkInfoCallBack(AppLinkInfoAPI.AppLinkInfoCallBack getActivityListCallBack){
        kzingCallBackList.add(getActivityListCallBack);
        return this;
    }

    public interface AppLinkInfoCallBack extends KzingCallBack{
        void onSuccess(JSONObject jsonResponse);
    }

    public AppLinkInfoAPI setParamGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }

}

