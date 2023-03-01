package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class UploadBankPassBookAPI extends CoreRequest {
    
    private String wdBankId;
    private String bankPassbook;

    UploadBankPassBookAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.uploadBankPassBook;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("wdbankid", wdBankId);
            jsonData.put("bankpassbook", bankPassbook);
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
                    ((UploadBankPassBookCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public UploadBankPassBookAPI addUploadBankPassBookCallBack(UploadBankPassBookCallBack uploadBankPassBookCallBack) {
        kzingCallBackList.add(uploadBankPassBookCallBack);
        return this;
    }

    public interface UploadBankPassBookCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }

    public UploadBankPassBookAPI setWdBankId(String wdBankId) {
        this.wdBankId = wdBankId;
        return this;
    }

    public UploadBankPassBookAPI setBankPassbook(String bankPassbook) {
        this.bankPassbook = bankPassbook;
        return this;
    }
}

