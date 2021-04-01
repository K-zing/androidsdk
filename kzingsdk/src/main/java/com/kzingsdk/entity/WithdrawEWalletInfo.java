package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class WithdrawEWalletInfo {

    private Double minAmount;
    private Double maxAmount;
    private ArrayList<WithdrawEWallet> walletList = new ArrayList<>();

    public static WithdrawEWalletInfo newInstance(JSONObject rootObject) {
        WithdrawEWalletInfo withdrawInfo = new WithdrawEWalletInfo();
        withdrawInfo.setMinAmount(rootObject.optDouble("wmin"));
        withdrawInfo.setMaxAmount(rootObject.optDouble("wmax"));
        JSONArray walletsArray = rootObject.optJSONArray("wallets");
        for (int i = 0; i < walletsArray.length(); i++) {
            withdrawInfo.walletList.add(WithdrawEWallet.newInstance(walletsArray.optJSONObject(i)));
        }
        return withdrawInfo;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public ArrayList<WithdrawEWallet> getWalletList() {
        return walletList;
    }

    public void setWalletList(ArrayList<WithdrawEWallet> walletList) {
        this.walletList = walletList;
    }
}
