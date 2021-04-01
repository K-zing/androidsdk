package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class COption implements Parcelable {
    private String display;
    private String logo;
    private String value;


    public COption() {

    }

    public static COption newInstance(JSONObject rootObject) {
        COption cOption = new COption();
        cOption.display = rootObject.optString("display");
        cOption.logo = rootObject.optString("logo");
        cOption.value = rootObject.optString("value");
        return cOption;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public COption createFromParcel(Parcel in) {
            return new COption(in);
        }

        public COption[] newArray(int size) {
            return new COption[size];
        }
    };

    public COption(Parcel in) {
        display = in.readString();
        logo = in.readString();
        value = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(display);
        dest.writeString(logo);
        dest.writeString(value);
    }

}
