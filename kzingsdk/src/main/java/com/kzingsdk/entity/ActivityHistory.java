package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class ActivityHistory {

    private String actid;
    private String actName;
    private String playerId;
    private String dno;
    private String ano;
    private String remark;
    private String formDetail;
    private String created;
    private String dealDate;
    private String status;
    private String dealRemark;
    private String aDomain;
    private String platform;
    private String currency;
    private String brandId;
    private String statusText;
    private Integer promoType;
    private BigDecimal depositAmount;
    private BigDecimal bonusAmount;

    public ActivityHistory() {

    }

    public static ActivityHistory newInstance(JSONObject rootObject) {
        ActivityHistory activityHistory = new ActivityHistory();
        activityHistory.setActid(rootObject.optString("actid"));
        activityHistory.setActName(rootObject.optString("actname"));
        activityHistory.setPlayerId(rootObject.optString("playerid"));
        activityHistory.setDno(rootObject.optString("dno"));
        activityHistory.setAno(rootObject.optString("ano"));
        activityHistory.setRemark(rootObject.optString("remark"));
        activityHistory.setFormDetail(rootObject.optString("formdetail"));
        activityHistory.setCreated(rootObject.optString("created"));
        activityHistory.setDealDate(rootObject.optString("dealdate"));
        activityHistory.setStatus(rootObject.optString("status"));
        activityHistory.setDealRemark(rootObject.optString("dealremark"));
        activityHistory.setADomain(rootObject.optString("adomain"));
        activityHistory.setPlatform(rootObject.optString("platform"));
        activityHistory.setCurrency(rootObject.optString("currency"));
        activityHistory.setBrandId(rootObject.optString("brandid"));
        activityHistory.setStatusText(rootObject.optString("statusText"));
        activityHistory.setPromoType(rootObject.optInt("promotype"));
        activityHistory.setDepositAmount(BigDecimalUtil.optBigDecimal(rootObject, "depositamount"));
        activityHistory.setBonusAmount(BigDecimalUtil.optBigDecimal(rootObject, "bonusamount"));
        return activityHistory;
    }

    public String getActid() {
        return actid;
    }

    public void setActid(String actid) {
        this.actid = actid;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFormDetail() {
        return formDetail;
    }

    public void setFormDetail(String formDetail) {
        this.formDetail = formDetail;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDealRemark() {
        return dealRemark;
    }

    public void setDealRemark(String dealRemark) {
        this.dealRemark = dealRemark;
    }

    public String getADomain() {
        return aDomain;
    }

    public void setADomain(String aDomain) {
        this.aDomain = aDomain;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Integer getPromoType() {
        return promoType;
    }

    public void setPromoType(Integer promoType) {
        this.promoType = promoType;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }
}

