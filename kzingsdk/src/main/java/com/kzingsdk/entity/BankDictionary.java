package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class BankDictionary implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public BankDictionary createFromParcel(Parcel in) {
            return new BankDictionary(in);
        }

        public BankDictionary[] newArray(int size) {
            return new BankDictionary[size];
        }
    };
    private String bankName = "";
    private String bankCode = "";
    private String bankImage = "";

    ;

    public BankDictionary() {

    }

    public BankDictionary(Parcel in) {
        bankName = in.readString();
        bankCode = in.readString();
        bankImage = in.readString();
    }

    public static BankDictionary newInstance(JSONObject rootObject) {
        BankDictionary bankDictionary = new BankDictionary();
        bankDictionary.setBankName(rootObject.optString("bankname"));
        bankDictionary.setBankCode(rootObject.optString("bankcode"));
        bankDictionary.setBankImage(rootObject.optString("bankcss"));
        return bankDictionary;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankImage() {
        return bankImage;
    }

    public void setBankImage(String bankImage) {
        this.bankImage = bankImage;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bankName);
        dest.writeString(bankCode);
        dest.writeString(bankImage);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "BankDictionary{" +
                "name='" + bankName + '\'' +
                ", bid='" + bankCode + '\'' +
                ", bankImage='" + bankImage + '\'' +
                '}';
    }
}
