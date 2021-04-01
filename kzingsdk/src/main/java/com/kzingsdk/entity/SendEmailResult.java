package com.kzingsdk.entity;

import org.json.JSONObject;

public class SendEmailResult {

    private Integer interval = 0;
    private Boolean success = false;
    private String message = "";
    private String token = "";

    public SendEmailResult() {

    }

    public static SendEmailResult newInstance(JSONObject rootObject) {
        SendEmailResult sendEmailResult = new SendEmailResult();
        sendEmailResult.setInterval(rootObject.optInt("validduration"));
        sendEmailResult.setSuccess(rootObject.optInt("status") == 0);
        sendEmailResult.setMessage(rootObject.optString("message"));
        sendEmailResult.setToken(rootObject.optString("token"));
        return sendEmailResult;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SendEmailResult{" +
                "interval=" + interval +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
