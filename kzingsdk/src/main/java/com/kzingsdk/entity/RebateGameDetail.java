package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class RebateGameDetail {

    private String gpType;
    private String gpid;
    private String gpName;
    private BigDecimal betTotal = BigDecimal.ZERO;
    private BigDecimal rakebackTotal = BigDecimal.ZERO;

    public static RebateGameDetail newInstance(JSONObject rootObject) {
        RebateGameDetail rebateGameDetail = new RebateGameDetail();
        rebateGameDetail.setGpType(rootObject.optString("gptype"));
        rebateGameDetail.setGpid(rootObject.optString("gpid"));
        rebateGameDetail.setGpName(rootObject.optString("gpname"));
        rebateGameDetail.setBetTotal(BigDecimalUtil.optBigDecimal(rootObject, "bettotal", BigDecimal.ZERO));
        rebateGameDetail.setRakebackTotal(BigDecimalUtil.optBigDecimal(rootObject, "rakebacktotal", BigDecimal.ZERO));
        return rebateGameDetail;
    }

    public String getGpType() {
        return gpType;
    }

    public void setGpType(String gpType) {
        this.gpType = gpType;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
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
}
