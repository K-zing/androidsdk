package com.kzingsdk.entity;

import org.json.JSONObject;

public class AnnouncementStatusApiResult extends SimpleApiResult {

    private Integer count;

    public static AnnouncementStatusApiResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        AnnouncementStatusApiResult announcementStatusApiResult = new AnnouncementStatusApiResult();
        announcementStatusApiResult.status = simpleApiResult.status;
        announcementStatusApiResult.message = simpleApiResult.message;
        announcementStatusApiResult.setCount(rootObject.optInt("count"));
        return announcementStatusApiResult;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
