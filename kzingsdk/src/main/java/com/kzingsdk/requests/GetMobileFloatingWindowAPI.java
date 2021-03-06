package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MobileFloatingWindow;

import org.json.JSONObject;

import io.reactivex.Observable;

public class GetMobileFloatingWindowAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.getMobileFloatingWindow;
    }

    GetMobileFloatingWindowAPI() {
        super();
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
    public Observable<MobileFloatingWindow> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            return MobileFloatingWindow.newInstance(jsonResponse.optJSONObject("data"));
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getMobileFloatingWindowList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMobileFloatingWindowCallBack) kzingCallBack).onSuccess(getMobileFloatingWindowList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMobileFloatingWindowAPI addGetMobileFloatingWindowCallBack(GetMobileFloatingWindowCallBack getMobileFloatingWindowCallBack) {
        kzingCallBackList.add(getMobileFloatingWindowCallBack);
        return this;
    }

    public interface GetMobileFloatingWindowCallBack extends KzingCallBack {
        void onSuccess(MobileFloatingWindow mobileFloatingWindow);
    }
}

