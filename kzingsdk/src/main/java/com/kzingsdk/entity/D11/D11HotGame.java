package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class D11HotGame {

    private String imgurl;
    private String name;
    private String url;
    private String roomNo;
    private Integer order;
    private Integer tryPlatform;
    private Integer type;

    public D11HotGame() {

    }

    public static D11HotGame newInstance(JSONObject rootObject) {
        D11HotGame activityBonus = new D11HotGame();
        JSONObject dataObject = rootObject.optJSONObject("data");
        if(dataObject!=null) {
            activityBonus.setImgurl(dataObject.optString("imgurl"));
            activityBonus.setName(dataObject.optString("name"));
            activityBonus.setUrl(dataObject.optString("url"));
            activityBonus.setRoomNo(dataObject.optString("room_no"));
        }
        activityBonus.setOrder(rootObject.optInt("order"));
        activityBonus.setTryPlatform(rootObject.optInt("try_platform"));
        activityBonus.setType(rootObject.optInt("type"));
        return activityBonus;
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


