package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class BankCard {

    protected String bankName = "";
    protected String bankCode = "";
    protected String bankImageUrl = "";
    protected String bankEn = "";
    protected String currency = "";
    protected BigDecimal withdrawMin = BigDecimal.ZERO;

    public static BankCard newInstance(JSONObject rootObject) {
        BankCard bankCard = new BankCard();
        bankCard.setBankName(rootObject.optString("bankname"));
        bankCard.setBankCode(rootObject.optString("bankcode"));
        bankCard.setBankImageUrl(rootObject.optString("bankcss"));
        bankCard.setBankEn(rootObject.optString("banken"));
        bankCard.setCurrency(rootObject.optString("currency"));
        bankCard.setWithdrawMin(BigDecimalUtil.optBigDecimal(rootObject, "withdrawmin", BigDecimal.ZERO));
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

    public String getBankEn() {
        return bankEn;
    }

    public void setBankEn(String bankEn) {
        this.bankEn = bankEn;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getWithdrawMin() {
        return withdrawMin;
    }

    public void setWithdrawMin(BigDecimal withdrawMin) {
        this.withdrawMin = withdrawMin;
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
