package com.kzingsdk.util;

import org.json.JSONObject;

import java.math.BigDecimal;

public class BigDecimalUtil {

    public static BigDecimal optBigDecimal(JSONObject jsonObject, String key) {
        return optBigDecimal(jsonObject, key, BigDecimal.ZERO);
    }

    public static BigDecimal optBigDecimal(JSONObject jsonObject, String key, BigDecimal fallback) {
        if (jsonObject == null) {
            return fallback;
        }
        String valueString = jsonObject.optString(key, "");
        try {
            return new BigDecimal(valueString);
        } catch (NumberFormatException e) {
            return fallback;
        }
    }


}
