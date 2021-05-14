package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class GameLikesData {

    private String gpid;
    private Integer onlineGamers;
    private Integer thumbStatus;
    private Integer thumbValue;

    public GameLikesData() {

    }

    public static GameLikesData newInstance(JSONObject rootObject) {
        GameLikesData activityBonus = new GameLikesData();
        activityBonus.setGpid(rootObject.optString("game_id"));
        activityBonus.setOnlineGamers(rootObject.optInt("online_gamers"));
        activityBonus.setThumbStatus(rootObject.optInt("thumb_status"));
        activityBonus.setThumbValue(rootObject.optInt("thumb_value"));
        return activityBonus;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public Integer getOnlineGamers() {
        return onlineGamers;
    }

    public void setOnlineGamers(Integer onlineGamers) {
        this.onlineGamers = onlineGamers;
    }

    public Integer getThumbStatus() {
        return thumbStatus;
    }

    public void setThumbStatus(Integer thumbStatus) {
        this.thumbStatus = thumbStatus;
    }

    public Integer getThumbValue() {
        return thumbValue;
    }

    public void setThumbValue(Integer thumbValue) {
        this.thumbValue = thumbValue;
    }
}

