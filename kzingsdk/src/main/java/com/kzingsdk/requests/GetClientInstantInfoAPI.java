package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ClientInstantInfo;

import io.reactivex.Observable;


public class GetClientInstantInfoAPI extends CoreRequest {
    GetClientInstantInfoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getClientInstantInfo;
    }


    @Override
    public Observable<ClientInstantInfo> requestRx(Context context) {
        return super.baseExecute(context).map(ClientInstantInfo::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(clientInstantInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSiteInfoCallBack) kzingCallBack).onSuccess(clientInstantInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetClientInstantInfoAPI addGetSiteInfoCallBack(GetClientInstantInfoAPI.GetSiteInfoCallBack getSiteInfoCallBack) {
        kzingCallBackList.add(getSiteInfoCallBack);
        return this;
    }

    public interface GetSiteInfoCallBack extends KzingCallBack {
        void onSuccess(ClientInstantInfo clientInstantInfo);
    }


}
