package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class RedeemSpecRedPacketResult {

    private int status;
    private BigDecimal award;

    public RedeemSpecRedPacketResult() {

    }

    public static RedeemSpecRedPacketResult newInstance(JSONObject rootObject) {
        RedeemSpecRedPacketResult redeemSpecRedPacketResult = new RedeemSpecRedPacketResult();
        redeemSpecRedPacketResult.setStatus(rootObject.optInt("c"));
        redeemSpecRedPacketResult.setAward(BigDecimalUtil.optBigDecimal(rootObject, "Award"));
        return redeemSpecRedPacketResult;
    }

    public int getStatus() {
        return status;
    }

    public RedeemSpecRedPacketResult setStatus(int status) {
        this.status = status;
        return this;
    }

    public BigDecimal getAward() {
        return award;
    }

    public RedeemSpecRedPacketResult setAward(BigDecimal award) {
        this.award = award;
        return this;
    }
}

