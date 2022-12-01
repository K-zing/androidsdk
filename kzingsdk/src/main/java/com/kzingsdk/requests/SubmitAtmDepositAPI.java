package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.deposit.AtmPayment;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitAtmDepositAPI extends CoreRequest {

    private AtmPayment atmPayment = null;
    private Double amount = 0d;
    private String transactionNumber = "";
    private String depositDate = "";
    private String depositorName = "";
    private String depositSlip = "";
    private String utmCode = "";
    private String transType = "";
    private String userbank = "";
    private String gpaid = "";
    private String depositRefNo;

    SubmitAtmDepositAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitAtmDeposit;
    }


    @Override
    protected Observable<String> validateParams() {
        if (amount <= 0) {
            return Observable.just("Deposit amount must be bigger than 0.");
        }
        if (atmPayment == null) {
            return Observable.just("AtmPayment is missing");
        }
        if (atmPayment.getId() == null || atmPayment.getId().length() == 0) {
            return Observable.just("Atm Payment ID is missing. AtmPayment object is invalid.");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("bcid", atmPayment.getId());
            jsonData.put("amount", amount);
            jsonData.put("transtype", transType);
            if (gpaid != null) {
                jsonData.put("gpaid", gpaid);
            }
            if (utmCode != null) {
                jsonData.put("utm_code", utmCode);
            }
            if (transactionNumber != null) {
                jsonData.put("transno", transactionNumber);
            }
            if (depositDate != null) {
                jsonData.put("depositdate", depositDate);
            }
            if (depositorName != null) {
                jsonData.put("deposituser", depositorName);
            }
            if (depositSlip != null) {
                jsonData.put("depositslip", depositSlip);
            }
            if (userbank != null) {
                jsonData.put("userbank", userbank);
            }
            if (depositRefNo != null) {
                jsonData.put("depositrefno", depositRefNo);
            }
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
        requestRx(context).subscribe(url -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitAtmDepositCallBack) kzingCallBack).onSuccess(url);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitAtmDepositAPI addSubmitAtmDepositCallBack(SubmitAtmDepositCallBack submitAtmDepositCallBack) {
        kzingCallBackList.add(submitAtmDepositCallBack);
        return this;
    }

    public SubmitAtmDepositAPI setParamThirdPartyPayment(AtmPayment atmPayment) {
        this.atmPayment = atmPayment;
        return this;
    }

    public SubmitAtmDepositAPI setParamAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public SubmitAtmDepositAPI setParamTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
        return this;
    }

    public SubmitAtmDepositAPI setParamDepositDate(String depositDate) {
        this.depositDate = depositDate;
        return this;
    }

    public SubmitAtmDepositAPI setParamDepositorName(String depositorName) {
        this.depositorName = depositorName;
        return this;
    }

    public SubmitAtmDepositAPI setParamDepositSlip(String depositSlip) {
        this.depositSlip = depositSlip;
        return this;
    }

    public SubmitAtmDepositAPI setParamUtmCode(String utmCode) {
        this.utmCode = utmCode;
        return this;
    }

    public SubmitAtmDepositAPI setParamTransType(String transType) {
        this.transType = transType;
        return this;
    }

    public SubmitAtmDepositAPI setParamUserBank(String userbank) {
        this.userbank = userbank;
        return this;
    }

    public SubmitAtmDepositAPI setParamGpaid(String gpaid) {
        this.gpaid = gpaid;
        return this;
    }

    public SubmitAtmDepositAPI setDepositRefNo(String depositRefNo) {
        this.depositRefNo = depositRefNo;
        return this;
    }

    public interface SubmitAtmDepositCallBack extends KzingCallBack {
        void onSuccess(String url);
    }

}
