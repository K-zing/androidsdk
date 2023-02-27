package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class GetAllTierRateResult extends SimpleApiResult {

    protected Boolean isExcludedMember = false;
    protected BigDecimal depositRate = BigDecimal.ZERO;
    protected BigDecimal withdrawTier1 = BigDecimal.ZERO;
    protected BigDecimal withdrawTier2 = BigDecimal.ZERO;

    public static GetAllTierRateResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        GetAllTierRateResult result = new GetAllTierRateResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        JSONObject dataObject = rootObject.optJSONObject("data");
        if (dataObject != null) {
            JSONObject defaultRateObject = dataObject.optJSONObject("default_rate");
            if (defaultRateObject != null) {
                result.setExcludedMember(defaultRateObject.optBoolean("'isExcludedMember'"));
                result.setDepositRate(BigDecimalUtil.optBigDecimal(defaultRateObject, "deposit_rate"));
                result.setWithdrawTier1(BigDecimalUtil.optBigDecimal(defaultRateObject, "withdraw_tier1"));
                result.setWithdrawTier2(BigDecimalUtil.optBigDecimal(defaultRateObject, "withdraw_tier2"));
            }
        }
        return result;
    }

    public Boolean getExcludedMember() {
        return isExcludedMember;
    }

    public void setExcludedMember(Boolean excludedMember) {
        isExcludedMember = excludedMember;
    }

    public BigDecimal getDepositRate() {
        return depositRate;
    }

    public void setDepositRate(BigDecimal depositRate) {
        this.depositRate = depositRate;
    }

    public BigDecimal getWithdrawTier1() {
        return withdrawTier1;
    }

    public void setWithdrawTier1(BigDecimal withdrawTier1) {
        this.withdrawTier1 = withdrawTier1;
    }

    public BigDecimal getWithdrawTier2() {
        return withdrawTier2;
    }

    public void setWithdrawTier2(BigDecimal withdrawTier2) {
        this.withdrawTier2 = withdrawTier2;
    }
}
