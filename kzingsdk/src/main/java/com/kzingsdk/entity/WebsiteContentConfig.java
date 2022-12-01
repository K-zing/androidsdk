package com.kzingsdk.entity;

import org.json.JSONObject;


public class WebsiteContentConfig {

    private String itemKey;
    private String itemVal;
    private String title;

    public WebsiteContentConfig() {

    }

    public static WebsiteContentConfig newInstance(JSONObject rootObject) {
        WebsiteContentConfig websiteContentConfig = new WebsiteContentConfig();
        websiteContentConfig.setItemKey(rootObject.optString("itemkey"));
        websiteContentConfig.setItemVal(rootObject.optString("itemval"));
        websiteContentConfig.setTitle(rootObject.optString("title"));
        return websiteContentConfig;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public String getItemVal() {
        return itemVal;
    }

    public void setItemVal(String itemVal) {
        this.itemVal = itemVal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

