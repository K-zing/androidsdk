package com.kzingsdk.entity;

import org.json.JSONObject;

public class SubmitMemberKycResult extends SimpleApiResult {

    private String id;
    private String filename;

    public static SubmitMemberKycResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        SubmitMemberKycResult result = new SubmitMemberKycResult();
        result.status = simpleApiResult.status;
        result.message = simpleApiResult.message;
        JSONObject dataObject = rootObject.optJSONObject("data");
        if (dataObject != null) {
            result.setId(dataObject.optString("id"));
            result.setFilename(dataObject.optString("filename"));
        }
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
}
