package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RegSendSmsResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RegSendSmsAPI extends CoreRequest {


    private String loginName = null;
    private String phone = null;
    private String uphonecountry = null;

    RegSendSmsAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.regSendSms;
    }

    @Override
    protected Observable<String> validateParams() {
        if (loginName == null) {
            return Observable.just("Login name is missing");
        }
        if (phone == null) {
            return Observable.just("Phone number is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("username", loginName);
            jsonData.put("uphone", phone);
            jsonData.put("uphonecountry", uphonecountry);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<RegSendSmsResult> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            JSONObject response = jsonResponse.optJSONObject("response");
            return RegSendSmsResult.newInstance(response);
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(regSendSmsResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RegSendSmsCallBack) kzingCallBack).onSuccess(regSendSmsResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RegSendSmsAPI addRegSendSmsCallBack(RegSendSmsCallBack regSendSmsCallBack) {
        kzingCallBackList.add(regSendSmsCallBack);
        return this;
    }

    public interface RegSendSmsCallBack extends KzingCallBack {
        void onSuccess(RegSendSmsResult regSendSmsResult);
    }

    public RegSendSmsAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public RegSendSmsAPI setParamPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RegSendSmsAPI setParamUPhoneCountry(String uphonecountry) {
        this.uphonecountry = uphonecountry;
        return this;
    }

}
