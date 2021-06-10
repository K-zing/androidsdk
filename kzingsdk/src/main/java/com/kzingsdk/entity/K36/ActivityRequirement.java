package com.kzingsdk.entity.K36;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class ActivityRequirement {

    private BigDecimal fixBonusAmount;
    private BigDecimal signInDaysAmount;
    private BigDecimal depositAmount;
    private BigDecimal depositAmountMultiplier;
    private BigDecimal withdrawalAmount;
    private BigDecimal moneyPercentage;
    private BigDecimal watergateMultiplier;
    private BigDecimal maxDistributeAmount;
    private BigDecimal amountMaxLimit;
    private Integer type;
    private Long created;

    public ActivityRequirement() {

    }

    public static ActivityRequirement newInstance(JSONObject rootObject) {
        ActivityRequirement activityRequirement = new ActivityRequirement();
        activityRequirement.setFixBonusAmount(BigDecimalUtil.optBigDecimal(rootObject, "fix_bonus_amount"));
        activityRequirement.setSignInDaysAmount(BigDecimalUtil.optBigDecimal(rootObject, "signin_days_amount"));
        activityRequirement.setDepositAmount(BigDecimalUtil.optBigDecimal(rootObject, "deposit_amount"));
        activityRequirement.setDepositAmountMultiplier(BigDecimalUtil.optBigDecimal(rootObject, "depositamount_multiplier"));
        activityRequirement.setWithdrawalAmount(BigDecimalUtil.optBigDecimal(rootObject, "withdrawal_amount"));
        activityRequirement.setMoneyPercentage(BigDecimalUtil.optBigDecimal(rootObject, "money_percentage"));
        activityRequirement.setWatergateMultiplier(BigDecimalUtil.optBigDecimal(rootObject, "watergate_multiplier"));
        activityRequirement.setMaxDistributeAmount(BigDecimalUtil.optBigDecimal(rootObject, "max_distribute_amount"));
        activityRequirement.setAmountMaxLimit(BigDecimalUtil.optBigDecimal(rootObject, "amount_max_limit"));
        activityRequirement.setType(rootObject.optInt("type"));
        activityRequirement.setCreated(rootObject.optLong("created"));
        return activityRequirement;
    }

    public BigDecimal getFixBonusAmount() {
        return fixBonusAmount;
    }

    public void setFixBonusAmount(BigDecimal fixBonusAmount) {
        this.fixBonusAmount = fixBonusAmount;
    }

    public BigDecimal getSignInDaysAmount() {
        return signInDaysAmount;
    }

    public void setSignInDaysAmount(BigDecimal signInDaysAmount) {
        this.signInDaysAmount = signInDaysAmount;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getDepositAmountMultiplier() {
        return depositAmountMultiplier;
    }

    public void setDepositAmountMultiplier(BigDecimal depositAmountMultiplier) {
        this.depositAmountMultiplier = depositAmountMultiplier;
    }

    public BigDecimal getMoneyPercentage() {
        return moneyPercentage;
    }

    public void setMoneyPercentage(BigDecimal moneyPercentage) {
        this.moneyPercentage = moneyPercentage;
    }

    public BigDecimal getWatergateMultiplier() {
        return watergateMultiplier;
    }

    public void setWatergateMultiplier(BigDecimal watergateMultiplier) {
        this.watergateMultiplier = watergateMultiplier;
    }

    public BigDecimal getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public BigDecimal getMaxDistributeAmount() {
        return maxDistributeAmount;
    }

    public void setMaxDistributeAmount(BigDecimal maxDistributeAmount) {
        this.maxDistributeAmount = maxDistributeAmount;
    }

    public BigDecimal getAmountMaxLimit() {
        return amountMaxLimit;
    }

    public void setAmountMaxLimit(BigDecimal amountMaxLimit) {
        this.amountMaxLimit = amountMaxLimit;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }
}


