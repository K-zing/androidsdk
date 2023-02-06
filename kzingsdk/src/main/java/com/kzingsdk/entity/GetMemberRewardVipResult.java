package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class GetMemberRewardVipResult {

    private String playerid;
    private String id;
    private String levelCode;
    private String levelName;
    private String levelNameEN;
    private String iconUrl;
    private String vipid;
    private String qualificationPeriod;
    private Integer levelRank;
    private BigDecimal reqPointAmount;
    private BigDecimal reqTurnoverAmount;
    private BigDecimal reqDepositAmount;
    private BigDecimal reqRedemptionAmount;
    private BigDecimal levelUpAmount;

    public static GetMemberRewardVipResult newInstance(JSONObject rootObject) {
        GetMemberRewardVipResult getDepositRecordResult = new GetMemberRewardVipResult();
        getDepositRecordResult.playerid = rootObject.optString("playerid");
        getDepositRecordResult.id = rootObject.optString("id");
        getDepositRecordResult.levelCode = rootObject.optString("levelCode");
        getDepositRecordResult.levelName = rootObject.optString("levelName");
        getDepositRecordResult.levelNameEN = rootObject.optString("levelNameEN");
        getDepositRecordResult.iconUrl = rootObject.optString("iconUrl");
        getDepositRecordResult.vipid = rootObject.optString("vipid");
        getDepositRecordResult.qualificationPeriod = rootObject.optString("qualificationPeriod");
        getDepositRecordResult.levelRank = rootObject.optInt("levelRank");
        getDepositRecordResult.reqPointAmount = BigDecimalUtil.optBigDecimal(rootObject, "reqPointAmount");
        getDepositRecordResult.reqTurnoverAmount = BigDecimalUtil.optBigDecimal(rootObject, "reqTurnoverAmount");
        getDepositRecordResult.reqDepositAmount = BigDecimalUtil.optBigDecimal(rootObject, "reqDepositAmount");
        getDepositRecordResult.reqRedemptionAmount = BigDecimalUtil.optBigDecimal(rootObject, "reqRedemptionAmount");
        getDepositRecordResult.levelUpAmount = BigDecimalUtil.optBigDecimal(rootObject, "levelUpAmount");
        return getDepositRecordResult;
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelNameEN() {
        return levelNameEN;
    }

    public void setLevelNameEN(String levelNameEN) {
        this.levelNameEN = levelNameEN;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getVipid() {
        return vipid;
    }

    public void setVipid(String vipid) {
        this.vipid = vipid;
    }

    public String getQualificationPeriod() {
        return qualificationPeriod;
    }

    public void setQualificationPeriod(String qualificationPeriod) {
        this.qualificationPeriod = qualificationPeriod;
    }

    public Integer getLevelRank() {
        return levelRank;
    }

    public void setLevelRank(Integer levelRank) {
        this.levelRank = levelRank;
    }

    public BigDecimal getReqPointAmount() {
        return reqPointAmount;
    }

    public void setReqPointAmount(BigDecimal reqPointAmount) {
        this.reqPointAmount = reqPointAmount;
    }

    public BigDecimal getReqTurnoverAmount() {
        return reqTurnoverAmount;
    }

    public void setReqTurnoverAmount(BigDecimal reqTurnoverAmount) {
        this.reqTurnoverAmount = reqTurnoverAmount;
    }

    public BigDecimal getReqDepositAmount() {
        return reqDepositAmount;
    }

    public void setReqDepositAmount(BigDecimal reqDepositAmount) {
        this.reqDepositAmount = reqDepositAmount;
    }

    public BigDecimal getReqRedemptionAmount() {
        return reqRedemptionAmount;
    }

    public void setReqRedemptionAmount(BigDecimal reqRedemptionAmount) {
        this.reqRedemptionAmount = reqRedemptionAmount;
    }

    public BigDecimal getLevelUpAmount() {
        return levelUpAmount;
    }

    public void setLevelUpAmount(BigDecimal levelUpAmount) {
        this.levelUpAmount = levelUpAmount;
    }
}

