package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;


public class ReferralDataBonusTier {

    private Integer playerCount;
    private BigDecimal minDepositAmount;
    private BigDecimal minValidbetAmount;
    private BigDecimal bonusAmount;

    public ReferralDataBonusTier() {

    }

    public static ReferralDataBonusTier newInstance(JSONObject rootObject) {
        ReferralDataBonusTier referralDataBonusTier = new ReferralDataBonusTier();
        referralDataBonusTier.setPlayerCount(rootObject.optInt("player_count"));
        referralDataBonusTier.setMinDepositAmount(BigDecimalUtil.optBigDecimal(rootObject, "min_deposit_amount", BigDecimal.ZERO));
        referralDataBonusTier.setMinValidbetAmount(BigDecimalUtil.optBigDecimal(rootObject, "min_validbet_amount", BigDecimal.ZERO));
        referralDataBonusTier.setBonusAmount(BigDecimalUtil.optBigDecimal(rootObject, "bonus_amount", BigDecimal.ZERO));
        return referralDataBonusTier;
    }

    public Integer getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(Integer playerCount) {
        this.playerCount = playerCount;
    }

    public BigDecimal getMinDepositAmount() {
        return minDepositAmount;
    }

    public void setMinDepositAmount(BigDecimal minDepositAmount) {
        this.minDepositAmount = minDepositAmount;
    }

    public BigDecimal getMinValidbetAmount() {
        return minValidbetAmount;
    }

    public void setMinValidbetAmount(BigDecimal minValidbetAmount) {
        this.minValidbetAmount = minValidbetAmount;
    }

    public BigDecimal getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }
}

