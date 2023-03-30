package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetPhoneByNameResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetPhoneByNameAPI extends CoreRequest {
    private String loginName;

    GetPhoneByNameAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getPhoneByName;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("loginame", loginName);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<GetPhoneByNameResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetPhoneByNameResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetPhoneByNameCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetPhoneByNameAPI addGetPhoneByNameCallBack(GetPhoneByNameCallBack getPhoneByNameCallBack) {
        kzingCallBackList.add(getPhoneByNameCallBack);
        return this;
    }

    public interface GetPhoneByNameCallBack extends KzingCallBack {
        void onSuccess(GetPhoneByNameResult simpleApiResult);
    }

    public GetPhoneByNameAPI setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }
}

