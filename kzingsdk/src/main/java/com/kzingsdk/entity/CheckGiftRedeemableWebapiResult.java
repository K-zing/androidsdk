package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class CheckGiftRedeemableWebapiResult extends SimpleApiResult{

    CheckGiftRedeemableResult checkGiftRedeemableResult;

    public CheckGiftRedeemableWebapiResult() {

    }

    public static CheckGiftRedeemableWebapiResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        CheckGiftRedeemableWebapiResult result = new CheckGiftRedeemableWebapiResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        JSONObject dataObject = rootObject.optJSONObject("response");
        if (dataObject != null) {
            result.checkGiftRedeemableResult = CheckGiftRedeemableResult.newInstance(dataObject);
        }
        return result;
    }

    public CheckGiftRedeemableResult getCheckGiftRedeemableResult() {
        return checkGiftRedeemableResult;
    }

    public void setCheckGiftRedeemableResult(CheckGiftRedeemableResult checkGiftRedeemableResult) {
        this.checkGiftRedeemableResult = checkGiftRedeemableResult;
    }
}
