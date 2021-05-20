package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class CsHistoryDetail {

    private String title;
    private String value;


    public CsHistoryDetail() {

    }

    public static CsHistoryDetail newInstance(JSONObject rootObject) {
        CsHistoryDetail csHistoryDetail = new CsHistoryDetail();
        csHistoryDetail.setTitle(rootObject.optString("title"));
        csHistoryDetail.setValue(rootObject.optString("value"));
        return csHistoryDetail;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

