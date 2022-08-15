package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;


public class GetDepositRecordResult {

    private Integer count;
    private Boolean manualAdjRecord;
    private BigDecimal successAmount;
    private ArrayList<DepositRecord> depositRecordList = new ArrayList<>();

    public static GetDepositRecordResult newInstance(JSONObject rootObject) {
        GetDepositRecordResult getDepositRecordResult = new GetDepositRecordResult();
        getDepositRecordResult.count = rootObject.optInt("count");
        getDepositRecordResult.manualAdjRecord = rootObject.optBoolean("manualadjrecord");
        getDepositRecordResult.successAmount = BigDecimalUtil.optBigDecimal(rootObject, "successAmount");
        JSONArray response = rootObject.optJSONArray("response");
        for (int i = 0; i < response.length(); i++) {
            getDepositRecordResult.depositRecordList.add(DepositRecord.newInstance(response.optJSONObject(i)));
        }
        return getDepositRecordResult;
    }

    public Integer getCount() {
        return count;
    }

    public GetDepositRecordResult setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Boolean getManualAdjRecord() {
        return manualAdjRecord;
    }

    public GetDepositRecordResult setManualAdjRecord(Boolean manualAdjRecord) {
        this.manualAdjRecord = manualAdjRecord;
        return this;
    }

    public BigDecimal getSuccessAmount() {
        return successAmount;
    }

    public GetDepositRecordResult setSuccessAmount(BigDecimal successAmount) {
        this.successAmount = successAmount;
        return this;
    }

    public ArrayList<DepositRecord> getDepositRecordList() {
        return depositRecordList;
    }

    public GetDepositRecordResult setDepositRecordList(ArrayList<DepositRecord> depositRecordList) {
        this.depositRecordList = depositRecordList;
        return this;
    }
}

