package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitJarvisUTRAPI extends CoreRequest {

    private String bcid;
    private String dno;
    private String amount;
    private String utrcode;

    SubmitJarvisUTRAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitJarvisUTR;
    }


    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("bcid", bcid);
            jsonData.put("dno", dno);
            jsonData.put("amount", amount);
            jsonData.put("utrcode", utrcode);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(success -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitJarvisUTRCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitJarvisUTRAPI addSubmitJarvisUTRCallBack(SubmitJarvisUTRAPI.SubmitJarvisUTRCallBack submitJarvisUTRCallBack) {
        kzingCallBackList.add(submitJarvisUTRCallBack);
        return this;
    }

    public String getBcid() {
        return bcid;
    }

    public SubmitJarvisUTRAPI setBcid(String bcid) {
        this.bcid = bcid;
        return this;
    }

    public String getDno() {
        return dno;
    }

    public SubmitJarvisUTRAPI setDno(String dno) {
        this.dno = dno;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public SubmitJarvisUTRAPI setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public String getUtrcode() {
        return utrcode;
    }

    public SubmitJarvisUTRAPI setUtrcode(String utrcode) {
        this.utrcode = utrcode;
        return this;
    }

    public interface SubmitJarvisUTRCallBack extends KzingCallBack {
        void onSuccess(String success);
    }
}
