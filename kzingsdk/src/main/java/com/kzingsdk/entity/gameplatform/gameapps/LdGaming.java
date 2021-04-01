package com.kzingsdk.entity.gameplatform.gameapps;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.kzingsdk.core.BaseAppGame;
import com.kzingsdk.entity.gameplatform.GamePlatform;

import java.util.List;

import io.reactivex.Observable;

public final class LdGaming extends BaseAppGame implements FromAppLinkApi {

    static final String GPID = "952038801201";
    private String username, password;
    private final String PACKAGE = "air.com.gaming.lt";
    private final String APP_ID = "air.com.gaming.lt.AppEntry";

    LdGaming(GamePlatform gamePlatform) {
        super(gamePlatform);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected Intent processRedirectInfo(Context context) throws AppNotInstalledException{
        Intent intent = new Intent();
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setAction(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String url = String.format("name=%s&psd=%s", username, password);
        intent.setData(Uri.parse(url));
        intent.setClassName(PACKAGE, APP_ID);
        PackageManager packageManager = context.getPackageManager();
        List activities = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            return intent;
        } else {
            throw new AppNotInstalledException(getGamePlatform(),"App not installed.");
        }
    }
}
