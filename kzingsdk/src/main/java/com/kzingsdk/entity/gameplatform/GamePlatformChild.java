package com.kzingsdk.entity.gameplatform;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;

public class GamePlatformChild implements Playable {

    private String gpChildId = "";
    private GamePlatform gamePlatform;
    private String childGroupId = "";
    private String childName = "";
    private String childEnName = "";
    private String urlSuffix = "";
    private String image = "";
    private int displayorder = 0;
    private boolean isEnabled = false;
    private HashSet<Integer> categorysSet = new HashSet<>();

    public GamePlatformChild clone() {
        GamePlatformChild gpChild = new GamePlatformChild();
        gpChild.gpChildId = gpChildId;
        gpChild.gamePlatform = gamePlatform.clone();
        gpChild.childGroupId = childGroupId;
        gpChild.childName = childName;
        gpChild.childEnName = childEnName;
        gpChild.urlSuffix = urlSuffix;
        gpChild.image = image;
        gpChild.displayorder = displayorder;
        gpChild.isEnabled = isEnabled;
        gpChild.categorysSet = (HashSet<Integer>) categorysSet.clone();
        return gpChild;
    }

    public GamePlatformChild() {

    }

    ;

    public static GamePlatformChild newInstance(JSONObject rootObject, GamePlatform gamePlatform) {
        GamePlatformChild item = new GamePlatformChild();
        item.setGpChildId(rootObject.optString("gpchildid"));
        item.setGamePlatform(gamePlatform);
        item.setChildGroupId(rootObject.optString("childgroupid"));
        item.setChildName(rootObject.optString("childname"));
        item.setChildEnName(rootObject.optString("childnameen"));
        item.urlSuffix = rootObject.optString("appurl_suffix");
        item.setDisplayorder(rootObject.optInt("displayorder"));
        item.setImage(rootObject.optString("image"));
        item.setEnabled(rootObject.optString("enable_an").equals("1"));
        JSONArray categorysArray = rootObject.optJSONArray("categories");
        if (categorysArray != null) {
            for (int i = 0; i < categorysArray.length(); i++) {
                item.categorysSet.add(categorysArray.optInt(i));
            }
        }
        return item;
    }


    @Override
    public String getGpid() {
        return gamePlatform == null ? "" : gamePlatform.getGpid();
    }

    @Override
    public String getGpAccountId() {
        return gamePlatform == null ? "" : gamePlatform.getGpAccountId();
    }

    @Override
    public String getUrl() {
        return gamePlatform == null ? "" : gamePlatform.getUrl() + urlSuffix;
    }

    public String getUrlSuffix() {
        return urlSuffix;
    }

    public void setUrlSuffix(String urlSuffix) {
        this.urlSuffix = urlSuffix;
    }

    public GamePlatform getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(GamePlatform gamePlatform) {
        this.gamePlatform = gamePlatform;
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

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getGpChildId() {
        return gpChildId;
    }

    public void setGpChildId(String gpChildId) {
        this.gpChildId = gpChildId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public HashSet<Integer> getCategorysSet() {
        return categorysSet;
    }

    public void setCategorysSet(HashSet<Integer> categorysSet) {
        this.categorysSet = categorysSet;
    }

    public String getChildGroupId() {
        return childGroupId;
    }

    public void setChildGroupId(String childGroupId) {
        this.childGroupId = childGroupId;
    }

    public String getChildEnName() {
        return childEnName;
    }

    public void setChildEnName(String childEnName) {
        this.childEnName = childEnName;
    }

    @Override
    public String toString() {
        return "GamePlatformChild{" +
                "gpChildId='" + gpChildId + '\'' +
                (gamePlatform == null ? "" : ", gpid='" + gamePlatform.getGpid() + '\'') +
                (gamePlatform == null ? "" : ", gpAccountId='" + gamePlatform.getGpAccountId() + '\'') +
                ", childGroupId='" + childGroupId + '\'' +
                ", childName='" + childName + '\'' +
                ", image='" + image + '\'' +
                ",displayorder ='" + displayorder + '\'' +
                ", playUrl='" + getUrl() + '\'' +
                '}';
    }

}
