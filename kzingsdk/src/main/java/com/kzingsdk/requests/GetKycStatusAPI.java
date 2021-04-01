package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.KycStatus;

import io.reactivex.Observable;


public class GetKycStatusAPI extends CoreRequest {

    GetKycStatusAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getKycStatus;
    }

    @Override
    public Observable<KycStatus> requestRx(Context context) {
        return super.baseExecute(context).map(KycStatus::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(kycStatus -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetKycStatusCallBack) kzingCallBack).onSuccess(kycStatus);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetKycStatusAPI addGetKycStatusCallBack(GetKycStatusAPI.GetKycStatusCallBack getKycStatusCallBack) {
        kzingCallBackList.add(getKycStatusCallBack);
        return this;
    }

    public interface GetKycStatusCallBack extends KzingCallBack {
        void onSuccess(KycStatus kycStatus);
    }


}
