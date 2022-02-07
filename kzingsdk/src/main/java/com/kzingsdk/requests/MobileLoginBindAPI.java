package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MemberInfo;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class MobileLoginBindAPI extends CoreRequest {

    MobileLoginBindAPI() {
        super();
    }

    private String phone;
    private String countryCode;
    private String smsCode;
    private String uid;
    private String playerName;
    private String pwd;
    private String captcha;

    @Override
    protected String getAction() {
        return Action.mobileLoginBind;
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
            jsonData.put("uid", uid);
            jsonData.put("playername", playerName);
            jsonData.put("password", pwd);
            jsonData.put("captcha", captcha);
            jsonData.put("jsessionid", getSessionId());
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<MemberInfo> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            String vcToken = jsonResponse.optString("vc", "");
            String ccToken = jsonResponse.optString("cc", "");
            SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
            SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
            setLoginTokens(vcToken, ccToken);
            return MemberInfo.newInstance(jsonResponse);
        });
    }


    @Override
    public void request(Context context) {
        requestRx(context).subscribe(memberInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((MobileLoginBindCallBack) kzingCallBack).onSuccess(memberInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public MobileLoginBindAPI addLoginCallBack(MobileLoginBindCallBack mobileLoginBindCallBack) {
        kzingCallBackList.add(mobileLoginBindCallBack);
        return this;
    }

    public interface MobileLoginBindCallBack extends KzingCallBack {
        void onSuccess(MemberInfo memberInfo);
    }

    public MobileLoginBindAPI setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public MobileLoginBindAPI setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public MobileLoginBindAPI setSmsCode(String smsCode) {
        this.smsCode = smsCode;
        return this;
    }

    public MobileLoginBindAPI setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public MobileLoginBindAPI setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public MobileLoginBindAPI setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    public MobileLoginBindAPI setCaptcha(String captcha) {
        this.captcha = captcha;
        return this;
    }


}

