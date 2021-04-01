package com.kzingsdk.entity;

import org.json.JSONObject;

public class BankCard {

    protected String bankName = "";
    protected String bankCode = "";
    protected String bankImageUrl = "";

    public static BankCard newInstance(JSONObject rootObject) {
        BankCard bankCard = new BankCard();
        bankCard.setBankName(rootObject.optString("bankname"));
        bankCard.setBankCode(rootObject.optString("bankcode"));
        bankCard.setBankImageUrl(rootObject.optString("bankcss"));
        return bankCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankImageUrl() {
        return bankImageUrl;
    }

    public void setBankImageUrl(String bankImageUrl) {
        this.bankImageUrl = bankImageUrl;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "name='" + bankName + '\'' +
                ", bid='" + bankCode + '\'' +
                ", bankImageUrl='" + bankImageUrl + '\'' +
                '}';
    }
}
