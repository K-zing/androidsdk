package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class CsRemark {

    private Integer type;
    private String remarks;
    private String csId;
    private String csName;
    private Long dateTime;

    public CsRemark() {

    }

    public static CsRemark newInstance(JSONObject rootObject) {
        CsRemark csHistoryDetail = new CsRemark();
        csHistoryDetail.setType(rootObject.optInt("type"));
        csHistoryDetail.setRemarks(rootObject.optString("remarks"));
        csHistoryDetail.setCsId(rootObject.optString("csid"));
        csHistoryDetail.setCsName(rootObject.optString("csname"));
        csHistoryDetail.setDateTime(rootObject.optLong("datetime"));
        return csHistoryDetail;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }

    public String getCsName() {
        return csName;
    }

    public void setCsName(String csName) {
        this.csName = csName;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }
}

