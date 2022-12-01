package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

import io.reactivex.Observable;

public class SubmitAtmDepositV2API extends CoreRequest {

    private String depositUser;
    private String cTransNo;
    private String bcid;
    private Double cAmount;
    private BigDecimal cryptoRate;
    private String address;

    //    private CryptoAtmPayment cryptoAtmPayment = null;
    private Double amount = 0d;
    private String transactionNumber = "";
    private String depositDate = "";
    private String depositSlip = "";
    private String utmCode = "";
    private String transType = "";
    private String userbank = "";
    private String gpaid = "";
    private String depositRefNo;

    SubmitAtmDepositV2API() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitAtmDepositV2;
    }

    @Override
    protected Observable<String> validateParams() {
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
            jsonData.put("crypto_rate", cryptoRate.toString());
            jsonData.put("address", address);
//            jsonData.put("bcid", cryptoAtmPayment.getId());
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

    public SubmitAtmDepositV2API setCryptoRate(BigDecimal cryptoRate) {
        this.cryptoRate = cryptoRate;
        return this;
    }

    public SubmitAtmDepositV2API setAddress(String address) {
        this.address = address;
        return this;
    }

    public SubmitAtmDepositV2API setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

//    public SubmitAtmDepositV2API setCryptoAtmPayment(CryptoAtmPayment cryptoAtmPayment) {
//        this.cryptoAtmPayment = cryptoAtmPayment;
//        return this;
//    }

    public SubmitAtmDepositV2API setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
        return this;
    }

    public SubmitAtmDepositV2API setDepositDate(String depositDate) {
        this.depositDate = depositDate;
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

    public SubmitAtmDepositV2API setDepositRefNo(String depositRefNo) {
        this.depositRefNo = depositRefNo;
        return this;
    }

    public interface SubmitAtmDepositV2CallBack extends KzingCallBack {
        void onSuccess();
    }


}

