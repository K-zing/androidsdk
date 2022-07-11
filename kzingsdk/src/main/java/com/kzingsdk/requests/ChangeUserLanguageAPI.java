package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ChangeUserLanguageAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.changeUserLanguage;
    }

    private String lang = "";

    ChangeUserLanguageAPI() {
        super();
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
    public Observable<SimpleApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SimpleApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ChangeUserLanguageCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ChangeUserLanguageAPI addChangeUserLanguageCallBack(ChangeUserLanguageCallBack changeUserLanguageCallBack) {
        kzingCallBackList.add(changeUserLanguageCallBack);
        return this;
    }

    public interface ChangeUserLanguageCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }


    public String getLang() {
        return lang;
    }

    public ChangeUserLanguageAPI setLang(String lang) {
        this.lang = lang;
        return this;
    }

}

