package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class CsHistoryDetail {

    private boolean isExtra = false;
    private String id;
    private String title;
    private String type;
    private String value;

    public CsHistoryDetail() {

    }

    public static CsHistoryDetail newInstance(JSONObject rootObject, String id, boolean isExtra) {
        CsHistoryDetail csHistoryDetail = new CsHistoryDetail();
        csHistoryDetail.isExtra = isExtra;
        csHistoryDetail.id = id;
        csHistoryDetail.setTitle(rootObject.optString("title"));
        csHistoryDetail.setType(rootObject.optString("type"));
        csHistoryDetail.setValue(rootObject.optString("value"));
        return csHistoryDetail;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

