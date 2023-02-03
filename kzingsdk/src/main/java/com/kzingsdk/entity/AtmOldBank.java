package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class AtmOldBank {

    private String wdBankId;
    private String bankName;
    private String cardNum;

    public static AtmOldBank newInstance(JSONObject rootObject) {
        AtmOldBank activityBonus = new AtmOldBank();
        activityBonus.setWdBankId(rootObject.optString("wdbankid"));
        activityBonus.setBankName(rootObject.optString("bankname"));
        activityBonus.setCardNum(rootObject.optString("cardnum"));
        return activityBonus;
    }

    public String getWdBankId() {
        return wdBankId;
    }

    public void setWdBankId(String wdBankId) {
        this.wdBankId = wdBankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}

