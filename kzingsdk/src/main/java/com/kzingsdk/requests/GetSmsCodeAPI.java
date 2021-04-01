package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import io.reactivex.Observable;


public class GetSmsCodeAPI extends CoreRequest {

    GetSmsCodeAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getSmsCode;
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> jsonResponse.optString("response"));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(dataRsaKey -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSmsCodeCallBack) kzingCallBack).onSuccess(dataRsaKey);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetSmsCodeAPI addGetSmsCodeCallBack(GetSmsCodeCallBack getSmsCodeCallBack) {
        kzingCallBackList.add(getSmsCodeCallBack);
        return this;
    }

    public interface GetSmsCodeCallBack extends KzingCallBack {
        void onSuccess(String dataRsaKey);
    }

}
