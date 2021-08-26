package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.deposit.AtmPayment;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitAtmDepositV2API extends CoreRequest {

    private String depositUser;
    private String cTransNo;
    private String bcid;
    private Double cAmount;
    private Double cryptoRate;
    private String address;

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

    @Override
    protected String getAction() {
        return Action.submitAtmDepositV2;
    }

    SubmitAtmDepositV2API() {
        super();
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
            jsonData.put("deposituser", depositUser);
            jsonData.put("ctransno", cTransNo);
            jsonData.put("bcid", bcid);
            jsonData.put("camount", cAmount);
            jsonData.put("crypto_rate", cryptoRate);
            jsonData.put("address", address);
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
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitAtmDepositV2CallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitAtmDepositV2API addSubmitAtmDepositV2CallBack(SubmitAtmDepositV2CallBack submitAtmDepositV2CallBack) {
        kzingCallBackList.add(submitAtmDepositV2CallBack);
        return this;
    }

    public interface SubmitAtmDepositV2CallBack extends KzingCallBack {
        void onSuccess();
    }

    public SubmitAtmDepositV2API setDepositUser(String depositUser) {
        this.depositUser = depositUser;
        return this;
    }

    public SubmitAtmDepositV2API setCTransNo(String cTransNo) {
        this.cTransNo = cTransNo;
        return this;
    }

    public SubmitAtmDepositV2API setBcid(String bcid) {
        this.bcid = bcid;
        return this;
    }

    public SubmitAtmDepositV2API setCAmount(Double cAmount) {
        this.cAmount = cAmount;
        return this;
    }

    public SubmitAtmDepositV2API setCryptoRate(Double cryptoRate) {
        this.cryptoRate = cryptoRate;
        return this;
    }

    public SubmitAtmDepositV2API setAddress(String address) {
        this.address = address;
        return this;
    }

    public SubmitAtmDepositV2API setThirdPartyPayment(AtmPayment atmPayment) {
        this.atmPayment = atmPayment;
        return this;
    }

    public SubmitAtmDepositV2API setAmount(Double amount) {
        this.amount = amount;
        return this;
    }


    public SubmitAtmDepositV2API setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
        return this;
    }


    public SubmitAtmDepositV2API setDepositDate(String depositDate) {
        this.depositDate = depositDate;
        return this;
    }


    public SubmitAtmDepositV2API setDepositorName(String depositorName) {
        this.depositorName = depositorName;
        return this;
    }

    public SubmitAtmDepositV2API setDepositSlip(String depositSlip) {
        this.depositSlip = depositSlip;
        return this;
    }


    public SubmitAtmDepositV2API setUtmCode(String utmCode) {
        this.utmCode = utmCode;
        return this;
    }

    public SubmitAtmDepositV2API setTransType(String transType) {
        this.transType = transType;
        return this;
    }

    public SubmitAtmDepositV2API setUserBank(String userbank) {
        this.userbank = userbank;
        return this;
    }

    public SubmitAtmDepositV2API setGpaid(String gpaid) {
        this.gpaid = gpaid;
        return this;
    }
    
}

