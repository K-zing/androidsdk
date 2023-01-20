package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.VipSettingV2;

import org.json.JSONObject;

import io.reactivex.Observable;

public class GetVipSettingsV2API extends CoreRequest {

    public GetVipSettingsV2API() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getVipSettingsV2;
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
    public Observable<VipSettingV2> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> VipSettingV2.newInstance(jsonResponse.optJSONObject("response")));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(vipSettingV2 -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetVipSettingsV2CallBack) kzingCallBack).onSuccess(vipSettingV2);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetVipSettingsV2API addGetVipSettingsV2CallBack(GetVipSettingsV2API.GetVipSettingsV2CallBack GetVipSettingsV2CallBack) {
        kzingCallBackList.add(GetVipSettingsV2CallBack);
        return this;
    }

    public interface GetVipSettingsV2CallBack extends KzingCallBack {
        void onSuccess(VipSettingV2 vipSettingV2);
    }


}
