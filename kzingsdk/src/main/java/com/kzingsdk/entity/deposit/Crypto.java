package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Crypto implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public Crypto createFromParcel(Parcel in) {
            return new Crypto(in);
        }

        public Crypto[] newArray(int size) {
            return new Crypto[size];
        }
    };
    private String txid;
    private String bcid;
    private String qrcode;
    private String network;
    private String bankcode;
    private String recommended;

    public Crypto() {
    }

    public Crypto(Parcel in) {
        txid = in.readString();
        bcid = in.readString();
        qrcode = in.readString();
        network = in.readString();
        bankcode = in.readString();
        recommended = in.readString();
    }

    public static Crypto newInstance(JSONObject rootObject) {
        Crypto crypto = new Crypto();
        crypto.setTxid(rootObject.optString("txid"));
        crypto.setBcid(rootObject.optString("bcid"));
        crypto.setQrcode(rootObject.optString("qrcode"));
        crypto.setNetwork(rootObject.optString("network"));
        crypto.setBankcode(rootObject.optString("bankcode"));
        crypto.setRecommended(rootObject.optString("recommended"));
        return crypto;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
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

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(txid);
        dest.writeString(bcid);
        dest.writeString(qrcode);
        dest.writeString(network);
        dest.writeString(bankcode);
        dest.writeString(recommended);
    }

}
