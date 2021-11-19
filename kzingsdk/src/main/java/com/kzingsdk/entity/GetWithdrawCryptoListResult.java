package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class GetWithdrawCryptoListResult {

    private ArrayList<WithdrawCrypto> withdrawCryptoList = new ArrayList<>();
    private HashMap<String, WithdrawCryptoLimit> withdrawCryptoLimitMap = new HashMap<>();

    public GetWithdrawCryptoListResult() {

    }

    public static GetWithdrawCryptoListResult newInstance(JSONObject rootObject) {
        GetWithdrawCryptoListResult getWithdrawCryptoListResult = new GetWithdrawCryptoListResult();
        JSONArray response = rootObject.optJSONArray("response");
        if (response != null) {
            for (int i = 0; i < response.length(); i++) {
                getWithdrawCryptoListResult.withdrawCryptoList.add(WithdrawCrypto.newInstance(response.optJSONObject(i)));
            }
        }
        JSONArray responseLimits = rootObject.optJSONArray("limits");
        if (responseLimits != null) {
            for (int i = 0; i < responseLimits.length(); i++) {
                WithdrawCryptoLimit withdrawCryptoLimit = WithdrawCryptoLimit.newInstance(responseLimits.optJSONObject(i));
                getWithdrawCryptoListResult.withdrawCryptoLimitMap.put(withdrawCryptoLimit.getCurrency(), withdrawCryptoLimit);
            }
        }
        return getWithdrawCryptoListResult;
    }

    public ArrayList<WithdrawCrypto> getWithdrawCryptoList() {
        return withdrawCryptoList;
    }

    public void setWithdrawCryptoList(ArrayList<WithdrawCrypto> withdrawCryptoList) {
        this.withdrawCryptoList = withdrawCryptoList;
    }

    public HashMap<String, WithdrawCryptoLimit> getWithdrawCryptoLimitMap() {
        return withdrawCryptoLimitMap;
    }

    public void setWithdrawCryptoLimitMap(HashMap<String, WithdrawCryptoLimit> withdrawCryptoLimitMap) {
        this.withdrawCryptoLimitMap = withdrawCryptoLimitMap;
    }
}

