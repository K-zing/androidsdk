package com.kzingsdk.entity;

import org.json.JSONObject;


public class PhoneCountry {

    private String country;
    private String name;
    private Integer mobileCode;
    private boolean isPreferred;

    public static PhoneCountry newInstance(JSONObject rootObject) {
        PhoneCountry phoneCountry = new PhoneCountry();
        phoneCountry.setCountry(rootObject.optString("country"));
        phoneCountry.setName(rootObject.optString("text"));
        phoneCountry.setMobileCode(rootObject.optInt("mobilecode"));
        phoneCountry.setPreferred(rootObject.optBoolean("preferred", false));
        return phoneCountry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMobileCode() {
        return mobileCode;
    }

    public void setMobileCode(Integer mobileCode) {
        this.mobileCode = mobileCode;
    }

    public boolean isPreferred() {
        return isPreferred;
    }

    public void setPreferred(boolean preferred) {
        isPreferred = preferred;
    }
}