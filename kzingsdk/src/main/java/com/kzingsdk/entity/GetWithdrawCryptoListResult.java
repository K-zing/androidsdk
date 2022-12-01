package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class GetWithdrawCryptoListResult {

    private ArrayList<WithdrawCrypto> withdrawCryptoList = new ArrayList<>();
    private ArrayList<WithdrawCryptoLimit> withdrawCryptoLimitList = new ArrayList<>();

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
                getWithdrawCryptoListResult.withdrawCryptoLimitList.add(withdrawCryptoLimit);
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

    public ArrayList<WithdrawCryptoLimit> getWithdrawCryptoLimitList() {
        return withdrawCryptoLimitList;
    }

    public void setWithdrawCryptoLimitList(ArrayList<WithdrawCryptoLimit> withdrawCryptoLimitList) {
        this.withdrawCryptoLimitList = withdrawCryptoLimitList;
    }
}

