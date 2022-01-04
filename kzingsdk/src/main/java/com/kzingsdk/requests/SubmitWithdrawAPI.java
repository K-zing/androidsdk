package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.PlayerBankCard;
import com.kzingsdk.entity.WithdrawInfo;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitWithdrawAPI extends CoreRequest {

    private String playerBankId = null;
    private Double amount = 0d;
    private String withdrawPassword = null;

    private String smsCode = null;
    private String smsPhoneNo = null;
    private String smsPhoneNoCountry = null;

    SubmitWithdrawAPI() {
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
        return Action.submitWithdraw;
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
            if (smsCode != null) {
                jsonData.put("smsCode", smsCode);
            }
            if (smsPhoneNo != null) {
                jsonData.put("smsPhoneNo", smsPhoneNo);
            }
            if (smsPhoneNoCountry != null) {
                jsonData.put("smsPhoneNoCountry", smsPhoneNoCountry);
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
                    ((SubmitWithdrawCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitWithdrawAPI addSubmitWithdrawCallBack(SubmitWithdrawCallBack submitWithdrawCallBack) {
        kzingCallBackList.add(submitWithdrawCallBack);
        return this;
    }

    public interface SubmitWithdrawCallBack extends KzingCallBack {
        void onSuccess();
    }

    /**
     * @param playerBankId Equal to {@link PlayerBankCard#getPlayerBankId()}
     */
    public SubmitWithdrawAPI setParamPlayerBankId(String playerBankId) {
        this.playerBankId = playerBankId;
        return this;
    }


    public SubmitWithdrawAPI setParamAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    /**
     * @param withdrawPassword Please check you must pass this param if {@link WithdrawInfo#getNeedWithdrawPassword()} is true.
     */
    public SubmitWithdrawAPI setParamWithdrawPassword(String withdrawPassword) {
        this.withdrawPassword = withdrawPassword;
        return this;
    }

    public SubmitWithdrawAPI setParamSmsCode(String smsCode) {
        this.smsCode = smsCode;
        return this;
    }
    public SubmitWithdrawAPI setParamSmsPhoneNo(String smsPhoneNo) {
        this.smsPhoneNo = smsPhoneNo;
        return this;
    }
    public SubmitWithdrawAPI setParamSmsPhoneNoCountry(String smsPhoneNoCountry) {
        this.smsPhoneNoCountry = smsPhoneNoCountry;
        return this;
    }



}

