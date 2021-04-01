package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class WithdrawEWallet implements Parcelable {

    public static Creator getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator CREATOR = new Creator() {
        public WithdrawEWallet createFromParcel(Parcel in) {
            return new WithdrawEWallet(in);
        }

        public WithdrawEWallet[] newArray(int size) {
            return new WithdrawEWallet[size];
        }
    };
    private String bankEn;
    private String wType;
    private String id;
    private String bankName;
    private String bankCode;
    private String bankCss;
    private String ppid;
    private int minDuration;
    private int maxDuration;
    private String tag;
    private Double minAmount;
    private Double maxAmount;

    public WithdrawEWallet() {
    }

    public static WithdrawEWallet newInstance(JSONObject rootObject) {
        WithdrawEWallet withdrawEWallet = new WithdrawEWallet();
        withdrawEWallet.setBankEn(rootObject.optString("banken"));
        withdrawEWallet.setWType(rootObject.optString("wtype"));
        withdrawEWallet.setId(rootObject.optString("id"));
        withdrawEWallet.setBankName(rootObject.optString("bankname"));
        withdrawEWallet.setBankCode(rootObject.optString("bankcode"));
        withdrawEWallet.setBankCss(rootObject.optString("bankcss"));
        withdrawEWallet.setPpid(rootObject.optString("ppid"));
        withdrawEWallet.setMinAmount(rootObject.optDouble("min_amt"));
        withdrawEWallet.setMaxAmount(rootObject.optDouble("max_amt"));
        withdrawEWallet.setMinDuration(rootObject.optInt("min_duration"));
        withdrawEWallet.setMaxDuration(rootObject.optInt("max_duration"));
        withdrawEWallet.setTag(rootObject.optString("tag"));

        return withdrawEWallet;
    }

    public String getBankEn() {
        return bankEn;
    }

    public void setBankEn(String bankEn) {
        this.bankEn = bankEn;
    }

    public String getWType() {
        return wType;
    }

    public void setWType(String wType) {
        this.wType = wType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBankCss() {
        return bankCss;
    }

    public void setBankCss(String bankCss) {
        this.bankCss = bankCss;
    }

    public String getPpid() {
        return ppid;
    }

    public void setPpid(String ppid) {
        this.ppid = ppid;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public WithdrawEWallet(Parcel in) {

        bankEn = in.readString();
        wType = in.readString();
        id = in.readString();
        bankName = in.readString();
        bankCode = in.readString();
        bankCss = in.readString();
        ppid = in.readString();
        minDuration = in.readInt();
        maxDuration = in.readInt();
        tag = in.readString();
        minAmount = in.readDouble();
        maxAmount = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bankEn);
        dest.writeString(wType);
        dest.writeString(id);
        dest.writeString(bankName);
        dest.writeString(bankCode);
        dest.writeString(bankCss);
        dest.writeString(ppid);
        dest.writeInt(minDuration);
        dest.writeInt(maxDuration);
        dest.writeString(tag);
        dest.writeDouble(minAmount);
        dest.writeDouble(maxAmount);

    }
}
