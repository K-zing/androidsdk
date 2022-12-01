package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetTgLinkAPI extends CoreRequest {

    private String type;
    private String origin;

    GetTgLinkAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getTgLink;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("type", type);
            jsonData.put("origin", origin);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> jsonResponse.optString("data"));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityContent -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetTgLinkCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetTgLinkAPI addGetTgLinkCallBack(GetTgLinkCallBack getTgLinkCallBack) {
        kzingCallBackList.add(getTgLinkCallBack);
        return this;
    }

    public GetTgLinkAPI setType(String type) {
        this.type = type;
        return this;
    }

    public GetTgLinkAPI setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public interface GetTgLinkCallBack extends KzingCallBack {
        void onSuccess();
    }
}
