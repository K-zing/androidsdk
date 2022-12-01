package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class TWDHistory {

    private BigDecimal actual;
    private BigDecimal amount;
    private BigDecimal bonus;
    private BigDecimal ddeals;
    private BigDecimal wFee;
    private BigDecimal transAmount;
    private Integer statusCode;
    private Integer finalResultCode;
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
    private String bankName;
    private String cardNum;
    private String convertedAmt;
    private String cryptoAddress;
    private String cryptoAddress1;
    private String cryptoAddress2;
    private String finalResult;
    private String inImageAn;
    private String inImageH5;
    private String inImageIos;
    private String inGpid;
    private String inGpName;
    private String outImageAn;
    private String outImageH5;
    private String outImageIos;
    private String outGpid;
    private String outGpName;
    private Boolean isUploaded;
    private Boolean manualAdjusted;
    private Boolean canCancal;

    public static TWDHistory newInstance(JSONObject rootObject) {
        TWDHistory twdHistory = new TWDHistory();
        twdHistory.actual = BigDecimalUtil.optBigDecimal(rootObject, "actual");
        twdHistory.amount = BigDecimalUtil.optBigDecimal(rootObject, "amount");
        twdHistory.bonus = BigDecimalUtil.optBigDecimal(rootObject, "bonus");
        twdHistory.ddeals = BigDecimalUtil.optBigDecimal(rootObject, "ddeals");
        twdHistory.transAmount = BigDecimalUtil.optBigDecimal(rootObject, "transamount");
        twdHistory.wFee = BigDecimalUtil.optBigDecimal(rootObject, "wfee");
        twdHistory.statusCode = rootObject.optInt("status_code");
        twdHistory.finalResultCode = rootObject.optInt("finalresult_code");
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
        twdHistory.bankName = rootObject.optString("bankname");
        twdHistory.cardNum = rootObject.optString("cardnum");
        twdHistory.convertedAmt = rootObject.optString("convertedAmt");
        twdHistory.cryptoAddress = rootObject.optString("cryptoAddress");
        twdHistory.cryptoAddress1 = rootObject.optString("cryptoAddress1");
        twdHistory.cryptoAddress2 = rootObject.optString("cryptoAddress2");
        twdHistory.finalResult = rootObject.optString("finalresult");
        twdHistory.inImageAn = rootObject.optString("in_image_an");
        twdHistory.inImageH5 = rootObject.optString("in_image_h5");
        twdHistory.inImageIos = rootObject.optString("in_image_ios");
        twdHistory.inGpid = rootObject.optString("ingpid");
        twdHistory.inGpName = rootObject.optString("ingpname");
        twdHistory.outImageAn = rootObject.optString("out_image_an");
        twdHistory.outImageH5 = rootObject.optString("out_image_h5");
        twdHistory.outImageIos = rootObject.optString("out_image_ios");
        twdHistory.outGpid= rootObject.optString("outgpid");
        twdHistory.outGpName = rootObject.optString("outgpname");
        twdHistory.isUploaded = rootObject.optBoolean("isUploaded");
        twdHistory.manualAdjusted = rootObject.optBoolean("manualAdjusted");
        twdHistory.canCancal = rootObject.optBoolean("canCancal");
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

    public BigDecimal getwFee() {
        return wFee;
    }

    public void setwFee(BigDecimal wFee) {
        this.wFee = wFee;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getConvertedAmt() {
        return convertedAmt;
    }

    public void setConvertedAmt(String convertedAmt) {
        this.convertedAmt = convertedAmt;
    }

    public String getCryptoAddress() {
        return cryptoAddress;
    }

    public void setCryptoAddress(String cryptoAddress) {
        this.cryptoAddress = cryptoAddress;
    }

    public String getCryptoAddress1() {
        return cryptoAddress1;
    }

    public void setCryptoAddress1(String cryptoAddress1) {
        this.cryptoAddress1 = cryptoAddress1;
    }

    public String getCryptoAddress2() {
        return cryptoAddress2;
    }

    public void setCryptoAddress2(String cryptoAddress2) {
        this.cryptoAddress2 = cryptoAddress2;
    }

    public Boolean getCanCancal() {
        return canCancal;
    }

    public void setCanCancal(Boolean canCancal) {
        this.canCancal = canCancal;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public Integer getFinalResultCode() {
        return finalResultCode;
    }

    public void setFinalResultCode(Integer finalResultCode) {
        this.finalResultCode = finalResultCode;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }

    public String getInImageAn() {
        return inImageAn;
    }

    public void setInImageAn(String inImageAn) {
        this.inImageAn = inImageAn;
    }

    public String getInImageH5() {
        return inImageH5;
    }

    public void setInImageH5(String inImageH5) {
        this.inImageH5 = inImageH5;
    }

    public String getInImageIos() {
        return inImageIos;
    }

    public void setInImageIos(String inImageIos) {
        this.inImageIos = inImageIos;
    }

    public String getInGpid() {
        return inGpid;
    }

    public void setInGpid(String inGpid) {
        this.inGpid = inGpid;
    }

    public String getInGpName() {
        return inGpName;
    }

    public void setInGpName(String inGpName) {
        this.inGpName = inGpName;
    }

    public String getOutImageAn() {
        return outImageAn;
    }

    public void setOutImageAn(String outImageAn) {
        this.outImageAn = outImageAn;
    }

    public String getOutImageH5() {
        return outImageH5;
    }

    public void setOutImageH5(String outImageH5) {
        this.outImageH5 = outImageH5;
    }

    public String getOutImageIos() {
        return outImageIos;
    }

    public void setOutImageIos(String outImageIos) {
        this.outImageIos = outImageIos;
    }

    public String getOutGpid() {
        return outGpid;
    }

    public void setOutGpid(String outGpid) {
        this.outGpid = outGpid;
    }

    public String getOutGpName() {
        return outGpName;
    }

    public void setOutGpName(String outGpName) {
        this.outGpName = outGpName;
    }
}

