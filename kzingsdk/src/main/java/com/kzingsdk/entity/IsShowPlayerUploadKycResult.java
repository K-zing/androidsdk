package com.kzingsdk.entity;

import org.json.JSONObject;

public class IsShowPlayerUploadKycResult extends SimpleApiResult {

    protected Integer data = 0;

    public static IsShowPlayerUploadKycResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        IsShowPlayerUploadKycResult result = new IsShowPlayerUploadKycResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        result.setData(rootObject.optInt("data"));
        return result;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
