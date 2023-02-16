package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;
import com.kzingsdk.entity.VerifyPlayerPhoneResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class VerifyPlayerPhoneAPI extends CoreRequest {

    private String phone = null;
    private String phoneCountry = null;
    private String validateCode = null;
    private String type = null;


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
            if (phoneCountry != null)
                jsonData.put("phoneCountry", phoneCountry);
            if (type != null)
                jsonData.put("type", type);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<VerifyPlayerPhoneResult> requestRx(final Context context) {
        return super.baseExecute(context).map(VerifyPlayerPhoneResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(verifyPlayerPhoneResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((VerifyPlayerPhoneCallBack) kzingCallBack).onSuccess(verifyPlayerPhoneResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public VerifyPlayerPhoneAPI addVerifyPlayerPhoneCallBack(VerifyPlayerPhoneCallBack verifyPlayerPhoneCallBack) {
        kzingCallBackList.add(verifyPlayerPhoneCallBack);
        return this;
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

    public VerifyPlayerPhoneAPI setParamPhoneCountry(String phoneCountry) {
        this.phoneCountry = phoneCountry;
        return this;
    }

    public VerifyPlayerPhoneAPI setType(String type) {
        this.type = type;
        return this;
    }

    public interface VerifyPlayerPhoneCallBack extends KzingCallBack {
        void onSuccess(VerifyPlayerPhoneResult verifyPlayerPhoneResult);
    }
}
