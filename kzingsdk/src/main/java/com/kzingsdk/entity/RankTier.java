package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class RankTier {

    private String name;
    private BigDecimal autoRemainTargetBet;
    private BigDecimal vipPoint;
    private BigDecimal reward;
    private BigDecimal bonusReward;
    private BigDecimal birthdayReward;
    private BigDecimal nftReward;

    public RankTier() {

    }

    public static RankTier newInstance(JSONObject rootObject) {
        RankTier rankTier = new RankTier();
        rankTier.setName(rootObject.optString("name"));
        rankTier.setAutoRemainTargetBet(BigDecimalUtil.optBigDecimal(rootObject, "autoRemainTargetBet"));
        rankTier.setVipPoint(BigDecimalUtil.optBigDecimal(rootObject, "vippoint"));
        rankTier.setReward(BigDecimalUtil.optBigDecimal(rootObject, "reward"));
        rankTier.setBonusReward(BigDecimalUtil.optBigDecimal(rootObject, "bonusreward"));
        rankTier.setBirthdayReward(BigDecimalUtil.optBigDecimal(rootObject, "birthdayreward"));
        rankTier.setNftReward(BigDecimalUtil.optBigDecimal(rootObject, "nftreward"));
        return rankTier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAutoRemainTargetBet() {
        return autoRemainTargetBet;
    }

    public void setAutoRemainTargetBet(BigDecimal autoRemainTargetBet) {
        this.autoRemainTargetBet = autoRemainTargetBet;
    }

    public BigDecimal getVipPoint() {
        return vipPoint;
    }

    public void setVipPoint(BigDecimal vipPoint) {
        this.vipPoint = vipPoint;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }

    public BigDecimal getBonusReward() {
        return bonusReward;
    }

    public void setBonusReward(BigDecimal bonusReward) {
        this.bonusReward = bonusReward;
    }

    public BigDecimal getBirthdayReward() {
        return birthdayReward;
    }

    public void setBirthdayReward(BigDecimal birthdayReward) {
        this.birthdayReward = birthdayReward;
    }

    public BigDecimal getNftReward() {
        return nftReward;
    }

    public void setNftReward(BigDecimal nftReward) {
        this.nftReward = nftReward;
    }
}

