package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MobilePopup;

import org.json.JSONObject;

import io.reactivex.Observable;

public class GetNewMobilePopupAPI extends CoreRequest {

    GetNewMobilePopupAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getNewMobilePopup;
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
    public Observable<MobilePopup> requestRx(Context context) {
        return super.baseExecute(context).map(MobilePopup::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(mobilePopup -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetNewMobilePopupCallBack) kzingCallBack).onSuccess(mobilePopup);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetNewMobilePopupAPI addGetNewMobilePopupCallBack(GetNewMobilePopupCallBack getNewMobilePopupCallBack) {
        kzingCallBackList.add(getNewMobilePopupCallBack);
        return this;
    }

    public interface GetNewMobilePopupCallBack extends KzingCallBack {
        void onSuccess(MobilePopup mobilePopup);
    }


}
