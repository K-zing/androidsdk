package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import io.reactivex.Observable;

public class CheckPlayerRealNameAndEmailAPI extends CoreRequest {

    CheckPlayerRealNameAndEmailAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.checkPlayerRealNameAndEmail;
    }

    @Override
    public Observable<Integer> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> jsonResponse.optInt("dValue"));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(dValue -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((CheckPlayerRealNameAndEmailCallBack) kzingCallBack).onSuccess(dValue);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CheckPlayerRealNameAndEmailAPI addCheckPlayerRealNameAndEmailCallBack(CheckPlayerRealNameAndEmailCallBack checkPlayerRealNameAndEmailCallBack) {
        kzingCallBackList.add(checkPlayerRealNameAndEmailCallBack);
        return this;
    }

    public interface CheckPlayerRealNameAndEmailCallBack extends KzingCallBack {
        void onSuccess(Integer dValue);
    }

}
