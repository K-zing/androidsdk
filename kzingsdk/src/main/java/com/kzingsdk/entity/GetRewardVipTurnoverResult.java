package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class GetRewardVipTurnoverResult {

    private String vipId;
    private String gpid;
    private String gpName;
    private String gpType;
    private String currency;
    private String rrPeriod;
    private Integer rRate;
    private Integer stepped;
    private String stepCond;
    private BigDecimal rrLimit;

    public static GetRewardVipTurnoverResult newInstance(JSONObject rootObject) {
        GetRewardVipTurnoverResult getDepositRecordResult = new GetRewardVipTurnoverResult();
        getDepositRecordResult.vipId = rootObject.optString("vipid");
        getDepositRecordResult.gpid = rootObject.optString("gpid");
        getDepositRecordResult.gpName = rootObject.optString("gpname");
        getDepositRecordResult.gpType = rootObject.optString("gptype");
        getDepositRecordResult.currency = rootObject.optString("currency");
        getDepositRecordResult.rrPeriod = rootObject.optString("rrperiod");
        getDepositRecordResult.rRate = rootObject.optInt("rrate");
        getDepositRecordResult.stepped = rootObject.optInt("stepped");
        getDepositRecordResult.stepCond = rootObject.optString("stepcond");
        getDepositRecordResult.rrLimit = BigDecimalUtil.optBigDecimal(rootObject, "rrlimit");
        return getDepositRecordResult;
    }

    public String getVipId() {
        return vipId;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId;
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

    public String getGpType() {
        return gpType;
    }

    public void setGpType(String gpType) {
        this.gpType = gpType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRrPeriod() {
        return rrPeriod;
    }

    public void setRrPeriod(String rrPeriod) {
        this.rrPeriod = rrPeriod;
    }

    public Integer getrRate() {
        return rRate;
    }

    public void setrRate(Integer rRate) {
        this.rRate = rRate;
    }

    public Integer getStepped() {
        return stepped;
    }

    public void setStepped(Integer stepped) {
        this.stepped = stepped;
    }

    public String getStepCond() {
        return stepCond;
    }

    public void setStepCond(String stepCond) {
        this.stepCond = stepCond;
    }

    public BigDecimal getRrLimit() {
        return rrLimit;
    }

    public void setRrLimit(BigDecimal rrLimit) {
        this.rrLimit = rrLimit;
    }
}

