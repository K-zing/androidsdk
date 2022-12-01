package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONObject;

import io.reactivex.Observable;

public class GetSendRegCodeDurationAPI extends CoreRequest {

    GetSendRegCodeDurationAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getSendRegCodeDuration;
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
    public Observable<Integer> requestRx(final Context context) {
        return super.baseExecute(context).map((result) -> result.optInt("response"));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(cooldown -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSendRegCodeDurationCallBack) kzingCallBack).onSuccess(cooldown);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetSendRegCodeDurationAPI addGetSendRegCodeDurationCallBack(GetSendRegCodeDurationCallBack getSendRegCodeDurationCallBack) {
        kzingCallBackList.add(getSendRegCodeDurationCallBack);
        return this;
    }

    public interface GetSendRegCodeDurationCallBack extends KzingCallBack {
        void onSuccess(Integer cooldown);
    }

}
