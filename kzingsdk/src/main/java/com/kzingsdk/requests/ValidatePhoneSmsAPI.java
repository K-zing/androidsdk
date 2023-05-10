package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ValidatePhoneSmsAPI extends CoreRequest {
    private String uphone;
    private String uphonecountry;
    private String validateCode;
    


    ValidatePhoneSmsAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.validatePhoneSms;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("uphone", uphone);
            jsonData.put("uphonecountry", uphonecountry);
            jsonData.put("validateCode", validateCode);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SimpleApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SimpleApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ValidatePhoneSmsCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ValidatePhoneSmsAPI addValidatePhoneSmsCallBack(ValidatePhoneSmsCallBack validatePhoneSmsCallBack) {
        kzingCallBackList.add(validatePhoneSmsCallBack);
        return this;
    }

    public interface ValidatePhoneSmsCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult result);
    }

    public String getUphone() {
        return uphone;
    }

    public ValidatePhoneSmsAPI setUphone(String uphone) {
        this.uphone = uphone;
        return this;
    }

    public String getUphonecountry() {
        return uphonecountry;
    }

    public ValidatePhoneSmsAPI setUphonecountry(String uphonecountry) {
        this.uphonecountry = uphonecountry;
        return this;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public ValidatePhoneSmsAPI setValidateCode(String validateCode) {
        this.validateCode = validateCode;
        return this;
    }
}

