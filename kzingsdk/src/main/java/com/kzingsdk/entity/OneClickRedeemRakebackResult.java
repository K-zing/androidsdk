package com.kzingsdk.entity;

import org.json.JSONObject;


public class OneClickRedeemRakebackResult {

    private Integer status;
    private Integer code;
    private String message;

    public static OneClickRedeemRakebackResult newInstance(JSONObject rootObject) {
        OneClickRedeemRakebackResult result = new OneClickRedeemRakebackResult();
        result.status = rootObject.optInt("status");
        result.code = rootObject.optInt("code");
        result.message = rootObject.optString("msg");
        return result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

