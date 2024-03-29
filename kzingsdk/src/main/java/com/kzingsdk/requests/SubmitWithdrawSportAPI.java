package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.PlayerBankCard;
import com.kzingsdk.entity.WithdrawInfo;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitWithdrawSportAPI extends CoreRequest {

    private String playerBankId = null;
    private Double amount = 0d;
    private String withdrawPassword = null;

    SubmitWithdrawSportAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        if (playerBankId == null) {
            return Observable.just("Player bank ID is missing.");
        }
        if (amount <= 0) {
            return Observable.just("Amount cannot be lower than 0.");
        }
        return super.validateParams();
    }

    @Override
    protected String getAction() {
        return Action.submitWithdrawSport;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("usenew", "1");
            jsonData.put("wdbank", playerBankId);
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
                    ((SubmitWithdrawSportCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitWithdrawSportAPI addSubmitWithdrawSportCallBack(SubmitWithdrawSportCallBack submitWithdrawSportCallBack) {
        kzingCallBackList.add(submitWithdrawSportCallBack);
        return this;
    }

    /**
     * @param playerBankId Equal to {@link PlayerBankCard#getPlayerBankId()}
     */
    public SubmitWithdrawSportAPI setParamPlayerBankId(String playerBankId) {
        this.playerBankId = playerBankId;
        return this;
    }

    public SubmitWithdrawSportAPI setParamAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    /**
     * @param withdrawPassword Please check you must pass this param if {@link WithdrawInfo#getNeedWithdrawPassword()} is true.
     */
    public SubmitWithdrawSportAPI setParamWithdrawPassword(String withdrawPassword) {
        this.withdrawPassword = withdrawPassword;
        return this;
    }

    public interface SubmitWithdrawSportCallBack extends KzingCallBack {
        void onSuccess();
    }
}

