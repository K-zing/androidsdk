package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetFeMaintenanceStatusResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetFeMaintenanceStatusAPI extends CoreRequest {
    private String module;

    GetFeMaintenanceStatusAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getFeMaintenanceStatus;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("module", module);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<GetFeMaintenanceStatusResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetFeMaintenanceStatusResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getFeMaintenanceStatusResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetFeMaintenanceStatusCallBack) kzingCallBack).onSuccess(getFeMaintenanceStatusResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetFeMaintenanceStatusAPI addGetFeMaintenanceStatusCallBack(GetFeMaintenanceStatusCallBack getFeMaintenanceStatusCallBack) {
        kzingCallBackList.add(getFeMaintenanceStatusCallBack);
        return this;
    }

    public interface GetFeMaintenanceStatusCallBack extends KzingCallBack {
        void onSuccess(GetFeMaintenanceStatusResult getFeMaintenanceStatusResult);
    }

    public GetFeMaintenanceStatusAPI setModule(String module) {
        this.module = module;
        return this;
    }
}

