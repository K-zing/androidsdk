package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetNewsCategoryResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetNewsCategoryAPI extends CoreRequest {
    private String lang;

    GetNewsCategoryAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getNewsCategory;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("lang", lang);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<GetNewsCategoryResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetNewsCategoryResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetNewsCategoryCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetNewsCategoryAPI addGetNewsCategoryCallBack(GetNewsCategoryCallBack getNewsCategoryCallBack) {
        kzingCallBackList.add(getNewsCategoryCallBack);
        return this;
    }

    public interface GetNewsCategoryCallBack extends KzingCallBack {
        void onSuccess(GetNewsCategoryResult result);
    }

    public GetNewsCategoryAPI setLang(String lang) {
        this.lang = lang;
        return this;
    }
}

