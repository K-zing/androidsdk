package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SocialAccountBindingStatus;

import org.json.JSONObject;

import io.reactivex.Observable;

public class SocialAccountBindingStatusAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.socialAccountBindingStatus;
    }

    SocialAccountBindingStatusAPI() {
        super();
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
    public Observable<SocialAccountBindingStatus> requestRx(final Context context) {
        return super.baseExecute(context).map(SocialAccountBindingStatus::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(socialAccountBindingStatus -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SocialAccountBindingStatusCallBack) kzingCallBack).onSuccess(socialAccountBindingStatus);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SocialAccountBindingStatusAPI addSocialAccountBindingStatusCallBack(SocialAccountBindingStatusCallBack socialAccountBindingStatusCallBack) {
        kzingCallBackList.add(socialAccountBindingStatusCallBack);
        return this;
    }

    public interface SocialAccountBindingStatusCallBack extends KzingCallBack {
        void onSuccess(SocialAccountBindingStatus socialAccountBindingStatus);
    }

}

