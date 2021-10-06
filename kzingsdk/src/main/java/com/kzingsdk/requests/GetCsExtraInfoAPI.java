package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import io.reactivex.Observable;

public class GetCsExtraInfoAPI extends CoreRequest {

    GetCsExtraInfoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getCsExtraInfo;
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    return jsonResponse.optString("url");
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(csExtraInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCsExtraInfoCallBack) kzingCallBack).onSuccess(csExtraInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCsExtraInfoAPI addGetCsExtraInfoCallBack(GetCsExtraInfoCallBack getCsExtraInfoCallBack) {
        kzingCallBackList.add(getCsExtraInfoCallBack);
        return this;
    }

    public interface GetCsExtraInfoCallBack extends KzingCallBack {
        void onSuccess(String csExtraInfo);
    }

}
