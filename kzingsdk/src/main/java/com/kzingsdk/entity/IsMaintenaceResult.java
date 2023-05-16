package com.kzingsdk.entity;

import org.json.JSONObject;

public class IsMaintenaceResult {

    protected String isMaintenance = "";
    protected String start = "";
    protected String end = "";
    protected String remark = "";
    protected String supportUrl = "";
    protected String supportUrl2 = "";


    public static IsMaintenaceResult newInstance(JSONObject rootObject) {
        IsMaintenaceResult simpleApiResult = new IsMaintenaceResult();
        simpleApiResult.setIsMaintenance(rootObject.optString("isMaintenance"));
        simpleApiResult.setStart(rootObject.optString("start"));
        simpleApiResult.setEnd(rootObject.optString("end"));
        simpleApiResult.setRemark(rootObject.optString("remark"));
        simpleApiResult.setSupportUrl(rootObject.optString("supportUrl"));
        simpleApiResult.setSupportUrl2(rootObject.optString("supportUrl2"));
        return simpleApiResult;
    }


    public String getIsMaintenance() {
        return isMaintenance;
    }

    public IsMaintenaceResult setIsMaintenance(String isMaintenance) {
        this.isMaintenance = isMaintenance;
        return this;
    }

    public String getStart() {
        return start;
    }

    public IsMaintenaceResult setStart(String start) {
        this.start = start;
        return this;
    }

    public String getEnd() {
        return end;
    }

    public IsMaintenaceResult setEnd(String end) {
        this.end = end;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public IsMaintenaceResult setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getSupportUrl() {
        return supportUrl;
    }

    public IsMaintenaceResult setSupportUrl(String supportUrl) {
        this.supportUrl = supportUrl;
        return this;
    }

    public String getSupportUrl2() {
        return supportUrl2;
    }

    public IsMaintenaceResult setSupportUrl2(String supportUrl2) {
        this.supportUrl2 = supportUrl2;
        return this;
    }
}


