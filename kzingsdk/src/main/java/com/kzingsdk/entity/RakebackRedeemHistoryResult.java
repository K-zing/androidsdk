package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class RakebackRedeemHistoryResult {

    private HashMap<String, RakebackRedeemTotal> rakebackRedeemTotalMap;
    private ArrayList<RakebackRedeemHistory> rakebackRedeemHistoryList;
    private int total = 0;

    public RakebackRedeemHistoryResult() {

    }

    public static RakebackRedeemHistoryResult newInstance(JSONObject rootObject) {
        RakebackRedeemHistoryResult result = new RakebackRedeemHistoryResult();
        result.rakebackRedeemTotalMap = new HashMap<>();
        result.rakebackRedeemHistoryList = new ArrayList<>();
        result.total = rootObject.optInt("totalCount");
        JSONObject totalJSON = rootObject.optJSONObject("totals");
        if (totalJSON != null) {
            Iterator<String> keys = totalJSON.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                RakebackRedeemTotal total = RakebackRedeemTotal.newInstance(totalJSON.optJSONObject(key), key);
                result.rakebackRedeemTotalMap.put(key, total);
            }
        }
        JSONArray response = rootObject.optJSONArray("data");
        for (int i = 0; i < response.length(); i++) {
            result.rakebackRedeemHistoryList.add(RakebackRedeemHistory.newInstance(response.optJSONObject(i)));
        }
        return result;
    }

    public HashMap<String, RakebackRedeemTotal> getRakebackRedeemTotalMap() {
        return rakebackRedeemTotalMap;
    }

    public void setRakebackRedeemTotalMap(HashMap<String, RakebackRedeemTotal> rakebackRedeemTotalMap) {
        this.rakebackRedeemTotalMap = rakebackRedeemTotalMap;
    }

    public ArrayList<RakebackRedeemHistory> getRakebackRedeemHistoryList() {
        return rakebackRedeemHistoryList;
    }

    public void setRakebackRedeemHistoryList(ArrayList<RakebackRedeemHistory> rakebackRedeemHistoryList) {
        this.rakebackRedeemHistoryList = rakebackRedeemHistoryList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

