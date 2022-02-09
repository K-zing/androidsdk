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
    private BigDecimal withdrawMaxUsdt;
    private BigDecimal withdrawMinUsdt;

    public WithdrawCryptoLimit() {

    }

    public static WithdrawCryptoLimit newInstance(JSONObject rootObject) {
        WithdrawCryptoLimit withdrawCryptoLimit = new WithdrawCryptoLimit();
        withdrawCryptoLimit.setCurrency(rootObject.optString("currency"));
        withdrawCryptoLimit.setInfo(rootObject.optString("winfo"));
        withdrawCryptoLimit.setNetwork(rootObject.optString("network"));
        withdrawCryptoLimit.setWithdrawDayMaxCount(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_day_max_count"));
        withdrawCryptoLimit.setWithdrawMax(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_max"));
        withdrawCryptoLimit.setWithdrawMin(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_min"));
        withdrawCryptoLimit.setWithdrawMaxUsdt(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_max_usdt", null));
        withdrawCryptoLimit.setWithdrawMinUsdt(BigDecimalUtil.optBigDecimal(rootObject, "withdraw_min_usdt", null));
        return withdrawCryptoLimit;
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

    public BigDecimal getWithdrawMaxUsdt() {
        return withdrawMaxUsdt;
    }

    public void setWithdrawMaxUsdt(BigDecimal withdrawMaxUsdt) {
        this.withdrawMaxUsdt = withdrawMaxUsdt;
    }

    public BigDecimal getWithdrawMinUsdt() {
        return withdrawMinUsdt;
    }

    public void setWithdrawMinUsdt(BigDecimal withdrawMinUsdt) {
        this.withdrawMinUsdt = withdrawMinUsdt;
    }
}

