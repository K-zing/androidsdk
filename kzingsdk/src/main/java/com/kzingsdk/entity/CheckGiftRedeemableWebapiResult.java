package com.kzingsdk.entity;

import org.json.JSONObject;

public class CheckGiftRedeemableWebapiResult extends SimpleApiResult{

    CheckGiftRedeemableWebapi checkGiftRedeemableWebapi;

    public CheckGiftRedeemableWebapiResult() {

    }

    public static CheckGiftRedeemableWebapiResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        CheckGiftRedeemableWebapiResult result = new CheckGiftRedeemableWebapiResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        JSONObject dataObject = rootObject.optJSONObject("response");
        if (dataObject != null) {
            result.checkGiftRedeemableWebapi = CheckGiftRedeemableWebapi.newInstance(dataObject);
        }
        return result;
    }

    public CheckGiftRedeemableWebapi getCheckGiftRedeemableWebapi() {
        return checkGiftRedeemableWebapi;
    }

    public void setCheckGiftRedeemableWebapi(CheckGiftRedeemableWebapi checkGiftRedeemableWebapi) {
        this.checkGiftRedeemableWebapi = checkGiftRedeemableWebapi;
    }
}
