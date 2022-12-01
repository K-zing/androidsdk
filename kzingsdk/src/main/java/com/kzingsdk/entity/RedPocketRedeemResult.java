package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


public class RedPocketRedeemResult implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public RedPocketRedeemResult createFromParcel(Parcel in) {
            return new RedPocketRedeemResult(in);
        }

        public RedPocketRedeemResult[] newArray(int size) {
            return new RedPocketRedeemResult[size];
        }
    };

    private Double award = 0d;
    private Integer chance = 0;

    public RedPocketRedeemResult() {

    }

    public RedPocketRedeemResult(Parcel in) {
        award = in.readDouble();
        chance = in.readInt();
    }

    public static RedPocketRedeemResult newInstance(JSONObject rootObject) {
        RedPocketRedeemResult redPocketInfo = new RedPocketRedeemResult();
        redPocketInfo.setAward(rootObject.optDouble("Award"));
        redPocketInfo.setChance(rootObject.optInt("Balance"));
        return redPocketInfo;
    }

    public Integer getChance() {
        return chance;
    }

    public void setChance(Integer chance) {
        this.chance = chance;
    }

    public Double getAward() {
        return award;
    }

    public void setAward(Double award) {
        this.award = award;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(award);
        dest.writeInt(chance);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "RedPocketRedeemResult{" +
                "award=" + award +
                ", chance=" + chance +
                '}';
    }
}

