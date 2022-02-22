package com.kzingsdk.entity;

import org.json.JSONObject;


public class MobilePopupV2 {
    private int id;
    private int order;
    private int displayCondition;
    private int displayRepeat;
    private int clickFunction;
    private int frameSetting;
    private String imgPath;
    private String redirectLink;
    private String title;
    private String content;
    private String frame;

    public MobilePopupV2() {
    }

    public static MobilePopupV2 newInstance(JSONObject rootObject) {
        MobilePopupV2 item = new MobilePopupV2();
        item.setId(rootObject.optInt("id"));
        item.setOrder(rootObject.optInt("order"));
        item.setDisplayCondition(rootObject.optInt("displaycondition"));
        item.setDisplayRepeat(rootObject.optInt("displayrepeat"));
        item.setClickFunction(rootObject.optInt("clickfunction"));
        item.setFrameSetting(rootObject.optInt("framesetting"));
        item.setImgPath(rootObject.optString("imgpath"));
        item.setRedirectLink(rootObject.optString("redirect_link"));
        item.setTitle(rootObject.optString("title"));
        item.setContent(rootObject.optString("content"));
        item.setFrame(rootObject.optString("frame"));
        return item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getDisplayCondition() {
        return displayCondition;
    }

    public void setDisplayCondition(int displayCondition) {
        this.displayCondition = displayCondition;
    }

    public int getDisplayRepeat() {
        return displayRepeat;
    }

    public void setDisplayRepeat(int displayRepeat) {
        this.displayRepeat = displayRepeat;
    }

    public int getClickFunction() {
        return clickFunction;
    }

    public void setClickFunction(int clickFunction) {
        this.clickFunction = clickFunction;
    }

    public int getFrameSetting() {
        return frameSetting;
    }

    public void setFrameSetting(int frameSetting) {
        this.frameSetting = frameSetting;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getRedirectLink() {
        return redirectLink;
    }

    public void setRedirectLink(String redirectLink) {
        this.redirectLink = redirectLink;
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

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }
}