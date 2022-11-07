package com.kzingsdk.entity;

import org.json.JSONObject;


public class SpecialEvent {

    private String floatingWindowPosition;
    private String displayPage;
    private String displayRepetitionAfterClosing;
    private String gpid;
    private String imageUrl;

    public SpecialEvent() {

    }

    public static SpecialEvent newInstance(JSONObject rootObject) {
        SpecialEvent specialEvent = new SpecialEvent();
        specialEvent.setFloatingWindowPosition(rootObject.optString("floatingWindowPosition"));
        specialEvent.setDisplayPage(rootObject.optString("displayPage"));
        specialEvent.setDisplayRepetitionAfterClosing(rootObject.optString("displayRepetitionAfterClosing"));
        specialEvent.setGpid(rootObject.optString("gpid"));
        specialEvent.setImageUrl(rootObject.optString("imageUrl"));
        return specialEvent;
    }

    public String getFloatingWindowPosition() {
        return floatingWindowPosition;
    }

    public void setFloatingWindowPosition(String floatingWindowPosition) {
        this.floatingWindowPosition = floatingWindowPosition;
    }

    public String getDisplayPage() {
        return displayPage;
    }

    public void setDisplayPage(String displayPage) {
        this.displayPage = displayPage;
    }

    public String getDisplayRepetitionAfterClosing() {
        return displayRepetitionAfterClosing;
    }

    public void setDisplayRepetitionAfterClosing(String displayRepetitionAfterClosing) {
        this.displayRepetitionAfterClosing = displayRepetitionAfterClosing;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

