package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;


public class AddWithdrawalCryptoAPI extends CoreRequest {

    AddWithdrawalCryptoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.addWithdrawalCrypto;
    }

    private String bankcode;
    private String network;
    private String address;
    private String note;

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (bankcode != null)
                jsonData.put("bankcode", bankcode);
            if (network != null)
                jsonData.put("network", network);
            if (address != null)
                jsonData.put("address", address);
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

}
