package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;


public class ActivityBonusPoint {

    private BigDecimal total;
    private BigDecimal bonusPending;
    private ArrayList<ActivityBonus> activityBonusList = new ArrayList<>();
    private ArrayList<ActivityPoint> activityPointList = new ArrayList<>();

    public ActivityBonusPoint() {

    }

    public static ActivityBonusPoint newInstance(JSONObject rootObject) {
        ActivityBonusPoint activityBonusPoint = new ActivityBonusPoint();
        activityBonusPoint.setTotal(BigDecimalUtil.optBigDecimal(rootObject, "total"));
        activityBonusPoint.setBonusPending(BigDecimalUtil.optBigDecimal(rootObject, "bonuspending"));
        JSONArray bonusArray = rootObject.optJSONArray("bonus");
        if (bonusArray != null) {
            for (int i = 0; i < bonusArray.length(); i++) {
                activityBonusPoint.activityBonusList.add(ActivityBonus.newInstance(bonusArray.optJSONObject(i)));
            }
        }
        JSONArray pointArray = rootObject.optJSONArray("point");
        if (pointArray != null) {
            for (int i = 0; i < pointArray.length(); i++) {
                activityBonusPoint.activityPointList.add(ActivityPoint.newInstance(pointArray.optJSONObject(i)));
            }
        }
        return activityBonusPoint;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getBonusPending() {
        return bonusPending;
    }

    public void setBonusPending(BigDecimal bonusPending) {
        this.bonusPending = bonusPending;
    }

    public ArrayList<ActivityBonus> getActivityBonusList() {
        return activityBonusList;
    }

    public void setActivityBonusList(ArrayList<ActivityBonus> activityBonusList) {
        this.activityBonusList = activityBonusList;
    }

    public ArrayList<ActivityPoint> getActivityPointList() {
        return activityPointList;
    }

    public void setActivityPointList(ArrayList<ActivityPoint> activityPointList) {
        this.activityPointList = activityPointList;
    }
}

