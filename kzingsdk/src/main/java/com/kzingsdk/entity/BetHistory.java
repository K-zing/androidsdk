package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class BetHistory {

    private String gpid = "";
    private String gpName = "";
    private String dateFrom = "";
    private String dateTo = "";
    private String gpType = "";
    private String conversionCurrency = "";
    private Integer conversion;
    private BigDecimal betAmt = BigDecimal.ZERO;
    private BigDecimal win = BigDecimal.ZERO;

    public static BetHistory newInstance(JSONObject rootObject) {
        BetHistory betHistory = new BetHistory();
        betHistory.setGpid(rootObject.optString("gpid"));
        betHistory.setGpName(rootObject.optString("gpname"));
        betHistory.setDateFrom(rootObject.optString("datefrom"));
        betHistory.setDateTo(rootObject.optString("dateto"));
        betHistory.setGpType(rootObject.optString("gp_type"));
        betHistory.setConversionCurrency(rootObject.optString("conversioncurrency"));
        betHistory.setConversion(rootObject.optInt("conversion"));
        betHistory.setBetAmt(BigDecimalUtil.optBigDecimal(rootObject, "betamt", BigDecimal.ZERO));
        betHistory.setWin(BigDecimalUtil.optBigDecimal(rootObject, "win", BigDecimal.ZERO));
        return betHistory;
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

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getGpType() {
        return gpType;
    }

    public void setGpType(String gpType) {
        this.gpType = gpType;
    }

    public String getConversionCurrency() {
        return conversionCurrency;
    }

    public void setConversionCurrency(String conversionCurrency) {
        this.conversionCurrency = conversionCurrency;
    }

    public Integer getConversion() {
        return conversion;
    }

    public void setConversion(Integer conversion) {
        this.conversion = conversion;
    }

    public BigDecimal getBetAmt() {
        return betAmt;
    }

    public void setBetAmt(BigDecimal betAmt) {
        this.betAmt = betAmt;
    }

    public BigDecimal getWin() {
        return win;
    }

    public void setWin(BigDecimal win) {
        this.win = win;
    }
}
