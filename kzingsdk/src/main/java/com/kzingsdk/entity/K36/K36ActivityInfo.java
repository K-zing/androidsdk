package com.kzingsdk.entity.K36;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class K36ActivityInfo {

    private String bankcard;
    private String scratchBonusDno;
    private BigDecimal rakebackAmount;
    private BigDecimal companyWinloss;
    private BigDecimal depositBonusAmount;
    private BigDecimal nonDepositBonusAmount;
    private BigDecimal validBetAmount;
    private BigDecimal withdrawAmount;
    private long startTime;
    private long endTime;
    private BigDecimal bonusAmount;
    private BigDecimal watergateAmount;
    private BigDecimal depositAmount;
    private BigDecimal gpTransferBonusAmount;
    private Integer checkedInDay;
    private Integer activityType;
    private Boolean isSeamless;
    private BigDecimal watergateMultiplier;
    private BigDecimal scratchBonus;
    private BigDecimal prizeHitPercentage;


    public K36ActivityInfo() {

    }

    public static K36ActivityInfo newInstance(JSONObject rootObject) {
        K36ActivityInfo k36ActivityInfo = new K36ActivityInfo();
        k36ActivityInfo.setBankcard(rootObject.optString("bankcard"));
        k36ActivityInfo.setScratchBonusDno(rootObject.optString("scratchBonusDno"));
        k36ActivityInfo.setStartTime(rootObject.optLong("startTime"));
        k36ActivityInfo.setEndTime(rootObject.optLong("endTime"));
        k36ActivityInfo.setRakebackAmount(BigDecimalUtil.optBigDecimal(rootObject, "rakebackAmount"));
        k36ActivityInfo.setCompanyWinloss(BigDecimalUtil.optBigDecimal(rootObject, "companyWinloss"));
        k36ActivityInfo.setDepositBonusAmount(BigDecimalUtil.optBigDecimal(rootObject, "depositBonusAmount"));
        k36ActivityInfo.setNonDepositBonusAmount(BigDecimalUtil.optBigDecimal(rootObject, "nonDepositBonusAmount"));
        k36ActivityInfo.setValidBetAmount(BigDecimalUtil.optBigDecimal(rootObject, "validBetAmount"));
        k36ActivityInfo.setWithdrawAmount(BigDecimalUtil.optBigDecimal(rootObject, "withdrawAmount"));
        k36ActivityInfo.setBonusAmount(BigDecimalUtil.optBigDecimal(rootObject, "bonusAmount"));
        k36ActivityInfo.setWatergateAmount(BigDecimalUtil.optBigDecimal(rootObject, "watergateAmount"));
        k36ActivityInfo.setDepositAmount(BigDecimalUtil.optBigDecimal(rootObject, "depositAmount"));
        k36ActivityInfo.setGpTransferBonusAmount(BigDecimalUtil.optBigDecimal(rootObject, "gpTransferBonusAmount"));
        k36ActivityInfo.setCheckedInDay(rootObject.optInt("checkedInDay", 0));
        k36ActivityInfo.setActivityType(rootObject.optInt("activityType", 0));
        k36ActivityInfo.setSeamless(rootObject.optBoolean("isSeamless", false));
        JSONObject selectedScratchBonusRequirementObject = rootObject.optJSONObject("selectedScratchBonusRequirement");
        if (selectedScratchBonusRequirementObject != null) {
            k36ActivityInfo.setWatergateMultiplier(BigDecimalUtil.optBigDecimal(selectedScratchBonusRequirementObject, "watergate_multiplier"));
            k36ActivityInfo.setScratchBonus(BigDecimalUtil.optBigDecimal(selectedScratchBonusRequirementObject, "scratch_bonus"));
            k36ActivityInfo.setPrizeHitPercentage(BigDecimalUtil.optBigDecimal(selectedScratchBonusRequirementObject, "prizeHit_percentage"));
        }
        return k36ActivityInfo;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getScratchBonusDno() {
        return scratchBonusDno;
    }

    public void setScratchBonusDno(String scratchBonusDno) {
        this.scratchBonusDno = scratchBonusDno;
    }

    public BigDecimal getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public BigDecimal getWatergateAmount() {
        return watergateAmount;
    }

    public void setWatergateAmount(BigDecimal watergateAmount) {
        this.watergateAmount = watergateAmount;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Boolean getSeamless() {
        return isSeamless;
    }

    public void setSeamless(Boolean seamless) {
        isSeamless = seamless;
    }

    public BigDecimal getWatergateMultiplier() {
        return watergateMultiplier;
    }

    public void setWatergateMultiplier(BigDecimal watergateMultiplier) {
        this.watergateMultiplier = watergateMultiplier;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getGpTransferBonusAmount() {
        return gpTransferBonusAmount;
    }

    public void setGpTransferBonusAmount(BigDecimal gpTransferBonusAmount) {
        this.gpTransferBonusAmount = gpTransferBonusAmount;
    }

    public Integer getCheckedInDay() {
        return checkedInDay;
    }

    public void setCheckedInDay(Integer checkedInDay) {
        this.checkedInDay = checkedInDay;
    }

    public BigDecimal getScratchBonus() {
        return scratchBonus;
    }

    public void setScratchBonus(BigDecimal scratchBonus) {
        this.scratchBonus = scratchBonus;
    }

    public BigDecimal getPrizeHitPercentage() {
        return prizeHitPercentage;
    }

    public void setPrizeHitPercentage(BigDecimal prizeHitPercentage) {
        this.prizeHitPercentage = prizeHitPercentage;
    }

    public BigDecimal getRakebackAmount() {
        return rakebackAmount;
    }

    public void setRakebackAmount(BigDecimal rakebackAmount) {
        this.rakebackAmount = rakebackAmount;
    }

    public BigDecimal getCompanyWinloss() {
        return companyWinloss;
    }

    public void setCompanyWinloss(BigDecimal companyWinloss) {
        this.companyWinloss = companyWinloss;
    }

    public BigDecimal getDepositBonusAmount() {
        return depositBonusAmount;
    }

    public void setDepositBonusAmount(BigDecimal depositBonusAmount) {
        this.depositBonusAmount = depositBonusAmount;
    }

    public BigDecimal getNonDepositBonusAmount() {
        return nonDepositBonusAmount;
    }

    public void setNonDepositBonusAmount(BigDecimal nonDepositBonusAmount) {
        this.nonDepositBonusAmount = nonDepositBonusAmount;
    }

    public BigDecimal getValidBetAmount() {
        return validBetAmount;
    }

    public void setValidBetAmount(BigDecimal validBetAmount) {
        this.validBetAmount = validBetAmount;
    }

    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
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
}


