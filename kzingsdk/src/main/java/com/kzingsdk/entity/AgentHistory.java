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

    public AgentHistory() {

    }

    public static AgentHistory newInstance(JSONObject rootObject) {
        AgentHistory activityBonus = new AgentHistory();
        activityBonus.setAgentName(rootObject.optString("agentname"));
        activityBonus.setLastLoginIp(rootObject.optString("lastloginip"));
        activityBonus.setPlayerName(rootObject.optString("playername"));
        activityBonus.setRegDomain(rootObject.optString("regdomain"));
        activityBonus.setLastDomain(rootObject.optString("lastdomain"));
        activityBonus.setParentPlayerId(rootObject.optString("parentplayerid"));
        activityBonus.setPlayerId(rootObject.optString("playerid"));
        activityBonus.setRegDate(rootObject.optLong("regdate"));
        activityBonus.setLastLoginTime(rootObject.optLong("lastlogintime"));

        return activityBonus;
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
}

