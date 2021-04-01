package com.kzingsdk.entity;

import org.json.JSONObject;

public class SocialAccountBindingStatus {

    private SocialRegisterPlatform platform;
    private String message;
    private Boolean bindingStatus = false;

    public SocialAccountBindingStatus() {
    }

    public static SocialAccountBindingStatus newInstance(JSONObject rootObject) {
        SocialAccountBindingStatus regSendSmsResult = new SocialAccountBindingStatus();
        regSendSmsResult.setPlatform(SocialRegisterPlatform.valueOfName(rootObject.optString("data")));
        regSendSmsResult.setMessage(rootObject.optString("message"));
        regSendSmsResult.setBindingStatus(rootObject.optInt("status", 1) == 0);
        return regSendSmsResult;
    }

    public SocialRegisterPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(SocialRegisterPlatform platform) {
        this.platform = platform;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getBindingStatus() {
        return bindingStatus;
    }

    public void setBindingStatus(Boolean bindingStatus) {
        this.bindingStatus = bindingStatus;
    }
}
