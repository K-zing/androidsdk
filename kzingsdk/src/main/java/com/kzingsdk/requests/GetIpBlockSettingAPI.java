package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.IpBlockSetting;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;


public class GetIpBlockSettingAPI extends CoreRequest {

    private String appId = "";

    GetIpBlockSettingAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getIpBlockSetting;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("appId", appId);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<IpBlockSetting> requestRx(Context context) {
        return super.baseExecute(context).map(IpBlockSetting::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ipBlockSetting -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetIpBlockSettingCallBack) kzingCallBack).onSuccess(ipBlockSetting);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetIpBlockSettingAPI addGetIpBlockSettingCallBack(GetIpBlockSettingCallBack getIpBlockSettingCallBack) {
        kzingCallBackList.add(getIpBlockSettingCallBack);
        return this;
    }

    public GetIpBlockSettingAPI setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public interface GetIpBlockSettingCallBack extends KzingCallBack {
        void onSuccess(IpBlockSetting ipBlockSetting);
    }
}
