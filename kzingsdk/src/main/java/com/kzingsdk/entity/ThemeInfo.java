package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class ThemeInfo implements Parcelable {

    private String colorId = "";
    private String rgbWhite = "";
    private String rgbBlack = "";

    public ThemeInfo() {

    }


    public static ThemeInfo newInstance(JSONObject rootObject) {
        ThemeInfo themeInfo = new ThemeInfo();
        themeInfo.setColorId(rootObject.optString("color_id"));
        themeInfo.setRgbWhite(rootObject.optString("rgb_white"));
        themeInfo.setRgbBlack(rootObject.optString("rgb_black"));
        return themeInfo;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getRgbWhite() {
        return rgbWhite;
    }

    public void setRgbWhite(String rgbWhite) {
        this.rgbWhite = rgbWhite;
    }

    public String getRgbBlack() {
        return rgbBlack;
    }

    public void setRgbBlack(String rgbBlack) {
        this.rgbBlack = rgbBlack;
    }

    public static final Creator<ThemeInfo> CREATOR = new Creator<ThemeInfo>() {
        @Override
        public ThemeInfo createFromParcel(Parcel in) {
            return new ThemeInfo(in);
        }

        @Override
        public ThemeInfo[] newArray(int size) {
            return new ThemeInfo[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(colorId);
        dest.writeString(rgbWhite);
        dest.writeString(rgbBlack);
    }

    public ThemeInfo(Parcel in) {
        colorId = in.readString();
        rgbWhite = in.readString();
        rgbBlack = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public String toString() {
        return "ThemeInfo{" +
                "colorId='" + colorId + '\'' +
                ", rgbWhite='" + rgbWhite + '\'' +
                ", rgbBlack='" + rgbBlack + '\'' +
                '}';
    }
}
