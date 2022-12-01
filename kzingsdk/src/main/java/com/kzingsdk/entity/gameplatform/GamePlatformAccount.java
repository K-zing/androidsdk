package com.kzingsdk.entity.gameplatform;

import org.json.JSONObject;

public class GamePlatformAccount {

    private String gpAccountId = "";
    private String gpName = "";
    private String isseamless = "";
    private int displayorder = 0;
    private int status = 0;
    private String image = "";

    public GamePlatformAccount() {

    }

    public static GamePlatformAccount newInstance(JSONObject rootObject) {
        GamePlatformAccount item = new GamePlatformAccount();
        item.setGpAccountId(rootObject.optString("gpaccountid"));
        item.setGpName(rootObject.optString("gpname"));
        item.setIsseamless(rootObject.optString("isseamless"));
        item.setDisplayorder(rootObject.optInt("displayorder"));
        item.setStatus(rootObject.optInt("status"));
        item.setImage(rootObject.optString("image"));
        return item;
    }

    public GamePlatformAccount clone() {
        GamePlatformAccount gpChild = new GamePlatformAccount();
        gpChild.gpAccountId = gpAccountId;
        gpChild.gpName = gpName;
        gpChild.isseamless = isseamless;
        gpChild.image = image;
        gpChild.displayorder = displayorder;
        return gpChild;
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

    public String getIsseamless() {
        return isseamless;
    }

    public GamePlatformAccount setIsseamless(String isseamless) {
        this.isseamless = isseamless;
        return this;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
