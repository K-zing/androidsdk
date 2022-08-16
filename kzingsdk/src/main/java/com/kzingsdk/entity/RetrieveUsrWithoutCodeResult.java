package com.kzingsdk.entity;

import org.json.JSONObject;

public class RetrieveUsrWithoutCodeResult {

    private String status = "";
    private String message = "";
    private Integer intervalSec = 0;

    public RetrieveUsrWithoutCodeResult() {

    }

    public static RetrieveUsrWithoutCodeResult newInstance(JSONObject rootObject) {
        RetrieveUsrWithoutCodeResult sendEmailResult = new RetrieveUsrWithoutCodeResult();
        sendEmailResult.setMessage(rootObject.optString("msg"));
        sendEmailResult.setStatus(rootObject.optString("status"));
        sendEmailResult.setIntervalSec(rootObject.optInt("intervalsec"));
        return sendEmailResult;
    }

    public String getStatus() {
        return status;
    }

    public RetrieveUsrWithoutCodeResult setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RetrieveUsrWithoutCodeResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getIntervalSec() {
        return intervalSec;
    }

    public RetrieveUsrWithoutCodeResult setIntervalSec(Integer intervalSec) {
        this.intervalSec = intervalSec;
        return this;
    }
}
