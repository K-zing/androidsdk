package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class IsAccountEmailMatchAPI extends CoreRequest {


    private String loginName = null;
    private String email = null;

    IsAccountEmailMatchAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.isAccountEmailMatch;
    }

    @Override
    protected Observable<String> validateParams() {
        if (loginName == null) {
            return Observable.just("Login name is missing");
        }
        if (email == null) {
            return Observable.just("Email is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("name", loginName);
            jsonData.put("email", email);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<Boolean> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> true);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(success -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((IsAccountEmailMatchCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public IsAccountEmailMatchAPI addIsAccountEmailMatchCallBack(IsAccountEmailMatchCallBack isAccountEmailMatchCallBack) {
        kzingCallBackList.add(isAccountEmailMatchCallBack);
        return this;
    }

    public interface IsAccountEmailMatchCallBack extends KzingCallBack {
        void onSuccess(Boolean success);
    }

    public IsAccountEmailMatchAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public IsAccountEmailMatchAPI setParamEmail(String email) {
        this.email = email;
        return this;
    }

}
