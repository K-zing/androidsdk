package com.kzingsdk.entity;

import org.json.JSONObject;

import java.util.ArrayList;

public class TransferGameToMainBalanceResult extends SimpleApiResult {

    private String balance;

    public static TransferGameToMainBalanceResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        TransferGameToMainBalanceResult result = new TransferGameToMainBalanceResult();
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
