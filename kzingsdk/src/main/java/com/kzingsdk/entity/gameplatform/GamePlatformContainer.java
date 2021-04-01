package com.kzingsdk.entity.gameplatform;

import java.util.ArrayList;

public class GamePlatformContainer {

    private GamePlatformType type = null;
    private ArrayList<GamePlatform> gamePlatformList = new ArrayList<>();

    public GamePlatformContainer(GamePlatformType type) {
        this.type = type;
        gamePlatformList = new ArrayList<>();
    }

    public GamePlatformContainer(GamePlatformType type, ArrayList<GamePlatform> gamePlatformList) {
        this.type = type;
        this.gamePlatformList = (ArrayList<GamePlatform>) gamePlatformList.clone();
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
