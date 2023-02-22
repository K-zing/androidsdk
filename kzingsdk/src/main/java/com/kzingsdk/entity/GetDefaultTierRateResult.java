package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class GetDefaultTierRateResult extends SimpleApiResult {

    protected BigDecimal defaultRate = BigDecimal.ZERO;

    public static GetDefaultTierRateResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        GetDefaultTierRateResult result = new GetDefaultTierRateResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        JSONObject dataObject = rootObject.optJSONObject("data");
        if (dataObject != null) {
            result.setDefaultRate(BigDecimalUtil.optBigDecimal(dataObject, "default_rate"));
        }
        return result;
    }

    public BigDecimal getDefaultRate() {
        return defaultRate;
    }

    public void setDefaultRate(BigDecimal defaultRate) {
        this.defaultRate = defaultRate;
    }
}
