package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class CurrencyBalance implements Parcelable {

    private String currency;
    private String symbol;
    private BigDecimal amount;
    private Integer decimalPlaces;
    private boolean isCrypto;

    public static final Creator<CurrencyBalance> CREATOR = new Creator<CurrencyBalance>() {
        @Override
        public CurrencyBalance createFromParcel(Parcel in) {
            return new CurrencyBalance(in);
        }

        @Override
        public CurrencyBalance[] newArray(int size) {
            return new CurrencyBalance[size];
        }
    };

    public static CurrencyBalance newInstance(JSONObject rootObject) {
        CurrencyBalance currencyBalance = new CurrencyBalance();
        currencyBalance.setCurrency(rootObject.optString("currency"));
        currencyBalance.setSymbol(rootObject.optString("symbol"));
        currencyBalance.setAmount(BigDecimalUtil.optBigDecimal(rootObject, "amount"));
        currencyBalance.setDecimalPlaces(rootObject.optInt("decimalPlaces"));
        currencyBalance.setIsCrypto(rootObject.optInt("iscrypto") == 1);
        return currencyBalance;
    }

    public boolean isCrypto() {
        return isCrypto;
    }

    public void setIsCrypto(boolean crypto) {
        isCrypto = crypto;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public CurrencyBalance() {

    }

    public CurrencyBalance(Parcel in) {
        currency = in.readString();
        symbol = in.readString();
        amount = new BigDecimal(in.readString());
        decimalPlaces = in.readInt();
        isCrypto = in.readInt() == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(currency);
        dest.writeString(symbol);
        dest.writeString(amount.toString());
        dest.writeInt(decimalPlaces);
        dest.writeInt(isCrypto ? 1 : 0);
    }
}
