package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;


public class GetTWDHistoryResult {

    private Integer count;
    private Boolean manualAdjRecord;
    private BigDecimal successAmount;
    private ArrayList<TWDHistory> twdHistoryList = new ArrayList<>();

    public static GetTWDHistoryResult newInstance(JSONObject rootObject) {
        GetTWDHistoryResult getTWDHistoryResult = new GetTWDHistoryResult();
        getTWDHistoryResult.count = rootObject.optInt("count");
        getTWDHistoryResult.manualAdjRecord = rootObject.optBoolean("manualadjrecord");
        getTWDHistoryResult.successAmount = BigDecimalUtil.optBigDecimal(rootObject, "successAmount");
        JSONArray responseArray = rootObject.optJSONArray("response");
        if (responseArray != null) {
            for (int i = 0; i < responseArray.length(); i++) {
                getTWDHistoryResult.twdHistoryList.add(TWDHistory.newInstance(responseArray.optJSONObject(i)));
            }
        }
        return getTWDHistoryResult;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getManualAdjRecord() {
        return manualAdjRecord;
    }

    public void setManualAdjRecord(Boolean manualAdjRecord) {
        this.manualAdjRecord = manualAdjRecord;
    }

    public BigDecimal getSuccessAmount() {
        return successAmount;
    }

    public void setSuccessAmount(BigDecimal successAmount) {
        this.successAmount = successAmount;
    }

    public ArrayList<TWDHistory> getTwdHistoryList() {
        return twdHistoryList;
    }

    public void setTwdHistoryList(ArrayList<TWDHistory> twdHistoryList) {
        this.twdHistoryList = twdHistoryList;
    }
}

