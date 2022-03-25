package com.kzingsdk.entity.gameplatform;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GamePlatformContainer {

    private GamePlatformType type;
    private ArrayList<GamePlatform> gamePlatformList;

    public GamePlatformContainer(GamePlatformType type) {
        this.type = type;
        gamePlatformList = new ArrayList<>();
    }

    public GamePlatformContainer(GamePlatformType type, ArrayList<GamePlatform> gamePlatformList) {
        this.type = type;
        this.gamePlatformList = (ArrayList<GamePlatform>) gamePlatformList.clone();
    }

    public static GamePlatformContainer newInstanceFromEp(JSONObject rootObject) {
        GamePlatformType type = GamePlatformType.valueOfTypeId(rootObject.optInt("gptype"));
        GamePlatformContainer item = new GamePlatformContainer(type);
        JSONArray gamePlatformArray = rootObject.optJSONArray("gp");
        if (gamePlatformArray != null) {
            for (int i = 0; i < gamePlatformArray.length(); i++) {
                GamePlatform gp = GamePlatform.newInstanceFromEp(gamePlatformArray.optJSONObject(i), type);
                item.gamePlatformList.add(gp);
            }
        }
        return item;
    }

    public GamePlatformType getType() {
        return type;
    }

    public void setType(GamePlatformType type) {
        this.type = type;
    }

    public ArrayList<GamePlatform> getGamePlatformList() {
        return gamePlatformList;
    }

    public void setGamePlatformList(ArrayList<GamePlatform> gamePlatformList) {
        this.gamePlatformList = (ArrayList<GamePlatform>) gamePlatformList.clone();
    }


    public static GamePlatform findGamePlatform(ArrayList<GamePlatformContainer> gamePlatformContainerList, String gpid) {

        for (GamePlatformContainer gpContainer : gamePlatformContainerList) {
            for (GamePlatform gpPlatform : gpContainer.getGamePlatformList()) {
                String id = gpPlatform instanceof GamePlatformCustom ? ((GamePlatformCustom) gpPlatform).getCustomgpid() : gpPlatform.getGpid();
                if (gpid.equals(id)) {
                    return gpPlatform;
                }
            }
        }
        return null;
    }


}
