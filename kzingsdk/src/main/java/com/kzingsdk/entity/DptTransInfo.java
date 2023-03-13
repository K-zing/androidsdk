package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;

public class DptTransInfo extends SimpleApiResult{

    private Integer dstatus = 0; //dstatus (0/50 – processing, 33 – successful, 22 - unsuccessful)
    private BigDecimal amount = BigDecimal.ZERO;
    private String dno = "";

    public DptTransInfo() {

    }

    public static DptTransInfo newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        DptTransInfo result = new DptTransInfo();
        result.status = simpleApiResult.status;
        result.message = simpleApiResult.message;
        JSONObject dataObject = rootObject.optJSONObject("response");
        if (dataObject!=null){
            result.setDstatus(dataObject.optInt("dstatus"));
            result.setAmount(BigDecimalUtil.optBigDecimal(dataObject, "amount"));
            result.setDno(dataObject.optString("dno"));
        }
        return result;
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
