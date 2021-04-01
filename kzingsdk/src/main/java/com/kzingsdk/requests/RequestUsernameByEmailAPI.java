package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RequestUsernameResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RequestUsernameByEmailAPI extends CoreRequest {

    private String email = null;
    private String validateCode = null;


    RequestUsernameByEmailAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.requestUsernameByEmail;
    }

    @Override
    protected Observable<String> validateParams() {
        if (email == null) {
            return Observable.just("Email is missing");
        }
        if (validateCode == null) {
            return Observable.just("ValidateCode is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("email", email);
            jsonData.put("validateCode", validateCode);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<RequestUsernameResult> requestRx(final Context context) {
        return super.baseExecute(context).map(RequestUsernameResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(requestUsernameResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RequestUsernameByEmailCallBack) kzingCallBack).onSuccess(requestUsernameResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RequestUsernameByEmailAPI addRequestUsernameByEmailCallBack(RequestUsernameByEmailCallBack requestUsernameByEmailCallBack) {
        kzingCallBackList.add(requestUsernameByEmailCallBack);
        return this;
    }

    public interface RequestUsernameByEmailCallBack extends KzingCallBack {
        void onSuccess(RequestUsernameResult requestUsernameResult);
    }

    public RequestUsernameByEmailAPI setEmail(String email) {
        this.email = email;
        return this;
    }

    public RequestUsernameByEmailAPI setValidateCode(String validateCode) {
        this.validateCode = validateCode;
        return this;
    }

}
