package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Observable;

public class GetGamePlatformOrderByPlayerBetAPI extends CoreRequest {

    GetGamePlatformOrderByPlayerBetAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.gamePlatformOrderByPlayerBet;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        return super.generateParamsJson();
    }


    @Override
    public Observable<HashMap<String, Integer>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    HashMap<String, Integer> gpidOrderMap = new HashMap<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject orderObject = response.optJSONObject(i);
                        gpidOrderMap.put(orderObject.optString("gpid"), orderObject.optInt("displayorder"));
                    }
                    return gpidOrderMap;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(gpidOrderMap -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GamePlatformOrderByPlayerBetCallBack) kzingCallBack).onSuccess(gpidOrderMap);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetGamePlatformOrderByPlayerBetAPI addGamePlatformOrderByPlayerBetCallBack(GamePlatformOrderByPlayerBetCallBack gamePlatformOrderByPlayerBetCallBack) {
        kzingCallBackList.add(gamePlatformOrderByPlayerBetCallBack);
        return this;
    }

    public interface GamePlatformOrderByPlayerBetCallBack extends KzingCallBack {
        void onSuccess(HashMap<String, Integer> gpidOrderMap);
    }

}
