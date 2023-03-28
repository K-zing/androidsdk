package com.kzingsdk.entity;

import org.json.JSONObject;


public class Banner {

    private String cover;
    private String coveralt;
    private String redirect;
    private String actid;
    private String actgpid;

    public Banner() {

    }

    public static Banner newInstance(JSONObject rootObject) {
        Banner activityBonus = new Banner();
        activityBonus.setCover(rootObject.optString("cover"));
        activityBonus.setCoveralt(rootObject.optString("coveralt"));
        activityBonus.setRedirect(rootObject.optString("redirect"));
        activityBonus.setActid(rootObject.optString("actid"));
        activityBonus.setActgpid(rootObject.optString("actgpid"));
        return activityBonus;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCoveralt() {
        return coveralt;
    }

    public void setCoveralt(String coveralt) {
        this.coveralt = coveralt;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getActid() {
        return actid;
    }

    public void setActid(String actid) {
        this.actid = actid;
    }

    public String getActgpid() {
        return actgpid;
    }

    public void setActgpid(String actgpid) {
        this.actgpid = actgpid;
    }
}

