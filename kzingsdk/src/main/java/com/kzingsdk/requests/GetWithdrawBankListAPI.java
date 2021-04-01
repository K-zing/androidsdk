package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.WithdrawInfo;

import io.reactivex.Observable;

public class GetWithdrawBankListAPI extends CoreRequest {

    GetWithdrawBankListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getWithdrawBankList;
    }

    @Override
    public Observable<WithdrawInfo> requestRx(final Context context) {
        return super.baseExecute(context).map(WithdrawInfo::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(withdrawInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetBankDictionaryCallBack) kzingCallBack).onSuccess(withdrawInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetWithdrawBankListAPI addGetBankDictionaryCallBack(GetBankDictionaryCallBack getBankDictionaryCallBack){
        kzingCallBackList.add(getBankDictionaryCallBack);
        return this;
    }

    public interface GetBankDictionaryCallBack extends KzingCallBack{
        void onSuccess(WithdrawInfo withdrawInfo);
    }
}

