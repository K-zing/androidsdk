package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SendSmsResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RequestVerifyPlayerPhoneAPI extends CoreRequest {


    private String phone = null;
    private String playerPhoneCountry = null;

    RequestVerifyPlayerPhoneAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.requestVerifyPlayerPhone;
    }

    @Override
    protected Observable<String> validateParams() {
        if (phone == null) {
            return Observable.just("Phone is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("phone", phone);
            if (playerPhoneCountry != null)
                jsonData.put("playerPhoneCountry", playerPhoneCountry);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SendSmsResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SendSmsResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(sendSmsResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RequestVerifyPlayerPhoneCallBack) kzingCallBack).onSuccess(sendSmsResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RequestVerifyPlayerPhoneAPI addRequestVerifyPlayerPhoneCallBack(RequestVerifyPlayerPhoneCallBack requestVerifyPlayerPhoneCallBack) {
        kzingCallBackList.add(requestVerifyPlayerPhoneCallBack);
        return this;
    }

    public interface RequestVerifyPlayerPhoneCallBack extends KzingCallBack {
        void onSuccess(SendSmsResult sendSmsResult);
    }

    public RequestVerifyPlayerPhoneAPI setParamPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RequestVerifyPlayerPhoneAPI setParamPlayerPhoneCountry(String playerPhoneCountry) {
        this.playerPhoneCountry = playerPhoneCountry;
        return this;
    }

}
