package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class CryptoAtmPayment extends BasePaymentMethod implements Parcelable {

    private String address;
    private String desc;
    private int showField;
    private String qrcode;
    private BigDecimal promoRate = BigDecimal.ZERO;
    private String accountId;
    private String dpAddress;
    private String key;
    private String ptAlias;
    private int number;

    public CryptoAtmPayment() {
    }

    public static CryptoAtmPayment newInstance(JSONObject rootObject) {
        CryptoAtmPayment item = new CryptoAtmPayment();
        item.setId(rootObject.optString("bcid"));
        item.setAddress(rootObject.optString("address"));
        item.setImage(rootObject.optString("bankcss"));
        item.setBankCode(rootObject.optString("bankcode"));
        item.setPaymentName(rootObject.optString("bankname"));
        item.setDesc(rootObject.optString("desc"));
        item.setDisplayOrder(rootObject.optInt("displayorder"));
        item.setPromoRate(BigDecimalUtil.optBigDecimal(rootObject, "promorate", BigDecimal.ZERO));
        item.setShowField(rootObject.optInt("showfield"));
        item.setRandom(rootObject.optInt("random"));
        item.setAccountId(rootObject.optString("accountid"));
        item.setDpAddress(rootObject.optString("dpaddress"));
        item.setKey(rootObject.optString("key"));
        item.setNumber(rootObject.optInt("number"));
        item.setPtAlias(rootObject.optString("ptalias"));
        return item;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getShowField() {
        return showField;
    }

    public void setShowField(int showField) {
        this.showField = showField;
    }

    public Integer getRandom() {
        return random;
    }

    public void setRandom(Integer random) {
        this.random = random;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPromoRate() {
        return promoRate;
    }

    public void setPromoRate(BigDecimal promoRate) {
        this.promoRate = promoRate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDpAddress() {
        return dpAddress;
    }

    public void setDpAddress(String dpAddress) {
        this.dpAddress = dpAddress;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPtAlias() {
        return ptAlias;
    }

    public void setPtAlias(String ptAlias) {
        this.ptAlias = ptAlias;
    }

    public static final Creator CREATOR = new Creator() {
        public CryptoAtmPayment createFromParcel(Parcel in) {
            return new CryptoAtmPayment(in);
        }

        public CryptoAtmPayment[] newArray(int size) {
            return new CryptoAtmPayment[size];
        }
    };

    public CryptoAtmPayment(Parcel in) {
        id = in.readString();
        paymentName = in.readString();
        image = in.readString();
        displayOrder = in.readInt();
        minAmount = in.readDouble();
        maxAmount = in.readDouble();
        desc = in.readString();
        bankCode = in.readString();
        address = in.readString();
        qrcode = in.readString();
        showField = in.readInt();
        random = in.readInt();
        isAllowDecimal = in.readInt() == 1;
        promoRate = new BigDecimal(in.readString());
        formType = in.readString();
        accountId = in.readString();
        dpAddress = in.readString();
        key = in.readString();
        ptAlias = in.readString();
        number = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(paymentName);
        dest.writeString(image);
        dest.writeInt(displayOrder);
        dest.writeDouble(minAmount);
        dest.writeDouble(maxAmount);
        dest.writeString(desc);
        dest.writeString(bankCode);
        dest.writeString(address);
        dest.writeString(qrcode);
        dest.writeInt(showField);
        dest.writeInt(random);
        dest.writeInt(isAllowDecimal ? 1 : 0);
        dest.writeString(promoRate.toString());
        dest.writeString(formType);
        dest.writeString(accountId);
        dest.writeString(dpAddress);
        dest.writeString(key);
        dest.writeString(ptAlias);
        dest.writeInt(number);
    }

    @Override
    public String toString() {
        return "CryptoAtmPayment{" +
                "address='" + address + '\'' +
                ", desc='" + desc + '\'' +
                ", showField=" + showField +
                ", qrcode='" + qrcode + '\'' +
                ", promoRate=" + promoRate +
                ", accountId='" + accountId + '\'' +
                ", dpAddress='" + dpAddress + '\'' +
                ", key='" + key + '\'' +
                ", ptAlias='" + ptAlias + '\'' +
                ", number=" + number +
                ", id='" + id + '\'' +
                ", paymentName='" + paymentName + '\'' +
                ", image='" + image + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", displayOrder=" + displayOrder +
                ", random=" + random +
                ", minAmount=" + minAmount +
                ", maxAmount=" + maxAmount +
                ", formType='" + formType + '\'' +
                ", isAllowDecimal=" + isAllowDecimal +
                "} " + super.toString();
    }
}
