package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.PlatformMaintenanceApiResult;

import org.json.JSONObject;

import io.reactivex.Observable;

public class PlatformMaintenanceAPI extends CoreRequest {

    PlatformMaintenanceAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.platformMaintenance;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        return super.generateParamsJson();
    }

    @Override
    public Observable<PlatformMaintenanceApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(PlatformMaintenanceApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((PlatformMaintenanceCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public PlatformMaintenanceAPI addPlatformMaintenanceCallBack(PlatformMaintenanceCallBack platformMaintenanceCallBack) {
        kzingCallBackList.add(platformMaintenanceCallBack);
        return this;
    }

    public interface PlatformMaintenanceCallBack extends KzingCallBack {
        void onSuccess(PlatformMaintenanceApiResult result);
    }

}

