package com.kzingsdk.entity;

import org.json.JSONObject;

public class WithdrawTierRateResult extends SimpleApiResult {

    protected Boolean isExcludedMember = false;
    protected String requestAmount = "";
    protected String quotaBal = "";
    protected String quotaUpdate = "";
    protected String tier1Amt = "";
    protected String tier1ConvertAmt = "";
    protected String tier2Amt = "";
    protected String tier2ConvertAmt = "";
    protected String totalConvertAmt = "";

    public static WithdrawTierRateResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        WithdrawTierRateResult result = new WithdrawTierRateResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        JSONObject dataObject = rootObject.optJSONObject("data");
        if (dataObject != null) {
            JSONObject defaultRateObject = dataObject.optJSONObject("default_rate");
            if (defaultRateObject != null) {
                result.setExcludedMember(defaultRateObject.optBoolean("isExcludedMember"));
                result.setRequestAmount(defaultRateObject.optString("requestamount"));
                result.setQuotaBal(defaultRateObject.optString("quotabal"));
                result.setQuotaUpdate(defaultRateObject.optString("quotaupdate"));
                result.setTier1Amt(defaultRateObject.optString("tier1_amt"));
                result.setTier1ConvertAmt(defaultRateObject.optString("tier1_convertamt"));
                result.setTier2Amt(defaultRateObject.optString("tier2_amt"));
                result.setTier2ConvertAmt(defaultRateObject.optString("tier2_convertamt"));
                result.setTotalConvertAmt(defaultRateObject.optString("totalconvertamt"));
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

    public String getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(String requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getQuotaBal() {
        return quotaBal;
    }

    public void setQuotaBal(String quotaBal) {
        this.quotaBal = quotaBal;
    }

    public String getQuotaUpdate() {
        return quotaUpdate;
    }

    public void setQuotaUpdate(String quotaUpdate) {
        this.quotaUpdate = quotaUpdate;
    }

    public String getTier1Amt() {
        return tier1Amt;
    }

    public void setTier1Amt(String tier1Amt) {
        this.tier1Amt = tier1Amt;
    }

    public String getTier1ConvertAmt() {
        return tier1ConvertAmt;
    }

    public void setTier1ConvertAmt(String tier1ConvertAmt) {
        this.tier1ConvertAmt = tier1ConvertAmt;
    }

    public String getTier2Amt() {
        return tier2Amt;
    }

    public void setTier2Amt(String tier2Amt) {
        this.tier2Amt = tier2Amt;
    }

    public String getTier2ConvertAmt() {
        return tier2ConvertAmt;
    }

    public void setTier2ConvertAmt(String tier2ConvertAmt) {
        this.tier2ConvertAmt = tier2ConvertAmt;
    }

    public String getTotalConvertAmt() {
        return totalConvertAmt;
    }

    public void setTotalConvertAmt(String totalConvertAmt) {
        this.totalConvertAmt = totalConvertAmt;
    }
}
