package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class LikeGameAPI extends BaseD11API {

    private Boolean isThumb;
    private String gpid;
    LikeGameAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.likeGame;
    }

    @Override
    protected Observable<String> validateParams() {
        if (isThumb == null) {
            return Observable.just("IsThumb is missing");
        }
        if (gpid == null) {
            return Observable.just("GPID is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("thumb_count", isThumb ? 1 : 0);
            jsonData.put("game_id", gpid);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> true);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ignored -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((LikeGameCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public LikeGameAPI addLikeGameCallBack(LikeGameCallBack likeGameCallBack) {
        kzingCallBackList.add(likeGameCallBack);
        return this;
    }

    public LikeGameAPI setIsThumb(boolean isThumb) {
        this.isThumb = isThumb;
        return this;
    }

    public LikeGameAPI setGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }

    public interface LikeGameCallBack extends KzingCallBack {
        void onSuccess();
    }

}
