package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;

public class RebateSummary {

    private BigDecimal total = BigDecimal.ZERO;
    private ArrayList<RebateGameDetail> rebateGameDetailList = new ArrayList<>();

    public static RebateSummary newInstance(JSONObject rootObject) {
        RebateSummary rebateSummary = new RebateSummary();
        rebateSummary.setTotal(BigDecimalUtil.optBigDecimal(rootObject, "total", BigDecimal.ZERO));
        JSONArray dataArray = rootObject.optJSONArray("data");
        if (dataArray != null) {
            for (int i = 0; i < dataArray.length(); i++) {
                rebateSummary.rebateGameDetailList.add(RebateGameDetail.newInstance(dataArray.optJSONObject(i)));
            }
        }
        return rebateSummary;
    }


    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ArrayList<RebateGameDetail> getRebateGameDetailList() {
        return rebateGameDetailList;
    }

    public void setRebateGameDetailList(ArrayList<RebateGameDetail> rebateGameDetailList) {
        this.rebateGameDetailList = rebateGameDetailList;
    }
}
