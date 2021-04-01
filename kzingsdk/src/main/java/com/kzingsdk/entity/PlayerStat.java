package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class PlayerStat {

    private BigDecimal depositAmount = BigDecimal.ZERO;
    private BigDecimal validBetMonthly = BigDecimal.ZERO;
    private BigDecimal winloss90Day = BigDecimal.ZERO;
    private BigDecimal depositAmount90Day = BigDecimal.ZERO;
    private BigDecimal depositAmountMonthly = BigDecimal.ZERO;
    private BigDecimal validBet90Day = BigDecimal.ZERO;
    private BigDecimal winloss = BigDecimal.ZERO;
    private BigDecimal winlossMonthly = BigDecimal.ZERO;
    private BigDecimal validBet = BigDecimal.ZERO;

    public static PlayerStat newInstance(JSONObject rootObject) {
        PlayerStat playerStat = new PlayerStat();
        playerStat.depositAmount = BigDecimalUtil.optBigDecimal(rootObject, "depositAmount", BigDecimal.ZERO);
        playerStat.validBetMonthly = BigDecimalUtil.optBigDecimal(rootObject, "validBetMonthly", BigDecimal.ZERO);
        playerStat.winloss90Day = BigDecimalUtil.optBigDecimal(rootObject, "winloss90Day", BigDecimal.ZERO);
        playerStat.depositAmount90Day = BigDecimalUtil.optBigDecimal(rootObject, "depositAmount90Day", BigDecimal.ZERO);
        playerStat.depositAmountMonthly = BigDecimalUtil.optBigDecimal(rootObject, "depositAmountMonthly", BigDecimal.ZERO);
        playerStat.validBet90Day = BigDecimalUtil.optBigDecimal(rootObject, "validBet90Day", BigDecimal.ZERO);
        playerStat.winloss = BigDecimalUtil.optBigDecimal(rootObject, "winloss", BigDecimal.ZERO);
        playerStat.winlossMonthly = BigDecimalUtil.optBigDecimal(rootObject, "winlossMonthly", BigDecimal.ZERO);
        playerStat.validBet = BigDecimalUtil.optBigDecimal(rootObject, "validBet", BigDecimal.ZERO);
        return playerStat;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getValidBetMonthly() {
        return validBetMonthly;
    }

    public void setValidBetMonthly(BigDecimal validBetMonthly) {
        this.validBetMonthly = validBetMonthly;
    }

    public BigDecimal getWinloss90Day() {
        return winloss90Day;
    }

    public void setWinloss90Day(BigDecimal winloss90Day) {
        this.winloss90Day = winloss90Day;
    }

    public BigDecimal getDepositAmount90Day() {
        return depositAmount90Day;
    }

    public void setDepositAmount90Day(BigDecimal depositAmount90Day) {
        this.depositAmount90Day = depositAmount90Day;
    }

    public BigDecimal getDepositAmountMonthly() {
        return depositAmountMonthly;
    }

    public void setDepositAmountMonthly(BigDecimal depositAmountMonthly) {
        this.depositAmountMonthly = depositAmountMonthly;
    }

    public BigDecimal getValidBet90Day() {
        return validBet90Day;
    }

    public void setValidBet90Day(BigDecimal validBet90Day) {
        this.validBet90Day = validBet90Day;
    }

    public BigDecimal getWinloss() {
        return winloss;
    }

    public void setWinloss(BigDecimal winloss) {
        this.winloss = winloss;
    }

    public BigDecimal getWinlossMonthly() {
        return winlossMonthly;
    }

    public void setWinlossMonthly(BigDecimal winlossMonthly) {
        this.winlossMonthly = winlossMonthly;
    }

    public BigDecimal getValidBet() {
        return validBet;
    }

    public void setValidBet(BigDecimal validBet) {
        this.validBet = validBet;
    }
}
