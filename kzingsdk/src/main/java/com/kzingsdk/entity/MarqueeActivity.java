package com.kzingsdk.entity;

import org.json.JSONObject;


public class MarqueeActivity {


    private String id;
    private String title;
    private String content;
    private String unread;
    private String status;
    private String created;

    public MarqueeActivity() {

    }

    public static MarqueeActivity newInstance(JSONObject rootObject) {
        MarqueeActivity marqueeAnnouncement = new MarqueeActivity();
        marqueeAnnouncement.setId(rootObject.optString("id"));
        marqueeAnnouncement.setTitle(rootObject.optString("title"));
        marqueeAnnouncement.setContent(rootObject.optString("content"));
        marqueeAnnouncement.setUnread(rootObject.optString("unread"));
        marqueeAnnouncement.setStatus(rootObject.optString("status"));
        marqueeAnnouncement.setCreated(rootObject.optString("created"));
        return marqueeAnnouncement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUnread() {
        return unread;
    }

    public MarqueeActivity setUnread(String unread) {
        this.unread = unread;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}

