package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.gameplatform.GamePlatform;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetGamePlatformByIconAPI extends CoreRequest {

    private Integer frameIcon = null;

    GetGamePlatformByIconAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getGamePlatformByIcon;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("frameIcon", frameIcon);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<GamePlatform>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<GamePlatform> containers = new ArrayList<>();
                    JSONArray dataJSONArray = jsonResponse.optJSONArray("response");
                    if (dataJSONArray != null) {
                        for (int i = 0; i < dataJSONArray.length(); i++) {
                            containers.add(GamePlatform.newInstance(dataJSONArray.optJSONObject(i)));
                        }
                    }
                    return containers;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(gamePlatformContainerList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetGamePlatformByIconCallBack) kzingCallBack).onSuccess(gamePlatformContainerList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetGamePlatformByIconAPI addGetGamePlatformByIconCallBack(GetGamePlatformByIconCallBack getGamePlatformByIconCallBack) {
        kzingCallBackList.add(getGamePlatformByIconCallBack);
        return this;
    }

    public interface GetGamePlatformByIconCallBack extends KzingCallBack {
        void onSuccess(ArrayList<GamePlatform> gamePlatformContainerList);
    }

    public GetGamePlatformByIconAPI setFrameIcon(Integer frameIcon) {
        this.frameIcon = frameIcon;
        return this;
    }
}
