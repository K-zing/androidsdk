package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.requests.KzingCallBack;

import io.reactivex.Observable;

public class GetSupportTermsAPI extends CoreRequest {

    GetSupportTermsAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getSupportTerms;
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> jsonResponse.optString("data"));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(supportTerms -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSupportTermsCallBack) kzingCallBack).onSuccess(supportTerms);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetSupportTermsAPI addGetSupportTermsCallBack(GetSupportTermsCallBack getSupportTermsCallBack) {
        kzingCallBackList.add(getSupportTermsCallBack);
        return this;
    }

    public interface GetSupportTermsCallBack extends KzingCallBack {
        void onSuccess(String supportTerms);
    }

}
