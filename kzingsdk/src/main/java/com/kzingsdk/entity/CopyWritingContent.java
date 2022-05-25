package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class CopyWritingContent {

    private String cwid;
    private String content;
    private String targetCountry;
    private String displayDate;
    private boolean display;

    public CopyWritingContent() {

    }

    public static CopyWritingContent newInstance(JSONObject rootObject) {
        CopyWritingContent activityForm = new CopyWritingContent();
        activityForm.setCwid(rootObject.optString("cwid"));
        activityForm.setContent(rootObject.optString("content"));
        activityForm.setTargetCountry(rootObject.optString("targetcountry"));
        activityForm.setDisplayDate(rootObject.optString("displaydate"));
        activityForm.setDisplay(rootObject.optBoolean("display"));
        return activityForm;
    }

    public String getCwid() {
        return cwid;
    }

    public CopyWritingContent setCwid(String cwid) {
        this.cwid = cwid;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CopyWritingContent setContent(String content) {
        this.content = content;
        return this;
    }

    public String getTargetCountry() {
        return targetCountry;
    }

    public CopyWritingContent setTargetCountry(String targetCountry) {
        this.targetCountry = targetCountry;
        return this;
    }

    public String getDisplayDate() {
        return displayDate;
    }

    public CopyWritingContent setDisplayDate(String displayDate) {
        this.displayDate = displayDate;
        return this;
    }

    public boolean isDisplay() {
        return display;
    }

    public CopyWritingContent setDisplay(boolean display) {
        this.display = display;
        return this;
    }
}

