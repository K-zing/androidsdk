package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class AddBankCardAPI extends CoreRequest {

    private String bankCode = null;
    private String accountRealName = null;
    private String cardNumber = null;
    private String accountBankName = null;
    private String verifyCode = null;
    private String mobileNumber = null;
    private String note = "";
    private boolean needSMS = false;
    private String ifscCode;
    private String address;
    private String addrA = "";
    private String addrB = "";
    private String smsPhoneNoCountry = "";
    AddBankCardAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.addBankCard;
    }

    @Override
    protected Observable<String> validateParams() {
        if (bankCode == null) {
            return Observable.just("Bank code is missing");
        }
        if (accountRealName == null) {
            return Observable.just("Account real name is missing");
        }
        if (cardNumber == null) {
            return Observable.just("Card number is missing");
        }
//        if (accountBankName == null) {
//            return Observable.just("Account bank name is missing");
//        }
        return super.validateParams();
    }


    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("bankcode", bankCode);
            jsonData.put("account", accountRealName);
            jsonData.put("card", cardNumber);
            jsonData.put("accountbank", accountBankName);
            jsonData.put("note", note);
            if (verifyCode != null) {
                jsonData.put("mobile_code", verifyCode);
            }
            if (mobileNumber != null) {
                jsonData.put("mobile_no", mobileNumber);
            }
            if (ifscCode != null) {
                jsonData.put("ifsccode", ifscCode);
            }
            if (address != null) {
                jsonData.put("address", address);
            }
            if (smsPhoneNoCountry != null) {
                jsonData.put("smsPhoneNoCountry", smsPhoneNoCountry);
            }
            jsonData.put("needSMS", needSMS);
            jsonData.put("addrA", addrA);
            jsonData.put("addrB", addrB);

            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> jsonResponse.optString("msg", "Success"));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(string -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((AddBankCardCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public AddBankCardAPI addAddBankCardCallBack(AddBankCardCallBack addBankCardCallBack) {
        kzingCallBackList.add(addBankCardCallBack);
        return this;
    }

    public AddBankCardAPI setParamBankCode(String bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    /**
     * @param accountRealName Real name of the player. Must be equal to the real name of registration.
     */
    public AddBankCardAPI setParamAccountRealName(String accountRealName) {
        this.accountRealName = accountRealName;
        return this;
    }

    /**
     * @param cardNumber Card number of the bank account.
     */
    public AddBankCardAPI setParamCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    /**
     * @param accountBankName Card number of the bank account.
     */
    public AddBankCardAPI setParamAccountBankName(String accountBankName) {
        this.accountBankName = accountBankName;
        return this;
    }

    public AddBankCardAPI setParamVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        return this;
    }

    public AddBankCardAPI setParamMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public AddBankCardAPI setNeedSMS(boolean needSMS) {
        this.needSMS = needSMS;
        return this;
    }

    public AddBankCardAPI setNote(String note) {
        this.note = note;
        return this;
    }

    public AddBankCardAPI setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
        return this;
    }

    public AddBankCardAPI setAddress(String address) {
        this.address = address;
        return this;
    }

    public AddBankCardAPI setSmsPhoneNoCountry(String smsPhoneNoCountry) {
        this.smsPhoneNoCountry = smsPhoneNoCountry;
        return this;
    }

    public AddBankCardAPI setAddrA(String addrA) {
        this.addrA = addrA;
        return this;
    }

    public AddBankCardAPI setAddrB(String addrB) {
        this.addrB = addrB;
        return this;
    }

    public interface AddBankCardCallBack extends KzingCallBack {
        void onSuccess();
    }


}

