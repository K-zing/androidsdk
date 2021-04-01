package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RegAgentParam;

import io.reactivex.Observable;

public class RegAgentParamAPI extends CoreRequest {


    RegAgentParamAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.regAgentParam;
    }

    @Override
    public Observable<RegAgentParam> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            String sessionId = jsonResponse.optString("sessionid", "");
            setSessionId(sessionId);
            return RegAgentParam.newInstance(jsonResponse);
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(siteInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RegAgentParamCallBack) kzingCallBack).onSuccess(siteInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RegAgentParamAPI addRegAgentParamCallBack(RegAgentParamCallBack regAgentParamCallBack) {
        kzingCallBackList.add(regAgentParamCallBack);
        return this;
    }

    public interface RegAgentParamCallBack extends KzingCallBack {
        void onSuccess(RegAgentParam regAgentParam);
    }

}
