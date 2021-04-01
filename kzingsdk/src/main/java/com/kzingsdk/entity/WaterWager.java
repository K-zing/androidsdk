package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class WaterWager {

    private BigDecimal amount = BigDecimal.ZERO;
    private String gpid = "";
    private String name = "";

    public WaterWager() {

    }

    public static WaterWager newInstance(JSONObject rootObject) {
        WaterWager sendEmailResult = new WaterWager();
        sendEmailResult.setAmount(BigDecimalUtil.optBigDecimal(rootObject, "amount", BigDecimal.ZERO));
        sendEmailResult.setGpid(rootObject.optString("gpid"));
        sendEmailResult.setName(rootObject.optString("name"));
        return sendEmailResult;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WaterWager{" +
                "amount=" + amount +
                ", gpid='" + gpid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
