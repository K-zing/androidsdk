package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.gameplatform.GamePlatformContainer;
import com.kzingsdk.entity.gameplatform.GamePlatformType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetEpGamePlatformAPI extends CoreRequest {

    public static final String ALL = "10000";

    private Boolean showAll = false;
    private Boolean platformOnly = false;
    private GamePlatformType gpType = null;
    private Boolean showChild = false;

    GetEpGamePlatformAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getEpGamePlatform;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("showall", showAll ? 1 : 0);
            jsonData.put("platformonly", platformOnly ? 1 : 0);
            jsonData.put("gptype", gpType == null ? 0 : gpType.getId());
            jsonData.put("showchild", showChild ? 1 : 0);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<GamePlatformContainer>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<GamePlatformContainer> containers = new ArrayList<>();
                    JSONArray dataJSONArray = jsonResponse.optJSONArray("data");
                    if (dataJSONArray != null) {
                        for (int i = 0; i < dataJSONArray.length(); i++) {
                            containers.add(GamePlatformContainer.newInstanceFromEp(dataJSONArray.optJSONObject(i)));
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
                    ((GetEpGamePlatformCallBack) kzingCallBack).onSuccess(gamePlatformContainerList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetEpGamePlatformAPI addGetEpGamePlatformCallBack(GetEpGamePlatformCallBack getEpGamePlatformCallBack) {
        kzingCallBackList.add(getEpGamePlatformCallBack);
        return this;
    }

    public GetEpGamePlatformAPI setShowAll(Boolean showAll) {
        this.showAll = showAll;
        return this;
    }

    public GetEpGamePlatformAPI setPlatformOnly(Boolean platformOnly) {
        this.platformOnly = platformOnly;
        return this;
    }

    /**
     * @param gpType Pass null to get all
     */
    public GetEpGamePlatformAPI setGpType(GamePlatformType gpType) {
        this.gpType = gpType;
        return this;
    }

    public GetEpGamePlatformAPI setShowChild(Boolean showChild) {
        this.showChild = showChild;
        return this;
    }

    public interface GetEpGamePlatformCallBack extends KzingCallBack {
        void onSuccess(ArrayList<GamePlatformContainer> gamePlatformContainerList);
    }
}
