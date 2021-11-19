package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetWithdrawCryptoListResult;

import io.reactivex.Observable;

public class GetWithdrawCryptoListAPI extends CoreRequest {

    GetWithdrawCryptoListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getWithdrawCryptoList;
    }

    @Override
    public Observable<GetWithdrawCryptoListResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetWithdrawCryptoListResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getWithdrawCryptoListResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetWithdrawCryptoListCallBack) kzingCallBack).onSuccess(getWithdrawCryptoListResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetWithdrawCryptoListAPI addGetWithdrawCryptoListCallBack(GetWithdrawCryptoListCallBack getWithdrawCryptoListCallBack) {
        kzingCallBackList.add(getWithdrawCryptoListCallBack);
        return this;
    }

    public interface GetWithdrawCryptoListCallBack extends KzingCallBack {
        void onSuccess(GetWithdrawCryptoListResult getWithdrawCryptoListResult);
    }
}

