package com.kzingsdk.entity;

import org.json.JSONObject;


public class EnterGameResult {

    private String url;
    private String conversion;

    public EnterGameResult() {

    }

    public static EnterGameResult newInstance(JSONObject rootObject) {
        EnterGameResult activityBonus = new EnterGameResult();
        activityBonus.setUrl(rootObject.optString("url"));
        activityBonus.setConversion(rootObject.optString("conversion"));
        return activityBonus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }
}

