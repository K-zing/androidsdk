package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MemberInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

import io.reactivex.Observable;

public class EditMemberInfoAPI extends CoreRequest {


    private String email = null;
    private String phone = null;
    private String qq = null;
    private String weixin = null;
    private String realname = null;
    private String birth = null;
    private String whatsapp = null;
    private String telegram = null;
    private String userPreferLanguage = null;
    private String zalo = null;
    private String facebook = null;
    private String line = null;
    private String skype = null;
    private String fullAddress = null;
    private String phoneCountry = null;
    private MemberInfo.Gender gender = null;


    EditMemberInfoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.editMemberInfo;
    }

    @Override
    protected Observable<String> validateParams() {
        if (email == null && phone == null && qq == null && weixin == null && realname == null && birth == null && gender == null &&
                whatsapp == null && telegram == null && userPreferLanguage == null && zalo == null &&
                facebook == null && line == null && skype == null && fullAddress == null && phoneCountry == null) {
            return Observable.just("You must at least edit one of the infos.");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (email != null)
                jsonData.put("email", email);
            if (phone != null)
                jsonData.put("mobile", phone);
            if (qq != null)
                jsonData.put("qq", qq);
            if (weixin != null)
                jsonData.put("weixin", weixin);
            if (realname != null)
                jsonData.put("realname", realname);
            if (birth != null)
                jsonData.put("birth", birth);
            if (gender != null)
                jsonData.put("gender", gender.ordinal());
            if (whatsapp != null)
                jsonData.put("whatsapp", whatsapp);
            if (telegram != null)
                jsonData.put("telegram", telegram);
            if (userPreferLanguage != null)
                jsonData.put("userpreferlanguage", userPreferLanguage);
            if (zalo != null)
                jsonData.put("zalo", zalo);
            if (facebook != null)
                jsonData.put("facebook", facebook);
            if (line != null)
                jsonData.put("line", line);
            if (skype != null)
                jsonData.put("skype", skype);
            if (fullAddress != null)
                jsonData.put("fulladdress", fullAddress);
            if (phoneCountry != null)
                jsonData.put("phonecountry", phoneCountry);

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
                    ((EditMemberInfoCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public EditMemberInfoAPI addEditMemberInfoCallBack(EditMemberInfoCallBack EditMemberInfoCallBack) {
        kzingCallBackList.add(EditMemberInfoCallBack);
        return this;
    }

    public interface EditMemberInfoCallBack extends KzingCallBack {
        void onSuccess();
    }


    public EditMemberInfoAPI setParamQq(String qq) {
        this.qq = qq;
        return this;
    }

    public EditMemberInfoAPI setParamPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public EditMemberInfoAPI setParamEmail(String email) {
        this.email = email;
        return this;
    }

    public EditMemberInfoAPI setParamBirth(Integer birthdayYear, Integer birthdayMonth, Integer birthdayDay) {
        this.birth = birthdayYear + "-" + String.format(Locale.ENGLISH, "%02d", birthdayMonth) + "-" + String.format(Locale.ENGLISH, "%02d", birthdayDay);
        return this;
    }

    public EditMemberInfoAPI setWeiXin(String weixin) {
        this.weixin = weixin;
        return this;
    }


    public EditMemberInfoAPI setRealName(String realname) {
        this.realname = realname;
        return this;
    }

    public EditMemberInfoAPI setGender(MemberInfo.Gender gender) {
        this.gender = gender;
        return this;
    }

    public EditMemberInfoAPI setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
        return this;
    }

    public EditMemberInfoAPI setTelegram(String telegram) {
        this.telegram = telegram;
        return this;
    }

    public EditMemberInfoAPI setUserPreferLanguage(String userPreferLanguage) {
        this.userPreferLanguage = userPreferLanguage;
        return this;
    }

    public EditMemberInfoAPI setZalo(String zalo) {
        this.zalo = zalo;
        return this;
    }

    public EditMemberInfoAPI setFacebook(String facebook) {
        this.facebook = facebook;
        return this;
    }

    public EditMemberInfoAPI setLine(String line) {
        this.line = line;
        return this;
    }

    public EditMemberInfoAPI setSkype(String skype) {
        this.skype = skype;
        return this;
    }

    public EditMemberInfoAPI setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
        return this;
    }

    public EditMemberInfoAPI setPhoneCountry(String phoneCountry) {
        this.phoneCountry = phoneCountry;
        return this;
    }
}


