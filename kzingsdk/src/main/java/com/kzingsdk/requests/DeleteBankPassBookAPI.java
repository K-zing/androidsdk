package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;
public class DeleteBankPassBookAPI extends CoreRequest {

    private String wdBankId;

    DeleteBankPassBookAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.deleteBankPassBook;
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
                    ((DeleteBankPassBookCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public DeleteBankPassBookAPI addDeleteBankPassBookCallBack(DeleteBankPassBookCallBack deleteBankPassBookCallBack) {
        kzingCallBackList.add(deleteBankPassBookCallBack);
        return this;
    }

    public interface DeleteBankPassBookCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }

    public DeleteBankPassBookAPI setWdBankId(String wdBankId) {
        this.wdBankId = wdBankId;
        return this;
    }

}

