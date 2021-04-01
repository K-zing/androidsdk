package com.kzingsdk.entity;

import org.json.JSONObject;

public class EWalletCard {

    protected String name = "";
    protected String bid = "";
    protected String poBid = "";
    protected String account = "";
    protected String bankImageUrl = "";

    public static EWalletCard newInstance(JSONObject rootObject) {
        EWalletCard eWalletCard = new EWalletCard();
        eWalletCard.setName(rootObject.optString("name"));
        eWalletCard.setBid(rootObject.optString("bid"));
        eWalletCard.setPoBid(rootObject.optString("pobid"));
        eWalletCard.setAccount(rootObject.optString("account"));
        eWalletCard.setBankImageUrl(rootObject.optString("bankcss"));
        return eWalletCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankImageUrl() {
        return bankImageUrl;
    }

    public void setBankImageUrl(String bankImageUrl) {
        this.bankImageUrl = bankImageUrl;
    }

    public String getPoBid() {
        return poBid;
    }

    public void setPoBid(String poBid) {
        this.poBid = poBid;
    }
}
