package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class WithdrawFieldOption implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public WithdrawFieldOption createFromParcel(Parcel in) {
            return new WithdrawFieldOption(in);
        }

        public WithdrawFieldOption[] newArray(int size) {
            return new WithdrawFieldOption[size];
        }
    };
    private String code;
    private String css;
    private String name;

    private WithdrawFieldOption() {
    }

    public WithdrawFieldOption(Parcel in) {

        code = in.readString();
        css = in.readString();
        name = in.readString();
    }

    public static Creator getCREATOR() {
        return CREATOR;
    }

    public static WithdrawFieldOption newInstance(JSONObject rootObject) {
        WithdrawFieldOption withdrawField = new WithdrawFieldOption();
        withdrawField.setCode(rootObject.optString("code"));
        withdrawField.setCss(rootObject.optString("css"));
        withdrawField.setName(rootObject.optString("name"));
        return withdrawField;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(css);
        dest.writeString(name);


    }
}
