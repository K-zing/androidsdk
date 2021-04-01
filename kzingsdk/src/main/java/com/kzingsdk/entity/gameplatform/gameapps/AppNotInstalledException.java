package com.kzingsdk.entity.gameplatform.gameapps;


import com.kzingsdk.core.KzingException;
import com.kzingsdk.entity.gameplatform.GamePlatform;

public class AppNotInstalledException extends KzingException {

    private GamePlatform gamePlatform;

    public AppNotInstalledException(GamePlatform gamePlatform,String message) {
        super(message);
        this.gamePlatform = gamePlatform;
    }

    public GamePlatform getGamePlatform() {
        return gamePlatform;
    }

}
