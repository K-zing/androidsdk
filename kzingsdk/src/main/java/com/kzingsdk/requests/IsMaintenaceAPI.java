package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.IsMaintenaceResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class IsMaintenaceAPI extends CoreRequest {

    IsMaintenaceAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.isMaintenace;
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
    public Observable<IsMaintenaceResult> requestRx(final Context context) {
        return super.baseExecute(context).map(IsMaintenaceResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((IsMaintenaceCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public IsMaintenaceAPI addIsMaintenaceCallBack(IsMaintenaceCallBack isMaintenaceCallBack) {
        kzingCallBackList.add(isMaintenaceCallBack);
        return this;
    }

    public interface IsMaintenaceCallBack extends KzingCallBack {
        void onSuccess(IsMaintenaceResult simpleApiResult);
    }

}

