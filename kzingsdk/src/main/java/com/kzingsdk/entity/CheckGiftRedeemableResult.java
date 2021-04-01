package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class CheckGiftRedeemableResult {

    private Boolean isRedeemable = false;
    private Boolean isAlreadyRedeemed = false;
    private Boolean isUnderReview = false;
    private BigDecimal requirementAmount = BigDecimal.ZERO;
    private BigDecimal resultAmount = BigDecimal.ZERO;
    private String reason = "";
    private long startTime = 0L;
    private long endTime = 0L;
    private long validBefore = 0L;

    public CheckGiftRedeemableResult() {

    }

    public static CheckGiftRedeemableResult newInstance(JSONObject rootObject) {
        CheckGiftRedeemableResult checkGiftRedeemableResult = new CheckGiftRedeemableResult();
        checkGiftRedeemableResult.setRedeemable(rootObject.optString("isRedeemable").equalsIgnoreCase("true"));
        checkGiftRedeemableResult.setUnderReview(rootObject.optString("isUnderReview").equalsIgnoreCase("true"));
        checkGiftRedeemableResult.setAlreadyRedeemed(rootObject.optString("isAlreadyRedeemed").equalsIgnoreCase("true"));
        checkGiftRedeemableResult.setRequirementAmount(BigDecimalUtil.optBigDecimal(rootObject, "requirementamount", BigDecimal.ZERO));
        checkGiftRedeemableResult.setResultAmount(BigDecimalUtil.optBigDecimal(rootObject, "resultamount", BigDecimal.ZERO));
        checkGiftRedeemableResult.setValidBefore(rootObject.optLong("validBefore", 0));
        checkGiftRedeemableResult.setStartTime(rootObject.optLong("starttime", 0));
        checkGiftRedeemableResult.setEndTime(rootObject.optLong("endtime", 0));
        checkGiftRedeemableResult.setReason(rootObject.optString("reason", ""));
        return checkGiftRedeemableResult;
    }

    public Boolean getRedeemable() {
        return isRedeemable;
    }

    public void setRedeemable(Boolean redeemable) {
        isRedeemable = redeemable;
    }

    public Boolean getUnderReview() {
        return isUnderReview;
    }

    public void setUnderReview(Boolean underReview) {
        isUnderReview = underReview;
    }

    public Boolean getAlreadyRedeemed() {
        return isAlreadyRedeemed;
    }

    public void setAlreadyRedeemed(Boolean alreadyRedeemed) {
        isAlreadyRedeemed = alreadyRedeemed;
    }

    public BigDecimal getRequirementAmount() {
        return requirementAmount;
    }

    public void setRequirementAmount(BigDecimal requirementAmount) {
        this.requirementAmount = requirementAmount;
    }

    public BigDecimal getResultAmount() {
        return resultAmount;
    }

    public void setResultAmount(BigDecimal resultAmount) {
        this.resultAmount = resultAmount;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getValidBefore() {
        return validBefore;
    }

    public void setValidBefore(long validBefore) {
        this.validBefore = validBefore;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
