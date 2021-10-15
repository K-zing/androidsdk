package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class CurrencyRate {

    private String fromCurrency;
    private String toCurrency;
    private BigDecimal rate;
    private String source;

    public CurrencyRate() {

    }

    public static CurrencyRate newInstance(JSONObject rootObject) {
        CurrencyRate activityBonus = new CurrencyRate();
        activityBonus.setFromCurrency(rootObject.optString("fromcurrency"));
        activityBonus.setToCurrency(rootObject.optString("tocurrency"));
        activityBonus.setRate(BigDecimalUtil.optBigDecimal(rootObject, "rate"));
        activityBonus.setSource(rootObject.optString("source"));
        return activityBonus;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

