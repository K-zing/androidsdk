package com.kzingsdk.entity.K36;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class TransferBonusActivityAcData {

    private BigDecimal depositAmount;
    private BigDecimal moneyPercentage;
    private BigDecimal watergateMultiplier;
    private Integer maxDistributeAmount;
    private Integer type;
    private Long created;

    public TransferBonusActivityAcData() {

    }

    public static TransferBonusActivityAcData newInstance(JSONObject rootObject) {
        TransferBonusActivityAcData transferBonusActivity = new TransferBonusActivityAcData();
        transferBonusActivity.setDepositAmount(BigDecimalUtil.optBigDecimal(rootObject, "deposit_amount"));
        transferBonusActivity.setMoneyPercentage(BigDecimalUtil.optBigDecimal(rootObject, "money_percentage"));
        transferBonusActivity.setWatergateMultiplier(BigDecimalUtil.optBigDecimal(rootObject, "watergate_multiplier"));
        transferBonusActivity.setMaxDistributeAmount(rootObject.optInt("max_distribute_amount"));
        transferBonusActivity.setType(rootObject.optInt("type"));
        transferBonusActivity.setCreated(rootObject.optLong("created"));
        return transferBonusActivity;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
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

    public Integer getMaxDistributeAmount() {
        return maxDistributeAmount;
    }

    public void setMaxDistributeAmount(Integer maxDistributeAmount) {
        this.maxDistributeAmount = maxDistributeAmount;
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


