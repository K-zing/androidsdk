package com.kzingsdk.entity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;

import org.json.JSONObject;


public class RegAgentParam implements Parcelable {

    private boolean regQQ, reqPhone, regEmail;
    private boolean
            reqRealName,
            reqPhoneCountry,
            reqWeixin,
            reqWhatsapp,
            reqTelegram,
            reqLine,
            reqBirthdate,
            reqFacebook,
            highLevelPassAgent,
            agentWithdrawPassword;

    private Bitmap verifyCode;
    private String agentWithdrawPasswordFormat;

    public static RegAgentParam newInstance(JSONObject rootObject) {
        RegAgentParam regParam = new RegAgentParam();
        regParam.setRegEmail(rootObject.optString("agentreqemail").equals("ON"));
        regParam.setRegQQ(rootObject.optString("agentreqqq").equals("ON"));
        regParam.setReqPhone(rootObject.optString("agentreqphone").equals("ON"));
        regParam.setReqRealName(rootObject.optString("agentreqrealname").equals("ON"));
        regParam.setReqPhoneCountry(rootObject.optString("agentreqphonecountry").equals("ON"));
        regParam.setReqWeixin(rootObject.optString("agentreqweixin").equals("ON"));
        regParam.setReqWhatsapp(rootObject.optString("agentreqwhatsapp").equals("ON"));
        regParam.setReqTelegram(rootObject.optString("agentreqtelegram").equals("ON"));
        regParam.setReqLine(rootObject.optString("agentreqline").equals("ON"));
        regParam.setReqBirthdate(rootObject.optString("agentreqbirthdate").equals("ON"));
        regParam.setHighLevelPassAgent(rootObject.optString("highLevelPassAgent").equals("ON"));
        regParam.setAgentWithdrawPassword(rootObject.optString("agentwithdrawpassword").equals("ON"));
        regParam.setReqFacebook(rootObject.optString("agentreqfacebook").equals("ON"));

        regParam.setAgentWithdrawPasswordFormat(rootObject.optString("agentwithdrawpasswordformat"));
        String image = rootObject.optString("image");
        byte[] decodedString = Base64.decode(image, Base64.DEFAULT);
        regParam.verifyCode = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return regParam;
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

    public Bitmap getVerifyCodeBitmap() {
        return verifyCode;
    }

    public void setVerifyCode(Bitmap verifyCode) {
        this.verifyCode = verifyCode;
    }

    public boolean isReqRealName() {
        return reqRealName;
    }

    public void setReqRealName(boolean reqRealName) {
        this.reqRealName = reqRealName;
    }

    public boolean isReqPhoneCountry() {
        return reqPhoneCountry;
    }

    public void setReqPhoneCountry(boolean reqPhoneCountry) {
        this.reqPhoneCountry = reqPhoneCountry;
    }

    public boolean isReqWeixin() {
        return reqWeixin;
    }

    public void setReqWeixin(boolean reqWeixin) {
        this.reqWeixin = reqWeixin;
    }

    public boolean isReqWhatsapp() {
        return reqWhatsapp;
    }

    public void setReqWhatsapp(boolean reqWhatsapp) {
        this.reqWhatsapp = reqWhatsapp;
    }

    public boolean isReqTelegram() {
        return reqTelegram;
    }

    public void setReqTelegram(boolean reqTelegram) {
        this.reqTelegram = reqTelegram;
    }

    public boolean isReqBirthdate() {
        return reqBirthdate;
    }

    public void setReqBirthdate(boolean reqBirthdate) {
        this.reqBirthdate = reqBirthdate;
    }

    public boolean isReqFacebook() {
        return reqFacebook;
    }

    public void setReqFacebook(boolean reqFacebook) {
        this.reqFacebook = reqFacebook;
    }

    public boolean isHighLevelPassAgent() {
        return highLevelPassAgent;
    }

    public void setHighLevelPassAgent(boolean highLevelPassAgent) {
        this.highLevelPassAgent = highLevelPassAgent;
    }

    public boolean isReqLine() {
        return reqLine;
    }

    public void setReqLine(boolean reqLine) {
        this.reqLine = reqLine;
    }

    public boolean isAgentWithdrawPassword() {
        return agentWithdrawPassword;
    }

    public void setAgentWithdrawPassword(boolean agentWithdrawPassword) {
        this.agentWithdrawPassword = agentWithdrawPassword;
    }

    public String getAgentWithdrawPasswordFormat() {
        return agentWithdrawPasswordFormat;
    }

    public void setAgentWithdrawPasswordFormat(String agentWithdrawPasswordFormat) {
        this.agentWithdrawPasswordFormat = agentWithdrawPasswordFormat;
    }

    public RegAgentParam(Parcel in) {
        regQQ = in.readInt() == 1;
        reqPhone = in.readInt() == 1;
        regEmail = in.readInt() == 1;
        reqRealName = in.readInt() == 1;
        reqPhoneCountry = in.readInt() == 1;
        reqWeixin = in.readInt() == 1;
        reqWhatsapp = in.readInt() == 1;
        reqTelegram = in.readInt() == 1;
        reqLine = in.readInt() == 1;
        reqBirthdate = in.readInt() == 1;
        reqFacebook = in.readInt() == 1;
        highLevelPassAgent = in.readInt() == 1;
        agentWithdrawPassword = in.readInt() == 1;
        agentWithdrawPasswordFormat = in.readString();
        Object[] objectArray = in.readArray(RegAgentParam.class.getClassLoader());
        verifyCode = (Bitmap) objectArray[0];
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(regQQ ? 1 : 0);
        dest.writeInt(reqPhone ? 1 : 0);
        dest.writeInt(regEmail ? 1 : 0);
        dest.writeInt(reqRealName ? 1 : 0);
        dest.writeInt(reqPhoneCountry ? 1 : 0);
        dest.writeInt(reqWeixin ? 1 : 0);
        dest.writeInt(reqWhatsapp ? 1 : 0);
        dest.writeInt(reqTelegram ? 1 : 0);
        dest.writeInt(reqLine ? 1 : 0);
        dest.writeInt(reqBirthdate ? 1 : 0);
        dest.writeInt(reqFacebook ? 1 : 0);
        dest.writeInt(highLevelPassAgent ? 1 : 0);
        dest.writeInt(agentWithdrawPassword ? 1 : 0);
        dest.writeString(agentWithdrawPasswordFormat);
        dest.writeArray(new Object[]{
                verifyCode
        });
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public RegAgentParam createFromParcel(Parcel in) {
            return new RegAgentParam(in);
        }

        public RegAgentParam[] newArray(int size) {
            return new RegAgentParam[size];
        }
    };


    public RegAgentParam() {

    }

    @Override
    public String toString() {
        return "RegAgentParam{" +
                "regQQ=" + regQQ +
                ", reqPhone=" + reqPhone +
                ", regEmail=" + regEmail +
                ", reqRealName=" + reqRealName +
                ", reqPhoneCountry=" + reqPhoneCountry +
                ", reqWeixin=" + reqWeixin +
                ", reqWhatsapp=" + reqWhatsapp +
                ", reqTelegram=" + reqTelegram +
                ", reqBirthdate=" + reqBirthdate +
                ", highLevelPassAgent=" + highLevelPassAgent +
                '}';
    }
}