package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class SupportHelperContent {

    private String title;
    private String content;
    private String imgurl;
    private String url;

    public SupportHelperContent() {

    }

    public static SupportHelperContent newInstance(JSONObject rootObject) {
        SupportHelperContent activityBonus = new SupportHelperContent();
        activityBonus.setTitle(rootObject.optString("title"));
        activityBonus.setContent(rootObject.optString("content"));
        activityBonus.setImgurl(rootObject.optString("imgurl"));
        activityBonus.setUrl(rootObject.optString("url"));
        return activityBonus;
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

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

