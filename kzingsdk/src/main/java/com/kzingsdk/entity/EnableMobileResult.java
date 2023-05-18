package com.kzingsdk.entity;

import org.json.JSONObject;

public class EnableMobileResult extends SimpleApiResult{

    protected boolean data = false;

    public static EnableMobileResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        EnableMobileResult result = new EnableMobileResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        result.setData(rootObject.optBoolean("data"));
        return result;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }
}
