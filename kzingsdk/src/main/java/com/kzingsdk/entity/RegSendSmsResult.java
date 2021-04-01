package com.kzingsdk.entity;

import org.json.JSONObject;

public class RegSendSmsResult {

    private Integer interval = 0;
    private Boolean success = false;
    private String message = "";

    public RegSendSmsResult() {

    }

    public static RegSendSmsResult newInstance(JSONObject rootObject) {
        RegSendSmsResult regSendSmsResult = new RegSendSmsResult();
        regSendSmsResult.setInterval(rootObject.optInt("interval"));
        regSendSmsResult.setSuccess(rootObject.optInt("status") == 1);
        regSendSmsResult.setMessage(rootObject.optString("message"));
        return regSendSmsResult;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RegSendSmsResult{" +
                "interval=" + interval +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
