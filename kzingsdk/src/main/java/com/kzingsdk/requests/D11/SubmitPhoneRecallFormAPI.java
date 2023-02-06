package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitPhoneRecallFormAPI extends BaseD11API {

    private String phoneNo;
    private String callbackDate;
    private String callbackStart;
    private String callbackEnd;
    private String cid;
    private String scid;
    private String description;

    SubmitPhoneRecallFormAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.submitPhoneRecallForm;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("phoneNo", phoneNo);
            jsonData.put("callbackdate", callbackDate);
            jsonData.put("callbackstart", callbackStart);
            jsonData.put("callbackend", callbackEnd);
            jsonData.put("cid", cid);
            jsonData.put("scid", scid);
            jsonData.put("description", description);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> true);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ignored -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitPhoneRecallFormCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitPhoneRecallFormAPI addSubmitPhoneRecallFormCallBack(SubmitPhoneRecallFormCallBack submitPhoneRecallFormCallBack) {
        kzingCallBackList.add(submitPhoneRecallFormCallBack);
        return this;
    }

    public SubmitPhoneRecallFormAPI setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public SubmitPhoneRecallFormAPI setCallbackDate(String callbackDate) {
        this.callbackDate = callbackDate;
        return this;
    }

    public SubmitPhoneRecallFormAPI setCallbackStart(String callbackStart) {
        this.callbackStart = callbackStart;
        return this;
    }

    public SubmitPhoneRecallFormAPI setCallbackEnd(String callbackEnd) {
        this.callbackEnd = callbackEnd;
        return this;
    }

    public SubmitPhoneRecallFormAPI setCid(String cid) {
        this.cid = cid;
        return this;
    }

    public SubmitPhoneRecallFormAPI setScid(String scid) {
        this.scid = scid;
        return this;
    }

    public SubmitPhoneRecallFormAPI setDescription(String description) {
        this.description = description;
        return this;
    }

    public interface SubmitPhoneRecallFormCallBack extends KzingCallBack {
        void onSuccess();
    }
}
