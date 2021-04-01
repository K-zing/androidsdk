package com.kzingsdk.entity.gameplatform.gameapps;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.kzingsdk.core.BaseAppGame;
import com.kzingsdk.entity.gameplatform.GamePlatform;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import io.reactivex.Observable;

public final class AgLive extends BaseAppGame {

    static final String GPID = "38712217599873024";

    AgLive(GamePlatform gamePlatform) {
        super(gamePlatform);
    }

    @Override
    protected Observable<String> validateParams(){
        if(clientInfo == null || clientInfo.getSiteId() == null || clientInfo.getSiteId().equals("") ){
            Observable.just("ClientInfo is not set or not valid.");
        }
        if(memberInfo == null || memberInfo.getPlayerName() == null || memberInfo.getPlayerName().equals("") ){
            Observable.just("MemberInfo is not set or not valid.");
        }
        return super.validateParams();
    }

    @Override
    protected Intent processRedirectInfo(Context context) throws AppNotInstalledException{
        String acc = clientInfo.getSiteId() + "_" + memberInfo.getPlayerName();
        String pw = "jeVZ2OqD4I5oE37YJqBoZf1gLveRec+/";
        try {
            acc = URLEncoder.encode(acc, "utf-8");
            pw = URLEncoder.encode(pw, "utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        String url = String.format("aggaming://login?u=%s&p=%s&pid=B85", acc, pw);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
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
