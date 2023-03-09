package com.kzingsdk.entity;

import org.json.JSONObject;

public class PlayerBankCard extends BankCard {

    private String cardNumber = "";
    private String playerBankId = "";
    private String note = "";
    private String ifscCode = "";
    private String address = "";
    private String bankNode = "";
    private String province = "";
    private String city = "";
    private String bankPassbook = "";
    private Integer defaultCard = 0;

    public static PlayerBankCard newInstance(JSONObject rootObject) {
        PlayerBankCard playerBankCard = new PlayerBankCard();
        playerBankCard.setCardNumber(rootObject.optString("cardnum"));
        playerBankCard.setPlayerBankId(rootObject.optString("wdbankid"));
        playerBankCard.setBankName(rootObject.optString("bankname"));
        playerBankCard.setBankCode(rootObject.optString("bankcode"));
        playerBankCard.setBankImageUrl(rootObject.optString("bankcss"));
        playerBankCard.setNote(rootObject.optString("note"));
        playerBankCard.setIfscCode(rootObject.optString("ifsccode"));
        playerBankCard.setAddress(rootObject.optString("address"));
        playerBankCard.setBankNode(rootObject.optString("banknode"));
        playerBankCard.setProvince(rootObject.optString("province"));
        playerBankCard.setCity(rootObject.optString("city"));
        playerBankCard.setBankPassbook(rootObject.optString("bankpassbook"));
        playerBankCard.setDefaultCard(rootObject.optInt("defaultcard"));

        return playerBankCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPlayerBankId() {
        return playerBankId;
    }

    public void setPlayerBankId(String playerBankId) {
        this.playerBankId = playerBankId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankNode() {
        return bankNode;
    }

    public void setBankNode(String bankNode) {
        this.bankNode = bankNode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBankPassbook() {
        return bankPassbook;
    }

    public void setBankPassbook(String bankPassbook) {
        this.bankPassbook = bankPassbook;
    }

    public Integer getDefaultCard() {
        return defaultCard;
    }

    public void setDefaultCard(Integer defaultCard) {
        this.defaultCard = defaultCard;
    }

    @Override
    public String toString() {
        return "PlayerBankCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", playerBankId='" + playerBankId + '\'' +
                ", name='" + bankName + '\'' +
                ", bid='" + bankCode + '\'' +
                ", bankImageUrl='" + bankImageUrl + '\'' +
                '}';
    }
}
