package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import io.reactivex.Observable;


public class GetBasicEncryptKeyAPI extends CoreRequest {

    GetBasicEncryptKeyAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getBasicEncryptKey;
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> jsonResponse.optString("response"));
    }

    @Override
    protected String generateEncryptedParams() {
        return "6d5222be55bc8ff9772864459a598701";
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityContent -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetBasicEncryptKeyCallBack) kzingCallBack).onSuccess(activityContent);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetBasicEncryptKeyAPI addGetBasicEncryptKeyCallBack(GetBasicEncryptKeyCallBack getBasicEncryptKeyCallBack) {
        kzingCallBackList.add(getBasicEncryptKeyCallBack);
        return this;
    }

    public interface GetBasicEncryptKeyCallBack extends KzingCallBack {
        void onSuccess(String basicRsaKey);
    }

}
