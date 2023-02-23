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
        SubmitBankTransferResult result = new SubmitBankTransferResult();
        result.setType(rootObject.optInt("type"));
        result.setMsg(rootObject.optString("msg"));
        result.setUrl(rootObject.optString("url"));
        result.setQrcode(rootObject.optString("qrcode"));
        result.setHtml(rootObject.optString("html"));
        result.setDno(rootObject.optString("dno"));
        JSONObject resultObject = rootObject.optJSONObject("result");
        if (resultObject != null) {
            result.setDno(resultObject.optString("dno"));
            JSONObject tlcObject = resultObject.optJSONObject("TLC_RESPONSE");
            if (tlcObject != null) {
                result.setStatus(tlcObject.optString("status"));
                result.setBankAccount(tlcObject.optString("bankAccount"));
                result.setBankName(tlcObject.optString("bankName"));
                result.setAccountName(tlcObject.optString("accountName"));
                result.setPpid(tlcObject.optString("ppid"));
                result.setCanRedirect(tlcObject.optString("canRedirect"));
                result.setAtmName(tlcObject.optString("atmname"));
                result.setAtmNo(tlcObject.optString("atm_no"));
                result.setBankcode(tlcObject.optString("bankcode"));
                result.setAtmAddr(tlcObject.optString("atm_addr"));
                result.setAtmBankName(tlcObject.optString("atm_bankname"));
                result.setAmount(tlcObject.optString("amount"));
                result.setCreated(tlcObject.optString("created"));
            }
        }
        return result;
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
