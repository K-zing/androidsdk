package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ManageWithdrawCryptoAPI extends CoreRequest {

    private String wdbankid;
    private String address;
    private String network;
    private String note;
    private String status;
    private String wdpassword;

    ManageWithdrawCryptoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.manageWithdrawCrypto;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (wdbankid != null)
                jsonData.put("wdbankid", wdbankid);
            if (address != null)
                jsonData.put("address", address);
            if (network != null)
                jsonData.put("network", network);
            if (note != null)
                jsonData.put("note", note);
            if (status != null)
                jsonData.put("status", status);
            if (wdpassword != null)
                jsonData.put("wdpassword", wdpassword);
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
                    ((ManageWithdrawCryptoCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ManageWithdrawCryptoAPI addManageWithdrawCryptoCallBack(ManageWithdrawCryptoAPI.ManageWithdrawCryptoCallBack manageWithdrawCryptoCallBack) {
        kzingCallBackList.add(manageWithdrawCryptoCallBack);
        return this;
    }

    public ManageWithdrawCryptoAPI setWdbankid(String wdbankid) {
        this.wdbankid = wdbankid;
        return this;
    }

    public ManageWithdrawCryptoAPI setAddress(String address) {
        this.address = address;
        return this;
    }

    public ManageWithdrawCryptoAPI setNetwork(String network) {
        this.network = network;
        return this;
    }

    public ManageWithdrawCryptoAPI setNote(String note) {
        this.note = note;
        return this;
    }

    public ManageWithdrawCryptoAPI setStatus(String status) {
        this.status = status;
        return this;
    }

    public ManageWithdrawCryptoAPI setWdpassword(String wdpassword) {
        this.wdpassword = wdpassword;
        return this;
    }

    public interface ManageWithdrawCryptoCallBack extends KzingCallBack {
        void onSuccess();
    }
}
