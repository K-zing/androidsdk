package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitWithdrawCryptoAPI extends CoreRequest implements RequireCurrency {

    SubmitWithdrawCryptoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitWithdrawCrypto;
    }

    private String amount;
    private String cryptoRate;
    private String wdpassword;
    private String wdbank;
    private String note;
    private String address;
    private String network;
    private String currency;

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (amount != null)
                jsonData.put("amount", amount);
            if (cryptoRate != null)
                jsonData.put("cryptorate", cryptoRate);
            if (wdpassword != null)
                jsonData.put("wdpassword", wdpassword);
            if (wdbank != null)
                jsonData.put("wdbank", wdbank);
            if (note != null)
                jsonData.put("note", note);
            if (address != null)
                jsonData.put("address", address);
            if (network != null)
                jsonData.put("network", network);
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

    @Override
    public String getCurrency() {
        return currency;
    }

    public interface SubmitWithdrawCryptoCallBack extends KzingCallBack {
        void onSuccess();
    }

    public SubmitWithdrawCryptoAPI setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public SubmitWithdrawCryptoAPI setCryptoRate(String cryptoRate) {
        this.cryptoRate = cryptoRate;
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

    public SubmitWithdrawCryptoAPI setAddress(String address) {
        this.address = address;
        return this;
    }

    public SubmitWithdrawCryptoAPI setNetwork(String network) {
        this.network = network;
        return this;
    }

    public SubmitWithdrawCryptoAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
