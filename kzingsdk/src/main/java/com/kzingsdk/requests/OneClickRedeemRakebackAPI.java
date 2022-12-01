package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.OneClickRedeemRakebackResult;

import org.json.JSONObject;

import io.reactivex.Observable;

public class OneClickRedeemRakebackAPI extends CoreRequest {

    OneClickRedeemRakebackAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.oneClickRedeemRakeback;
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
    public Observable<OneClickRedeemRakebackResult> requestRx(Context context) {
        return super.baseExecute(context).map(OneClickRedeemRakebackResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((OneClickRedeemRakebackCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public OneClickRedeemRakebackAPI addOneClickRedeemRakebackCallBack(OneClickRedeemRakebackAPI.OneClickRedeemRakebackCallBack activityApplyCallBack) {
        kzingCallBackList.add(activityApplyCallBack);
        return this;
    }

    public interface OneClickRedeemRakebackCallBack extends KzingCallBack {
        void onSuccess(OneClickRedeemRakebackResult result);
    }
}
