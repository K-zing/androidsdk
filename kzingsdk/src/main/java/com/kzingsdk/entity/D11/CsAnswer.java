package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class CsAnswer {

    private String sqdId;
    private String qType;
    private String value;

    public CsAnswer() {

    }

    public static CsAnswer newInstance(JSONObject rootObject) {
        CsAnswer csHistoryDetail = new CsAnswer();
        csHistoryDetail.setSqdId(rootObject.optString("i"));
        csHistoryDetail.setQType(rootObject.optString("t"));
        csHistoryDetail.setValue(rootObject.optString("v"));
        return csHistoryDetail;
    }

    public String getSqdId() {
        return sqdId;
    }

    public void setSqdId(String sqdId) {
        this.sqdId = sqdId;
    }

    public String getQType() {
        return qType;
    }

    public void setQType(String qType) {
        this.qType = qType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

