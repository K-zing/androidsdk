package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class RedPocketTime implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public RedPocketTime createFromParcel(Parcel in) {
            return new RedPocketTime(in);
        }

        public RedPocketTime[] newArray(int size) {
            return new RedPocketTime[size];
        }
    };

    private String shiftName = "";
    private String shiftStartTime = "";
    private String shiftEndTime = "";
    private Integer shiftShowTime = 0;

    public RedPocketTime() {

    }

    public static RedPocketTime newInstance(JSONObject rootObject) {
        RedPocketTime redPocketTime = new RedPocketTime();
        redPocketTime.setShiftName(rootObject.optString("shift_name", ""));
        redPocketTime.setShiftStartTime(rootObject.optString("shift_stime", ""));
        redPocketTime.setShiftEndTime(rootObject.optString("shift_etime", ""));
        redPocketTime.setShiftShowTime(rootObject.optInt("shift_show_time", 0));
        return redPocketTime;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getShiftStartTime() {
        return shiftStartTime;
    }

    public void setShiftStartTime(String shiftStartTime) {
        this.shiftStartTime = shiftStartTime;
    }

    public String getShiftEndTime() {
        return shiftEndTime;
    }

    public void setShiftEndTime(String shiftEndTime) {
        this.shiftEndTime = shiftEndTime;
    }

    public Integer getShiftShowTime() {
        return shiftShowTime;
    }

    public void setShiftShowTime(Integer shiftShowTime) {
        this.shiftShowTime = shiftShowTime;
    }

    public RedPocketTime(Parcel in) {
        shiftName = in.readString();
        shiftStartTime = in.readString();
        shiftEndTime = in.readString();
        shiftShowTime = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(shiftName);
        dest.writeString(shiftStartTime);
        dest.writeString(shiftEndTime);
        dest.writeInt(shiftShowTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}

