package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import io.reactivex.Observable;

public class DeleteEWalletBankCardAPI extends CoreRequest {

    DeleteEWalletBankCardAPI() {
        super();
    }

    private String id = null;

    @Override
    protected String getAction() {
        return Action.deleteEWalletBankCard;
    }

    @Override
    protected Observable<String> validateParams() {
        if (id == null) {
            return Observable.just("ID is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("id", id);
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
        requestRx(context).subscribe(message -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((DeleteEWalletBankCardCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public DeleteEWalletBankCardAPI addDeleteEWalletBankCardCallBack(DeleteEWalletBankCardCallBack deleteEWalletBankCardCallBack) {
        kzingCallBackList.add(deleteEWalletBankCardCallBack);
        return this;
    }

    public interface DeleteEWalletBankCardCallBack extends KzingCallBack {
        void onSuccess();
    }

    public DeleteEWalletBankCardAPI setId(String id) {
        this.id = id;
        return this;
    }

}
