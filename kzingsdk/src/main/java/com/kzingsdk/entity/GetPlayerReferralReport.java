package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class GetPlayerReferralReport {

    private String gpid;
    private String gpName;
    private String currency;
    private String playerName;
    private String regDate;
    private BigDecimal betAmt;
    private BigDecimal win;

    public static GetPlayerReferralReport newInstance(JSONObject rootObject) {
        GetPlayerReferralReport getDepositRecordResult = new GetPlayerReferralReport();
        getDepositRecordResult.gpid = rootObject.optString("gpid");
        getDepositRecordResult.gpName = rootObject.optString("gpname");
        getDepositRecordResult.currency = rootObject.optString("currency");
        getDepositRecordResult.playerName = rootObject.optString("playername");
        getDepositRecordResult.regDate = rootObject.optString("regdate");
        getDepositRecordResult.betAmt = BigDecimalUtil.optBigDecimal(rootObject, "betamt");
        getDepositRecordResult.win = BigDecimalUtil.optBigDecimal(rootObject, "win");
        return getDepositRecordResult;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
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

