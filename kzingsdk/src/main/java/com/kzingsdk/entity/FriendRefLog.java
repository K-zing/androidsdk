package com.kzingsdk.entity;

import org.json.JSONObject;

public class FriendRefLog {

    private String playerId;
    private String playerName;
    private String regDate;
    private String firstSaveTime;
    private String firstSaveAmount;
    private String bonusAmount;
    private String processStatus;
    private String processDate;
    private Integer status;

    public static FriendRefLog newInstance(JSONObject rootObject) {
        FriendRefLog friendRefLog = new FriendRefLog();
        friendRefLog.setPlayerId(rootObject.optString("playerid"));
        friendRefLog.setPlayerName(rootObject.optString("playername"));
        friendRefLog.setRegDate(rootObject.optString("regdate"));
        friendRefLog.setFirstSaveTime(rootObject.optString("firstsavetime"));
        friendRefLog.setFirstSaveAmount(rootObject.optString("firstsaveamount"));
        friendRefLog.setBonusAmount(rootObject.optString("bonusamount"));
        friendRefLog.setProcessStatus(rootObject.optString("processstatus"));
        friendRefLog.setProcessDate(rootObject.optString("processdate"));
        friendRefLog.setStatus(rootObject.optInt("status"));
        return friendRefLog;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getFirstSaveTime() {
        return firstSaveTime;
    }

    public void setFirstSaveTime(String firstSaveTime) {
        this.firstSaveTime = firstSaveTime;
    }

    public String getFirstSaveAmount() {
        return firstSaveAmount;
    }

    public void setFirstSaveAmount(String firstSaveAmount) {
        this.firstSaveAmount = firstSaveAmount;
    }

    public String getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(String bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FriendRefLog{" +
                "playerId='" + playerId + '\'' +
                ", playerName='" + playerName + '\'' +
                ", regDate='" + regDate + '\'' +
                ", firstSaveTime='" + firstSaveTime + '\'' +
                ", firstSaveAmount='" + firstSaveAmount + '\'' +
                ", bonusAmount='" + bonusAmount + '\'' +
                ", processStatus='" + processStatus + '\'' +
                ", processDate='" + processDate + '\'' +
                ", status=" + status +
                '}';
    }
}
