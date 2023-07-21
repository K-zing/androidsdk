package com.kzingsdk.entity;

import org.json.JSONObject;

public class CategoryNews {

    private int id = 0;
    private String datetime = "";
    private String title = "";
    private String content = "";
    private String lang = "";
    private String mobileFName = "";
    private String mobileType = "";
    private String redirectUrl = "";

    public static CategoryNews newInstance(JSONObject rootObject) {
        CategoryNews result = new CategoryNews();
        result.setId(rootObject.optInt("id"));
        result.setDatetime(rootObject.optString("datetime"));
        result.setTitle(rootObject.optString("title"));
        result.setContent(rootObject.optString("content"));
        result.setLang(rootObject.optString("lang"));
        result.setMobileFName(rootObject.optString("mobile_fname"));
        result.setMobileType(rootObject.optString("mobile_type"));
        result.setRedirectUrl(rootObject.optString("redirect_url"));
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getMobileFName() {
        return mobileFName;
    }

    public void setMobileFName(String mobileFName) {
        this.mobileFName = mobileFName;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
