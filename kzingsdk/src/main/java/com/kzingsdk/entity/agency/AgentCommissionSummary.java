package com.kzingsdk.entity.agency;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class AgentCommissionSummary {

    private String brandId;
    private String currency;
    private String playerId;
    private String sid;
    private String parentPlayerId;
    private String parentPlayerName;
    private Integer directDownlineCount;
    private Integer directDownlineCountDiff;
    private Integer teamDownlineCount;
    private Integer teamDownlineCountDiff;
    private Integer calculationStatus;
    private Integer rewardStatus;
    private BigDecimal commissionEvery;
    private BigDecimal commissionRateDownlineSales;
    private BigDecimal commissionRateTotalSales;
    private BigDecimal directDownlineCompanyWin;
    private BigDecimal downlineCommission;
    private BigDecimal downlineSales;
    private BigDecimal finalizedCommission;
    private BigDecimal salesAmountMetDownlineSales;
    private BigDecimal salesAmountMetTotalSales;
    private BigDecimal selfCompanyWin;
    private BigDecimal selfSales;
    private BigDecimal selfValidBet;
    private BigDecimal teamDownlineCompanyWin;
    private BigDecimal totalCommission;
    private BigDecimal totalSales;
    private Long processedTime;
    private Long created;
    private Long updated;

    public AgentCommissionSummary() {

    }

    public static AgentCommissionSummary newInstance(JSONObject rootObject) {
        AgentCommissionSummary agentCommissionSummary = new AgentCommissionSummary();
        agentCommissionSummary.setBrandId(rootObject.optString("brandid"));
        agentCommissionSummary.setCurrency(rootObject.optString("currency"));
        agentCommissionSummary.setPlayerId(rootObject.optString("playerid"));
        agentCommissionSummary.setSid(rootObject.optString("sid"));
        agentCommissionSummary.setParentPlayerId(rootObject.optString("parentplayerid"));
        agentCommissionSummary.setParentPlayerName(rootObject.optString("parentplayername"));
        agentCommissionSummary.setDirectDownlineCount(rootObject.optInt("directdownlinecount"));
        agentCommissionSummary.setDirectDownlineCountDiff(rootObject.optInt("directdownlinecountdiff"));
        agentCommissionSummary.setTeamDownlineCount(rootObject.optInt("teamdownlinecount"));
        agentCommissionSummary.setTeamDownlineCountDiff(rootObject.optInt("teamdownlinecountdiff"));
        agentCommissionSummary.setCalculationStatus(rootObject.optInt("calculationstatus"));
        agentCommissionSummary.setRewardStatus(rootObject.optInt("rewardstatus"));
        agentCommissionSummary.setCommissionEvery(BigDecimalUtil.optBigDecimal(rootObject, "commissionevery"));
        agentCommissionSummary.setCommissionRateDownlineSales(BigDecimalUtil.optBigDecimal(rootObject, "commissionratedownlinesales"));
        agentCommissionSummary.setCommissionRateTotalSales(BigDecimalUtil.optBigDecimal(rootObject, "commissionratetotalsales"));
        agentCommissionSummary.setDirectDownlineCompanyWin(BigDecimalUtil.optBigDecimal(rootObject, "directdownlinecompanywin"));
        agentCommissionSummary.setDownlineCommission(BigDecimalUtil.optBigDecimal(rootObject, "downlinecommission"));
        agentCommissionSummary.setDownlineSales(BigDecimalUtil.optBigDecimal(rootObject, "downlinesales"));
        agentCommissionSummary.setFinalizedCommission(BigDecimalUtil.optBigDecimal(rootObject, "finalizedcommission"));
        agentCommissionSummary.setSalesAmountMetDownlineSales(BigDecimalUtil.optBigDecimal(rootObject, "salesamountmetdownlinesales"));
        agentCommissionSummary.setSalesAmountMetTotalSales(BigDecimalUtil.optBigDecimal(rootObject, "salesamountmettotalsales"));
        agentCommissionSummary.setSelfCompanyWin(BigDecimalUtil.optBigDecimal(rootObject, "selfcompanywin"));
        agentCommissionSummary.setSelfSales(BigDecimalUtil.optBigDecimal(rootObject, "selfsales"));
        agentCommissionSummary.setSelfValidBet(BigDecimalUtil.optBigDecimal(rootObject, "selfvalidbet"));
        agentCommissionSummary.setTeamDownlineCompanyWin(BigDecimalUtil.optBigDecimal(rootObject, "teamdownlinecompanywin"));
        agentCommissionSummary.setTotalCommission(BigDecimalUtil.optBigDecimal(rootObject, "totalcommission"));
        agentCommissionSummary.setTotalSales(BigDecimalUtil.optBigDecimal(rootObject, "totalsales"));
        agentCommissionSummary.setProcessedTime(rootObject.optLong("processedtime"));
        agentCommissionSummary.setCreated(rootObject.optLong("created"));
        agentCommissionSummary.setUpdated(rootObject.optLong("updated"));
        return agentCommissionSummary;
    }


    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getParentPlayerId() {
        return parentPlayerId;
    }

    public void setParentPlayerId(String parentPlayerId) {
        this.parentPlayerId = parentPlayerId;
    }

    public String getParentPlayerName() {
        return parentPlayerName;
    }

    public void setParentPlayerName(String parentPlayerName) {
        this.parentPlayerName = parentPlayerName;
    }

    public Integer getDirectDownlineCount() {
        return directDownlineCount;
    }

    public void setDirectDownlineCount(Integer directDownlineCount) {
        this.directDownlineCount = directDownlineCount;
    }

    public Integer getDirectDownlineCountDiff() {
        return directDownlineCountDiff;
    }

    public void setDirectDownlineCountDiff(Integer directDownlineCountDiff) {
        this.directDownlineCountDiff = directDownlineCountDiff;
    }

    public Integer getTeamDownlineCount() {
        return teamDownlineCount;
    }

    public void setTeamDownlineCount(Integer teamDownlineCount) {
        this.teamDownlineCount = teamDownlineCount;
    }

    public Integer getTeamDownlineCountDiff() {
        return teamDownlineCountDiff;
    }

    public void setTeamDownlineCountDiff(Integer teamDownlineCountDiff) {
        this.teamDownlineCountDiff = teamDownlineCountDiff;
    }

    public Integer getCalculationStatus() {
        return calculationStatus;
    }

    public void setCalculationStatus(Integer calculationStatus) {
        this.calculationStatus = calculationStatus;
    }

    public Integer getRewardStatus() {
        return rewardStatus;
    }

    public void setRewardStatus(Integer rewardStatus) {
        this.rewardStatus = rewardStatus;
    }

    public BigDecimal getCommissionEvery() {
        return commissionEvery;
    }

    public void setCommissionEvery(BigDecimal commissionEvery) {
        this.commissionEvery = commissionEvery;
    }

    public BigDecimal getCommissionRateDownlineSales() {
        return commissionRateDownlineSales;
    }

    public void setCommissionRateDownlineSales(BigDecimal commissionRateDownlineSales) {
        this.commissionRateDownlineSales = commissionRateDownlineSales;
    }

    public BigDecimal getCommissionRateTotalSales() {
        return commissionRateTotalSales;
    }

    public void setCommissionRateTotalSales(BigDecimal commissionRateTotalSales) {
        this.commissionRateTotalSales = commissionRateTotalSales;
    }

    public BigDecimal getDirectDownlineCompanyWin() {
        return directDownlineCompanyWin;
    }

    public void setDirectDownlineCompanyWin(BigDecimal directDownlineCompanyWin) {
        this.directDownlineCompanyWin = directDownlineCompanyWin;
    }

    public BigDecimal getDownlineCommission() {
        return downlineCommission;
    }

    public void setDownlineCommission(BigDecimal downlineCommission) {
        this.downlineCommission = downlineCommission;
    }

    public BigDecimal getDownlineSales() {
        return downlineSales;
    }

    public void setDownlineSales(BigDecimal downlineSales) {
        this.downlineSales = downlineSales;
    }

    public BigDecimal getFinalizedCommission() {
        return finalizedCommission;
    }

    public void setFinalizedCommission(BigDecimal finalizedCommission) {
        this.finalizedCommission = finalizedCommission;
    }

    public BigDecimal getSalesAmountMetDownlineSales() {
        return salesAmountMetDownlineSales;
    }

    public void setSalesAmountMetDownlineSales(BigDecimal salesAmountMetDownlineSales) {
        this.salesAmountMetDownlineSales = salesAmountMetDownlineSales;
    }

    public BigDecimal getSalesAmountMetTotalSales() {
        return salesAmountMetTotalSales;
    }

    public void setSalesAmountMetTotalSales(BigDecimal salesAmountMetTotalSales) {
        this.salesAmountMetTotalSales = salesAmountMetTotalSales;
    }

    public BigDecimal getSelfCompanyWin() {
        return selfCompanyWin;
    }

    public void setSelfCompanyWin(BigDecimal selfCompanyWin) {
        this.selfCompanyWin = selfCompanyWin;
    }

    public BigDecimal getSelfSales() {
        return selfSales;
    }

    public void setSelfSales(BigDecimal selfSales) {
        this.selfSales = selfSales;
    }

    public BigDecimal getSelfValidBet() {
        return selfValidBet;
    }

    public void setSelfValidBet(BigDecimal selfValidBet) {
        this.selfValidBet = selfValidBet;
    }

    public BigDecimal getTeamDownlineCompanyWin() {
        return teamDownlineCompanyWin;
    }

    public void setTeamDownlineCompanyWin(BigDecimal teamDownlineCompanyWin) {
        this.teamDownlineCompanyWin = teamDownlineCompanyWin;
    }

    public BigDecimal getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(BigDecimal totalCommission) {
        this.totalCommission = totalCommission;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public Long getProcessedTime() {
        return processedTime;
    }

    public void setProcessedTime(Long processedTime) {
        this.processedTime = processedTime;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }
}

