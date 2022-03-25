package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.EnterGameResult;
import com.kzingsdk.entity.gameplatform.GamePlatformChild;
import com.kzingsdk.entity.gameplatform.Playable;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class EnterGameAPI extends CoreRequest {

    public EnterGameAPI() {
        super();
    }

    private boolean isDemo = false;
    private boolean isAutoTransfer = true;
    private Playable playable;
    private String userAgent;
    private Boolean requestMobile = true;
    private String option;

    @Override
    protected String getAction() {
        return Action.enterGame;
    }

    @Override
    protected Observable<String> validateParams() {
        if (playable == null) {
            return Observable.just("Playable is not set yet.");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gpid", playable.getGpid());
            if (isAutoTransfer)
                jsonData.put("gpaccountID", playable.getGpAccountId());
            jsonData.put("demo", isDemo);
            jsonData.put("useragent", userAgent);
            jsonData.put("requestMobile", requestMobile);
            if (playable instanceof GamePlatformChild) {
                GamePlatformChild gamePlatformChild = (GamePlatformChild) playable;
                jsonData.put("gameCode", gamePlatformChild.getUrlSuffix());
            }
            if (option != null) {
                jsonData.put("option", option);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<EnterGameResult> requestRx(Context context) {
        return super.baseExecute(context).map(EnterGameResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(enterGameResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((EnterGameCallBack) kzingCallBack).onSuccess(enterGameResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public EnterGameAPI addEnterGameCallBack(EnterGameCallBack enterGameCallBack) {
        kzingCallBackList.add(enterGameCallBack);
        return this;
    }

    public interface EnterGameCallBack extends KzingCallBack {
        void onSuccess(EnterGameResult enterGameResult);
    }

    public EnterGameAPI setPlayable(Playable playable) {
        this.playable = playable;
        return this;
    }

    public EnterGameAPI setIsDemo(boolean isDemo) {
        this.isDemo = isDemo;
        return this;
    }

    public EnterGameAPI setIsAutoTransfer(boolean isAutoTransfer) {
        this.isAutoTransfer = isAutoTransfer;
        return this;
    }

    public EnterGameAPI setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public EnterGameAPI setRequestMobile(Boolean requestMobile) {
        this.requestMobile = requestMobile;
        return this;
    }

    public EnterGameAPI setOption(String option) {
        this.option = option;
        return this;
    }

}
