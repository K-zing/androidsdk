package com.kzingsdk.entity;

import org.json.JSONObject;


public class MobileFloatingWindow {

    private String floatingActivity;
    private String floatingClickValue;
    private String floatingPageValue;
    private String floatingPositionValue;
    private String floatingRedirectUrl;
    private String floatingRepeatDisplayValue;
    private String floatingStyleValue;
    private String id;
    private String lang;
    private Integer order = 0;
    private Integer status = 0;
    private String floatingImageId;
    private String floatingImagePath;
    private String floatingRedirectGpid;


    public static MobileFloatingWindow newInstance(JSONObject rootObject) {
        MobileFloatingWindow mobileFloatingWindow = new MobileFloatingWindow();
        mobileFloatingWindow.setFloatingActivity(rootObject.optString("floatingActivity"));
        mobileFloatingWindow.setFloatingClickValue(rootObject.optString("floatingClickValue"));
        mobileFloatingWindow.setFloatingPageValue(rootObject.optString("floatingPageValue"));
        mobileFloatingWindow.setFloatingPositionValue(rootObject.optString("floatingPositionValue"));
        mobileFloatingWindow.setFloatingRedirectUrl(rootObject.optString("floatingRedirectUrl"));
        mobileFloatingWindow.setFloatingRepeatDisplayValue(rootObject.optString("floatingRepeatDisplayValue"));
        mobileFloatingWindow.setFloatingStyleValue(rootObject.optString("floatingStyleValue"));
        mobileFloatingWindow.setId(rootObject.optString("id"));
        mobileFloatingWindow.setLang(rootObject.optString("lang"));
        mobileFloatingWindow.setLang(rootObject.optString("lang"));
        mobileFloatingWindow.setFloatingRedirectGpid(rootObject.optInt("floatingRedirectGpid"));
        mobileFloatingWindow.setStatus(rootObject.optInt("status"));
        JSONObject floatingImageObject = rootObject.optJSONObject("floatingImage");
        if (floatingImageObject != null) {
            mobileFloatingWindow.setFloatingImageId(floatingImageObject.optString("image_id"));
            mobileFloatingWindow.setFloatingImagePath(floatingImageObject.optString("image_path"));
        }
        return mobileFloatingWindow;
    }

    public String getFloatingActivity() {
        return floatingActivity;
    }

    public void setFloatingActivity(String floatingActivity) {
        this.floatingActivity = floatingActivity;
    }

    public String getFloatingClickValue() {
        return floatingClickValue;
    }

    public void setFloatingClickValue(String floatingClickValue) {
        this.floatingClickValue = floatingClickValue;
    }

    public String getFloatingPageValue() {
        return floatingPageValue;
    }

    public void setFloatingPageValue(String floatingPageValue) {
        this.floatingPageValue = floatingPageValue;
    }

    public String getFloatingPositionValue() {
        return floatingPositionValue;
    }

    public void setFloatingPositionValue(String floatingPositionValue) {
        this.floatingPositionValue = floatingPositionValue;
    }

    public String getFloatingRedirectUrl() {
        return floatingRedirectUrl;
    }

    public void setFloatingRedirectUrl(String floatingRedirectUrl) {
        this.floatingRedirectUrl = floatingRedirectUrl;
    }

    public String getFloatingRepeatDisplayValue() {
        return floatingRepeatDisplayValue;
    }

    public void setFloatingRepeatDisplayValue(String floatingRepeatDisplayValue) {
        this.floatingRepeatDisplayValue = floatingRepeatDisplayValue;
    }

    public String getFloatingStyleValue() {
        return floatingStyleValue;
    }

    public void setFloatingStyleValue(String floatingStyleValue) {
        this.floatingStyleValue = floatingStyleValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFloatingImageId() {
        return floatingImageId;
    }

    public void setFloatingImageId(String floatingImageId) {
        this.floatingImageId = floatingImageId;
    }

    public String getFloatingImagePath() {
        return floatingImagePath;
    }

    public void setFloatingImagePath(String floatingImagePath) {
        this.floatingImagePath = floatingImagePath;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getFloatingRedirectGpid() {
        return floatingRedirectGpid;
    }

    public void setFloatingRedirectGpid(String floatingRedirectGpid) {
        this.floatingRedirectGpid = floatingRedirectGpid;
    }
}

