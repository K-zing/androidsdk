package com.kzingsdk.entity;

import org.json.JSONObject;


public class MarqueeAnnouncement {


    private String id;
    private String title;
    private String content;
    private String important;
    private String ticker;
    private String unread;
    private String status;
    private String created;
    private String tickerEffect;
    private String tickerLink;

    public MarqueeAnnouncement() {

    }

    public static MarqueeAnnouncement newInstance(JSONObject rootObject) {
        MarqueeAnnouncement marqueeAnnouncement = new MarqueeAnnouncement();
        marqueeAnnouncement.setId(rootObject.optString("id"));
        marqueeAnnouncement.setTitle(rootObject.optString("title"));
        marqueeAnnouncement.setContent(rootObject.optString("content"));
        marqueeAnnouncement.setImportant(rootObject.optString("important"));
        marqueeAnnouncement.setTicker(rootObject.optString("ticker"));
        marqueeAnnouncement.setUnread(rootObject.optString("unread"));
        marqueeAnnouncement.setStatus(rootObject.optString("status"));
        marqueeAnnouncement.setCreated(rootObject.optString("created"));
        marqueeAnnouncement.setTickerEffect(rootObject.optString("ticker_effect"));
        marqueeAnnouncement.setTickerLink(rootObject.optString("ticker_link"));
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

    public String getImportant() {
        return important;
    }

    public void setImportant(String important) {
        this.important = important;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getUnread() {
        return unread;
    }

    public MarqueeAnnouncement setUnread(String unread) {
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

    public String getTickerEffect() {
        return tickerEffect;
    }

    public void setTickerEffect(String tickerEffect) {
        this.tickerEffect = tickerEffect;
    }

    public String getTickerLink() {
        return tickerLink;
    }

    public void setTickerLink(String tickerLink) {
        this.tickerLink = tickerLink;
    }
}

