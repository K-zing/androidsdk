package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SecurityCodeVerificationResult;

import org.json.JSONObject;

import io.reactivex.Observable;

public class SecurityCodeVerificationAPI extends CoreRequest {

    SecurityCodeVerificationAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.securityCodeVerification;
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
    public Observable<SecurityCodeVerificationResult> requestRx(final Context context) {
        return super.baseExecute(context)
                .map(SecurityCodeVerificationResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(securityCodeVerificationResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SecurityCodeVerificationCallBack) kzingCallBack).onSuccess(securityCodeVerificationResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SecurityCodeVerificationAPI addSecurityCodeVerificationCallBack(SecurityCodeVerificationCallBack securityCodeVerificationCallBack) {
        kzingCallBackList.add(securityCodeVerificationCallBack);
        return this;
    }

    public interface SecurityCodeVerificationCallBack extends KzingCallBack {
        void onSuccess(SecurityCodeVerificationResult securityCodeVerificationResult);
    }

}

