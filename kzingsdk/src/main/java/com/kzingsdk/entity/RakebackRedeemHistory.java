package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class RakebackRedeemHistory {

    private String gpName;
    private String time;
    private String currency;
    private BigDecimal validBet;
    private BigDecimal rakeAmount;

    public RakebackRedeemHistory() {

    }

    public static RakebackRedeemHistory newInstance(JSONObject rootObject) {
        RakebackRedeemHistory history = new RakebackRedeemHistory();
        history.setGpName(rootObject.optString("gpname"));
        history.setTime(rootObject.optString("time"));
        history.setCurrency(rootObject.optString("currency"));
        history.setValidBet(BigDecimalUtil.optBigDecimal(rootObject, "validbet"));
        history.setRakeAmount(BigDecimalUtil.optBigDecimal(rootObject, "rakeamount"));
        return history;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getValidBet() {
        return validBet;
    }

    public void setValidBet(BigDecimal validBet) {
        this.validBet = validBet;
    }

    public BigDecimal getRakeAmount() {
        return rakeAmount;
    }

    public void setRakeAmount(BigDecimal rakeAmount) {
        this.rakeAmount = rakeAmount;
    }
}

