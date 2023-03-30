package com.kzingsdk.entity;

import org.json.JSONObject;

public class GetPhoneByNameResult extends SimpleApiResult {

    protected String playerName = "";
    protected String encodedPhone = "";
    protected String mobileCountry = "";

    public static GetPhoneByNameResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        GetPhoneByNameResult result = new GetPhoneByNameResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        JSONObject dataObject = rootObject.optJSONObject("data");
        if (dataObject != null) {
            result.setPlayerName(dataObject.optString("playername"));
            result.setEncodedPhone(dataObject.optString("encodedPhone"));
            result.setMobileCountry(dataObject.optString("mobilecountry"));
        }
        return result;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getEncodedPhone() {
        return encodedPhone;
    }

    public void setEncodedPhone(String encodedPhone) {
        this.encodedPhone = encodedPhone;
    }

    public String getMobileCountry() {
        return mobileCountry;
    }

    public void setMobileCountry(String mobileCountry) {
        this.mobileCountry = mobileCountry;
    }
}
