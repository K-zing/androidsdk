package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.HashSet;


public class ActivityCanSignInResult {
    private Integer activityType;
    private Integer checkedInDay;
    private Integer currentDay;
    private BigDecimal bonusAmount;
    private BigDecimal dailyBetAmount;
    private BigDecimal gpTransferBonusAmount;
    private BigDecimal validBetRequirement;
    private Boolean isConsecutive;
    private Boolean isSeamless;
    private HashSet<Integer> checkedOnDay = new HashSet<>();
    private Integer dayFive;
    private Integer dayFour;
    private Integer dayOne;
    private Integer daySeven;
    private Integer daySix;
    private Integer dayThree;
    private Integer dayTwo;
    private Integer sevenDaysBonus;
    private BigDecimal validBetAmount;

    public ActivityCanSignInResult() {

    }

    public static ActivityCanSignInResult newInstance(JSONObject rootObject) {
        ActivityCanSignInResult activityCanSignInResult = new ActivityCanSignInResult();
        activityCanSignInResult.activityType = rootObject.optInt("activityType");
        activityCanSignInResult.checkedInDay = rootObject.optInt("checkedInDay");
        activityCanSignInResult.currentDay = rootObject.optInt("currentDay");
        activityCanSignInResult.bonusAmount = BigDecimalUtil.optBigDecimal(rootObject, "bonusAmount");
        activityCanSignInResult.dailyBetAmount = BigDecimalUtil.optBigDecimal(rootObject, "dailyBetAmount");
        activityCanSignInResult.gpTransferBonusAmount = BigDecimalUtil.optBigDecimal(rootObject, "gpTransferBonusAmount");
        activityCanSignInResult.validBetRequirement = BigDecimalUtil.optBigDecimal(rootObject, "validBetRequirement");
        activityCanSignInResult.isConsecutive = rootObject.optBoolean("isConsecutive");
        activityCanSignInResult.isSeamless = rootObject.optBoolean("isSeamless");
        JSONArray checkedOnDayArray = rootObject.optJSONArray("checkedOnDay");
        if (checkedOnDayArray != null) {
            for (int i = 0; i < checkedOnDayArray.length(); i++) {
                activityCanSignInResult.checkedOnDay.add(checkedOnDayArray.optInt(i));
            }
        }
        JSONObject reqObject = rootObject.optJSONObject("selectedSignin7DaysRequirement");
        if (reqObject != null) {
            activityCanSignInResult.dayFive = reqObject.optInt("day_five");
            activityCanSignInResult.dayFour = reqObject.optInt("day_four");
            activityCanSignInResult.dayOne = reqObject.optInt("day_one");
            activityCanSignInResult.daySeven = reqObject.optInt("day_seven");
            activityCanSignInResult.daySix = reqObject.optInt("day_six");
            activityCanSignInResult.dayThree = reqObject.optInt("day_three");
            activityCanSignInResult.dayTwo = reqObject.optInt("day_two");
            activityCanSignInResult.sevenDaysBonus = reqObject.optInt("sevendays_bonus");
            activityCanSignInResult.validBetAmount = BigDecimalUtil.optBigDecimal(reqObject, "validbet_amount");
        }
        return activityCanSignInResult;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getCheckedInDay() {
        return checkedInDay;
    }

    public void setCheckedInDay(Integer checkedInDay) {
        this.checkedInDay = checkedInDay;
    }

    public Integer getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(Integer currentDay) {
        this.currentDay = currentDay;
    }

    public BigDecimal getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public BigDecimal getDailyBetAmount() {
        return dailyBetAmount;
    }

    public void setDailyBetAmount(BigDecimal dailyBetAmount) {
        this.dailyBetAmount = dailyBetAmount;
    }

    public BigDecimal getGpTransferBonusAmount() {
        return gpTransferBonusAmount;
    }

    public void setGpTransferBonusAmount(BigDecimal gpTransferBonusAmount) {
        this.gpTransferBonusAmount = gpTransferBonusAmount;
    }

    public BigDecimal getValidBetRequirement() {
        return validBetRequirement;
    }

    public void setValidBetRequirement(BigDecimal validBetRequirement) {
        this.validBetRequirement = validBetRequirement;
    }

    public Boolean getConsecutive() {
        return isConsecutive;
    }

    public void setConsecutive(Boolean consecutive) {
        isConsecutive = consecutive;
    }

    public Boolean getSeamless() {
        return isSeamless;
    }

    public void setSeamless(Boolean seamless) {
        isSeamless = seamless;
    }

    public HashSet<Integer> getCheckedOnDay() {
        return checkedOnDay;
    }

    public void setCheckedOnDay(HashSet<Integer> checkedOnDay) {
        this.checkedOnDay = checkedOnDay;
    }

    public Integer getDayFive() {
        return dayFive;
    }

    public void setDayFive(Integer dayFive) {
        this.dayFive = dayFive;
    }

    public Integer getDayFour() {
        return dayFour;
    }

    public void setDayFour(Integer dayFour) {
        this.dayFour = dayFour;
    }

    public Integer getDayOne() {
        return dayOne;
    }

    public void setDayOne(Integer dayOne) {
        this.dayOne = dayOne;
    }

    public Integer getDaySeven() {
        return daySeven;
    }

    public void setDaySeven(Integer daySeven) {
        this.daySeven = daySeven;
    }

    public Integer getDaySix() {
        return daySix;
    }

    public void setDaySix(Integer daySix) {
        this.daySix = daySix;
    }

    public Integer getDayThree() {
        return dayThree;
    }

    public void setDayThree(Integer dayThree) {
        this.dayThree = dayThree;
    }

    public Integer getDayTwo() {
        return dayTwo;
    }

    public void setDayTwo(Integer dayTwo) {
        this.dayTwo = dayTwo;
    }

    public Integer getSevenDaysBonus() {
        return sevenDaysBonus;
    }

    public void setSevenDaysBonus(Integer sevenDaysBonus) {
        this.sevenDaysBonus = sevenDaysBonus;
    }

    public BigDecimal getValidBetAmount() {
        return validBetAmount;
    }

    public void setValidBetAmount(BigDecimal validBetAmount) {
        this.validBetAmount = validBetAmount;
    }
}

