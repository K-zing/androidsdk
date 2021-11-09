package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class VerifyWdPasswordAPI extends CoreRequest {

    private String wdpassword = null;
    private String username = null;

    VerifyWdPasswordAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.verifyWdPassword;
    }

    @Override
    protected Observable<String> validateParams() {
        if (wdpassword == null) {
            return Observable.just("WdPassword is missing");
        }
        if (username == null) {
            return Observable.just("Username is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("wdpassword", wdpassword);
            jsonData.put("username", username);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<Boolean> requestRx(final Context context) {
        return super.baseExecute(context).map((result)-> true);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(success -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((VerifyWdPasswordCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public VerifyWdPasswordAPI addVerifyWdPasswordCallBack(VerifyWdPasswordCallBack verifyWdPasswordCallBack) {
        kzingCallBackList.add(verifyWdPasswordCallBack);
        return this;
    }

    public interface VerifyWdPasswordCallBack extends KzingCallBack {
        void onSuccess(Boolean success);
    }

    public VerifyWdPasswordAPI setWdpassword(String wdpassword) {
        this.wdpassword = wdpassword;
        return this;
    }

    public VerifyWdPasswordAPI setUsername(String username) {
        this.username = username;
        return this;
    }

}
