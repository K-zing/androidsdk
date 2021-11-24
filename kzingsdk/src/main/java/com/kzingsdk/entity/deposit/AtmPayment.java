package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class AtmPayment extends BasePaymentMethod implements Parcelable {


    private String name;
    private String address;
    private String accountNumber;
    private String desc;
    private int showField;
    private String qrcode;
    private boolean isQrcode = false;
    private BigDecimal promoRate = BigDecimal.ZERO;
    private BigDecimal sDealsRate = BigDecimal.ZERO;
    private String bcMin;
    private String bcMax;
    private String network;


    public AtmPayment() {
    }

    public static AtmPayment newInstance(JSONObject rootObject) {
        AtmPayment item = new AtmPayment();
        item.setId(rootObject.optString("bcid"));
        item.setPaymentName(rootObject.optString("bankname"));
        item.setImage(rootObject.optString("bankcss"));
        item.setName(rootObject.optString("atmname"));
        item.setAddress(rootObject.optString("atm_addr"));
        item.setAccountNumber(rootObject.optString("atm_no"));
        item.setDesc(rootObject.optString("desc"));
        item.setBankCode(rootObject.optString("bankcode"));
        item.setShowField(rootObject.optInt("showfield"));
        item.setFormType(rootObject.optString("formtype"));
        item.setRandom(rootObject.optInt("random"));
        item.setQrcode(rootObject.optString("qrcode"));
        item.setPromoRate(BigDecimalUtil.optBigDecimal(rootObject, "promorate", BigDecimal.ZERO));
        item.setSDealsRate(BigDecimalUtil.optBigDecimal(rootObject, "sdealsrate", BigDecimal.ZERO));
        item.setBcMin(rootObject.optString("bcmin"));
        item.setBcMax(rootObject.optString("bcmax"));
        item.setNetwork(rootObject.optString("network"));
        return item;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public boolean isQrcode() {
        return isQrcode;
    }

    public void setIsQrcode(boolean qrcode) {
        isQrcode = qrcode;
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

    public BigDecimal getSDealsRate() {
        return sDealsRate;
    }

    public void setSDealsRate(BigDecimal sDealsRate) {
        this.sDealsRate = sDealsRate;
    }

    public String getBcMin() {
        return bcMin;
    }

    public void setBcMin(String bcMin) {
        this.bcMin = bcMin;
    }

    public String getBcMax() {
        return bcMax;
    }

    public void setBcMax(String bcMax) {
        this.bcMax = bcMax;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public AtmPayment createFromParcel(Parcel in) {
            return new AtmPayment(in);
        }

        public AtmPayment[] newArray(int size) {
            return new AtmPayment[size];
        }
    };

    public AtmPayment(Parcel in) {
        id = in.readString();
        paymentName = in.readString();
        image = in.readString();
        displayOrder = in.readInt();
        minAmount = in.readDouble();
        maxAmount = in.readDouble();
        name = in.readString();
        desc = in.readString();
        bankCode = in.readString();
        address = in.readString();
        accountNumber = in.readString();
        qrcode = in.readString();
        showField = in.readInt();
        random = in.readInt();
        isQrcode = in.readInt() == 1;
        isAllowDecimal = in.readInt() == 1;
        promoRate = new BigDecimal(in.readString());
        sDealsRate = new BigDecimal(in.readString());
        bcMin = in.readString();
        bcMax = in.readString();
        network = in.readString();
        formType = in.readString();
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
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeString(bankCode);
        dest.writeString(address);
        dest.writeString(accountNumber);
        dest.writeString(qrcode);
        dest.writeInt(showField);
        dest.writeInt(random);
        dest.writeInt(isQrcode ? 1 : 0);
        dest.writeInt(isAllowDecimal ? 1 : 0);
        dest.writeString(promoRate.toString());
        dest.writeString(sDealsRate.toString());
        dest.writeString(bcMin);
        dest.writeString(bcMax);
        dest.writeString(network);
        dest.writeString(formType);
    }

    @Override
    public String toString() {
        return "AtmPayment{" +
                "name='" + name + '\'' +
                "desc='" + desc + '\'' +
                ", address='" + address + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", desc='" + desc + '\'' +
                ", showField=" + showField + '\'' +
                ", random=" + random +
                ", isQrcode=" + isQrcode +
                "} " + super.toString();
    }
}
