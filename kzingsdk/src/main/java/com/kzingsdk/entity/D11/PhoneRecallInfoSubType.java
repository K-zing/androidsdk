package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class PhoneRecallInfoSubType {

    private String scname;
    private String status;
    private String scid;

    public PhoneRecallInfoSubType() {

    }

    public static PhoneRecallInfoSubType newInstance(JSONObject rootObject) {
        PhoneRecallInfoSubType activityBonus = new PhoneRecallInfoSubType();
        activityBonus.setScname(rootObject.optString("scname"));
        activityBonus.setStatus(rootObject.optString("status"));
        activityBonus.setScid(rootObject.optString("scid"));
        return activityBonus;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid;
    }
}

