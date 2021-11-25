package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class VerifyPlayerPhoneAPI extends CoreRequest {

    private String phone = null;
    private String playerPhoneCountry = null;
    private String validateCode = null;

    VerifyPlayerPhoneAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.verifyPlayerPhone;
    }

    @Override
    protected Observable<String> validateParams() {
        if (phone == null) {
            return Observable.just("Phone is missing");
        }
        if (validateCode == null) {
            return Observable.just("Validate Code is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("phone", phone);
            jsonData.put("validateCode", validateCode);
            if (playerPhoneCountry != null)
                jsonData.put("playerPhoneCountry", playerPhoneCountry);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<Boolean> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> true);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(success -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((VerifyPlayerPhoneCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public VerifyPlayerPhoneAPI addVerifyPlayerPhoneCallBack(VerifyPlayerPhoneCallBack verifyPlayerPhoneCallBack) {
        kzingCallBackList.add(verifyPlayerPhoneCallBack);
        return this;
    }

    public interface VerifyPlayerPhoneCallBack extends KzingCallBack {
        void onSuccess(Boolean success);
    }

    public VerifyPlayerPhoneAPI setParamPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public VerifyPlayerPhoneAPI setParamValidateCode(String validateCode) {
        this.validateCode = validateCode;
        return this;
    }

    public VerifyPlayerPhoneAPI setParamPlayerPhoneCountry(String playerPhoneCountry) {
        this.playerPhoneCountry = playerPhoneCountry;
        return this;
    }

}
