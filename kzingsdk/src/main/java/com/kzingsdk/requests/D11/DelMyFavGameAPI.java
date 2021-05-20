package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class DelMyFavGameAPI extends BaseD11API {

    DelMyFavGameAPI() {
        super();
    }

    private String gpid;

    @Override
    protected String getD11Action() {
        return Action.delMyFavGame;
    }

    @Override
    protected Observable<String> validateParams() {
        if (gpid == null) {
            return Observable.just("GPID is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gpid", gpid);
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
                    ((DelMyFavGameCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public DelMyFavGameAPI addDelMyFavGameCallBack(DelMyFavGameCallBack delMyFavGameCallBack) {
        kzingCallBackList.add(delMyFavGameCallBack);
        return this;
    }

    public interface DelMyFavGameCallBack extends KzingCallBack {
        void onSuccess();
    }

    public DelMyFavGameAPI setGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }

}
