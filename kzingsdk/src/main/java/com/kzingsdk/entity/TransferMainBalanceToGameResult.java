package com.kzingsdk.entity;

import org.json.JSONObject;

public class TransferMainBalanceToGameResult extends SimpleApiResult {

    private String balance;

    public static TransferMainBalanceToGameResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        TransferMainBalanceToGameResult result = new TransferMainBalanceToGameResult();
        result.status = simpleApiResult.status;
        result.message = simpleApiResult.message;
        JSONObject dataArray = rootObject.optJSONObject("data");
        if (dataArray != null) {
            result.balance = dataArray.optString("balance");
        }
        return result;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
