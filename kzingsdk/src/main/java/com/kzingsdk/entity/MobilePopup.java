package com.kzingsdk.entity;

import org.json.JSONObject;


public class MobilePopup {

    private String frame;
    private String frameSetting;
    private String title;
    private String content;
    private String imagePath;
    private String csRemark;
    private int displayCondition = 0;
    private int displayRepeat = 0;
    private String clickFunction;
    private String redirectLink;
    private String selectedDisplay;

    public MobilePopup() {
    }

    public static MobilePopup newInstance(JSONObject rootObject) {
        MobilePopup item = new MobilePopup();
        item.setFrame(rootObject.optString("frame"));
        item.setFrameSetting(rootObject.optString("framesetting"));
        item.setTitle(rootObject.optString("title"));
        item.setContent(rootObject.optString("content"));
        item.setImagePath(rootObject.optString("image_path"));
        item.setCsRemark(rootObject.optString("csremark"));
        item.setDisplayCondition(rootObject.optInt("displaycondition"));
        item.setDisplayRepeat(rootObject.optInt("displayrepeat"));
        item.setClickFunction(rootObject.optString("clickfunction"));
        item.setRedirectLink(rootObject.optString("redirect_link"));
        item.setSelectedDisplay(rootObject.optString("selecteddisplay"));
        return item;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getFrameSetting() {
        return frameSetting;
    }

    public void setFrameSetting(String frameSetting) {
        this.frameSetting = frameSetting;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCsRemark() {
        return csRemark;
    }

    public void setCsRemark(String csRemark) {
        this.csRemark = csRemark;
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

    public String getClickFunction() {
        return clickFunction;
    }

    public void setClickFunction(String clickFunction) {
        this.clickFunction = clickFunction;
    }

    public String getRedirectLink() {
        return redirectLink;
    }

    public void setRedirectLink(String redirectLink) {
        this.redirectLink = redirectLink;
    }

    public String getSelectedDisplay() {
        return selectedDisplay;
    }

    public void setSelectedDisplay(String selectedDisplay) {
        this.selectedDisplay = selectedDisplay;
    }
}