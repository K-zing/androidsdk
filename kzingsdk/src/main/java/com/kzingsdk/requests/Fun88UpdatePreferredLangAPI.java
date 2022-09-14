package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONObject;

import io.reactivex.Observable;

public class Fun88UpdatePreferredLangAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.fun88UpdatePreferredLang;
    }

    Fun88UpdatePreferredLangAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }


    @Override
    protected JSONObject generateParamsJson() {
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
                    ((Fun88UpdatePreferredLangCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public Fun88UpdatePreferredLangAPI addFun88UpdatePreferredLangCallBack(Fun88UpdatePreferredLangCallBack fun88UpdatePreferredLangCallBack) {
        kzingCallBackList.add(fun88UpdatePreferredLangCallBack);
        return this;
    }

    public interface Fun88UpdatePreferredLangCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }
}

