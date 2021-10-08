package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class EditWithdrawCryptoAPI extends CoreRequest {

    EditWithdrawCryptoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.editWithdrawCrypto;
    }

    private String wdbankid;
    private String status;

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (wdbankid != null)
                jsonData.put("wdbankid", wdbankid);
            if (status != null)
                jsonData.put("status", status);
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
                    ((EditWithdrawCryptoCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public EditWithdrawCryptoAPI addEditWithdrawCryptoCallBack(EditWithdrawCryptoAPI.EditWithdrawCryptoCallBack editWithdrawCryptoCallBack) {
        kzingCallBackList.add(editWithdrawCryptoCallBack);
        return this;
    }

    public interface EditWithdrawCryptoCallBack extends KzingCallBack {
        void onSuccess();
    }

    public EditWithdrawCryptoAPI setWdbankId(String wdbankid) {
        this.wdbankid = wdbankid;
        return this;
    }

    public EditWithdrawCryptoAPI setReceipient(String receipient) {
        this.status = receipient;
        return this;
    }
}
