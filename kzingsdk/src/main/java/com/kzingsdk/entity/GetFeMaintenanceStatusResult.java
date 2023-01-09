package com.kzingsdk.entity;

import org.json.JSONObject;

public class GetFeMaintenanceStatusResult {

    private String status;
    private String title;
    private String content;
    private Long startTime;
    private Long endTime;

    public static GetFeMaintenanceStatusResult newInstance(JSONObject rootObject) {
        GetFeMaintenanceStatusResult result = new GetFeMaintenanceStatusResult();
        result.setStatus(rootObject.optString("status"));
        result.setTitle(rootObject.optString("title"));
        result.setContent(rootObject.optString("content"));
        result.setStartTime(rootObject.optLong("starttime"));
        result.setEndTime(rootObject.optLong("endtime"));
        return result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
