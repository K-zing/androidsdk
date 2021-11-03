package com.kzingsdk.entity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import org.json.JSONObject;


public class RegParam {

    private boolean regBirthday, regQQ, reqPhone, regEmail, withdrawPassword, regWeixin,
            reqReferCode, regRealName, regMobileVerify, regPwdConfirm, regLegalAge, isHighLevelPass, reqPhoneCountry,
            reqDisplayReferCode, hasFriendPromo, regWhatsapp, regTelegram, regFacebook, regZalo, regLine, mustFillReferral,
            regEmailDisplay, reqPhoneDisplay, regSkype;
    private int nameMin = 4, nameMax = 11;
    private int passwordMin = 6, passwordMax = 16;
    private String defaultAgentCode, withdrawPasswordFormat;
    private Bitmap verifyCode;

    public static RegParam newInstance(JSONObject rootObject) {
        RegParam regParam = new RegParam();
        JSONObject paramObject = rootObject.optJSONObject("params");
        regParam.setNameMin(paramObject.optInt("regnamemin", 4));
        regParam.setNameMax(paramObject.optInt("regnamemax", 11));
        regParam.setPasswordMin(paramObject.optInt("regpwmin", 6));
        regParam.setPasswordMax(paramObject.optInt("regpwmax", 16));
        regParam.setRegBirthday(paramObject.optString("regbirthday").equalsIgnoreCase("ON"));
        regParam.setRegEmail(paramObject.optString("regemail").equalsIgnoreCase("ON"));
        regParam.setRegQQ(paramObject.optString("regqq").equalsIgnoreCase("ON"));
        regParam.setReqPhone(paramObject.optString("reqphone").equalsIgnoreCase("ON"));
        regParam.setWithdrawPassword(paramObject.optString("withdrawpassword").equalsIgnoreCase("ON"));
        regParam.setRegWeixin(paramObject.optString("regweixin").equalsIgnoreCase("ON"));
        regParam.setReqReferCode(paramObject.optString("reqrefercode").equalsIgnoreCase("ON"));
        regParam.setRegRealName(paramObject.optString("regrealname").equalsIgnoreCase("ON"));
        regParam.setRegMobileVerify(paramObject.optString("registermobileverify").equalsIgnoreCase("ON"));
        regParam.setRegPwdConfirm(paramObject.optString("regPwdConfirm").equalsIgnoreCase("ON"));
        regParam.setRegLegalAge(paramObject.optString("regLegalAge").equalsIgnoreCase("ON"));
        regParam.setHighLevelPass(paramObject.optString("highLevelPass").equalsIgnoreCase("ON"));
        regParam.setReqDisplayReferCode(paramObject.optString("reqdisplayrefercode").equalsIgnoreCase("ON"));
        regParam.setReqPhoneCountry(paramObject.optString("reqphonecountry").equalsIgnoreCase("ON"));
        regParam.setRegWhatsapp(paramObject.optString("regwhatsapp").equalsIgnoreCase("ON"));
        regParam.setRegTelegram(paramObject.optString("regtelegram").equalsIgnoreCase("ON"));
        regParam.setRegFacebook(paramObject.optString("regfacebook").equalsIgnoreCase("ON"));
        regParam.setRegZalo(paramObject.optString("regzalo").equalsIgnoreCase("ON"));
        regParam.setRegLine(paramObject.optString("regline").equalsIgnoreCase("ON"));
        regParam.setRegEmailDisplay(paramObject.optString("regemaildisplay").equalsIgnoreCase("ON"));
        regParam.setReqPhoneDisplay(paramObject.optString("reqphonedisplay").equalsIgnoreCase("ON"));
        regParam.setRegSkype(paramObject.optString("regskype").equalsIgnoreCase("ON"));

        regParam.setWithdrawPasswordFormat(paramObject.optString("withdrawpasswordformat"));

        regParam.setHasFriendPromo(paramObject.optBoolean("hasFriendPromo", false));
        regParam.setMustFillReferral(paramObject.optBoolean("mustfillrefferal", false));

        String image = rootObject.optString("image");
        byte[] decodedString = Base64.decode(image, Base64.DEFAULT);
        regParam.verifyCode = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return regParam;
    }

    public int getNameMin() {
        return nameMin;
    }

    public void setNameMin(int nameMin) {
        this.nameMin = nameMin;
    }

    public int getNameMax() {
        return nameMax;
    }

    public void setNameMax(int nameMax) {
        this.nameMax = nameMax;
    }

    public int getPasswordMin() {
        return passwordMin;
    }

    public void setPasswordMin(int passwordMin) {
        this.passwordMin = passwordMin;
    }

    public int getPasswordMax() {
        return passwordMax;
    }

    public void setPasswordMax(int passwordMax) {
        this.passwordMax = passwordMax;
    }

    public boolean isRegBirthday() {
        return regBirthday;
    }

    public void setRegBirthday(boolean regBirthday) {
        this.regBirthday = regBirthday;
    }

    public boolean isRegQQ() {
        return regQQ;
    }

    public void setRegQQ(boolean regQQ) {
        this.regQQ = regQQ;
    }

    public boolean isReqPhone() {
        return reqPhone;
    }

    public void setReqPhone(boolean reqPhone) {
        this.reqPhone = reqPhone;
    }

    public boolean isRegEmail() {
        return regEmail;
    }

    public void setRegEmail(boolean regEmail) {
        this.regEmail = regEmail;
    }

    public boolean isWithdrawPassword() {
        return withdrawPassword;
    }

    public void setWithdrawPassword(boolean withdrawPassword) {
        this.withdrawPassword = withdrawPassword;
    }

    public String getDefaultAgentCode() {
        return defaultAgentCode;
    }

    public void setDefaultAgentCode(String defaultAgentCode) {
        this.defaultAgentCode = defaultAgentCode;
    }

    public Bitmap getVerifyCodeBitmap() {
        return verifyCode;
    }

    public void setVerifyCode(Bitmap verifyCode) {
        this.verifyCode = verifyCode;
    }

    public boolean isRegWeixin() {
        return regWeixin;
    }

    public void setRegWeixin(boolean regWeixin) {
        this.regWeixin = regWeixin;
    }

    public boolean isReqReferCode() {
        return reqReferCode;
    }

    public void setReqReferCode(boolean reqReferCode) {
        this.reqReferCode = reqReferCode;
    }

    public boolean isRegRealName() {
        return regRealName;
    }

    public void setRegRealName(boolean regRealName) {
        this.regRealName = regRealName;
    }

    public boolean isRegMobileVerify() {
        return regMobileVerify;
    }

    public void setRegMobileVerify(boolean regMobileVerify) {
        this.regMobileVerify = regMobileVerify;
    }

    public boolean isRegPwdConfirm() {
        return regPwdConfirm;
    }

    public void setRegPwdConfirm(boolean regPwdConfirm) {
        this.regPwdConfirm = regPwdConfirm;
    }

    public boolean isRegLegalAge() {
        return regLegalAge;
    }

    public void setRegLegalAge(boolean regLegalAge) {
        this.regLegalAge = regLegalAge;
    }

    public boolean isHighLevelPass() {
        return isHighLevelPass;
    }

    public void setHighLevelPass(boolean isHighLevelPass) {
        this.isHighLevelPass = isHighLevelPass;
    }

    public boolean isReqPhoneCountry() {
        return reqPhoneCountry;
    }

    public void setReqPhoneCountry(boolean reqPhoneCountry) {
        this.reqPhoneCountry = reqPhoneCountry;
    }

    public boolean hasFriendPromo() {
        return hasFriendPromo;
    }

    public void setHasFriendPromo(boolean hasFriendPromo) {
        this.hasFriendPromo = hasFriendPromo;
    }

    public boolean isRegWhatsapp() {
        return regWhatsapp;
    }

    public void setRegWhatsapp(boolean regWhatsapp) {
        this.regWhatsapp = regWhatsapp;
    }

    public boolean isRegTelegram() {
        return regTelegram;
    }

    public void setRegTelegram(boolean regTelegram) {
        this.regTelegram = regTelegram;
    }

    public boolean isRegFacebook() {
        return regFacebook;
    }

    public void setRegFacebook(boolean regFacebook) {
        this.regFacebook = regFacebook;
    }

    public boolean isRegZalo() {
        return regZalo;
    }

    public void setRegZalo(boolean regZalo) {
        this.regZalo = regZalo;
    }

    public boolean isReqDisplayReferCode() {
        return reqDisplayReferCode;
    }

    public void setReqDisplayReferCode(boolean reqDisplayReferCode) {
        this.reqDisplayReferCode = reqDisplayReferCode;
    }

    public boolean isRegLine() {
        return regLine;
    }

    public void setRegLine(boolean regLine) {
        this.regLine = regLine;
    }

    public String getWithdrawPasswordFormat() {
        return withdrawPasswordFormat;
    }

    public void setWithdrawPasswordFormat(String withdrawPasswordFormat) {
        this.withdrawPasswordFormat = withdrawPasswordFormat;
    }

    public boolean isMustFillReferral() {
        return mustFillReferral;
    }

    public void setMustFillReferral(boolean mustFillReferral) {
        this.mustFillReferral = mustFillReferral;
    }

    public boolean isRegEmailDisplay() {
        return regEmailDisplay;
    }

    public void setRegEmailDisplay(boolean regEmailDisplay) {
        this.regEmailDisplay = regEmailDisplay;
    }

    public boolean isReqPhoneDisplay() {
        return reqPhoneDisplay;
    }

    public void setReqPhoneDisplay(boolean reqPhoneDisplay) {
        this.reqPhoneDisplay = reqPhoneDisplay;
    }

    public boolean isRegSkype() {
        return regSkype;
    }

    public void setRegSkype(boolean regSkype) {
        this.regSkype = regSkype;
    }

    @Override
    public String toString() {
        return "RegParam{" +
                "regBirthday=" + regBirthday +
                ", regQQ=" + regQQ +
                ", reqPhone=" + reqPhone +
                ", regEmail=" + regEmail +
                ", regWeixin=" + regWeixin +
                ", withdrawPassword=" + withdrawPassword +
                ", reqReferCode=" + reqReferCode +
                ", regRealName=" + regRealName +
                ", regMobileVerify=" + regMobileVerify +
                ", regPwdConfirm=" + regPwdConfirm +
                ", regLegalAge=" + regLegalAge +
                ", highLevelPass=" + isHighLevelPass +
                ", hasFriendPromo=" + hasFriendPromo +
                ", mustFillReferral=" + mustFillReferral +
                ", nameMin=" + nameMin +
                ", nameMax=" + nameMax +
                ", passwordMin=" + passwordMin +
                ", passwordMax=" + passwordMax +
                ", defaultAgentCode='" + defaultAgentCode + '\'' +
                ", verifyCode=" + verifyCode +
                '}';
    }
}