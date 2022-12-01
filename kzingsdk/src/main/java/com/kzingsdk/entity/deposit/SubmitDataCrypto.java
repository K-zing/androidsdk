package com.kzingsdk.entity.deposit;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class SubmitDataCrypto implements Parcelable {
    public static final Creator CREATOR = new Creator() {
        public SubmitDataCrypto createFromParcel(Parcel in) {
            return new SubmitDataCrypto(in);
        }

        public SubmitDataCrypto[] newArray(int size) {
            return new SubmitDataCrypto[size];
        }
    };
    private String address;
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal cryptoAmount = BigDecimal.ZERO;
    private String cryptoCurrency;
    private String currency;

    public SubmitDataCrypto() {

    }

    public SubmitDataCrypto(Parcel in) {
        address = in.readString();
        amount = new BigDecimal(in.readString());
        cryptoAmount = new BigDecimal(in.readString());
        cryptoCurrency = in.readString();
        currency = in.readString();
    }

    public static SubmitDataCrypto newInstance(JSONObject rootObject) {
        SubmitDataCrypto cOption = new SubmitDataCrypto();
        cOption.address = rootObject.optString("address");
        cOption.amount = BigDecimalUtil.optBigDecimal(rootObject, "amount", BigDecimal.ZERO);
        cOption.cryptoAmount = BigDecimalUtil.optBigDecimal(rootObject, "cryptoamt", BigDecimal.ZERO);
        cOption.cryptoCurrency = rootObject.optString("cryptocurrency");
        cOption.currency = rootObject.optString("currency");
        return cOption;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCryptoAmount() {
        return cryptoAmount;
    }

    public void setCryptoAmount(BigDecimal cryptoAmount) {
        this.cryptoAmount = cryptoAmount;
    }

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(amount.toString());
        dest.writeString(cryptoAmount.toString());
        dest.writeString(cryptoCurrency);
        dest.writeString(currency);
    }

}
