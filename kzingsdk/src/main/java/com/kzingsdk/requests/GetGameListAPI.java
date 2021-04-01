package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.gameplatform.GamePlatformContainer;
import com.kzingsdk.entity.gameplatform.GamePlatformCreator;
import com.kzingsdk.entity.gameplatform.GamePlatformType;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Return all GamePlatform without any sub games by default.
 * <p>
 * {@link #setRequestSubGame(boolean)} to import sub games to the GamePlatform of {@link GamePlatformType#GAME}.
 */
public class GetGameListAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.getGamePlatformList;
    }


    public GetGameListAPI() {
        super();
    }

    private boolean isRequestSubGame = false;

    private Context context;
    @Override
    public Observable<ArrayList<GamePlatformContainer>> requestRx(final Context context) {
        this.context = context;
        Observable<GamePlatformCreator> doRequestRx = super.baseExecute(context)
                .flatMap((Function<JSONObject, Observable<GamePlatformCreator>>) jsonResponse -> {
                    final GamePlatformCreator gamePlatformCreator = new GamePlatformCreator();
                    JSONArray containerJsonArray = jsonResponse.optJSONArray("response");
                    gamePlatformCreator.setContainerJsonArray(containerJsonArray);
                    SharePrefUtil.putString(context, Constant.Pref.GAMEPLATFORM, containerJsonArray.toString());
                    return Observable.just(gamePlatformCreator);
                });
        if(isRequestSubGame){
            doRequestRx = doRequestRx.flatMap(addSubGames);
        }
        return doRequestRx
                .flatMap((Function<GamePlatformCreator, Observable<ArrayList<GamePlatformContainer>>>) gamePlatformCreator -> Observable.just(gamePlatformCreator.build()))
                ;
    }

    @Override
    protected JSONObject generateParamsJson(){
        return super.generateParamsJson();
    }

    private Function<GamePlatformCreator, Observable<GamePlatformCreator>> addSubGames =
            new Function<GamePlatformCreator, Observable<GamePlatformCreator>>() {
                @Override
                public Observable<GamePlatformCreator> apply(GamePlatformCreator gamePlatformCreator) throws Exception {
                    return KzingAPI.getSubGameList()
                            .setGamePlatformContainerList(gamePlatformCreator)
                            .requestRx(context);
                }
    };

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(gamePlatformContainerList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetGameListCallBack) kzingCallBack).onSuccess(gamePlatformContainerList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetGameListAPI setRequestSubGame(boolean isRequestSubGame){
        this.isRequestSubGame = isRequestSubGame;
        return this;
    }

    public GetGameListAPI addGetGameListCallBack(GetGameListAPI.GetGameListCallBack getGetGameListCallBack){
        kzingCallBackList.add(getGetGameListCallBack);
        return this;
    }

    public interface GetGameListCallBack extends KzingCallBack{
        void onSuccess(ArrayList<GamePlatformContainer> gamePlatformContainerList);
    }

}
