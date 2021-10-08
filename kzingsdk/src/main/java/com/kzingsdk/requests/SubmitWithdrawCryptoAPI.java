package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitWithdrawCryptoAPI extends CoreRequest {

    SubmitWithdrawCryptoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitWithdrawCrypto;
    }

    private String amount;
    private String cryptorate;
    private String wdpassword;
    private String wdbank;
    private String note;

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (amount != null)
                jsonData.put("amount", amount);
            if (cryptorate != null)
                jsonData.put("cryptorate", cryptorate);
            if (wdpassword != null)
                jsonData.put("wdpassword", wdpassword);
            if (wdbank != null)
                jsonData.put("wdbank", wdbank);
            if (note != null)
                jsonData.put("note", note);
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
                    ((SubmitWithdrawCryptoCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitWithdrawCryptoAPI addSubmitWithdrawCryptoCallBack(SubmitWithdrawCryptoAPI.SubmitWithdrawCryptoCallBack submitWithdrawCryptoCallBack) {
        kzingCallBackList.add(submitWithdrawCryptoCallBack);
        return this;
    }

    public interface SubmitWithdrawCryptoCallBack extends KzingCallBack {
        void onSuccess();
    }

    public SubmitWithdrawCryptoAPI setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public SubmitWithdrawCryptoAPI setCryptoRate(String cryptorate) {
        this.cryptorate = cryptorate;
        return this;
    }

    public SubmitWithdrawCryptoAPI setWdpassword(String wdpassword) {
        this.wdpassword = wdpassword;
        return this;
    }

    public SubmitWithdrawCryptoAPI setWdbank(String wdbank) {
        this.wdbank = wdbank;
        return this;
    }

    public SubmitWithdrawCryptoAPI setNote(String note) {
        this.note = note;
        return this;
    }
}
