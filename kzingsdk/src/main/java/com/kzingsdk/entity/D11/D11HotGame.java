package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class D11HotGame {

    private String imgurl;
    private String name;
    private String url;
    private String roomNo;
    private String gpAccountId;
    private String gpid;
    private Integer order;
    private Integer tryPlatform;
    private Integer type;

    public D11HotGame() {

    }

    public static D11HotGame newInstance(JSONObject rootObject) {
        D11HotGame d11HotGame = new D11HotGame();
        JSONObject dataObject = rootObject.optJSONObject("data");
        if (dataObject != null) {
            d11HotGame.setImgurl(dataObject.optString("imgurl"));
            d11HotGame.setName(dataObject.optString("name"));
            d11HotGame.setUrl(dataObject.optString("url"));
            d11HotGame.setRoomNo(dataObject.optString("room_no"));
            d11HotGame.setGpAccountId(dataObject.optString("gpaccountid"));
            d11HotGame.setGpid(dataObject.optString("gpid"));
        }
        d11HotGame.setOrder(rootObject.optInt("order"));
        d11HotGame.setTryPlatform(rootObject.optInt("try_platform"));
        d11HotGame.setType(rootObject.optInt("type"));
        return d11HotGame;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getGpAccountId() {
        return gpAccountId;
    }

    public void setGpAccountId(String gpAccountId) {
        this.gpAccountId = gpAccountId;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getTryPlatform() {
        return tryPlatform;
    }

    public void setTryPlatform(Integer tryPlatform) {
        this.tryPlatform = tryPlatform;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}


