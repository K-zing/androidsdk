package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ClientInstantInfo implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public ClientInstantInfo createFromParcel(Parcel in) {
            return new ClientInstantInfo(in);
        }

        public ClientInstantInfo[] newArray(int size) {
            return new ClientInstantInfo[size];
        }
    };
    private CaptchaApiId captchaApiId = new CaptchaApiId();
    private String captchaMode;
    private boolean memberLoginNeedCaptcha;

    public ClientInstantInfo() {

    }

    public static ClientInstantInfo newInstance(JSONObject rootObject) {
        ClientInstantInfo clientInfo = new ClientInstantInfo();
        clientInfo.setCaptchaMode(rootObject.optString("captchaMode"));
        clientInfo.setMemberLoginNeedCaptcha(rootObject.optBoolean("memberLoginNeedCaptcha", false));

        JSONObject captchaApiIdJSONObject = rootObject.optJSONObject("captchaApiId");
        if(captchaApiIdJSONObject!=null)
            clientInfo.setCaptchaApiId(CaptchaApiId.newInstance(captchaApiIdJSONObject));

        return clientInfo;
    }

    public CaptchaApiId getCaptchaApiId() {
        return captchaApiId;
    }

    public void setCaptchaApiId(CaptchaApiId captchaApiId) {
        this.captchaApiId = captchaApiId;
    }

    public String getCaptchaMode() {
        return captchaMode;
    }

    public void setCaptchaMode(String captchaMode) {
        this.captchaMode = captchaMode;
    }

    public Boolean getMemberLoginNeedCaptcha() {
        return memberLoginNeedCaptcha;
    }

    public void setMemberLoginNeedCaptcha(Boolean memberLoginNeedCaptcha) {
        this.memberLoginNeedCaptcha = memberLoginNeedCaptcha;
    }

    public ClientInstantInfo(Parcel in) {
        Object[] objectArray = in.readArray(ClientInstantInfo.class.getClassLoader());
        captchaApiId = (CaptchaApiId) objectArray[0];
        captchaMode = in.readString();
        memberLoginNeedCaptcha = in.readInt() == 1;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeArray(new Object[]{
                captchaApiId
        });
        dest.writeString(captchaMode);
        dest.writeInt(memberLoginNeedCaptcha ? 1 : 0);

    }

    @Override
    public int describeContents() {
        return 0;
    }

}
