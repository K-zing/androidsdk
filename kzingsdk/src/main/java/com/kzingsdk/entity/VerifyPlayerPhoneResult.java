package com.kzingsdk.entity;

import org.json.JSONObject;

public class VerifyPlayerPhoneResult extends SimpleApiResult {

    protected int remainCount = 0;

    public static VerifyPlayerPhoneResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        VerifyPlayerPhoneResult result = new VerifyPlayerPhoneResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        result.setRemainCount(rootObject.optInt("remaincount"));
        return result;
    }

    public int getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(int remainCount) {
        this.remainCount = remainCount;
    }
}
