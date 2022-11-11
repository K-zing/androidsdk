package com.kzingsdk.entity;

import org.json.JSONObject;

public class SubmitBankTransferResult {

    protected Integer type;
    protected String msg;
    protected String url;
    protected String qrcode;
    protected String html;
    protected String dno;
    protected String status;
    protected String bankAccount;
    protected String bankName;
    protected String accountName;
    protected String ppid;
    protected String canRedirect;
    protected String atmName;
    protected String atmNo;
    protected String bankcode;
    protected String atmAddr;
    protected String atmBankName;
    protected String amount;
    protected String created;

    public static SubmitBankTransferResult newInstance(JSONObject rootObject) {
        SubmitBankTransferResult simpleApiResult = new SubmitBankTransferResult();
        simpleApiResult.setType(rootObject.optInt("type"));
        simpleApiResult.setMsg(rootObject.optString("msg"));
        simpleApiResult.setUrl(rootObject.optString("url"));
        simpleApiResult.setQrcode(rootObject.optString("qrcode"));
        simpleApiResult.setHtml(rootObject.optString("html"));
        simpleApiResult.setDno(rootObject.optString("dno"));
        JSONObject tlcObject = rootObject.optJSONObject("TLC_RESPONSE");
        if (tlcObject != null) {
            simpleApiResult.setStatus(tlcObject.optString("status"));
            simpleApiResult.setBankAccount(tlcObject.optString("bankAccount"));
            simpleApiResult.setBankName(tlcObject.optString("bankName"));
            simpleApiResult.setAccountName(tlcObject.optString("accountName"));
            simpleApiResult.setPpid(tlcObject.optString("ppid"));
            simpleApiResult.setCanRedirect(tlcObject.optString("canRedirect"));
            simpleApiResult.setAtmName(tlcObject.optString("atmname"));
            simpleApiResult.setAtmNo(tlcObject.optString("atm_no"));
            simpleApiResult.setBankcode(tlcObject.optString("bankcode"));
            simpleApiResult.setAtmAddr(tlcObject.optString("atm_addr"));
            simpleApiResult.setAtmBankName(tlcObject.optString("atm_bankname"));
            simpleApiResult.setAmount(tlcObject.optString("amount"));
            simpleApiResult.setCreated(tlcObject.optString("created"));
        }
        return simpleApiResult;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPpid() {
        return ppid;
    }

    public void setPpid(String ppid) {
        this.ppid = ppid;
    }

    public String getCanRedirect() {
        return canRedirect;
    }

    public void setCanRedirect(String canRedirect) {
        this.canRedirect = canRedirect;
    }

    public String getAtmName() {
        return atmName;
    }

    public void setAtmName(String atmName) {
        this.atmName = atmName;
    }

    public String getAtmNo() {
        return atmNo;
    }

    public void setAtmNo(String atmNo) {
        this.atmNo = atmNo;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getAtmAddr() {
        return atmAddr;
    }

    public void setAtmAddr(String atmAddr) {
        this.atmAddr = atmAddr;
    }

    public String getAtmBankName() {
        return atmBankName;
    }

    public void setAtmBankName(String atmBankName) {
        this.atmBankName = atmBankName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
