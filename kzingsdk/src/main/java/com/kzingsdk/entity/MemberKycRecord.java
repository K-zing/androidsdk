package com.kzingsdk.entity;

import org.json.JSONObject;

public class MemberKycRecord {

    private String id;
    private String filename;
    private String status;
    private String updated;

    public static MemberKycRecord newInstance(JSONObject rootObject) {
        MemberKycRecord result = new MemberKycRecord();
        result.setId(rootObject.optString("id"));
        result.setFilename(rootObject.optString("filename"));
        result.setStatus(rootObject.optString("status"));
        result.setUpdated(rootObject.optString("updated"));
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
