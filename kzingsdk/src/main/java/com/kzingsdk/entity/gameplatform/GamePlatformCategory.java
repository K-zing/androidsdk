package com.kzingsdk.entity.gameplatform;

import org.json.JSONObject;

public class GamePlatformCategory {

    private String childCategoryId = "-1";
    private String gpid = "" ;
    private String childGroupId = "" ;
    private String categoryName = "" ;
    private String categoryEnName = "";
    private String image = "" ;
    private int displayorder = 0 ;

    public GamePlatformCategory(){

    }

    public static GamePlatformCategory newInstance(JSONObject rootObject) {
        return newInstance(rootObject, rootObject.optString("gpid"));
    }

    public static GamePlatformCategory newInstance(JSONObject rootObject, String gpid) {
        GamePlatformCategory item = new GamePlatformCategory();
        item.setChildCategoryId(rootObject.optString("childcategoryid"));
        item.setGpid(gpid);
        item.setChildGroupId(rootObject.optString("childgroupid"));
        item.setCategoryName(rootObject.optString("categoryname"));
        item.setCategoryEnName(rootObject.optString("categorynameen"));
        item.setDisplayorder(rootObject.optInt("displayorder"));
        item.setImage(rootObject.optString("image"));
        return item;
    }

    public String getChildCategoryId() {
        return childCategoryId;
    }

    public void setChildCategoryId(String childCategoryId) {
        this.childCategoryId = childCategoryId;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getChildGroupId() {
        return childGroupId;
    }

    public void setChildGroupId(String childGroupId) {
        this.childGroupId = childGroupId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(int displayorder) {
        this.displayorder = displayorder;
    }

    public String getCategoryEnName() {
        return categoryEnName;
    }

    public void setCategoryEnName(String categoryEnName) {
        this.categoryEnName = categoryEnName;
    }

    @Override
    public String toString() {
        return "GamePlatformCategory{" +
                "childCategoryId='" + childCategoryId + '\'' +
                ", gpid='" + gpid + '\'' +
                ", childGroupId='" + childGroupId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryEnName='" + categoryEnName + '\'' +
                ", image='" + image + '\'' +
                ", displayorder=" + displayorder +
                '}';
    }
}
