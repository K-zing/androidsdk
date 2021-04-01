package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ClientInfo;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import io.reactivex.Observable;


public class GetClientInfoAPI extends CoreRequest {
    GetClientInfoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getClientInfo;
    }


    @Override
    public Observable<ClientInfo> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            SharePrefUtil.putString(context, Constant.Pref.USE_BETTER_URL, jsonResponse.optString("use_better_url"));
            return ClientInfo.newInstance(jsonResponse);
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(clientInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSiteInfoCallBack) kzingCallBack).onSuccess(clientInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetClientInfoAPI addGetSiteInfoCallBack(GetClientInfoAPI.GetSiteInfoCallBack getSiteInfoCallBack){
        kzingCallBackList.add(getSiteInfoCallBack);
        return this;
    }

    public interface GetSiteInfoCallBack extends KzingCallBack{
        void onSuccess(ClientInfo clientInfo);
    }


}
