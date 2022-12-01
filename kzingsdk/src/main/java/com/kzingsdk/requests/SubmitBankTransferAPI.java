package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SubmitBankTransferResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitBankTransferAPI extends CoreRequest {

    private String ppid;
    private String optionId;
    private String depositUser;
    private String amount;
    private String bank;
    private String utmCode;
    private String ac;
    private String formData;
    private String pgDepositUserName;
    private String protocol;

    SubmitBankTransferAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitBankTransfer;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("ppid", ppid);
            jsonData.put("optionid", optionId);
            jsonData.put("deposituser", depositUser);
            jsonData.put("amount", amount);
            jsonData.put("bank", bank);
            jsonData.put("utm_code", utmCode);
            jsonData.put("ac", ac);
            jsonData.put("formData", formData);
            jsonData.put("pgdepositusername", pgDepositUserName);
            jsonData.put("protocol", protocol);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SubmitBankTransferResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SubmitBankTransferResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(submitBankTransferResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitBankTransferCallBack) kzingCallBack).onSuccess(submitBankTransferResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitBankTransferAPI addSubmitBankTransferCallBack(SubmitBankTransferCallBack submitBankTransferCallBack) {
        kzingCallBackList.add(submitBankTransferCallBack);
        return this;
    }

    public SubmitBankTransferAPI setPpid(String ppid) {
        this.ppid = ppid;
        return this;
    }

    public SubmitBankTransferAPI setOptionId(String optionId) {
        this.optionId = optionId;
        return this;
    }

    public SubmitBankTransferAPI setDepositUser(String depositUser) {
        this.depositUser = depositUser;
        return this;
    }

    public SubmitBankTransferAPI setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public SubmitBankTransferAPI setBank(String bank) {
        this.bank = bank;
        return this;
    }

    public SubmitBankTransferAPI setUtmCode(String utmCode) {
        this.utmCode = utmCode;
        return this;
    }

    public SubmitBankTransferAPI setAc(String ac) {
        this.ac = ac;
        return this;
    }

    public SubmitBankTransferAPI setFormData(String formData) {
        this.formData = formData;
        return this;
    }

    public SubmitBankTransferAPI setPgDepositUserName(String pgDepositUserName) {
        this.pgDepositUserName = pgDepositUserName;
        return this;
    }

    public SubmitBankTransferAPI setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public interface SubmitBankTransferCallBack extends KzingCallBack {
        void onSuccess(SubmitBankTransferResult submitBankTransferResult);
    }
}

