package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RegSendSmsResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SendWithdrawSmsAPI extends CoreRequest {

    private String smsPhoneNoCountry = null;

    SendWithdrawSmsAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected String getAction() {
        return Action.sendWithdrawSms;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("smsPhoneNoCountry", smsPhoneNoCountry);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<RegSendSmsResult> requestRx(final Context context) {
        return super.baseExecute(context).map(RegSendSmsResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(regSendSmsResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SendWithdrawSmsCallBack) kzingCallBack).onSuccess(regSendSmsResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SendWithdrawSmsAPI addSendWithdrawSmsCallBack(SendWithdrawSmsCallBack sendWithdrawSmsCallBack) {
        kzingCallBackList.add(sendWithdrawSmsCallBack);
        return this;
    }

    public interface SendWithdrawSmsCallBack extends KzingCallBack {
        void onSuccess(RegSendSmsResult regSendSmsResult);
    }

    public SendWithdrawSmsAPI setSmsPhoneNoCountry(String smsPhoneNoCountry) {
        this.smsPhoneNoCountry = smsPhoneNoCountry;
        return this;
    }


}

