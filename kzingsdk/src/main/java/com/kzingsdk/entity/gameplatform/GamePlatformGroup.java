package com.kzingsdk.entity.gameplatform;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class GamePlatformGroup {

    private GamePlatform gamePlatform ;
    private String childGroupId = "" ;
    private String childGroupName = "" ;
    private String image = "" ;
    private int displayorder = 0 ;
    private ArrayList<GamePlatformChild> childArrayList = new ArrayList<>();
    private ArrayList<GamePlatformCategory> categoryArrayList = new ArrayList<>();

    public GamePlatformGroup(){

    };

    public static GamePlatformGroup newInstance(JSONObject rootObject,GamePlatform gamePlatform) {
        HashSet<Integer> checkCatagorySet = new HashSet<>();

        GamePlatformGroup item = new GamePlatformGroup();
        item.setGamePlatform(gamePlatform);
        item.setChildGroupId(rootObject.optString("childgroupid"));
        item.setChildGroupName(rootObject.optString("childgroupname"));
        item.setDisplayorder(rootObject.optInt("displayorder"));
        item.setImage(rootObject.optString("image"));

        JSONArray childsArray = rootObject.optJSONArray("childs");
        if(childsArray!=null){
            for(int i = 0 ; i < childsArray.length() ; i++){
                GamePlatformChild child = GamePlatformChild.newInstance(childsArray.optJSONObject(i),gamePlatform);
                if(child.isEnabled()){
                    checkCatagorySet.addAll(child.getCategorysSet());
                    item.childArrayList.add(child);
                }
            }
        }
        return item;
    }

    public ArrayList<GamePlatformChild> getChildListByCategory(GamePlatformCategory gamePlatformCategory){
        ArrayList<GamePlatformChild> resultList = new ArrayList<>();
        for(GamePlatformChild child :childArrayList){
            if(child.getCategorysSet().contains( Integer.parseInt(gamePlatformCategory.getChildCategoryId()))){
                resultList.add(child);
            }
        }
        return resultList;
    }

    public GamePlatform getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(GamePlatform gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public String getChildGroupId() {
        return childGroupId;
    }

    public void setChildGroupId(String childGroupId) {
        this.childGroupId = childGroupId;
    }

    public String getChildGroupName() {
        return childGroupName;
    }

    public void setChildGroupName(String childGroupName) {
        this.childGroupName = childGroupName;
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

    public ArrayList<GamePlatformChild> getChildArrayList() {
        return childArrayList;
    }

    public void setChildArrayList(ArrayList<GamePlatformChild> childArrayList) {
        this.childArrayList = childArrayList;
    }

    public ArrayList<GamePlatformCategory> getCategoryArrayList() {
        return categoryArrayList;
    }

    public void setCategoryArrayList(ArrayList<GamePlatformCategory> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
    }

    @Override
    public String toString() {
        return "GamePlatformGroup{" +
                "childGroupId='" + childGroupId + '\'' +
                ", childGroupName='" + childGroupName + '\'' +
                ", image='" + image + '\'' +
                ", displayorder=" + displayorder +
                '}';
    }
}
