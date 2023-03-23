package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.IsShowPlayerUploadKycResult;

import org.json.JSONObject;

import io.reactivex.Observable;

public class IsShowPlayerUploadKycAPI extends CoreRequest {

    IsShowPlayerUploadKycAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.isShowPlayerUploadKyc;
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
    public Observable<IsShowPlayerUploadKycResult> requestRx(final Context context) {
        return super.baseExecute(context).map(IsShowPlayerUploadKycResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((IsShowPlayerUploadKycCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public IsShowPlayerUploadKycAPI addIsShowPlayerUploadKycCallBack(IsShowPlayerUploadKycCallBack isShowPlayerUploadKycCallBack) {
        kzingCallBackList.add(isShowPlayerUploadKycCallBack);
        return this;
    }

    public interface IsShowPlayerUploadKycCallBack extends KzingCallBack {
        void onSuccess(IsShowPlayerUploadKycResult simpleApiResult);
    }
}

