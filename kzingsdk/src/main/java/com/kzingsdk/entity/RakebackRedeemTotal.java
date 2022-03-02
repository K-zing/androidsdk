package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class RakebackRedeemTotal {

    private String currency;
    private BigDecimal pageBetTotal;
    private BigDecimal pageActual;
    private BigDecimal sumBetTotal;
    private BigDecimal sumActual;

    public RakebackRedeemTotal() {

    }

    public static RakebackRedeemTotal newInstance(JSONObject rootObject, String currency) {
        RakebackRedeemTotal history = new RakebackRedeemTotal();
        history.setCurrency(currency);
        history.setPageBetTotal(BigDecimalUtil.optBigDecimal(rootObject, "page_bettotal"));
        history.setPageActual(BigDecimalUtil.optBigDecimal(rootObject, "page_actural"));
        history.setSumBetTotal(BigDecimalUtil.optBigDecimal(rootObject, "sum_bettotal"));
        history.setSumActual(BigDecimalUtil.optBigDecimal(rootObject, "sum_actural"));
        return history;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPageBetTotal() {
        return pageBetTotal;
    }

    public void setPageBetTotal(BigDecimal pageBetTotal) {
        this.pageBetTotal = pageBetTotal;
    }

    public BigDecimal getPageActual() {
        return pageActual;
    }

    public void setPageActual(BigDecimal pageActual) {
        this.pageActual = pageActual;
    }

    public BigDecimal getSumBetTotal() {
        return sumBetTotal;
    }

    public void setSumBetTotal(BigDecimal sumBetTotal) {
        this.sumBetTotal = sumBetTotal;
    }

    public BigDecimal getSumActual() {
        return sumActual;
    }

    public void setSumActual(BigDecimal sumActual) {
        this.sumActual = sumActual;
    }
}

