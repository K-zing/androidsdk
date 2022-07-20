package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class RebateDetail {

    private String sid = "";
    private BigDecimal betTotal = BigDecimal.ZERO;
    private BigDecimal rakebackTotal = BigDecimal.ZERO;
    private BigDecimal rRate = BigDecimal.ZERO;
    private String rkDate = "";


    public static RebateDetail newInstance(JSONObject rootObject) {
        RebateDetail rebateDetail = new RebateDetail();
        rebateDetail.setSid(rootObject.optString("sid"));
        rebateDetail.setBetTotal(BigDecimalUtil.optBigDecimal(rootObject,"bettotal",BigDecimal.ZERO));
        rebateDetail.setRakebackTotal(BigDecimalUtil.optBigDecimal(rootObject,"rakebacktotal",BigDecimal.ZERO));
        rebateDetail.setrRate(BigDecimalUtil.optBigDecimal(rootObject,"rrate",BigDecimal.ZERO));
        rebateDetail.setRkDate(rootObject.optString("rkdate"));
        return rebateDetail;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public BigDecimal getBetTotal() {
        return betTotal;
    }

    public void setBetTotal(BigDecimal betTotal) {
        this.betTotal = betTotal;
    }

    public BigDecimal getRakebackTotal() {
        return rakebackTotal;
    }

    public void setRakebackTotal(BigDecimal rakebackTotal) {
        this.rakebackTotal = rakebackTotal;
    }

    public BigDecimal getrRate() {
        return rRate;
    }

    public void setrRate(BigDecimal rRate) {
        this.rRate = rRate;
    }

    public String getRkDate() {
        return rkDate;
    }

    public void setRkDate(String rkDate) {
        this.rkDate = rkDate;
    }

}
