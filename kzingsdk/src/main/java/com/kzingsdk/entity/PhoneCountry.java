package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class PhoneCountry {

    private String country;
    private String name;
    private Integer mobileCode;
    private boolean isPreferred;
    private ArrayList<String> popularList;

    public static PhoneCountry newInstance(JSONObject rootObject) {
        PhoneCountry phoneCountry = new PhoneCountry();
        phoneCountry.setCountry(rootObject.optString("country"));
        phoneCountry.setName(rootObject.optString("text"));
        phoneCountry.setMobileCode(rootObject.optInt("mobilecode"));
        phoneCountry.setPreferred(rootObject.optBoolean("preferred", false));
        phoneCountry.setPopularList(new ArrayList<>());
        JSONArray popularListJSONArray = rootObject.optJSONArray("popular");
        if (popularListJSONArray != null) {
            for (int i = 0; i < popularListJSONArray.length(); i++) {
                phoneCountry.getPopularList().add(popularListJSONArray.optString(i));
            }
        }
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

    public ArrayList<String> getPopularList() {
        return popularList;
    }

    public void setPopularList(ArrayList<String> popularList) {
        this.popularList = popularList;
    }
}