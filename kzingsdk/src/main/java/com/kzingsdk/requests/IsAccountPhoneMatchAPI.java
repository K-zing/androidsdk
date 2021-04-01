package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class IsAccountPhoneMatchAPI extends CoreRequest {


    private String loginName = null;
    private String phone = null;

    IsAccountPhoneMatchAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.isAccountPhoneMatch;
    }

    @Override
    protected Observable<String> validateParams() {
        if (loginName == null) {
            return Observable.just("Login name is missing");
        }
        if (phone == null) {
            return Observable.just("Phone is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("name", loginName);
            jsonData.put("phone", phone);
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
                    ((IsAccountPhoneMatchCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public IsAccountPhoneMatchAPI addIsAccountPhoneMatchCallBack(IsAccountPhoneMatchCallBack isAccountPhoneMatchCallBack) {
        kzingCallBackList.add(isAccountPhoneMatchCallBack);
        return this;
    }

    public interface IsAccountPhoneMatchCallBack extends KzingCallBack {
        void onSuccess(Boolean success);
    }

    public IsAccountPhoneMatchAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public IsAccountPhoneMatchAPI setParamPhone(String phone) {
        this.phone = phone;
        return this;
    }

}
