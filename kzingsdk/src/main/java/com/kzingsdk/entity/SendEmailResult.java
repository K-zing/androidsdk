package com.kzingsdk.entity;

import org.json.JSONObject;

public class SendEmailResult {

    private Integer intervalSec = 0;
    private Integer validDuration = 0;
    private Boolean success = false;
    private String message = "";
    private String token = "";

    public SendEmailResult() {

    }

    public static SendEmailResult newInstance(JSONObject rootObject) {
        SendEmailResult sendEmailResult = new SendEmailResult();
        sendEmailResult.setIntervalSec(rootObject.optInt("intervalsec"));
        sendEmailResult.setValidDuration(rootObject.optInt("validduration"));
        sendEmailResult.setSuccess(rootObject.optInt("status") == 0);
        sendEmailResult.setMessage(rootObject.optString("message"));
        sendEmailResult.setToken(rootObject.optString("token"));

        return sendEmailResult;
    }

    public Integer getValidDuration() {
        return validDuration;
    }

    public void setValidDuration(Integer validDuration) {
        this.validDuration = validDuration;
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

    public Integer getIntervalSec() {
        return intervalSec;
    }

    public void setIntervalSec(Integer intervalSec) {
        this.intervalSec = intervalSec;
    }

    @Override
    public String toString() {
        return "SendEmailResult{" +
                "interval=" + validDuration +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
