package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MemberInfo;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class MobileLoginAPI extends CoreRequest {

    private String phone;
    private String countryCode;
    private String smsCode;

    MobileLoginAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.mobileLogin;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("phone", phone);
            jsonData.put("countrycode", countryCode);
            jsonData.put("smscode", smsCode);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<MemberInfo> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            JSONObject dataResponse = jsonResponse.optJSONObject("data");
            String vcToken = dataResponse.optString("vc", "");
            String ccToken = dataResponse.optString("cc", "");
            SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
            SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
            setLoginTokens(vcToken, ccToken);
            return MemberInfo.newInstance(dataResponse);
        });
    }


    @Override
    public void request(Context context) {
        requestRx(context).subscribe(memberInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((MobileLoginCallBack) kzingCallBack).onSuccess(memberInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public MobileLoginAPI addLoginCallBack(MobileLoginCallBack mobileLoginCallBack) {
        kzingCallBackList.add(mobileLoginCallBack);
        return this;
    }

    public MobileLoginAPI setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public MobileLoginAPI setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public MobileLoginAPI setSmsCode(String smsCode) {
        this.smsCode = smsCode;
        return this;
    }

    public interface MobileLoginCallBack extends KzingCallBack {
        void onSuccess(MemberInfo memberInfo);
    }


}

