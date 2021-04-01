package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.IplMatchesData;

import org.json.JSONObject;

import io.reactivex.Observable;

public class GetIplMatchesDataAPI extends CoreRequest {

    GetIplMatchesDataAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getIplMatchesData;
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
    public Observable<IplMatchesData> requestRx(final Context context) {
        return super.baseExecute(context).map(IplMatchesData::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(iplMatchesData -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetIplMatchesDataCallBack) kzingCallBack).onSuccess(iplMatchesData);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetIplMatchesDataAPI addGetIplMatchesDataCallBack(GetIplMatchesDataCallBack getIplMatchesDataCallBack) {
        kzingCallBackList.add(getIplMatchesDataCallBack);
        return this;
    }

    public interface GetIplMatchesDataCallBack extends KzingCallBack {
        void onSuccess(IplMatchesData iplMatchesData);
    }
}

