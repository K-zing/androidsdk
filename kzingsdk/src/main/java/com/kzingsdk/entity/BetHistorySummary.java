package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BetHistorySummary {

    private BigDecimal totalWin = BigDecimal.ZERO;
    private BigDecimal totalBetAmt = BigDecimal.ZERO;
    private ArrayList<BetHistory> betHistoryList = new ArrayList<>();

    public static BetHistorySummary newInstance(JSONObject rootObject) {
        BetHistorySummary rebateSummary = new BetHistorySummary();
        rebateSummary.setTotalWin(BigDecimalUtil.optBigDecimal(rootObject, "totalwin", BigDecimal.ZERO));
        rebateSummary.setTotalBetAmt(BigDecimalUtil.optBigDecimal(rootObject, "totalbetamt", BigDecimal.ZERO));
        JSONArray dataArray = rootObject.optJSONArray("data");
        if (dataArray != null) {
            for (int i = 0; i < dataArray.length(); i++) {
                rebateSummary.betHistoryList.add(BetHistory.newInstance(dataArray.optJSONObject(i)));
            }
        }
        return rebateSummary;
    }


    public BigDecimal getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(BigDecimal totalWin) {
        this.totalWin = totalWin;
    }

    public BigDecimal getTotalBetAmt() {
        return totalBetAmt;
    }

    public void setTotalBetAmt(BigDecimal totalBetAmt) {
        this.totalBetAmt = totalBetAmt;
    }

    public ArrayList<BetHistory> getBetHistoryList() {
        return betHistoryList;
    }

    public void setBetHistoryList(ArrayList<BetHistory> betHistoryList) {
        this.betHistoryList = betHistoryList;
    }
}
