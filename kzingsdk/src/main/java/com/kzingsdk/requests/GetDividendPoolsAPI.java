package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.DividendPool;

import io.reactivex.Observable;

public class GetDividendPoolsAPI extends CoreRequest {

    GetDividendPoolsAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getDividendPools;
    }

    @Override
    public Observable<DividendPool> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            return DividendPool.newInstance(jsonResponse.optJSONObject("response"));
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(dividendPool -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetDividendPoolsCallBack) kzingCallBack).onSuccess(dividendPool);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetDividendPoolsAPI addGetDividendPoolsCallBack(GetDividendPoolsCallBack getDividendPoolsCallBack) {
        kzingCallBackList.add(getDividendPoolsCallBack);
        return this;
    }

    public interface GetDividendPoolsCallBack extends KzingCallBack {
        void onSuccess(DividendPool dividendPool);
    }
}

