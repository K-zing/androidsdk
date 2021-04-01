package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RecommendGames;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetRecommendGamesAPI extends CoreRequest {

    GetRecommendGamesAPI() {
        super();
    }

    private int limit = 10;

    @Override
    protected String getAction() {
        return Action.getRecommendGames;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("limit", limit);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<RecommendGames>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            JSONArray dataArray = jsonResponse.optJSONArray("data");
            ArrayList<RecommendGames> recommendGamesList = new ArrayList<>();
            if (dataArray != null) {
                for (int i = 0; i < dataArray.length(); i++) {
                    recommendGamesList.add(RecommendGames.newInstance(dataArray.optJSONObject(i)));
                }
            }
            return recommendGamesList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(recommendGames -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRecommendGamesCallBack) kzingCallBack).onSuccess(recommendGames);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRecommendGamesAPI addGetRecommendGamesCallBack(GetRecommendGamesCallBack getRecommendGamesCallBack) {
        kzingCallBackList.add(getRecommendGamesCallBack);
        return this;
    }

    public interface GetRecommendGamesCallBack extends KzingCallBack {
        void onSuccess(ArrayList<RecommendGames> recommendGames);
    }

    public GetRecommendGamesAPI setLimit(int limit) {
        this.limit = limit;
        return this;
    }

}

