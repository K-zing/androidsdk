package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;


public class IplSendWhatsappAPI extends CoreRequest {

    IplSendWhatsappAPI() {
        super();
    }


    private String whatsapp = "";
    private String username = "";

    @Override
    protected String getAction() {
        return Action.iplSendWhatsapp;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("whatsapp", whatsapp);
            jsonData.put("username", username);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context).map(jsonObject -> true);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ipBlockSetting -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((IplSendWhatsappCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public IplSendWhatsappAPI addIplSendWhatsappCallBack(IplSendWhatsappCallBack iplSendWhatsappCallBack) {
        kzingCallBackList.add(iplSendWhatsappCallBack);
        return this;
    }

    public interface IplSendWhatsappCallBack extends KzingCallBack {
        void onSuccess();
    }

    public IplSendWhatsappAPI setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
        return this;
    }

    public IplSendWhatsappAPI setUsername(String username) {
        this.username = username;
        return this;
    }
}
