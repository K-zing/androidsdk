package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class TWDHistory {

    private BigDecimal actual;
    private BigDecimal amount;
    private BigDecimal bonus;
    private BigDecimal ddeals;
    private Integer statusCode;
    private String status;
    private String currency;
    private String dno;
    private String network;
    private String payName;
    private String transType;
    private String device;
    private String remark;
    private String created;
    private String updated;
    private String ppid;
    private String nextStatus;
    private Boolean isUploaded;
    private Boolean manualAdjusted;

    public static TWDHistory newInstance(JSONObject rootObject) {
        TWDHistory twdHistory = new TWDHistory();
        twdHistory.actual = BigDecimalUtil.optBigDecimal(rootObject, "actual");
        twdHistory.amount = BigDecimalUtil.optBigDecimal(rootObject, "amount");
        twdHistory.bonus = BigDecimalUtil.optBigDecimal(rootObject, "bonus");
        twdHistory.ddeals = BigDecimalUtil.optBigDecimal(rootObject, "ddeals");
        twdHistory.statusCode = rootObject.optInt("status_code");
        twdHistory.status = rootObject.optString("status");
        twdHistory.currency = rootObject.optString("currency");
        twdHistory.dno = rootObject.optString("dno");
        twdHistory.network = rootObject.optString("network");
        twdHistory.payName = rootObject.optString("payname");
        twdHistory.transType = rootObject.optString("transtype");
        twdHistory.device = rootObject.optString("device");
        twdHistory.remark = rootObject.optString("remark");
        twdHistory.created = rootObject.optString("created");
        twdHistory.updated = rootObject.optString("updated");
        twdHistory.ppid = rootObject.optString("ppid");
        twdHistory.nextStatus = rootObject.optString("nextStatus");
        twdHistory.isUploaded = rootObject.optBoolean("isUploaded");
        twdHistory.manualAdjusted = rootObject.optBoolean("manualAdjusted");
        return twdHistory;
    }

    public BigDecimal getActual() {
        return actual;
    }

    public void setActual(BigDecimal actual) {
        this.actual = actual;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getDdeals() {
        return ddeals;
    }

    public void setDdeals(BigDecimal ddeals) {
        this.ddeals = ddeals;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Boolean getManualAdjusted() {
        return manualAdjusted;
    }

    public void setManualAdjusted(Boolean manualAdjusted) {
        this.manualAdjusted = manualAdjusted;
    }

    public String getPpid() {
        return ppid;
    }

    public void setPpid(String ppid) {
        this.ppid = ppid;
    }

    public String getNextStatus() {
        return nextStatus;
    }

    public void setNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
    }

    public Boolean getUploaded() {
        return isUploaded;
    }

    public void setUploaded(Boolean uploaded) {
        isUploaded = uploaded;
    }
}

