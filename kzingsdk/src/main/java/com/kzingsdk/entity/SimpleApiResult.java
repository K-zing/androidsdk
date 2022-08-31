package com.kzingsdk.entity;

import org.json.JSONObject;

public class SimpleApiResult {

    protected Integer status;
    protected String message = "";

    public static SimpleApiResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = new SimpleApiResult();
        simpleApiResult.setStatus(rootObject.optInt("status"));
        String msg = rootObject.optString("message");
        if (msg == null){
            msg = rootObject.optString("msg");
        }
        simpleApiResult.setMessage(msg);
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
