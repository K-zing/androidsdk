package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import io.reactivex.Observable;


public class GetEmailCodeAPI extends CoreRequest {

    GetEmailCodeAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getEmailCode;
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
                    ((GetEmailCodeCallBack) kzingCallBack).onSuccess(dataRsaKey);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetEmailCodeAPI addGetEmailCodeCallBack(GetEmailCodeCallBack getEmailCodeCallBack) {
        kzingCallBackList.add(getEmailCodeCallBack);
        return this;
    }

    public interface GetEmailCodeCallBack extends KzingCallBack {
        void onSuccess(String dataRsaKey);
    }

}
