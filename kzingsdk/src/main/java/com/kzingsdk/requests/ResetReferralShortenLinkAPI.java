package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ResetReferralShortenLinkResult;

import org.json.JSONObject;

import io.reactivex.Observable;

public class ResetReferralShortenLinkAPI extends CoreRequest {

    ResetReferralShortenLinkAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.resetReferralShortenLink;
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
    public Observable<ResetReferralShortenLinkResult> requestRx(final Context context) {
        return super.baseExecute(context).map(ResetReferralShortenLinkResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ResetReferralShortenLinkResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ResetReferralShortenLinkCallBack) kzingCallBack).onSuccess(ResetReferralShortenLinkResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ResetReferralShortenLinkAPI addResetReferralShortenLinkCallBack(ResetReferralShortenLinkCallBack resetReferralShortenLinkCallBack) {
        kzingCallBackList.add(resetReferralShortenLinkCallBack);
        return this;
    }

    public interface ResetReferralShortenLinkCallBack extends KzingCallBack {
        void onSuccess(ResetReferralShortenLinkResult ResetReferralShortenLinkResult);
    }

}

