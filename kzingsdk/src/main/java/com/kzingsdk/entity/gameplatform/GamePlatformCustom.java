package com.kzingsdk.entity.gameplatform;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * GamePlatfrom fall into GamePlatformCustom is something not a real GamePlatform. Which is a self-define group of games like "Fishing" is including many difference fishing games from difference GamePlatfrom.
 */
public class GamePlatformCustom extends GamePlatform{

    private String customgpid = "" ;
    private String customgpname = "" ;
    private String customgpename = "" ;
    private String banner = "" ;
    private boolean isBig = false ;
    private ArrayList<Playable> playableArrayList = new ArrayList<>();


    public GamePlatformCustom(){

    };

    public static GamePlatformCustom newInstance(JSONObject rootObject) {
        GamePlatformCustom item = new GamePlatformCustom();
        item.setCustomgpid(rootObject.optString("gpid"));
        item.setCustomgpname(rootObject.optString("gpnameCN"));
        item.setCustomgpename(rootObject.optString("gpnameEN"));
        item.setDisplayorder(rootObject.optInt("displayorder"));
        item.setImage(rootObject.optString("image_an"));

        item.setBig(rootObject.optInt("is_big_game") == 1);
        item.setBanner(rootObject.optString("banner"));

        int statusFlag = rootObject.optInt("enable_an_app", 0) << 1 | rootObject.optInt("enable_an_h5", 0);
        item.setPlayStatus(PlayStatus.getPlayStatus(statusFlag));

        JSONArray groupsArray = rootObject.optJSONArray("childs");
        if(groupsArray!=null){
            for(int i = 0 ; i < groupsArray.length() ; i++){
                GamePlatform gp = GamePlatform.newInstance(groupsArray.optJSONObject(i),true);
                if(gp.getChildArrayList().size()>0 && gp.getChildArrayList().get(0).isEnabled()){
                    item.playableArrayList.add(gp);
                }else if( gp.getChildArrayList().size()==0 &&
                        (gp.getPlayStatus().contains(PlayStatus.ENABLE_APP) || gp.getPlayStatus().contains(PlayStatus.ENABLE_H5)
                        ) ){
                    item.playableArrayList.add(gp);
                }
            }
        }

        return item;
    }

    public String getCustomgpid() {
        return customgpid;
    }

    public void setCustomgpid(String customgpid) {
        this.customgpid = customgpid;
    }

    public String getCustomgpname() {
        return customgpname;
    }

    public void setCustomgpname(String customgpname) {
        this.customgpname = customgpname;
    }

    public String getCustomgpename() {
        return customgpename;
    }

    public void setCustomgpename(String customgpename) {
        this.customgpename = customgpename;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public boolean isBig() {
        return isBig;
    }

    public void setBig(boolean big) {
        isBig = big;
    }

    public ArrayList<Playable> getPlayableArrayList() {
        return playableArrayList;
    }

    public void setPlayableArrayList(ArrayList<Playable> childArrayList) {
        this.playableArrayList = childArrayList;
    }

    @Override
    public String toString() {
        return "GamePlatformCustom{" +
                "customgpid='" + customgpid + '\'' +
                ", customgpname='" + customgpname + '\'' +
                ", customgpename='" + customgpename + '\'' +
                ", banner='" + banner + '\'' +
                ", isBig=" + isBig +
                ", playableArrayList=" + playableArrayList +
                ", displayorder=" + displayorder +
                ", image='" + image + '\'' +
                ", statusCode=" + getStatusCode() +
                '}';
    }
}
