package com.kzingsdk.entity.D11;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class PhoneRecallInfo {

    private String cid;
    private String cname;
    private String status;
    private ArrayList<PhoneRecallInfoSubType> subTypeList = new ArrayList<>();

    public PhoneRecallInfo() {

    }

    public static PhoneRecallInfo newInstance(JSONObject rootObject) {
        PhoneRecallInfo phoneRecallInfo = new PhoneRecallInfo();
        phoneRecallInfo.setCid(rootObject.optString("cid"));
        phoneRecallInfo.setCname(rootObject.optString("cname"));
        phoneRecallInfo.setStatus(rootObject.optString("status"));
        JSONArray contentArray = rootObject.optJSONArray("subtypes");
        if (contentArray != null) {
            for (int i = 0; i < contentArray.length(); i++) {
                phoneRecallInfo.subTypeList.add(PhoneRecallInfoSubType.newInstance(contentArray.optJSONObject(i)));
            }
        }
        return phoneRecallInfo;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<PhoneRecallInfoSubType> getSubTypeList() {
        return subTypeList;
    }

    public void setSubTypeList(ArrayList<PhoneRecallInfoSubType> subTypeList) {
        this.subTypeList = subTypeList;
    }
}

