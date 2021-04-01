package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RedPocketInfo;

import io.reactivex.Observable;

public class GetRedPocketInfoAPI extends CoreRequest {

    GetRedPocketInfoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getRedPocketInfo;
    }

    @Override
    public Observable<RedPocketInfo> requestRx(Context context) {
        return super.baseExecute(context)
                .map(RedPocketInfo::newInstance)
                ;
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(redPocketInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRedPocketInfoCallBack) kzingCallBack).onSuccess(redPocketInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRedPocketInfoAPI addGetRedPocketInfoCallBack(GetRedPocketInfoCallBack getRedPocketInfoCallBack) {
        kzingCallBackList.add(getRedPocketInfoCallBack);
        return this;
    }

    public interface GetRedPocketInfoCallBack extends KzingCallBack {
        void onSuccess(RedPocketInfo redPocketInfo);
    }

}
