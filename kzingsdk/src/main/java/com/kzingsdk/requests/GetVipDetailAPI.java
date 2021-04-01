package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.VipDetail;

import io.reactivex.Observable;


public class GetVipDetailAPI extends CoreRequest {

    GetVipDetailAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getVipDetail;
    }


    @Override
    public Observable<VipDetail> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> VipDetail.newInstance(jsonResponse.optJSONObject("response")));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(vipDetail -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetVipDetailCallBack) kzingCallBack).onSuccess(vipDetail);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetVipDetailAPI addGetVipDetailCallBack(GetVipDetailAPI.GetVipDetailCallBack getVipDetailCallBack) {
        kzingCallBackList.add(getVipDetailCallBack);
        return this;
    }

    public interface GetVipDetailCallBack extends KzingCallBack {
        void onSuccess(VipDetail vipDetail);
    }


}
