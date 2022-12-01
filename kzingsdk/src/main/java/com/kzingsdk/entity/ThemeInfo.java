package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class ThemeInfo implements Parcelable {

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
    @Deprecated
    private String colorId = "";
    @Deprecated
    private String rgbWhite = "";
    @Deprecated
    private String rgbBlack = "";
    private String theme;
    private int layout;
    private boolean swapable;


    public ThemeInfo() {

    }

    public ThemeInfo(Parcel in) {
        colorId = in.readString();
        rgbWhite = in.readString();
        rgbBlack = in.readString();
        theme = in.readString();
        layout = in.readInt();
        swapable = in.readInt() == 1;
    }

    public static ThemeInfo newInstance(JSONObject rootObject) {
        ThemeInfo themeInfo = new ThemeInfo();
        themeInfo.setColorId(rootObject.optString("color_id"));
        themeInfo.setRgbWhite(rootObject.optString("rgb_white"));
        themeInfo.setRgbBlack(rootObject.optString("rgb_black"));
        themeInfo.setTheme(rootObject.optString("theme"));
        themeInfo.setLayout(rootObject.optInt("layout"));
        themeInfo.setSwapable(rootObject.optBoolean("swapable"));
        return themeInfo;
    }

    @Deprecated
    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    @Deprecated
    public String getRgbWhite() {
        return rgbWhite;
    }

    public void setRgbWhite(String rgbWhite) {
        this.rgbWhite = rgbWhite;
    }

    @Deprecated
    public String getRgbBlack() {
        return rgbBlack;
    }

    public void setRgbBlack(String rgbBlack) {
        this.rgbBlack = rgbBlack;
    }

    public String getTheme() {
        return theme;
    }

    public ThemeInfo setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public int getLayout() {
        return layout;
    }

    public ThemeInfo setLayout(int layout) {
        this.layout = layout;
        return this;
    }

    public boolean isSwapable() {
        return swapable;
    }

    public ThemeInfo setSwapable(boolean swapable) {
        this.swapable = swapable;
        return this;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(colorId);
        dest.writeString(rgbWhite);
        dest.writeString(rgbBlack);
        dest.writeString(theme);
        dest.writeInt(layout);
        dest.writeInt(swapable ? 1 : 0);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
