package com.kzingsdk.entity.agency;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class AgentCommission {

    private String title;
    private BigDecimal salesAmount;
    private BigDecimal commissionRate;

    public AgentCommission() {

    }

    public static AgentCommission newInstance(JSONObject rootObject) {
        AgentCommission agentCommissionSummary = new AgentCommission();
        agentCommissionSummary.setTitle(rootObject.optString("title"));
        agentCommissionSummary.setSalesAmount(BigDecimalUtil.optBigDecimal(rootObject, "salesamount"));
        agentCommissionSummary.setCommissionRate(BigDecimalUtil.optBigDecimal(rootObject, "commissionrate"));
        return agentCommissionSummary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }
}

