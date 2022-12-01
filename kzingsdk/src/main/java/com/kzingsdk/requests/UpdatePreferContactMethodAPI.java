package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class UpdatePreferContactMethodAPI extends CoreRequest {

    private String phone;
    private String sms;
    private String email;

    UpdatePreferContactMethodAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.updatePreferContactMethod;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("phone", phone);
            jsonData.put("sms", sms);
            jsonData.put("email", email);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SimpleApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SimpleApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((UpdatePreferContactMethodCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public UpdatePreferContactMethodAPI addUpdatePreferContactMethodCallBack(UpdatePreferContactMethodCallBack updatePreferContactMethodCallBack) {
        kzingCallBackList.add(updatePreferContactMethodCallBack);
        return this;
    }

    public UpdatePreferContactMethodAPI setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UpdatePreferContactMethodAPI setSms(String sms) {
        this.sms = sms;
        return this;
    }

    public UpdatePreferContactMethodAPI setEmail(String email) {
        this.email = email;
        return this;
    }

    public interface UpdatePreferContactMethodCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }
}

