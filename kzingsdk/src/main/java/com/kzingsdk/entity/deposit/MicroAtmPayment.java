package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MicroAtmPayment extends BasePaymentMethod implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public MicroAtmPayment createFromParcel(Parcel in) {
            return new MicroAtmPayment(in);
        }

        public MicroAtmPayment[] newArray(int size) {
            return new MicroAtmPayment[size];
        }
    };
    private String ptAlias;
    private String accountId;
    private String atmNo;
    private String atmName;
    private String atmBankCode;
    private String atmAddr;
    private String qrcode;
    private String key;
    private String atmFeremark;
    private BigDecimal promoRate = BigDecimal.ZERO;
    private BigDecimal sDealsRate = BigDecimal.ZERO;
    private BigDecimal bcMin = BigDecimal.ZERO;
    private BigDecimal bcMax = BigDecimal.ZERO;
    private Integer showField;
    private Integer number;
    private Integer bcOptionType;
    private boolean quickAmountFlag = false;
    private ArrayList<BigDecimal> quickAmountList = new ArrayList<>();

    public MicroAtmPayment() {
    }

    public MicroAtmPayment(Parcel in) {
        id = in.readString();
        paymentName = in.readString();
        image = in.readString();
        bankCode = in.readString();
        displayOrder = in.readInt();
        random = in.readInt();
        minAmount = in.readDouble();
        maxAmount = in.readDouble();
        formType = in.readString();
        isAllowDecimal = in.readInt() == 1;
        quickAmountFlag = in.readInt() == 1;
        ptAlias = in.readString();
        accountId = in.readString();
        atmNo = in.readString();
        atmName = in.readString();
        atmBankCode = in.readString();
        atmAddr = in.readString();
        qrcode = in.readString();
        key = in.readString();
        atmFeremark = in.readString();
        promoRate = new BigDecimal(in.readString());
        sDealsRate = new BigDecimal(in.readString());
        bcMin = new BigDecimal(in.readString());
        bcMax = new BigDecimal(in.readString());
        showField = in.readInt();
        number = in.readInt();
        bcOptionType = in.readInt();
        Object[] objectArray = in.readArray(MicroAtmPayment.class.getClassLoader());
        quickAmountList = (ArrayList<BigDecimal>) objectArray[0];
    }

    public static MicroAtmPayment newInstance(JSONObject rootObject) {
        MicroAtmPayment item = new MicroAtmPayment();
        item.setId(rootObject.optString("bcid"));
        item.setImage(rootObject.optString("bankcss"));
        item.setBankCode(rootObject.optString("bankcode"));
        item.setPaymentName(rootObject.optString("bankname"));
        item.setPtAlias(rootObject.optString("ptalias"));
        item.setAccountId(rootObject.optString("accountid"));
        item.setAtmNo(rootObject.optString("atm_no"));
        item.setAtmName(rootObject.optString("atmname"));
        item.setAtmBankCode(rootObject.optString("atm_bankcode"));
        item.setAtmAddr(rootObject.optString("atm_addr"));
        item.setQrcode(rootObject.optString("qrcode"));
        item.setKey(rootObject.optString("key"));
        item.setAtmFeremark(rootObject.optString("atm_feremark"));
        item.setDisplayOrder(rootObject.optInt("displayorder"));
        item.setRandom(rootObject.optInt("random"));
        item.setShowField(rootObject.optInt("showfield"));
        item.setNumber(rootObject.optInt("number"));
        item.setBcOptionType(rootObject.optInt("bcoptiontype"));
        item.setPromoRate(BigDecimalUtil.optBigDecimal(rootObject, "promorate", BigDecimal.ZERO));
        item.setSDealsRate(BigDecimalUtil.optBigDecimal(rootObject, "sdealsrate", BigDecimal.ZERO));
        item.setBcMin(BigDecimalUtil.optBigDecimal(rootObject, "bcmin", BigDecimal.ZERO));
        item.setBcMax(BigDecimalUtil.optBigDecimal(rootObject, "bcmax", BigDecimal.ZERO));
        item.setQuickAmountFlag(rootObject.optInt("quickamountflag") == 1);
        String quickamountString = rootObject.optString("quickamount");
        String[] quickamountStrings = quickamountString.split(",");
        ArrayList<BigDecimal> quickAmountList = new ArrayList<>();
        for (String quickamount : quickamountStrings) {
            if (quickamount.length() > 0) {
                quickAmountList.add(new BigDecimal(quickamount));
            }
            item.setQuickAmountList(quickAmountList);
        }

        return item;
    }

    public String getPtAlias() {
        return ptAlias;
    }

    public void setPtAlias(String ptAlias) {
        this.ptAlias = ptAlias;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAtmNo() {
        return atmNo;
    }

    public void setAtmNo(String atmNo) {
        this.atmNo = atmNo;
    }

    public String getAtmName() {
        return atmName;
    }

    public void setAtmName(String atmName) {
        this.atmName = atmName;
    }

    public String getAtmBankCode() {
        return atmBankCode;
    }

    public void setAtmBankCode(String atmBankCode) {
        this.atmBankCode = atmBankCode;
    }

    public String getAtmAddr() {
        return atmAddr;
    }

    public void setAtmAddr(String atmAddr) {
        this.atmAddr = atmAddr;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public Integer getShowField() {
        return showField;
    }

    public void setShowField(Integer showField) {
        this.showField = showField;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBcOptionType() {
        return bcOptionType;
    }

    public void setBcOptionType(Integer bcOptionType) {
        this.bcOptionType = bcOptionType;
    }

    public BigDecimal getBcMin() {
        return bcMin;
    }

    public void setBcMin(BigDecimal bcMin) {
        this.bcMin = bcMin;
    }

    public BigDecimal getBcMax() {
        return bcMax;
    }

    public void setBcMax(BigDecimal bcMax) {
        this.bcMax = bcMax;
    }

    public boolean isQuickAmountFlag() {
        return quickAmountFlag;
    }

    public void setQuickAmountFlag(boolean quickAmountFlag) {
        this.quickAmountFlag = quickAmountFlag;
    }

    public ArrayList<BigDecimal> getQuickAmountList() {
        return quickAmountList;
    }

    public void setQuickAmountList(ArrayList<BigDecimal> quickAmountList) {
        this.quickAmountList = quickAmountList;
    }

    public String getAtmFeremark() {
        return atmFeremark;
    }

    public void setAtmFeremark(String atmFeremark) {
        this.atmFeremark = atmFeremark;
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
        dest.writeString(bankCode);
        dest.writeInt(displayOrder);
        dest.writeInt(random);
        dest.writeDouble(minAmount);
        dest.writeDouble(maxAmount);
        dest.writeString(formType);
        dest.writeInt(isAllowDecimal ? 1 : 0);
        dest.writeInt(quickAmountFlag ? 1 : 0);
        dest.writeString(ptAlias);
        dest.writeString(accountId);
        dest.writeString(atmNo);
        dest.writeString(atmName);
        dest.writeString(atmBankCode);
        dest.writeString(atmAddr);
        dest.writeString(qrcode);
        dest.writeString(key);
        dest.writeString(atmFeremark);
        dest.writeString(promoRate.toString());
        dest.writeString(sDealsRate.toString());
        dest.writeString(bcMin.toString());
        dest.writeString(bcMax.toString());
        dest.writeInt(showField);
        dest.writeInt(number);
        dest.writeInt(bcOptionType);
        Object[] customObjects = new Object[1];
        customObjects[0] = quickAmountList;
        dest.writeArray(customObjects);
    }

}
