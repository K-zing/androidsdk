package com.kzingsdk.entity;

import org.json.JSONObject;

public class SimpleApiResult {

    protected Integer status;
    protected String message = "";

    public static SimpleApiResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = new SimpleApiResult();
        if (rootObject.has("status")) {
            simpleApiResult.setStatus(rootObject.optInt("status"));
        } else if (rootObject.has("c")) {
            simpleApiResult.setStatus(rootObject.optInt("c"));
        } else {
            simpleApiResult.setStatus(0);
        }
        String msg = rootObject.optString("message", "null");
        if (msg.equals("null")) {
            msg = rootObject.optString("msg", "null");
        }
        if (msg.equals("null")) {
            msg = rootObject.optString("m");
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
