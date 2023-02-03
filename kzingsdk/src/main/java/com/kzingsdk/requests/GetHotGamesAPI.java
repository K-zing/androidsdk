package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.gameplatform.HotGame;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetHotGamesAPI extends CoreRequest implements RequireCurrency {

    private String type;
    private String currency;

    GetHotGamesAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getHotGames;
    }

    @Override
    protected Observable<String> validateParams() {
        if (type == null) {
            return Observable.just("Type is missing");
        }
        return super.validateParams();
    }


    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("type", type);
            if (currency != null)
                jsonData.put("currency", currency);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<HotGame>> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<HotGame> hotGamesList = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            if (response != null)
                for (int i = 0; i < response.length(); i++) {
                    hotGamesList.add(HotGame.newInstance(response.optJSONObject(i)));
                }
            return hotGamesList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(hotGame -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetHotGamesCallBack) kzingCallBack).onSuccess(hotGame);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetHotGamesAPI addGetHotGamesCallBack(GetHotGamesCallBack getHotGamesCallBack) {
        kzingCallBackList.add(getHotGamesCallBack);
        return this;
    }

    public GetHotGamesAPI setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    public GetHotGamesAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public interface GetHotGamesCallBack extends KzingCallBack {
        void onSuccess(ArrayList<HotGame> hotGame);
    }
}
