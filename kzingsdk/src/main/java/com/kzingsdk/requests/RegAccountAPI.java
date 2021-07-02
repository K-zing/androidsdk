package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MemberInfo;
import com.kzingsdk.entity.RegParam;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RegAccountAPI extends CoreRequest {

    public static String NO_AGENT = "10000";

    private String loginName = "";
    private String password = "";
    private String realName = "";
    private String refCode = "10000";

    private String gender = "0";
    //optional
    private String email = "";
    private String phone = null;
    private String qq = "";
    private String weixin = "";
    private String birthdayDay = "";
    private String birthdayMonth = "";
    private String birthdayYear = "";
    private String wdpassword = "";
    private String verifycode = "";
    private String smscode = "";
    private String gpn = "";
    private String phoneCountry = "";
    private String whatsapp = "";
    private String telegram = "";
    private String zalo = "";
    private String facebook = "";
    private String utmCode = "";
    private String line = "";
    private String captchaValidate = "";


    RegAccountAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.regAccount;
    }

    @Override
    protected Observable<String> validateParams() {
        if (getSessionId() == null) {
            return Observable.just("Please request KzingAPI.getRegParam() first.");
        }
        if (loginName == null) {
            return Observable.just("Login name is missing");
        }
        if (password == null) {
            return Observable.just("Password is missing");
        }
        if (realName == null) {
            return Observable.just("Real name is missing");
        }
        if (refCode == null) {
            return Observable.just("Agent code is missing. If no agent code please don't modify it or pass RegAccountAPI.NO_AGENT");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            String passwordRSA = password;
            jsonData.put("joiname", loginName);
            jsonData.put("joinpwd", passwordRSA);
            jsonData.put("fullname", realName);
            jsonData.put("agc", refCode);
            jsonData.put("verifycode", verifycode);

            jsonData.put("gender", gender);
            jsonData.put("email", email);
            if (phone != null) {
                jsonData.put("uphone", phone);
            }
            jsonData.put("qq", qq);
            jsonData.put("weixin", weixin);
            jsonData.put("birthday", birthdayDay);
            jsonData.put("birthmonth", birthdayMonth);
            jsonData.put("birthyear", birthdayYear);
            jsonData.put("wdpassword", wdpassword);
            jsonData.put("smscode", smscode);
            jsonData.put("gpn", gpn);
            jsonData.put("uphonecountry", phoneCountry);
            jsonData.put("whatsapp", whatsapp);
            jsonData.put("telegram", telegram);
            jsonData.put("zalo", zalo);
            jsonData.put("facebook", facebook);
            jsonData.put("utmcode", utmCode);
            jsonData.put("line", line);
            jsonData.put("captchaValidate", captchaValidate);

            jsonData.put("jsessionid", getSessionId());

            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            String vcToken = jsonResponse.optString("vc", "");
            String ccToken = jsonResponse.optString("cc", "");
            SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
            SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
            setLoginTokens(vcToken, ccToken);
            return "Success";
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(string -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RegAccountCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RegAccountAPI addRegAccountCallBack(RegAccountCallBack regAccountCallBack) {
        kzingCallBackList.add(regAccountCallBack);
        return this;
    }

    public interface RegAccountCallBack extends KzingCallBack {
        void onSuccess();
    }

    /**
     * @param loginName Please check the length from {@link RegParam#getNameMin()} and {@link RegParam#getNameMax()}
     */
    public RegAccountAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public RegAccountAPI setParamPassword(String password) {
        this.password = password;
        return this;
    }

    public RegAccountAPI setParamRealName(String realName) {
        this.realName = realName;
        return this;
    }

    /**
     * @param agentCode Default is no agent, equal to{@link RegAccountAPI#NO_AGENT}
     */
    public RegAccountAPI setParamAgentCode(String agentCode) {
        this.refCode = agentCode;
        return this;
    }

    public RegAccountAPI setParamQq(String qq) {
        this.qq = qq;
        return this;
    }

    public RegAccountAPI setParamPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RegAccountAPI setParamEmail(String email) {
        this.email = email;
        return this;
    }

    public RegAccountAPI setParamBirthdayYear(Integer birthdayYear) {
        this.birthdayYear = birthdayYear + "";
        return this;
    }

    public RegAccountAPI setParamBirthdayMonth(Integer birthdayMonth) {
        this.birthdayMonth = birthdayMonth + "";
        return this;
    }

    public RegAccountAPI setParamBirthdayDay(Integer birthdayDay) {
        this.birthdayDay = birthdayDay + "";
        return this;
    }

    public RegAccountAPI setParamWithdrawPassword(String wdpassword) {
        this.wdpassword = wdpassword;
        return this;
    }

    public RegAccountAPI setParamVerifycode(String verifycode) {
        this.verifycode = verifycode;
        return this;
    }

    public RegAccountAPI setWeiXin(String weixin) {
        this.weixin = weixin;
        return this;
    }

    public RegAccountAPI setSmsCode(String smsCode) {
        this.smscode = smsCode;
        return this;
    }

    public RegAccountAPI setGpn(String gpn) {
        this.gpn = gpn;
        return this;
    }

    public RegAccountAPI setPhoneCountry(String phoneCountry) {
        this.phoneCountry = phoneCountry;
        return this;
    }

    public RegAccountAPI setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
        return this;
    }

    public RegAccountAPI setTelegram(String telegram) {
        this.telegram = telegram;
        return this;
    }

    public RegAccountAPI setZalo(String zalo) {
        this.zalo = zalo;
        return this;
    }

    public RegAccountAPI setFacebook(String facebook) {
        this.facebook = facebook;
        return this;
    }

    public RegAccountAPI setUtmCode(String utmCode) {
        this.utmCode = utmCode;
        return this;
    }

    public RegAccountAPI setLine(String line) {
        this.line = line;
        return this;
    }

    public RegAccountAPI setCaptchaValidate(String captchaValidate) {
        this.captchaValidate = captchaValidate;
        return this;
    }


}

