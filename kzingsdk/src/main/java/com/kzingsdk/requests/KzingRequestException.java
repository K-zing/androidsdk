package com.kzingsdk.requests;

import com.kzingsdk.core.KzingException;


public class KzingRequestException extends KzingException {

    private Integer httpStatusCode = null;
    private Integer kzingStatusCode = null;
    private String domain = null;
    private String api = null;

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

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public Integer getKzingStatusCode() {
        return kzingStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
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
