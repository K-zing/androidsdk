package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitAtmOldBankDepositAPI extends CoreRequest {
    private String amount;
    private String depositDate;
    private String depositSlip;
    private String oldBankAccount;
    private String wbankId;

    SubmitAtmOldBankDepositAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitAtmOldBankDeposit;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("amount", amount);
            jsonData.put("depositdate", depositDate);
            jsonData.put("depositslip", depositSlip);
            jsonData.put("oldbankaccount", oldBankAccount);
            jsonData.put("wbankid", wbankId);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SimpleApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SimpleApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitAtmOldBankDepositCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitAtmOldBankDepositAPI addSubmitAtmOldBankDepositCallBack(SubmitAtmOldBankDepositCallBack submitAtmOldBankDepositCallBack) {
        kzingCallBackList.add(submitAtmOldBankDepositCallBack);
        return this;
    }

    public interface SubmitAtmOldBankDepositCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }

    public SubmitAtmOldBankDepositAPI setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public SubmitAtmOldBankDepositAPI setDepositDate(String depositDate) {
        this.depositDate = depositDate;
        return this;
    }

    public SubmitAtmOldBankDepositAPI setDepositSlip(String depositSlip) {
        this.depositSlip = depositSlip;
        return this;
    }

    public SubmitAtmOldBankDepositAPI setOldBankAccount(String oldBankAccount) {
        this.oldBankAccount = oldBankAccount;
        return this;
    }

    public SubmitAtmOldBankDepositAPI setWbankId(String wbankId) {
        this.wbankId = wbankId;
        return this;
    }
}

