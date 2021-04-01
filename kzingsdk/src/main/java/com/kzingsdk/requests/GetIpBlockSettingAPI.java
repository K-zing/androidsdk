package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.IpBlockSetting;

import io.reactivex.Observable;


public class GetIpBlockSettingAPI extends CoreRequest {

    GetIpBlockSettingAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getIpBlockSetting;
    }

    @Override
    public Observable<IpBlockSetting> requestRx(Context context) {
        return super.baseExecute(context).map(IpBlockSetting::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ipBlockSetting -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetIpBlockSettingCallBack) kzingCallBack).onSuccess(ipBlockSetting);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetIpBlockSettingAPI addGetIpBlockSettingCallBack(GetIpBlockSettingCallBack getIpBlockSettingCallBack) {
        kzingCallBackList.add(getIpBlockSettingCallBack);
        return this;
    }

    public interface GetIpBlockSettingCallBack extends KzingCallBack {
        void onSuccess(IpBlockSetting ipBlockSetting);
    }

}
