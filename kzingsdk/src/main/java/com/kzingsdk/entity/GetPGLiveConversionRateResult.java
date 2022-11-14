package com.kzingsdk.entity;

import org.json.JSONObject;

public class GetPGLiveConversionRateResult {

    protected Integer status;
    protected String message = "";


    private String currencyFrom;
    private String currencyTo;
    private String rate;

    public static GetPGLiveConversionRateResult newInstance(JSONObject rootObject) {
        GetPGLiveConversionRateResult result = new GetPGLiveConversionRateResult();
        result.currencyFrom = rootObject.optString("currency_from");
        result.currencyTo = rootObject.optString("currency_to");
        result.rate = rootObject.optString("rate");

        result.setStatus(rootObject.optInt("status"));
        String msg = rootObject.optString("message");
        if (msg == null){
            msg = rootObject.optString("msg");
        }
        result.setMessage(msg);
        return result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
