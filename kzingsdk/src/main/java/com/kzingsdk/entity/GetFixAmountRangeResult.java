package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GetFixAmountRangeResult {

    protected ArrayList<FixAmount> fixAmountList = new ArrayList<>();

    protected String paymentMethod = "";
    protected String cryptoCurrency = "";
    protected BigDecimal minTransAmount = BigDecimal.ZERO;
    protected BigDecimal maxTransAmount = BigDecimal.ZERO;
    protected ArrayList<String> bankCodeList = new ArrayList<>();
    protected ArrayList<String> suggestedAmountList = new ArrayList<>();

    public static GetFixAmountRangeResult newInstance(JSONObject rootObject) {
        GetFixAmountRangeResult result = new GetFixAmountRangeResult();
        JSONArray listArray = rootObject.optJSONArray("list");
        if (listArray != null) {
            for (int i = 0; i < listArray.length(); i++) {
                result.fixAmountList.add(FixAmount.newInstance(listArray.optJSONObject(i)));
            }
        }

        result.paymentMethod = rootObject.optString("paymentMethod");
        result.cryptoCurrency = rootObject.optString("cryptoCurrency");
        result.minTransAmount = BigDecimalUtil.optBigDecimal(rootObject, "minTransAmount");
        result.maxTransAmount = BigDecimalUtil.optBigDecimal(rootObject, "maxTransAmount");

        JSONArray bankCodeArray = rootObject.optJSONArray("bankCode");
        if (bankCodeArray != null) {
            for (int i = 0; i < bankCodeArray.length(); i++) {
                result.bankCodeList.add(bankCodeArray.optString(i));
            }
        }
        JSONArray suggestedAmountArray = rootObject.optJSONArray("suggestedAmount");
        if (suggestedAmountArray != null) {
            for (int i = 0; i < suggestedAmountArray.length(); i++) {
                result.suggestedAmountList.add(suggestedAmountArray.optString(i));
            }
        }

        return result;
    }

    public ArrayList<FixAmount> getFixAmountList() {
        return fixAmountList;
    }

    public void setFixAmountList(ArrayList<FixAmount> fixAmountList) {
        this.fixAmountList = fixAmountList;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public BigDecimal getMinTransAmount() {
        return minTransAmount;
    }

    public void setMinTransAmount(BigDecimal minTransAmount) {
        this.minTransAmount = minTransAmount;
    }

    public BigDecimal getMaxTransAmount() {
        return maxTransAmount;
    }

    public void setMaxTransAmount(BigDecimal maxTransAmount) {
        this.maxTransAmount = maxTransAmount;
    }

    public ArrayList<String> getBankCodeList() {
        return bankCodeList;
    }

    public void setBankCodeList(ArrayList<String> bankCodeList) {
        this.bankCodeList = bankCodeList;
    }

    public ArrayList<String> getSuggestedAmountList() {
        return suggestedAmountList;
    }

    public void setSuggestedAmountList(ArrayList<String> suggestedAmountList) {
        this.suggestedAmountList = suggestedAmountList;
    }

    public static class FixAmount {
        private String amount;
        private boolean isActive;


        public static FixAmount newInstance(JSONObject rootObject) {
            FixAmount fixAmount = new FixAmount();
            fixAmount.isActive = rootObject.optBoolean("isActive");
            fixAmount.amount = rootObject.optString("Amount");
            return fixAmount;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }
    }


}
