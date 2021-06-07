package com.kzingsdk.requests.K36;

import android.content.Context;

import com.kzingsdk.entity.K36.TransferBonusActivity;
import com.kzingsdk.requests.KzingCallBack;

import io.reactivex.Observable;

public class GetTransferBonusActivityAPI extends BaseK36API {

    GetTransferBonusActivityAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getTransferBonusActivity;
    }

    @Override
    public Observable<TransferBonusActivity> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    return TransferBonusActivity.newInstance(jsonResponse.optJSONObject("result"));
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(transferBonusActivity -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetTransferBonusActivityAPICallBack) kzingCallBack).onSuccess(transferBonusActivity);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetTransferBonusActivityAPI addGetTransferBonusActivityAPICallBack(GetTransferBonusActivityAPICallBack getTransferBonusActivityAPICallBack) {
        kzingCallBackList.add(getTransferBonusActivityAPICallBack);
        return this;
    }

    public interface GetTransferBonusActivityAPICallBack extends KzingCallBack {
        void onSuccess(TransferBonusActivity transferBonusActivity);
    }


}
