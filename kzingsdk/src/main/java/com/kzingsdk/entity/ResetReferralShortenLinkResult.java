package com.kzingsdk.entity;

import org.json.JSONObject;

public class ResetReferralShortenLinkResult extends SimpleApiResult {

    protected String response;

    public static ResetReferralShortenLinkResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        ResetReferralShortenLinkResult result = new ResetReferralShortenLinkResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        result.setResponse(rootObject.optString("response"));
        return result;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
