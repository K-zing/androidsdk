package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class ActivityBonus {

    private String level;
    private BigDecimal redeemed;
    private BigDecimal amount;
    private BigDecimal point;

    public ActivityBonus() {

    }

    public static ActivityBonus newInstance(JSONObject rootObject) {
        ActivityBonus activityBonus = new ActivityBonus();
        activityBonus.setLevel(rootObject.optString("level"));
        activityBonus.setRedeemed(BigDecimalUtil.optBigDecimal(rootObject, "redeemed"));
        activityBonus.setAmount(BigDecimalUtil.optBigDecimal(rootObject, "amt"));
        activityBonus.setPoint(BigDecimalUtil.optBigDecimal(rootObject, "point"));
        return activityBonus;
    }

    public BigDecimal getRedeemed() {
        return redeemed;
    }

    public void setRedeemed(BigDecimal redeemed) {
        this.redeemed = redeemed;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }
}

