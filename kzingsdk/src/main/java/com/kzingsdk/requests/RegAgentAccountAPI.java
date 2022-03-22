package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RegParam;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RegAgentAccountAPI extends CoreRequest {

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
    private String weixin = null;
    private String whatsapp = null;
    private String telegram = null;
    private String line = null;
    private String birthdayDay = "";
    private String birthdayMonth = "";
    private String birthdayYear = "";
    private String facebook = "";
    private String verifycode = "";
    private String phoneCountry = "";
    private String wdPassword = "";
    private String captchaValidate = "";

    RegAgentAccountAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.regAgentAccount;
    }

    @Override
    protected Observable<String> validateParams() {
        if (getSessionId() == null) {
            return Observable.just("Please request KzingAPI.getRegAgentParam() first.");
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
            jsonData.put("aname", loginName);
            jsonData.put("apwd", passwordRSA);
            jsonData.put("realname", realName);
            jsonData.put("agc", refCode);
            jsonData.put("verifycode", verifycode);

            jsonData.put("gender", gender);
            jsonData.put("email", email);
            if (phone != null) {
                jsonData.put("aphone", phone);
            }
            if (weixin != null) {
                jsonData.put("weixin", weixin);
            }
            if (whatsapp != null) {
                jsonData.put("whatsapp", whatsapp);
            }
            if (telegram != null) {
                jsonData.put("telegram", telegram);
            }
            if (line != null) {
                jsonData.put("line", line);
            }
            if (wdPassword != null) {
                jsonData.put("wdpassword", wdPassword);
            }
            jsonData.put("qq", qq);
            jsonData.put("birthday", birthdayDay);
            jsonData.put("birthmonth", birthdayMonth);
            jsonData.put("birthyear", birthdayYear);
            jsonData.put("facebook", facebook);
            jsonData.put("atype", "1000");
            jsonData.put("aphonecountry", phoneCountry);
            jsonData.put("captchaValidate", captchaValidate);
//            jsonData.put("wdpassword",wdpassword);

            jsonData.put("jsessionid", getSessionId());

            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
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

    public RegAgentAccountAPI addRegAccountCallBack(RegAccountCallBack regAccountCallBack) {
        kzingCallBackList.add(regAccountCallBack);
        return this;
    }

    public interface RegAccountCallBack extends KzingCallBack {
        void onSuccess();
    }

    /**
     * @param loginName Please check the length from {@link RegParam#getNameMin()} and {@link RegParam#getNameMax()}
     */
    public RegAgentAccountAPI setParamLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public RegAgentAccountAPI setParamPassword(String password) {
        this.password = password;
        return this;
    }

    public RegAgentAccountAPI setParamRealName(String realName) {
        this.realName = realName;
        return this;
    }

    /**
     * @param agentCode Default is no agent, equal to{@link RegAgentAccountAPI#NO_AGENT}
     */
    public RegAgentAccountAPI setParamAgentCode(String agentCode) {
        this.refCode = agentCode;
        return this;
    }

    public RegAgentAccountAPI setParamQq(String qq) {
        this.qq = qq;
        return this;
    }

    public RegAgentAccountAPI setParamPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RegAgentAccountAPI setParamEmail(String email) {
        this.email = email;
        return this;
    }

    public RegAgentAccountAPI setParamBirthdayYear(Integer birthdayYear) {
        this.birthdayYear = birthdayYear + "";
        return this;
    }

    public RegAgentAccountAPI setParamBirthdayMonth(Integer birthdayMonth) {
        this.birthdayMonth = birthdayMonth + "";
        return this;
    }

    public RegAgentAccountAPI setParamBirthdayDay(Integer birthdayDay) {
        this.birthdayDay = birthdayDay + "";
        return this;
    }

//    public RegAgentAccountAPI setParamWithdrawPassword(String wdpassword) {
//        this.wdpassword = wdpassword;
//        return this;
//    }

    public RegAgentAccountAPI setParamVerifycode(String verifycode) {
        this.verifycode = verifycode;
        return this;
    }

    public RegAgentAccountAPI setParamPhoneCountry(String phoneCountry) {
        this.phoneCountry = phoneCountry;
        return this;
    }

    public RegAgentAccountAPI setWeiXin(String weixin) {
        this.weixin = weixin;
        return this;
    }

    public RegAgentAccountAPI setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
        return this;
    }

    public RegAgentAccountAPI setTelegram(String telegram) {
        this.telegram = telegram;
        return this;
    }

    public RegAgentAccountAPI setLine(String line) {
        this.line = line;
        return this;
    }
    public RegAgentAccountAPI setWdPassword(String wdPassword) {
        this.wdPassword = wdPassword;
        return this;
    }
    public RegAgentAccountAPI setCaptchaValidate(String captchaValidate) {
        this.captchaValidate = captchaValidate;
        return this;
    }
    public RegAgentAccountAPI setFacebook(String facebook) {
        this.facebook = facebook;
        return this;
    }


}

