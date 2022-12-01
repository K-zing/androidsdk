package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import io.reactivex.Observable;


public class SubmitPhoneDepositAPI extends CoreRequest {

    private String bank;
    private String amount;
    private String bcid;
    private String playerPhone;
    private Calendar depositDate;
    private String depositSlipBase64;
    private String userBank;
    private String prevdno;
    private String transno;


    SubmitPhoneDepositAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitPhoneDeposit;
    }


    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("bank", bank);
            jsonData.put("amount", amount);
            jsonData.put("bcid", bcid);
            jsonData.put("playerphone", playerPhone);
            jsonData.put("depositdate", Constant.DATE_FORMAT.format(depositDate.getTime()));
            jsonData.put("depositslip", depositSlipBase64);
            if (userBank != null)
                jsonData.put("userbank", userBank);
            if (prevdno != null)
                jsonData.put("prevdno", prevdno);
            if (transno != null)
                jsonData.put("transno", transno);

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
                    ((SubmitPhoneDepositCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitPhoneDepositAPI addSubmitPhoneDepositCallBack(SubmitPhoneDepositAPI.SubmitPhoneDepositCallBack submitPhoneDepositCallBack) {
        kzingCallBackList.add(submitPhoneDepositCallBack);
        return this;
    }

    public SubmitPhoneDepositAPI setBank(String bank) {
        this.bank = bank;
        return this;
    }

    public SubmitPhoneDepositAPI setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public SubmitPhoneDepositAPI setBcid(String bcid) {
        this.bcid = bcid;
        return this;
    }

    public SubmitPhoneDepositAPI setPlayerPhone(String playerPhone) {
        this.playerPhone = playerPhone;
        return this;
    }

    public SubmitPhoneDepositAPI setDepositDate(Calendar depositDate) {
        this.depositDate = depositDate;
        return this;
    }

    public SubmitPhoneDepositAPI setDepositSlipBase64(String depositSlipBase64) {
        this.depositSlipBase64 = depositSlipBase64;
        return this;
    }

    public SubmitPhoneDepositAPI setUserBank(String userBank) {
        this.userBank = userBank;
        return this;
    }

    public SubmitPhoneDepositAPI setPrevdno(String prevdno) {
        this.prevdno = prevdno;
        return this;
    }

    public SubmitPhoneDepositAPI setTransno(String transno) {
        this.transno = transno;
        return this;
    }

    public interface SubmitPhoneDepositCallBack extends KzingCallBack {
        void onSuccess(String success);
    }


}
