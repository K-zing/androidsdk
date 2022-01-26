package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class WithdrawCryptoLimit {

    private String currency;
    private String info;
    private String network;
    private BigDecimal withdrawDayMaxCount;
    private BigDecimal withdrawMax;
    private BigDecimal withdrawMin;

    public WithdrawCryptoLimit() {

    }

    public static WithdrawCryptoLimit newInstance(JSONObject rootObject) {
        WithdrawCryptoLimit activityBonus = new WithdrawCryptoLimit();
        activityBonus.setCurrency(rootObject.optString("currency"));
        activityBonus.setInfo(rootObject.optString("winfo"));
        activityBonus.setNetwork(rootObject.optString("network"));
        activityBonus.setWithdrawDayMaxCount(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_day_max_count"));
        activityBonus.setWithdrawMax(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_max"));
        activityBonus.setWithdrawMin(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_min"));
        return activityBonus;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public BigDecimal getWithdrawDayMaxCount() {
        return withdrawDayMaxCount;
    }

    public void setWithdrawDayMaxCount(BigDecimal withdrawDayMaxCount) {
        this.withdrawDayMaxCount = withdrawDayMaxCount;
    }

    public BigDecimal getWithdrawMax() {
        return withdrawMax;
    }

    public void setWithdrawMax(BigDecimal withdrawMax) {
        this.withdrawMax = withdrawMax;
    }

    public BigDecimal getWithdrawMin() {
        return withdrawMin;
    }

    public void setWithdrawMin(BigDecimal withdrawMin) {
        this.withdrawMin = withdrawMin;
    }
}

