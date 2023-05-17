package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ProfileImage;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class EnableMobileAPI extends CoreRequest {

    String uphone;

    public EnableMobileAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.enableMobile;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("uphone", uphone);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SimpleApiResult> requestRx(Context context) {
        return super.baseExecute(context).map(SimpleApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((EnableMobileCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public EnableMobileAPI addEnableMobileCallBack(EnableMobileAPI.EnableMobileCallBack enableMobileCallBack) {
        kzingCallBackList.add(enableMobileCallBack);
        return this;
    }

    public interface EnableMobileCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult result);
    }

    public EnableMobileAPI setUphone(String uphone) {
        this.uphone = uphone;
        return this;
    }
}
