package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class ActivitySignIn7DaysRequirement implements Parcelable {


    public static final Creator CREATOR = new Creator() {
        public ActivitySignIn7DaysRequirement createFromParcel(Parcel in) {
            return new ActivitySignIn7DaysRequirement(in);
        }

        public ActivitySignIn7DaysRequirement[] newArray(int size) {
            return new ActivitySignIn7DaysRequirement[size];
        }
    };

    private String validBetAmount;
    private String dayOne;
    private String dayTwo;
    private String dayThree;
    private String dayFour;
    private String dayFive;
    private String daySix;
    private String daySeven;
    private String sevenDaysBonus;

    public ActivitySignIn7DaysRequirement() {
    }

    public static ActivitySignIn7DaysRequirement newInstance(JSONObject rootObject) {
        ActivitySignIn7DaysRequirement item = new ActivitySignIn7DaysRequirement();
        item.setValidBetAmount(rootObject.optString("validbet_amount"));
        item.setDayOne(rootObject.optString("day_one"));
        item.setDayTwo(rootObject.optString("day_two"));
        item.setDayThree(rootObject.optString("day_three"));
        item.setDayFour(rootObject.optString("day_four"));
        item.setDayFive(rootObject.optString("day_five"));
        item.setDaySix(rootObject.optString("day_six"));
        item.setDaySeven(rootObject.optString("day_seven"));
        item.setSevenDaysBonus(rootObject.optString("sevendays_bonus"));
        return item;
    }


    public ActivitySignIn7DaysRequirement(Parcel in) {
        validBetAmount = in.readString();
        dayOne = in.readString();
        dayTwo = in.readString();
        dayThree = in.readString();
        dayFour = in.readString();
        dayFive = in.readString();
        daySix = in.readString();
        daySeven = in.readString();
        sevenDaysBonus = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(validBetAmount);
        dest.writeString(dayOne);
        dest.writeString(dayTwo);
        dest.writeString(dayThree);
        dest.writeString(dayFour);
        dest.writeString(dayFive);
        dest.writeString(daySix);
        dest.writeString(daySeven);
        dest.writeString(sevenDaysBonus);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getValidBetAmount() {
        return validBetAmount;
    }

    public void setValidBetAmount(String validBetAmount) {
        this.validBetAmount = validBetAmount;
    }

    public String getDayOne() {
        return dayOne;
    }

    public void setDayOne(String dayOne) {
        this.dayOne = dayOne;
    }

    public String getDayTwo() {
        return dayTwo;
    }

    public void setDayTwo(String dayTwo) {
        this.dayTwo = dayTwo;
    }

    public String getDayThree() {
        return dayThree;
    }

    public void setDayThree(String dayThree) {
        this.dayThree = dayThree;
    }

    public String getDayFour() {
        return dayFour;
    }

    public void setDayFour(String dayFour) {
        this.dayFour = dayFour;
    }

    public String getDayFive() {
        return dayFive;
    }

    public void setDayFive(String dayFive) {
        this.dayFive = dayFive;
    }

    public String getDaySix() {
        return daySix;
    }

    public void setDaySix(String daySix) {
        this.daySix = daySix;
    }

    public String getDaySeven() {
        return daySeven;
    }

    public void setDaySeven(String daySeven) {
        this.daySeven = daySeven;
    }

    public String getSevenDaysBonus() {
        return sevenDaysBonus;
    }

    public void setSevenDaysBonus(String sevenDaysBonus) {
        this.sevenDaysBonus = sevenDaysBonus;
    }
}