package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class AgentHistory {

    private String agentName;
    private String lastLoginIp;
    private String playerName;
    private String regDomain;
    private String lastDomain;
    private String parentPlayerId;
    private String playerId;
    private Long regDate;
    private Long lastLoginTime;
    private BigDecimal totalDptAmt;
    private BigDecimal totalWtdAmt;
    private BigDecimal totalValidBetAmt;
    private BigDecimal totalWinloss;

    public AgentHistory() {

    }

    public static AgentHistory newInstance(JSONObject rootObject) {
        AgentHistory agentHistory = new AgentHistory();
        agentHistory.setAgentName(rootObject.optString("agentname"));
        agentHistory.setLastLoginIp(rootObject.optString("lastloginip"));
        agentHistory.setPlayerName(rootObject.optString("playername"));
        agentHistory.setRegDomain(rootObject.optString("regdomain"));
        agentHistory.setLastDomain(rootObject.optString("lastdomain"));
        agentHistory.setParentPlayerId(rootObject.optString("parentplayerid"));
        agentHistory.setPlayerId(rootObject.optString("playerid"));
        agentHistory.setRegDate(rootObject.optLong("regdate"));
        agentHistory.setLastLoginTime(rootObject.optLong("lastlogintime"));
        agentHistory.setTotalDptAmt(BigDecimalUtil.optBigDecimal(rootObject, "total_dpt_amt"));
        agentHistory.setTotalWtdAmt(BigDecimalUtil.optBigDecimal(rootObject, "total_wtd_amt"));
        agentHistory.setTotalValidBetAmt(BigDecimalUtil.optBigDecimal(rootObject, "total_validbetamt"));
        agentHistory.setTotalWinloss(BigDecimalUtil.optBigDecimal(rootObject, "total_winloss"));

        return agentHistory;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRegDomain() {
        return regDomain;
    }

    public void setRegDomain(String regDomain) {
        this.regDomain = regDomain;
    }

    public String getLastDomain() {
        return lastDomain;
    }

    public void setLastDomain(String lastDomain) {
        this.lastDomain = lastDomain;
    }

    public String getParentPlayerId() {
        return parentPlayerId;
    }

    public void setParentPlayerId(String parentPlayerId) {
        this.parentPlayerId = parentPlayerId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Long getRegDate() {
        return regDate;
    }

    public void setRegDate(Long regDate) {
        this.regDate = regDate;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public BigDecimal getTotalDptAmt() {
        return totalDptAmt;
    }

    public void setTotalDptAmt(BigDecimal totalDptAmt) {
        this.totalDptAmt = totalDptAmt;
    }

    public BigDecimal getTotalWtdAmt() {
        return totalWtdAmt;
    }

    public void setTotalWtdAmt(BigDecimal totalWtdAmt) {
        this.totalWtdAmt = totalWtdAmt;
    }

    public BigDecimal getTotalValidBetAmt() {
        return totalValidBetAmt;
    }

    public void setTotalValidBetAmt(BigDecimal totalValidBetAmt) {
        this.totalValidBetAmt = totalValidBetAmt;
    }

    public BigDecimal getTotalWinloss() {
        return totalWinloss;
    }

    public void setTotalWinloss(BigDecimal totalWinloss) {
        this.totalWinloss = totalWinloss;
    }
}

