package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

public class SendOTPWithPhoneResult extends SimpleApiResult{

    private Integer interval = 0;

    public SendOTPWithPhoneResult() {

    }

    public static SendOTPWithPhoneResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        SendOTPWithPhoneResult result = new SendOTPWithPhoneResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        result.setInterval(rootObject.optInt("interval"));
        return result;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

}
