package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CheckUserNameExistAPI extends CoreRequest {

    private String userName;

    CheckUserNameExistAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.checkUserNameExist;
    }

    @Override
    protected Observable<String> validateParams() {
        if (userName == null || userName.length() == 0) {
            return Observable.just("User Name is not valid");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("name", userName);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> jsonResponse.optBoolean("isExist", false));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(isExist -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((CheckUserNameExistCallBack) kzingCallBack).onSuccess(isExist);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CheckUserNameExistAPI addCheckUserNameExistCallBack(CheckUserNameExistAPI.CheckUserNameExistCallBack checkUserNameExistCallBack) {
        kzingCallBackList.add(checkUserNameExistCallBack);
        return this;
    }

    public CheckUserNameExistAPI setParamUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public interface CheckUserNameExistCallBack extends KzingCallBack {
        void onSuccess(Boolean isExist);
    }

}
