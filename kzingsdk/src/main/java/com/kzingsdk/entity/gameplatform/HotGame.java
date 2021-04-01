package com.kzingsdk.entity.gameplatform;

import org.json.JSONObject;

public class HotGame {

    private String gpAccountId;
    private String image;
    private String game;
    private String code;
    private String gpid;
    private String gpName;
    private String name;
    private String gpChildId;
    private String currency;
    private int displayorder = 0;
    private int status = 1;

    public static HotGame newInstance(JSONObject rootObject) {
        HotGame item = new HotGame();
        item.setGpAccountId(rootObject.optString("gpaccountid"));
        item.setImage(rootObject.optString("image"));
        item.setGame(rootObject.optString("game"));
        item.setCode(rootObject.optString("code"));
        item.setGpid(rootObject.optString("gpid"));
        item.setGpName(rootObject.optString("gpname"));
        item.setName(rootObject.optString("name"));
        item.setGpChildId(rootObject.optString("gpchildid"));
        item.setCurrency(rootObject.optString("currency"));
        item.setDisplayorder(rootObject.optInt("displayorder"));
        item.setStatus(rootObject.optInt("status"));
        return item;
    }

    public String getGpAccountId() {
        return gpAccountId;
    }

    public void setGpAccountId(String gpAccountId) {
        this.gpAccountId = gpAccountId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGpChildId() {
        return gpChildId;
    }

    public void setGpChildId(String gpChildId) {
        this.gpChildId = gpChildId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(int displayorder) {
        this.displayorder = displayorder;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
