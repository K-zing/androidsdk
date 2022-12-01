package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RegParam;

import io.reactivex.Observable;

public class RegParamAPI extends CoreRequest {


    RegParamAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.regParam;
    }

    @Override
    public Observable<RegParam> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            String sessionId = jsonResponse.optString("sessionId", "");
            setSessionId(sessionId);
            RegParam regParam = RegParam.newInstance(jsonResponse);
            return regParam;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(siteInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RegParamCallBack) kzingCallBack).onSuccess(siteInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RegParamAPI addRegParamCallBack(RegParamCallBack regParamCallBack) {
        kzingCallBackList.add(regParamCallBack);
        return this;
    }

    public interface RegParamCallBack extends KzingCallBack {
        void onSuccess(RegParam regParam);
    }

}
