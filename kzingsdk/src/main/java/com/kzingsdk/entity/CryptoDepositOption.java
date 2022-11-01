package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class CryptoDepositOption {

    private String accountId;
    private String ppid;
    private String bcid;
    private String platform;
    private String currency;
    private String name;
    private String displayname;
    private BigDecimal min;
    private BigDecimal max;

    public CryptoDepositOption() {

    }

    public static CryptoDepositOption newInstance(JSONObject rootObject) {
        CryptoDepositOption cryptoDepositOption = new CryptoDepositOption();
        cryptoDepositOption.setAccountId(rootObject.optString("accountid"));
        cryptoDepositOption.setPpid(rootObject.optString("ppid"));
        cryptoDepositOption.setBcid(rootObject.optString("bcid"));
        cryptoDepositOption.setPlatform(rootObject.optString("platform"));
        cryptoDepositOption.setCurrency(rootObject.optString("currency"));
        cryptoDepositOption.setName(rootObject.optString("name"));
        cryptoDepositOption.setDisplayname(rootObject.optString("displayname"));
        cryptoDepositOption.setMin(BigDecimalUtil.optBigDecimal(rootObject, "min"));
        cryptoDepositOption.setMax(BigDecimalUtil.optBigDecimal(rootObject, "max"));
        return cryptoDepositOption;
    }

    public String getPpid() {
        return ppid;
    }

    public void setPpid(String ppid) {
        this.ppid = ppid;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getBcid() {
        return bcid;
    }

    public void setBcid(String bcid) {
        this.bcid = bcid;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }
}

