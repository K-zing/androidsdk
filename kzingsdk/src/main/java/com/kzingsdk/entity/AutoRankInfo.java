package com.kzingsdk.entity;

import java.math.BigDecimal;


public class AutoRankInfo {

    private String lv;
    private BigDecimal turnover;
    private BigDecimal reward;
    private BigDecimal nftReward;
    private BigDecimal monthlyReward;
    private BigDecimal birthdayReward;

    public String getLv() {
        return lv;
    }

    public void setLv(String lv) {
        this.lv = lv;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }

    public BigDecimal getNftReward() {
        return nftReward;
    }

    public void setNftReward(BigDecimal nftReward) {
        this.nftReward = nftReward;
    }

    public BigDecimal getMonthlyReward() {
        return monthlyReward;
    }

    public void setMonthlyReward(BigDecimal monthlyReward) {
        this.monthlyReward = monthlyReward;
    }

    public BigDecimal getBirthdayReward() {
        return birthdayReward;
    }

    public void setBirthdayReward(BigDecimal birthdayReward) {
        this.birthdayReward = birthdayReward;
    }
}

