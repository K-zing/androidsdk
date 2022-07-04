package com.kzingsdk.entity;

import org.json.JSONObject;

public class SimpleApiResult {

    private Integer status;
    private String message = "";

    public static SimpleApiResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = new SimpleApiResult();
        simpleApiResult.setStatus(rootObject.optInt("status"));
        simpleApiResult.setMessage(rootObject.optString("message"));
        return simpleApiResult;
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
