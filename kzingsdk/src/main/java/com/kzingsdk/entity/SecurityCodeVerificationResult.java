package com.kzingsdk.entity;

import org.json.JSONObject;

public class SecurityCodeVerificationResult extends SimpleApiResult {

    protected String otp = "";

    public static SecurityCodeVerificationResult newInstance(JSONObject rootObject) {
        SecurityCodeVerificationResult result = new SecurityCodeVerificationResult();
        result.setOtp(rootObject.optString("otp"));
        return result;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
