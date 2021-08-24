package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Crypto implements Parcelable {

    private String address;
    private String bcid;
    private String qrcode;

    public Crypto() {
    }

    public static Crypto newInstance(JSONObject rootObject) {
        Crypto quickLinkDeposit = new Crypto();
        quickLinkDeposit.setAddress(rootObject.optString("address"));
        quickLinkDeposit.setBcid(rootObject.optString("bcid"));
        quickLinkDeposit.setQrcode(rootObject.optString("qrcode"));
        return quickLinkDeposit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBcid() {
        return bcid;
    }

    public void setBcid(String bcid) {
        this.bcid = bcid;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public static final Creator CREATOR = new Creator() {
        public Crypto createFromParcel(Parcel in) {
            return new Crypto(in);
        }

        public Crypto[] newArray(int size) {
            return new Crypto[size];
        }
    };

    public Crypto(Parcel in) {
        address = in.readString();
        bcid = in.readString();
        qrcode = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(bcid);
        dest.writeString(qrcode);
    }

}
