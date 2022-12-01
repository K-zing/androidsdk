package com.kzingsdk.entity;

import org.json.JSONObject;


public class ForgotPwdVerifyUsernameResult {

    private Boolean status;
    private Boolean isUserNameValid;
    private Boolean isEmailSet;
    private Boolean isWithdrawalSet;
    private String message;

    public ForgotPwdVerifyUsernameResult() {

    }

    public static ForgotPwdVerifyUsernameResult newInstance(JSONObject rootObject) {
        ForgotPwdVerifyUsernameResult object = new ForgotPwdVerifyUsernameResult();
        object.setStatus(rootObject.optBoolean("status"));
        object.setUserNameValid(rootObject.optBoolean("isUsernameValid"));
        object.setEmailSet(rootObject.optBoolean("isEmailSet"));
        object.setWithdrawalSet(rootObject.optBoolean("isWithdrawalSet"));
        object.setMessage(rootObject.optString("message"));
        return object;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getUserNameValid() {
        return isUserNameValid;
    }

    public void setUserNameValid(Boolean userNameValid) {
        isUserNameValid = userNameValid;
    }

    public Boolean getEmailSet() {
        return isEmailSet;
    }

    public void setEmailSet(Boolean emailSet) {
        isEmailSet = emailSet;
    }

    public Boolean getWithdrawalSet() {
        return isWithdrawalSet;
    }

    public void setWithdrawalSet(Boolean withdrawalSet) {
        isWithdrawalSet = withdrawalSet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

