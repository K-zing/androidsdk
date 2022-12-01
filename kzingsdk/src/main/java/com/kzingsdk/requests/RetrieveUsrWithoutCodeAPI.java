package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RetrieveUsrWithoutCodeResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RetrieveUsrWithoutCodeAPI extends CoreRequest {

    private String email = null;

    RetrieveUsrWithoutCodeAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.retrieveUsrWithoutCode;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("email", email);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<RetrieveUsrWithoutCodeResult> requestRx(final Context context) {
        return super.baseExecute(context).map(RetrieveUsrWithoutCodeResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(retrieveUsrWithoutCodeResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RetrieveUsrWithoutCodeCallBack) kzingCallBack).onSuccess(retrieveUsrWithoutCodeResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RetrieveUsrWithoutCodeAPI addRetrieveUsrWithoutCodeCallBack(RetrieveUsrWithoutCodeCallBack retrieveUsrWithoutCodeCallBack) {
        kzingCallBackList.add(retrieveUsrWithoutCodeCallBack);
        return this;
    }

    public RetrieveUsrWithoutCodeAPI setEmail(String email) {
        this.email = email;
        return this;
    }

    public interface RetrieveUsrWithoutCodeCallBack extends KzingCallBack {
        void onSuccess(RetrieveUsrWithoutCodeResult retrieveUsrWithoutCodeResult);
    }

}
