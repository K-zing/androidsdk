package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class SpecRedPacketInfo {

    private String actId;
    private String actName;
    private BigDecimal playerBalance;
    private long displayDate;
    private long publishDate;
    private long expiredDate;

    public static SpecRedPacketInfo newInstance(JSONObject rootObject) {
        SpecRedPacketInfo specRedPacketInfo = new SpecRedPacketInfo();
        specRedPacketInfo.setActId(rootObject.optString("actid"));
        specRedPacketInfo.setActName(rootObject.optString("actname"));
        specRedPacketInfo.setPlayerBalance(BigDecimalUtil.optBigDecimal(rootObject, "playerBalance"));
        specRedPacketInfo.setDisplayDate(rootObject.optLong("display_date"));
        specRedPacketInfo.setPublishDate(rootObject.optLong("publishdate"));
        specRedPacketInfo.setExpiredDate(rootObject.optLong("expireddate"));
        return specRedPacketInfo;
    }

    public String getActId() {
        return actId;
    }

    public SpecRedPacketInfo setActId(String actId) {
        this.actId = actId;
        return this;
    }

    public String getActName() {
        return actName;
    }

    public SpecRedPacketInfo setActName(String actName) {
        this.actName = actName;
        return this;
    }

    public BigDecimal getPlayerBalance() {
        return playerBalance;
    }

    public SpecRedPacketInfo setPlayerBalance(BigDecimal playerBalance) {
        this.playerBalance = playerBalance;
        return this;
    }

    public long getDisplayDate() {
        return displayDate;
    }

    public SpecRedPacketInfo setDisplayDate(long displayDate) {
        this.displayDate = displayDate;
        return this;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public SpecRedPacketInfo setPublishDate(long publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public long getExpiredDate() {
        return expiredDate;
    }

    public SpecRedPacketInfo setExpiredDate(long expiredDate) {
        this.expiredDate = expiredDate;
        return this;
    }
}

