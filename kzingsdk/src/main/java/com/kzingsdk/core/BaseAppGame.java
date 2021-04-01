package com.kzingsdk.core;

import android.content.Context;
import android.content.Intent;

import com.kzingsdk.entity.ClientInfo;
import com.kzingsdk.entity.MemberInfo;
import com.kzingsdk.entity.gameplatform.GamePlatform;
import com.kzingsdk.entity.gameplatform.gameapps.AppNotInstalledException;
import com.kzingsdk.entity.gameplatform.gameapps.FromAppLinkApi;
import com.kzingsdk.requests.KzingAPI;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseAppGame {

    private GamePlatform gamePlatform;
    protected ArrayList<GameAppCallBack> gameAppCallBackList = new ArrayList<>();

    protected ClientInfo clientInfo;
    protected MemberInfo memberInfo;



    protected BaseAppGame(GamePlatform gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public GamePlatform getGamePlatform() {
        return gamePlatform;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }


    protected Observable<String> validateParams() {
        if (getToken() == null || getToken().isEmpty()) {
            Observable.just("Need login to play games.");
        }
        return Observable.just("");
    }

    ;

    public Observable<Intent> launchAppRx(Context context) {
        return baseExecute(context);
    }

    public void launchApp(Context context) {
        launchAppRx(context).subscribe(intent -> {
            if (gameAppCallBackList.size() > 0) {
                for (GameAppCallBack kzingCallBack : gameAppCallBackList) {
                    kzingCallBack.onSuccess(intent);
                }
            }
        }, defaultOnErrorConsumer);
    }

    protected abstract Intent processRedirectInfo(Context context) throws AppNotInstalledException;

    protected String getToken() {
        return KzingSDK.getInstance().getVcToken();
    }


    protected Observable<Intent> baseExecute(final Context context) {
        final Consumer<String> checkParams = failMsg -> {
            if (!failMsg.equals(""))
                throw new KzingException(failMsg);
        };

        final Function<String, Observable<Intent>> getIntent = msg -> {
            if (BaseAppGame.this instanceof FromAppLinkApi) {
                return KzingAPI.appLinkInfo()
                        .setParamGpid(getGamePlatform().getGpid())
                        .requestRx(context)
                        .flatMap((Function<JSONObject, Observable<Intent>>) jsonResponse -> {
                            ((FromAppLinkApi) BaseAppGame.this).setUsername(jsonResponse.optString("username"));
                            ((FromAppLinkApi) BaseAppGame.this).setPassword(jsonResponse.optString("pwd"));
                            return Observable.just(BaseAppGame.this.processRedirectInfo(context));
                        });
            } else {
                return Observable.just(processRedirectInfo(context));
            }
        };
        return validateParams()
                .doOnNext(checkParams)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(getIntent)
                ;
    }

    ;


    public interface GameAppCallBack extends KzingCallBack {
        void onSuccess(Intent intent);
    }

    public void clearCallBackList() {
        gameAppCallBackList = new ArrayList<>();
    }

    public BaseAppGame addGameAppCallBack(GameAppCallBack gameAppCallBack) {
        gameAppCallBackList.add(gameAppCallBack);
        return this;
    }

    protected final Consumer<Throwable> defaultOnErrorConsumer = throwable -> {
        if (gameAppCallBackList.size() > 0) {
            for (GameAppCallBack kzingCallBack : gameAppCallBackList) {
                if (throwable instanceof AppNotInstalledException) {
                    kzingCallBack.onFailure((AppNotInstalledException) throwable);
                } else {
                    kzingCallBack.onFailure(new KzingException(throwable.toString()));
                }
            }
        }
    };

}
