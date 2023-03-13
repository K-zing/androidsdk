package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetMemberKycRecordResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetMemberKycRecordAPI extends CoreRequest {

    GetMemberKycRecordAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getMemberKycRecord;
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
    public Observable<GetMemberKycRecordResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetMemberKycRecordResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMemberKycRecordCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMemberKycRecordAPI addGetMemberKycRecordCallBack(GetMemberKycRecordCallBack getMemberKycRecordCallBack) {
        kzingCallBackList.add(getMemberKycRecordCallBack);
        return this;
    }

    public interface GetMemberKycRecordCallBack extends KzingCallBack {
        void onSuccess(GetMemberKycRecordResult simpleApiResult);
    }
}

