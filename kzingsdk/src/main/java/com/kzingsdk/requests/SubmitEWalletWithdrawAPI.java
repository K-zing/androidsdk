package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.WithdrawInfo;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitEWalletWithdrawAPI extends CoreRequest {

    private String bid = null;
    private Double amount = 0d;
    private String withdrawPassword = null;

    SubmitEWalletWithdrawAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        if (bid == null) {
            return Observable.just("BID is missing.");
        }
        if (amount <= 0) {
            return Observable.just("Amount cannot be lower than 0.");
        }
        return super.validateParams();
    }

    @Override
    protected String getAction() {
        return Action.submitEWalletWithdraw;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("bid", bid);
            jsonData.put("amount", amount);
            if (withdrawPassword != null) {
                jsonData.put("wdpassword", withdrawPassword);
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
                    ((SubmitEWalletWithdrawCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitEWalletWithdrawAPI addSubmitEWalletWithdrawCallBack(SubmitEWalletWithdrawCallBack submitEWalletWithdrawCallBack) {
        kzingCallBackList.add(submitEWalletWithdrawCallBack);
        return this;
    }

    public interface SubmitEWalletWithdrawCallBack extends KzingCallBack {
        void onSuccess();
    }

    public SubmitEWalletWithdrawAPI setParamBid(String playerBankId) {
        this.bid = playerBankId;
        return this;
    }


    public SubmitEWalletWithdrawAPI setParamAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    /**
     * @param withdrawPassword Please check you must pass this param if {@link WithdrawInfo#getNeedWithdrawPassword()} is true.
     */
    public SubmitEWalletWithdrawAPI setParamWithdrawPassword(String withdrawPassword) {
        this.withdrawPassword = withdrawPassword;
        return this;
    }
}

