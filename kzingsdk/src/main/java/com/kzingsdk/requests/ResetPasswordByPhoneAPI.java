package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ResetPasswordByPhoneAPI extends CoreRequest {


    private String validateCode = null;
    private String loginName = null;
    private String password = null;
    private String phone = null;

    ResetPasswordByPhoneAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.resetPasswordByPhone;
    }

    @Override
    protected Observable<String> validateParams() {
        if (loginName == null) {
            return Observable.just("Login name is missing");
        }
        if (password == null) {
            return Observable.just("Password is missing");
        }
        if (phone == null) {
            return Observable.just("Phone is missing");
        }
        if (validateCode == null) {
            return Observable.just("Verify code is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("validateCode", validateCode);
            jsonData.put("name", loginName);
            jsonData.put("password", password);
            jsonData.put("phone", phone);
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
                    ((ResetPasswordByPhoneCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ResetPasswordByPhoneAPI addResetPasswordPhoneCallBack(ResetPasswordByPhoneCallBack resetPasswordByPhoneCallBack) {
        kzingCallBackList.add(resetPasswordByPhoneCallBack);
        return this;
    }

    public interface ResetPasswordByPhoneCallBack extends KzingCallBack {
        void onSuccess(Boolean success);
    }

    public ResetPasswordByPhoneAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public ResetPasswordByPhoneAPI setParamPassword(String password) {
        this.password = password;
        return this;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public ResetPasswordByPhoneAPI setParamValidateCode(String validateCode) {
        this.validateCode = validateCode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ResetPasswordByPhoneAPI setParamPhone(String phone) {
        this.phone = phone;
        return this;
    }

}
