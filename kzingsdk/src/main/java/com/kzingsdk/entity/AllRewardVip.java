package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class AllRewardVip {

    private String id;
    private String levelCode;
    private String levelName;
    private String levelNameEN;
    private String levelRank;
    private String iconUrl;
    private Integer qualPeriod;
    private Integer requalPeriod;
    private BigDecimal qualPointAmt;
    private BigDecimal qualTurnover;
    private BigDecimal qualDpt;
    private BigDecimal qualRedempt;
    private BigDecimal qualLevelAmt;
    private BigDecimal requalPointAmt;
    private BigDecimal requalTurnover;
    private BigDecimal requalDpt;
    private BigDecimal requalRedempt;
    private BigDecimal requalLevelAmt;

    public static AllRewardVip newInstance(JSONObject rootObject) {
        AllRewardVip getDepositRecordResult = new AllRewardVip();
        getDepositRecordResult.id = rootObject.optString("id");
        getDepositRecordResult.levelCode = rootObject.optString("levelCode");
        getDepositRecordResult.levelName = rootObject.optString("levelName");
        getDepositRecordResult.levelNameEN = rootObject.optString("levelNameEN");
        getDepositRecordResult.levelRank = rootObject.optString("levelRank");
        getDepositRecordResult.iconUrl = rootObject.optString("iconUrl");
        getDepositRecordResult.qualPeriod = rootObject.optInt("qualPeriod");
        getDepositRecordResult.requalPeriod = rootObject.optInt("requalPeriod");
        getDepositRecordResult.qualPointAmt = BigDecimalUtil.optBigDecimal(rootObject, "qualPointAmt");
        getDepositRecordResult.qualTurnover = BigDecimalUtil.optBigDecimal(rootObject, "qualTurnover");
        getDepositRecordResult.qualDpt = BigDecimalUtil.optBigDecimal(rootObject, "qualDpt");
        getDepositRecordResult.qualRedempt = BigDecimalUtil.optBigDecimal(rootObject, "qualRedempt");
        getDepositRecordResult.qualLevelAmt = BigDecimalUtil.optBigDecimal(rootObject, "qualLevelAmt");
        getDepositRecordResult.requalPointAmt = BigDecimalUtil.optBigDecimal(rootObject, "requalPointAmt");
        getDepositRecordResult.requalTurnover = BigDecimalUtil.optBigDecimal(rootObject, "requalTurnover");
        getDepositRecordResult.requalDpt = BigDecimalUtil.optBigDecimal(rootObject, "requalDpt");
        getDepositRecordResult.requalRedempt = BigDecimalUtil.optBigDecimal(rootObject, "requalRedempt");
        getDepositRecordResult.requalLevelAmt = BigDecimalUtil.optBigDecimal(rootObject, "requalLevelAmt");
        return getDepositRecordResult;
    }

    public String getId() {
        return id;
    }

    public AllRewardVip setId(String id) {
        this.id = id;
        return this;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public AllRewardVip setLevelCode(String levelCode) {
        this.levelCode = levelCode;
        return this;
    }

    public String getLevelName() {
        return levelName;
    }

    public AllRewardVip setLevelName(String levelName) {
        this.levelName = levelName;
        return this;
    }

    public String getLevelNameEN() {
        return levelNameEN;
    }

    public AllRewardVip setLevelNameEN(String levelNameEN) {
        this.levelNameEN = levelNameEN;
        return this;
    }

    public String getLevelRank() {
        return levelRank;
    }

    public AllRewardVip setLevelRank(String levelRank) {
        this.levelRank = levelRank;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public AllRewardVip setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public Integer getQualPeriod() {
        return qualPeriod;
    }

    public AllRewardVip setQualPeriod(Integer qualPeriod) {
        this.qualPeriod = qualPeriod;
        return this;
    }

    public Integer getRequalPeriod() {
        return requalPeriod;
    }

    public AllRewardVip setRequalPeriod(Integer requalPeriod) {
        this.requalPeriod = requalPeriod;
        return this;
    }

    public BigDecimal getQualPointAmt() {
        return qualPointAmt;
    }

    public AllRewardVip setQualPointAmt(BigDecimal qualPointAmt) {
        this.qualPointAmt = qualPointAmt;
        return this;
    }

    public BigDecimal getQualTurnover() {
        return qualTurnover;
    }

    public AllRewardVip setQualTurnover(BigDecimal qualTurnover) {
        this.qualTurnover = qualTurnover;
        return this;
    }

    public BigDecimal getQualDpt() {
        return qualDpt;
    }

    public AllRewardVip setQualDpt(BigDecimal qualDpt) {
        this.qualDpt = qualDpt;
        return this;
    }

    public BigDecimal getQualRedempt() {
        return qualRedempt;
    }

    public AllRewardVip setQualRedempt(BigDecimal qualRedempt) {
        this.qualRedempt = qualRedempt;
        return this;
    }

    public BigDecimal getQualLevelAmt() {
        return qualLevelAmt;
    }

    public AllRewardVip setQualLevelAmt(BigDecimal qualLevelAmt) {
        this.qualLevelAmt = qualLevelAmt;
        return this;
    }

    public BigDecimal getRequalPointAmt() {
        return requalPointAmt;
    }

    public AllRewardVip setRequalPointAmt(BigDecimal requalPointAmt) {
        this.requalPointAmt = requalPointAmt;
        return this;
    }

    public BigDecimal getRequalTurnover() {
        return requalTurnover;
    }

    public AllRewardVip setRequalTurnover(BigDecimal requalTurnover) {
        this.requalTurnover = requalTurnover;
        return this;
    }

    public BigDecimal getRequalDpt() {
        return requalDpt;
    }

    public AllRewardVip setRequalDpt(BigDecimal requalDpt) {
        this.requalDpt = requalDpt;
        return this;
    }

    public BigDecimal getRequalRedempt() {
        return requalRedempt;
    }

    public AllRewardVip setRequalRedempt(BigDecimal requalRedempt) {
        this.requalRedempt = requalRedempt;
        return this;
    }

    public BigDecimal getRequalLevelAmt() {
        return requalLevelAmt;
    }

    public AllRewardVip setRequalLevelAmt(BigDecimal requalLevelAmt) {
        this.requalLevelAmt = requalLevelAmt;
        return this;
    }
}

