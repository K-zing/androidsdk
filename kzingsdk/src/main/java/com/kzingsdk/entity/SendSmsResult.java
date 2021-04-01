package com.kzingsdk.entity;

import org.json.JSONObject;

public class SendSmsResult {

    private Integer interval = 0;
    private Boolean success = false;
    private String message = "";

    public SendSmsResult() {

    }

    public static SendSmsResult newInstance(JSONObject rootObject) {
        SendSmsResult sendSmsResult = new SendSmsResult();
        sendSmsResult.setInterval(rootObject.optInt("resendSec"));
        sendSmsResult.setSuccess(rootObject.optInt("status") == 0);
        sendSmsResult.setMessage(rootObject.optString("message"));
        return sendSmsResult;
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
        return "SendSmsResult{" +
                "interval=" + interval +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
