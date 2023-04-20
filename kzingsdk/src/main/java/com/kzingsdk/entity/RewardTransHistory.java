package com.kzingsdk.entity;

import org.json.JSONObject;


public class RewardTransHistory {

    private String transactionDate;
    private String pointType;
    private String point;
    private String detail;
    private String itemName;

    public RewardTransHistory() {

    }

    public static RewardTransHistory newInstance(JSONObject rootObject) {
        RewardTransHistory history = new RewardTransHistory();
        history.setTransactionDate(rootObject.optString("transactionDate"));
        history.setPointType(rootObject.optString("pointType"));
        history.setPoint(rootObject.optString("point"));
        history.setDetail(rootObject.optString("detail"));
        history.setItemName(rootObject.optString("itemName"));
        return history;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}

