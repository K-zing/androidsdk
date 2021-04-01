package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.WithdrawField;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class AddEWalletBankCardAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.addEWalletBankCard;
    }

    private String bid = null;
    private ArrayList<WithdrawField> withdrawFieldList = null;

    AddEWalletBankCardAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        if (bid == null) {
            return Observable.just("BID is missing");
        }
        return super.validateParams();
    }


    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("bid", bid);
            if (withdrawFieldList != null && withdrawFieldList.size() > 0) {
                JSONObject withdrawFieldData = new JSONObject();
                for (WithdrawField withdrawField : withdrawFieldList) {
                    withdrawFieldData.put(withdrawField.getField(), withdrawField.getInput());
                }
                jsonData.put("data", withdrawFieldData);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(string -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((AddEWalletBankCardCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public AddEWalletBankCardAPI addAddEWalletBankCardCallBack(AddEWalletBankCardCallBack addEWalletBankCardCallBack) {
        kzingCallBackList.add(addEWalletBankCardCallBack);
        return this;
    }

    public interface AddEWalletBankCardCallBack extends KzingCallBack {
        void onSuccess();
    }

    public AddEWalletBankCardAPI setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public AddEWalletBankCardAPI setWithdrawFieldList(ArrayList<WithdrawField> withdrawFieldList) {
        this.withdrawFieldList = withdrawFieldList;
        return this;
    }

}

