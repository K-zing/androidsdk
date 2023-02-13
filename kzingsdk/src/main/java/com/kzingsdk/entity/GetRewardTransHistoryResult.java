package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GetRewardTransHistoryResult extends SimpleApiResult {

    private ArrayList<RewardTransHistory> rewardTransHistoryList = new ArrayList<>();
    private BigDecimal pointBalance = BigDecimal.ZERO;

    public static GetRewardTransHistoryResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        GetRewardTransHistoryResult result = new GetRewardTransHistoryResult();
        result.status = simpleApiResult.status;
        result.message = simpleApiResult.message;
        JSONArray dataArray = rootObject.optJSONArray("data");
        if (dataArray != null) {
            for (int i = 0; i < dataArray.length(); i++) {
                result.rewardTransHistoryList.add(RewardTransHistory.newInstance(dataArray.optJSONObject(i)));
            }
        }
        result.pointBalance = BigDecimalUtil.optBigDecimal(rootObject, "pointBalance");
        return result;
    }

    public ArrayList<RewardTransHistory> getRewardTransHistoryList() {
        return rewardTransHistoryList;
    }

    public void setRewardTransHistoryList(ArrayList<RewardTransHistory> rewardTransHistoryList) {
        this.rewardTransHistoryList = rewardTransHistoryList;
    }

    public BigDecimal getPointBalance() {
        return pointBalance;
    }

    public void setPointBalance(BigDecimal pointBalance) {
        this.pointBalance = pointBalance;
    }
}
