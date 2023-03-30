package com.kzingsdk.requests;

import com.kzingsdk.core.KzingException;

import org.json.JSONObject;


public class KzingRequestException extends KzingException {

    private Integer httpStatusCode = null;
    private Integer kzingStatusCode = null;
    private String domain = null;
    private String api = null;
    private JSONObject dataObject = null;

    public KzingRequestException(String message) {
        super(message);
    }

    public KzingRequestException(Integer httpStatusCode, Integer kzingStatusCode) {
        this(httpStatusCode, kzingStatusCode, "", "", "");
    }

    public KzingRequestException(Integer httpStatusCode, Integer kzingStatusCode, String message, String domain, String api) {
        super(message);
        this.httpStatusCode = httpStatusCode;
        this.kzingStatusCode = kzingStatusCode;
        this.domain = domain;
        this.api = api;
    }
    public KzingRequestException(Integer httpStatusCode, Integer kzingStatusCode, String message, String domain, String api, JSONObject dataObject) {
        super(message);
        this.httpStatusCode = httpStatusCode;
        this.kzingStatusCode = kzingStatusCode;
        this.domain = domain;
        this.api = api;
        this.dataObject = dataObject;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public Integer getKzingStatusCode() {
        return kzingStatusCode;
    }

    public void setKzingStatusCode(Integer kzingStatusCode) {
        this.kzingStatusCode = kzingStatusCode;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public JSONObject getDataObject() {
        return dataObject;
    }

    public void setDataObject(JSONObject dataObject) {
        this.dataObject = dataObject;
    }

    @Override
    public String toString() {
        return "KzingRequestException{" +
                "httpStatusCode=" + httpStatusCode +
                ", kzingStatusCode=" + kzingStatusCode +
                ", domain='" + domain + '\'' +
                ", api='" + api + '\'' +
                "} " + super.toString();
    }

}
