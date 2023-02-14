package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetRefereeStatusResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetRefereeStatusAPI extends CoreRequest {

    GetRefereeStatusAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getRefereeStatus;
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
    public Observable<GetRefereeStatusResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetRefereeStatusResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getRefereeStatusResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRefereeStatusCallBack) kzingCallBack).onSuccess(getRefereeStatusResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRefereeStatusAPI addGetRefereeStatusCallBack(GetRefereeStatusCallBack getRefereeStatusCallBack) {
        kzingCallBackList.add(getRefereeStatusCallBack);
        return this;
    }

    public interface GetRefereeStatusCallBack extends KzingCallBack {
        void onSuccess(GetRefereeStatusResult getRefereeStatusResult);
    }

}

