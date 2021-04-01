package com.kzingsdk.entity.gameplatform.gameapps;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.kzingsdk.core.BaseAppGame;
import com.kzingsdk.entity.gameplatform.GamePlatform;

import io.reactivex.Observable;

public final class AllBet extends BaseAppGame implements FromAppLinkApi {

    static final String GPID = "9283948292830";
    private String username, password;

    private static final String SESSION_ID = "sessionId";
    private static final String ACCESS_TOKEN = "token";
    private static final String LANGUAGE = "language";
    private static final String LANGUAGE_CODE = "zh-Hans";
    private static final String ALLBET_PACAKGE_NAME = "com.bp.allbet.phone";

    AllBet(GamePlatform gamePlatform) {
        super( gamePlatform);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected Intent processRedirectInfo(Context context) throws AppNotInstalledException{
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(ALLBET_PACAKGE_NAME);
        boolean isIntentSafe = intent != null;
        if (isIntentSafe) {
            Bundle extras = new Bundle();
            extras.putString(SESSION_ID, username);
            extras.putString(ACCESS_TOKEN, password);
            extras.putString(LANGUAGE, LANGUAGE_CODE);
            intent.putExtras(extras);
            context.startActivity(intent);
            return intent;
        } else {
            throw new AppNotInstalledException(getGamePlatform(),"App not installed.");
        }
    }
}
