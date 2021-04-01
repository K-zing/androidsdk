package com.kzingsdk.entity.gameplatform.gameapps;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.kzingsdk.core.BaseAppGame;
import com.kzingsdk.entity.ClientInfo;
import com.kzingsdk.entity.MemberInfo;
import com.kzingsdk.entity.gameplatform.GamePlatform;
import com.kzingsdk.requests.GetActivityContentAPI;
import com.kzingsdk.requests.KzingCallBack;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public final class Ebet extends BaseAppGame {

    static final String GPID = "940256904101";

    Ebet(GamePlatform gamePlatform) {
        super( gamePlatform);
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
        String username = clientInfo.getSiteId() + "_" + memberInfo.getPlayerName();
        String url = String.format("kzing://login?u=%s&p=%s", username, getToken());
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
