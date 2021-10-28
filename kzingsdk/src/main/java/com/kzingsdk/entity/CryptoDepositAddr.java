package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class CryptoDepositAddr {

    private String address;
    private String currency;
    private String msg;

    public CryptoDepositAddr() {

    }

    public static CryptoDepositAddr newInstance(JSONObject rootObject) {
        CryptoDepositAddr activityBonus = new CryptoDepositAddr();
        activityBonus.setAddress(rootObject.optString("address"));
        activityBonus.setCurrency(rootObject.optString("currency"));
        activityBonus.setMsg(rootObject.optString("msg"));
        return activityBonus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

