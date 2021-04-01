package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.gameplatform.GamePlatformCreator;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.GzipUtil;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

class GetSubGameListAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.getSubGameList;
    }


    public GetSubGameListAPI() {
        super();
    }

    GamePlatformCreator gamePlatformCreator;

    public GetSubGameListAPI setGamePlatformContainerList(GamePlatformCreator gamePlatformCreator) {
        this.gamePlatformCreator = gamePlatformCreator;
        return this;
    }

    @Override
    protected JSONObject generateParamsJson() {
        return super.generateParamsJson();
    }

    @Override
    public Observable<GamePlatformCreator> requestRx(Context context) {
        return super.baseExecute(context)
                .flatMap((Function<JSONObject, Observable<GamePlatformCreator>>) jsonResponse -> {
                    String responseRaw = jsonResponse.optString("response");
                    String subGame = GzipUtil.decompress(responseRaw);
                    SharePrefUtil.putString(context, Constant.Pref.GAMEPLATFORMCHILD, subGame);
                    gamePlatformCreator.setSubGameJsonObject(new JSONArray(subGame));
                    return Observable.just(gamePlatformCreator);
                });
    }


    @Override
    public void request(Context context) {
        requestRx(context).subscribe(gamePlatformCreator -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSubGameListCallBack) kzingCallBack).onSuccess(gamePlatformCreator);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetSubGameListAPI addGetSubGameListCallBack(GetSubGameListCallBack getGetSubGameListCallBack) {
        kzingCallBackList.add(getGetSubGameListCallBack);
        return this;
    }

    public interface GetSubGameListCallBack extends KzingCallBack {
        void onSuccess(GamePlatformCreator gamePlatformCreator);
    }


}
