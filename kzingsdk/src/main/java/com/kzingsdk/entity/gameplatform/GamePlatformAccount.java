package com.kzingsdk.entity.gameplatform;

import org.json.JSONObject;

public class GamePlatformAccount {

    private String gpAccountId = "";
    private String gpName = "";
    private int displayorder = 0;
    private String image = "";

    public GamePlatformAccount clone() {
        GamePlatformAccount gpChild = new GamePlatformAccount();
        gpChild.gpAccountId = gpAccountId;
        gpChild.gpName = gpName;
        gpChild.image = image;
        gpChild.displayorder = displayorder;
        return gpChild;
    }

    public GamePlatformAccount() {

    }

    public static GamePlatformAccount newInstance(JSONObject rootObject) {
        GamePlatformAccount item = new GamePlatformAccount();
        item.setGpAccountId(rootObject.optString("gpaccountid"));
        item.setGpName(rootObject.optString("gpname"));
        item.setDisplayorder(rootObject.optInt("displayorder"));
        item.setImage(rootObject.optString("image"));
        return item;
    }

    public String getGpAccountId() {
        return gpAccountId;
    }

    public void setGpAccountId(String gpAccountId) {
        this.gpAccountId = gpAccountId;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public int getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(int displayorder) {
        this.displayorder = displayorder;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "GamePlatformAccount{" +
                "gpAccountId='" + gpAccountId + '\'' +
                ", gpName='" + gpName + '\'' +
                ", displayorder=" + displayorder +
                ", image='" + image + '\'' +
                '}';
    }
}
