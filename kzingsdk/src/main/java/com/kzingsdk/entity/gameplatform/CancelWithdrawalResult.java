package com.kzingsdk.entity.gameplatform;

import org.json.JSONObject;

public class CancelWithdrawalResult {

    private Integer status;
    private String message;

    public CancelWithdrawalResult() {

    }

    public static CancelWithdrawalResult newInstance(JSONObject rootObject) {
        CancelWithdrawalResult checkGiftRedeemableResult = new CancelWithdrawalResult();
        checkGiftRedeemableResult.setMessage(rootObject.optString("msg"));
        checkGiftRedeemableResult.setStatus(rootObject.optInt("status"));
        return checkGiftRedeemableResult;
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
}
