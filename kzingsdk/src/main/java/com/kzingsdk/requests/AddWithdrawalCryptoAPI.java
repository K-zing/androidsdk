package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;


public class AddWithdrawalCryptoAPI extends CoreRequest implements RequireCurrency {

    AddWithdrawalCryptoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.addWithdrawalCrypto;
    }

    private String wdpassword;
    private String bankcode;
    private String network;
    private String address;
    private String note;
    private String currency;
    private String smsPhoneNo;
    private String smsPhoneNoCountry;
    private String smscode;

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (wdpassword != null)
                jsonData.put("wdpassword", wdpassword);
            if (bankcode != null)
                jsonData.put("bankcode", bankcode);
            if (network != null)
                jsonData.put("network", network);
            if (address != null)
                jsonData.put("address", address);
            if (note != null)
                jsonData.put("note", note);
            if (smsPhoneNo != null)
                jsonData.put("smsPhoneNo", smsPhoneNo);
            if (smsPhoneNoCountry != null)
                jsonData.put("smsPhoneNoCountry", smsPhoneNoCountry);
            if (smscode != null)
                jsonData.put("smscode", smscode);
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
                    ((AddWithdrawalCryptoCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public AddWithdrawalCryptoAPI addAddWithdrawalCryptoCallBack(AddWithdrawalCryptoAPI.AddWithdrawalCryptoCallBack addWithdrawalCryptoCallBack) {
        kzingCallBackList.add(addWithdrawalCryptoCallBack);
        return this;
    }

    public interface AddWithdrawalCryptoCallBack extends KzingCallBack {
        void onSuccess();
    }

    public AddWithdrawalCryptoAPI setBankCode(String bankcode) {
        this.bankcode = bankcode;
        return this;
    }

    public AddWithdrawalCryptoAPI setNetwork(String network) {
        this.network = network;
        return this;
    }


    public AddWithdrawalCryptoAPI setAddress(String address) {
        this.address = address;
        return this;
    }

    public AddWithdrawalCryptoAPI setNote(String note) {
        this.note = note;
        return this;
    }

    public AddWithdrawalCryptoAPI setWdpassword(String wdpassword) {
        this.wdpassword = wdpassword;
        return this;
    }

    public AddWithdrawalCryptoAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    public AddWithdrawalCryptoAPI setSmsPhoneNo(String smsPhoneNo) {
        this.smsPhoneNo = smsPhoneNo;
        return this;
    }

    public AddWithdrawalCryptoAPI setSmsPhoneNoCountry(String smsPhoneNoCountry) {
        this.smsPhoneNoCountry = smsPhoneNoCountry;
        return this;
    }

    public AddWithdrawalCryptoAPI setSmsCode(String smscode) {
        this.smscode = smscode;
        return this;
    }
}
