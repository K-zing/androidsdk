package com.kzingsdk.entity;

import org.json.JSONObject;

public class RequestUsernameResult {

    private Integer status = 0;
    private String message = "";

    public RequestUsernameResult() {

    }

    public static RequestUsernameResult newInstance(JSONObject rootObject) {
        RequestUsernameResult sendEmailResult = new RequestUsernameResult();
        sendEmailResult.setStatus(rootObject.optInt("status"));
        sendEmailResult.setMessage(rootObject.optString("message"));
        return sendEmailResult;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
