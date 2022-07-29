package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class DptTransInfo {

    private Integer dstatus = 0; //dstatus (0/50 – processing, 33 – successful, 22 - unsuccessful)
    private BigDecimal amount = BigDecimal.ZERO;
    private String dno = "";

    public DptTransInfo() {

    }

    public static DptTransInfo newInstance(JSONObject rootObject) {
        DptTransInfo sendSmsResult = new DptTransInfo();
        sendSmsResult.setDstatus(rootObject.optInt("dstatus"));
        sendSmsResult.setAmount(BigDecimalUtil.optBigDecimal(rootObject, "amount"));
        sendSmsResult.setDno(rootObject.optString("dno"));
        return sendSmsResult;
    }

    public Integer getDstatus() {
        return dstatus;
    }

    public void setDstatus(Integer dstatus) {
        this.dstatus = dstatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }


}
