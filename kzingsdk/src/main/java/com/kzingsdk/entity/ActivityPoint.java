package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class ActivityPoint {

    private String eName;
    private String name;
    private BigDecimal bet;
    private String gpid;
    private BigDecimal ubet;
    private String type;
    private BigDecimal point;
    private BigDecimal uPoint;

    public ActivityPoint() {

    }

    public static ActivityPoint newInstance(JSONObject rootObject) {
        ActivityPoint activityPoint = new ActivityPoint();
        JSONObject gpnames = rootObject.optJSONObject("gpnames");
        if (gpnames != null) {
            activityPoint.setEName(gpnames.optString("ename"));
            activityPoint.setName(gpnames.optString("name"));
        }
        activityPoint.setBet(BigDecimalUtil.optBigDecimal(rootObject, "bet"));
        activityPoint.setGpid(rootObject.optString("gpid"));
        activityPoint.setUbet(BigDecimalUtil.optBigDecimal(rootObject, "ubet"));
        activityPoint.setType(rootObject.optString("type"));
        activityPoint.setPoint(BigDecimalUtil.optBigDecimal(rootObject, "point"));
        activityPoint.setUPoint(BigDecimalUtil.optBigDecimal(rootObject, "upoint"));
        return activityPoint;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBet() {
        return bet;
    }

    public void setBet(BigDecimal bet) {
        this.bet = bet;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public BigDecimal getUbet() {
        return ubet;
    }

    public void setUbet(BigDecimal ubet) {
        this.ubet = ubet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public BigDecimal getUPoint() {
        return uPoint;
    }

    public void setUPoint(BigDecimal uPoint) {
        this.uPoint = uPoint;
    }
}

