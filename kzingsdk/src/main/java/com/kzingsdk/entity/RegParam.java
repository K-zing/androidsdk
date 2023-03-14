package com.kzingsdk.entity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class RegParam {
    private Boolean regQQ;
    private Boolean regPwdConfirm;
    private Boolean regBirthday;
    private Boolean regEmail;
    private Boolean regEmailDisplay;
    private Boolean regEmailVerify;
    private Boolean regLegalAge;
    private Boolean regReferCode;
    private Boolean regReferCodeDisplay;
    private Boolean regWithdrawPwd;
    private Boolean regMarketing;
    private Boolean regPhone;
    private Boolean regPhoneDisplay;
    private Boolean regPhoneVerify;
    private Boolean regPhoneCountry;
    private Boolean regSendVoice;
    private Boolean regRealname;
    private Boolean regFacebook;
    private Boolean regTelegram;
    private Boolean regSkype;
    private Boolean regWhatsapp;
    private Boolean regWeixin;
    private Boolean regLine;
    private Boolean regZalo;
    private Boolean regFriendReferCode;
    private Boolean regFriendReferCodeDisplay;
    private Boolean isReferrerSameAgent;
    private Boolean regCaptcha;
    private Boolean regWithdrawBankCard;
    private Integer regWithdrawPwdFormat;
    private Integer regNameMin;
    private Integer regNameMax;
    private Integer regPwdFormat;
    private Integer regPwdMin;
    private Integer regPwdMax;
    private Integer dcode;
    private Bitmap verifyCode;
    private ArrayList<BankCard> bankDictList = new ArrayList<>();

    public static RegParam newInstance(JSONObject rootObject) {
        RegParam regParam = new RegParam();
        JSONObject paramObject = rootObject.optJSONObject("params");
        regParam.setRegWithdrawPwdFormat(paramObject.optInt("regWithdrawPwdFormat", 4));
        regParam.setRegNameMin(paramObject.optInt("regNameMin", 11));
        regParam.setRegNameMax(paramObject.optInt("regNameMax", 1));
        regParam.setRegPwdFormat(paramObject.optInt("regPwdFormat", 6));
        regParam.setRegPwdMin(paramObject.optInt("regPwdMin", 16));
        regParam.setRegPwdMax(paramObject.optInt("regPwdMax", 10000));
        regParam.setDcode(paramObject.optInt("dcode", 10000));

        regParam.setRegQQ(paramObject.optBoolean("regQQ", false));
        regParam.setRegPwdConfirm(paramObject.optBoolean("regPwdConfirm", false));
        regParam.setRegBirthday(paramObject.optBoolean("regBirthday", false));
        regParam.setRegEmail(paramObject.optBoolean("regEmail", false));
        regParam.setRegEmailDisplay(paramObject.optBoolean("regEmailDisplay", false));
        regParam.setRegEmailVerify(paramObject.optBoolean("regEmailVerify", false));
        regParam.setRegLegalAge(paramObject.optBoolean("regLegalAge", false));
        regParam.setRegReferCode(paramObject.optBoolean("regReferCode", false));
        regParam.setRegReferCodeDisplay(paramObject.optBoolean("regReferCodeDisplay", false));
        regParam.setRegWithdrawPwd(paramObject.optBoolean("regWithdrawPwd", false));
        regParam.setRegMarketing(paramObject.optBoolean("regMarketing", false));
        regParam.setRegPhone(paramObject.optBoolean("regPhone", false));
        regParam.setRegPhoneDisplay(paramObject.optBoolean("regPhoneDisplay", false));
        regParam.setRegPhoneVerify(paramObject.optBoolean("regPhoneVerify", false));
        regParam.setRegPhoneCountry(paramObject.optBoolean("regPhoneCountry", false));
        regParam.setRegSendVoice(paramObject.optBoolean("regSendVoice", false));
        regParam.setRegRealname(paramObject.optBoolean("regRealname", false));
        regParam.setRegFacebook(paramObject.optBoolean("regFacebook", false));
        regParam.setRegTelegram(paramObject.optBoolean("regTelegram", false));
        regParam.setRegSkype(paramObject.optBoolean("regSkype", false));
        regParam.setRegWhatsapp(paramObject.optBoolean("regWhatsapp", false));
        regParam.setRegWeixin(paramObject.optBoolean("regWeixin", false));
        regParam.setRegLine(paramObject.optBoolean("regLine", false));
        regParam.setRegZalo(paramObject.optBoolean("regZalo", false));
        regParam.setRegFriendReferCode(paramObject.optBoolean("regFriendReferCode", false));
        regParam.setRegFriendReferCodeDisplay(paramObject.optBoolean("regFriendReferCodeDisplay", false));
        regParam.setReferrerSameAgent(paramObject.optBoolean("isReferrerSameAgent", false));
        regParam.setRegCaptcha(paramObject.optBoolean("regCaptcha", false));
        regParam.setRegWithdrawBankCard(paramObject.optBoolean("regWithdrawBankCard", false));

        String image = rootObject.optString("image");
        byte[] decodedString = Base64.decode(image, Base64.DEFAULT);
        regParam.verifyCode = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        JSONArray dictArray = paramObject.optJSONArray("bankDict");
        if (dictArray!=null){
            for (int i = 0; i < dictArray.length(); i++) {
                regParam.bankDictList.add(BankCard.newInstance(dictArray.optJSONObject(i)));
            }
        }

        return regParam;
    }

    public Boolean getRegQQ() {
        return regQQ;
    }

    public void setRegQQ(Boolean regQQ) {
        this.regQQ = regQQ;
    }

    public Boolean getRegPwdConfirm() {
        return regPwdConfirm;
    }

    public void setRegPwdConfirm(Boolean regPwdConfirm) {
        this.regPwdConfirm = regPwdConfirm;
    }

    public Boolean getRegBirthday() {
        return regBirthday;
    }

    public void setRegBirthday(Boolean regBirthday) {
        this.regBirthday = regBirthday;
    }

    public Boolean getRegEmail() {
        return regEmail;
    }

    public void setRegEmail(Boolean regEmail) {
        this.regEmail = regEmail;
    }

    public Boolean getRegEmailDisplay() {
        return regEmailDisplay;
    }

    public void setRegEmailDisplay(Boolean regEmailDisplay) {
        this.regEmailDisplay = regEmailDisplay;
    }

    public Boolean getRegEmailVerify() {
        return regEmailVerify;
    }

    public void setRegEmailVerify(Boolean regEmailVerify) {
        this.regEmailVerify = regEmailVerify;
    }

    public Boolean getRegLegalAge() {
        return regLegalAge;
    }

    public void setRegLegalAge(Boolean regLegalAge) {
        this.regLegalAge = regLegalAge;
    }

    public Boolean getRegReferCode() {
        return regReferCode;
    }

    public void setRegReferCode(Boolean regReferCode) {
        this.regReferCode = regReferCode;
    }

    public Boolean getRegReferCodeDisplay() {
        return regReferCodeDisplay;
    }

    public void setRegReferCodeDisplay(Boolean regReferCodeDisplay) {
        this.regReferCodeDisplay = regReferCodeDisplay;
    }

    public Boolean getRegWithdrawPwd() {
        return regWithdrawPwd;
    }

    public void setRegWithdrawPwd(Boolean regWithdrawPwd) {
        this.regWithdrawPwd = regWithdrawPwd;
    }

    public Boolean getRegMarketing() {
        return regMarketing;
    }

    public void setRegMarketing(Boolean regMarketing) {
        this.regMarketing = regMarketing;
    }

    public Boolean getRegPhone() {
        return regPhone;
    }

    public void setRegPhone(Boolean regPhone) {
        this.regPhone = regPhone;
    }

    public Boolean getRegPhoneDisplay() {
        return regPhoneDisplay;
    }

    public void setRegPhoneDisplay(Boolean regPhoneDisplay) {
        this.regPhoneDisplay = regPhoneDisplay;
    }

    public Boolean getRegPhoneVerify() {
        return regPhoneVerify;
    }

    public void setRegPhoneVerify(Boolean regPhoneVerify) {
        this.regPhoneVerify = regPhoneVerify;
    }

    public Boolean getRegPhoneCountry() {
        return regPhoneCountry;
    }

    public void setRegPhoneCountry(Boolean regPhoneCountry) {
        this.regPhoneCountry = regPhoneCountry;
    }

    public Boolean getRegSendVoice() {
        return regSendVoice;
    }

    public void setRegSendVoice(Boolean regSendVoice) {
        this.regSendVoice = regSendVoice;
    }

    public Boolean getRegRealname() {
        return regRealname;
    }

    public void setRegRealname(Boolean regRealname) {
        this.regRealname = regRealname;
    }

    public Boolean getRegFacebook() {
        return regFacebook;
    }

    public void setRegFacebook(Boolean regFacebook) {
        this.regFacebook = regFacebook;
    }

    public Boolean getRegTelegram() {
        return regTelegram;
    }

    public void setRegTelegram(Boolean regTelegram) {
        this.regTelegram = regTelegram;
    }

    public Boolean getRegSkype() {
        return regSkype;
    }

    public void setRegSkype(Boolean regSkype) {
        this.regSkype = regSkype;
    }

    public Boolean getRegWhatsapp() {
        return regWhatsapp;
    }

    public void setRegWhatsapp(Boolean regWhatsapp) {
        this.regWhatsapp = regWhatsapp;
    }

    public Boolean getRegWeixin() {
        return regWeixin;
    }

    public void setRegWeixin(Boolean regWeixin) {
        this.regWeixin = regWeixin;
    }

    public Boolean getRegLine() {
        return regLine;
    }

    public void setRegLine(Boolean regLine) {
        this.regLine = regLine;
    }

    public Boolean getRegZalo() {
        return regZalo;
    }

    public void setRegZalo(Boolean regZalo) {
        this.regZalo = regZalo;
    }

    public Boolean getRegFriendReferCode() {
        return regFriendReferCode;
    }

    public void setRegFriendReferCode(Boolean regFriendReferCode) {
        this.regFriendReferCode = regFriendReferCode;
    }

    public Boolean getRegFriendReferCodeDisplay() {
        return regFriendReferCodeDisplay;
    }

    public void setRegFriendReferCodeDisplay(Boolean regFriendReferCodeDisplay) {
        this.regFriendReferCodeDisplay = regFriendReferCodeDisplay;
    }

    public Boolean getReferrerSameAgent() {
        return isReferrerSameAgent;
    }

    public void setReferrerSameAgent(Boolean referrerSameAgent) {
        isReferrerSameAgent = referrerSameAgent;
    }

    public Boolean getRegCaptcha() {
        return regCaptcha;
    }

    public void setRegCaptcha(Boolean regCaptcha) {
        this.regCaptcha = regCaptcha;
    }

    public Boolean getRegWithdrawBankCard() {
        return regWithdrawBankCard;
    }

    public void setRegWithdrawBankCard(Boolean regWithdrawBankCard) {
        this.regWithdrawBankCard = regWithdrawBankCard;
    }

    public Integer getRegWithdrawPwdFormat() {
        return regWithdrawPwdFormat;
    }

    public void setRegWithdrawPwdFormat(Integer regWithdrawPwdFormat) {
        this.regWithdrawPwdFormat = regWithdrawPwdFormat;
    }

    public Integer getRegNameMin() {
        return regNameMin;
    }

    public void setRegNameMin(Integer regNameMin) {
        this.regNameMin = regNameMin;
    }

    public Integer getRegNameMax() {
        return regNameMax;
    }

    public void setRegNameMax(Integer regNameMax) {
        this.regNameMax = regNameMax;
    }

    public Integer getRegPwdFormat() {
        return regPwdFormat;
    }

    public void setRegPwdFormat(Integer regPwdFormat) {
        this.regPwdFormat = regPwdFormat;
    }

    public Integer getRegPwdMin() {
        return regPwdMin;
    }

    public void setRegPwdMin(Integer regPwdMin) {
        this.regPwdMin = regPwdMin;
    }

    public Integer getRegPwdMax() {
        return regPwdMax;
    }

    public void setRegPwdMax(Integer regPwdMax) {
        this.regPwdMax = regPwdMax;
    }

    public Integer getDcode() {
        return dcode;
    }

    public void setDcode(Integer dcode) {
        this.dcode = dcode;
    }

    public Bitmap getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(Bitmap verifyCode) {
        this.verifyCode = verifyCode;
    }

    public ArrayList<BankCard> getBankDictList() {
        return bankDictList;
    }

    public void setBankDictList(ArrayList<BankCard> bankDictList) {
        this.bankDictList = bankDictList;
    }
}