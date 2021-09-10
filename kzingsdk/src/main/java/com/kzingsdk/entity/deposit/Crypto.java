package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Crypto implements Parcelable {

    private String txid;
    private String bcid;
    private String qrcode;
    private String network;
    private String bankcode;

    public Crypto() {
    }

    public static Crypto newInstance(JSONObject rootObject) {
        Crypto quickLinkDeposit = new Crypto();
        quickLinkDeposit.setTxid(rootObject.optString("txid"));
        quickLinkDeposit.setBcid(rootObject.optString("bcid"));
        quickLinkDeposit.setQrcode(rootObject.optString("qrcode"));
        quickLinkDeposit.setNetwork(rootObject.optString("network"));
        quickLinkDeposit.setBankcode(rootObject.optString("bankcode"));
        return quickLinkDeposit;
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

    public static final Creator CREATOR = new Creator() {
        public Crypto createFromParcel(Parcel in) {
            return new Crypto(in);
        }

        public Crypto[] newArray(int size) {
            return new Crypto[size];
        }
    };

    public Crypto(Parcel in) {
        txid = in.readString();
        bcid = in.readString();
        qrcode = in.readString();
        network = in.readString();
        bankcode = in.readString();
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
        dest.writeString(bcid);
        dest.writeString(bankcode);
    }

}
