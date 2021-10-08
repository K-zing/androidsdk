package com.kzingsdk.entity;

import org.json.JSONObject;

public class WithdrawCrypto {

    private String wdBankId;
    private String ano;
    private String bankCode;
    private String currency;
    private String address;
    private String network;
    private String note;
    private Integer utype;
    private Integer status;
    private Boolean isDefault;
    private Long created;

    public static WithdrawCrypto newInstance(JSONObject rootObject) {
        WithdrawCrypto withdrawCrypto = new WithdrawCrypto();
        withdrawCrypto.setWdBankId(rootObject.optString("wdbankid"));
        withdrawCrypto.setAno(rootObject.optString("ano"));
        withdrawCrypto.setBankCode(rootObject.optString("bankcode"));
        withdrawCrypto.setCurrency(rootObject.optString("currency"));
        withdrawCrypto.setAddress(rootObject.optString("address"));
        withdrawCrypto.setNetwork(rootObject.optString("network"));
        withdrawCrypto.setNote(rootObject.optString("note"));
        withdrawCrypto.setUtype(rootObject.optInt("utype"));
        withdrawCrypto.setStatus(rootObject.optInt("status"));
        withdrawCrypto.setDefault(rootObject.optInt("is_default") == 1);
        withdrawCrypto.setCreated(rootObject.optLong("created"));
        return withdrawCrypto;
    }

    public String getWdBankId() {
        return wdBankId;
    }

    public void setWdBankId(String wdBankId) {
        this.wdBankId = wdBankId;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getUtype() {
        return utype;
    }

    public void setUtype(Integer utype) {
        this.utype = utype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }
}
