package com.kzingsdk.entity;

import org.json.JSONObject;

public class GetRefereeStatusResult extends SimpleApiResult {

    protected String registerLink;
    protected Integer showPopUp;
    protected Integer registeredAccount;
    protected Integer hasDeposit;
    protected Integer emailMobileVerified;

    public static GetRefereeStatusResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        GetRefereeStatusResult result = new GetRefereeStatusResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        JSONObject dataObject = rootObject.optJSONObject("data");
        if (dataObject != null) {
            result.setRegisterLink(dataObject.optString("register_link"));
            result.setShowPopUp(dataObject.optInt("show_pop_up"));
            result.setRegisteredAccount(dataObject.optInt("registered_account"));
            result.setHasDeposit(dataObject.optInt("has_deposit"));
            result.setEmailMobileVerified(dataObject.optInt("email_mobile_verified"));
        }
        return result;
    }

    public String getRegisterLink() {
        return registerLink;
    }

    public void setRegisterLink(String registerLink) {
        this.registerLink = registerLink;
    }

    public Integer getShowPopUp() {
        return showPopUp;
    }

    public void setShowPopUp(Integer showPopUp) {
        this.showPopUp = showPopUp;
    }

    public Integer getRegisteredAccount() {
        return registeredAccount;
    }

    public void setRegisteredAccount(Integer registeredAccount) {
        this.registeredAccount = registeredAccount;
    }

    public Integer getHasDeposit() {
        return hasDeposit;
    }

    public void setHasDeposit(Integer hasDeposit) {
        this.hasDeposit = hasDeposit;
    }

    public Integer getEmailMobileVerified() {
        return emailMobileVerified;
    }

    public void setEmailMobileVerified(Integer emailMobileVerified) {
        this.emailMobileVerified = emailMobileVerified;
    }
}
