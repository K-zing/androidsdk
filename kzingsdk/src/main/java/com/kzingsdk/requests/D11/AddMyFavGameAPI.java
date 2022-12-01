package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class AddMyFavGameAPI extends BaseD11API {

    private String gpid;

    AddMyFavGameAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.addMyFavGame;
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
                    ((AddMyFavGameCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public AddMyFavGameAPI addAddMyFavGameCallBack(AddMyFavGameCallBack addMyFavGameCallBack) {
        kzingCallBackList.add(addMyFavGameCallBack);
        return this;
    }

    public AddMyFavGameAPI setGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }

    public interface AddMyFavGameCallBack extends KzingCallBack {
        void onSuccess();
    }

}
