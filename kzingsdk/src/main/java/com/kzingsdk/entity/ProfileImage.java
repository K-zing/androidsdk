package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class ProfileImage {

    private String id;
    private String images;
    private String created;
    private String updated;
    private Integer isDefault;
    private Integer displayOrder;

    public ProfileImage() {

    }

    public static ProfileImage newInstance(JSONObject rootObject) {
        ProfileImage profileImage = new ProfileImage();
        profileImage.setId(rootObject.optString("id"));
        if (rootObject.optString("images").length() == 0){
            profileImage.setImages(rootObject.optString("img"));
        }else{
            profileImage.setImages(rootObject.optString("images"));
        }
        profileImage.setCreated(rootObject.optString("created"));
        profileImage.setUpdated(rootObject.optString("updated"));
        profileImage.setIsDefault(rootObject.optInt("isdefault"));
        profileImage.setDisplayOrder(rootObject.optInt("displayorder"));
        return profileImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}

