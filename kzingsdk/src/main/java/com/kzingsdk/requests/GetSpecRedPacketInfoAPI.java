package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SpecRedPacketInfo;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetSpecRedPacketInfoAPI extends CoreRequest {

    GetSpecRedPacketInfoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getSpecRedPacketInfo;
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
    public Observable<SpecRedPacketInfo> requestRx(Context context) {
        return super.baseExecute(context).map(SpecRedPacketInfo::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(specRedPacketInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSpecRedPacketInfoCallBack) kzingCallBack).onSuccess(specRedPacketInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetSpecRedPacketInfoAPI addGetSpecRedPacketInfoCallBack(GetSpecRedPacketInfoCallBack getSpecRedPacketInfoCallBack) {
        kzingCallBackList.add(getSpecRedPacketInfoCallBack);
        return this;
    }

    public interface GetSpecRedPacketInfoCallBack extends KzingCallBack {
        void onSuccess(SpecRedPacketInfo specRedPacketInfo);
    }


}
