package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.GetPhoneRecallInfoResult;
import com.kzingsdk.requests.KzingCallBack;

import io.reactivex.Observable;

public class GetPhoneRecallInfoAPI extends BaseD11API {

    GetPhoneRecallInfoAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getPhoneRecallInfo;
    }

    @Override
    public Observable<GetPhoneRecallInfoResult> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> GetPhoneRecallInfoResult.newInstance(jsonResponse.optJSONObject("data")));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getPhoneRecallInfoResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetPhoneRecallInfoCallBack) kzingCallBack).onSuccess(getPhoneRecallInfoResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetPhoneRecallInfoAPI addGetPhoneRecallInfoCallBack(GetPhoneRecallInfoCallBack getPhoneRecallInfoCallBack) {
        kzingCallBackList.add(getPhoneRecallInfoCallBack);
        return this;
    }

    public interface GetPhoneRecallInfoCallBack extends KzingCallBack {
        void onSuccess(GetPhoneRecallInfoResult getPhoneRecallInfoResult);
    }

}
