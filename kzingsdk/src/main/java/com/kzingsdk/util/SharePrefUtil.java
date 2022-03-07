package com.kzingsdk.util;


import android.content.Context;
import android.content.SharedPreferences;

import com.kzingsdk.core.KzingSDK;

public final class SharePrefUtil {

    private SharePrefUtil() {
    }

    public static void putString(Context context, String key, String value) {
        String apiKey = KzingSDK.getInstance().getApiKey();
        if (apiKey == null || apiKey.length() < 30) {
            return;
        }
        if (value == null){
            SharePrefUtil.removeString(context, key);
            return;
        }
        SharedPreferences sharedPref = context.getSharedPreferences(Constant.Pref.PREF_FILE_NAME + "." + apiKey, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key, String defaultValue) {
        String apiKey = KzingSDK.getInstance().getApiKey();
        if (apiKey == null || apiKey.length() < 30) {
            return defaultValue;
        }
        SharedPreferences sharedPref = context.getSharedPreferences(Constant.Pref.PREF_FILE_NAME + "." + apiKey, Context.MODE_PRIVATE);
        return sharedPref.getString(key, defaultValue);
    }


    public static void removeString(Context context, String key) {
        String apiKey = KzingSDK.getInstance().getApiKey();
        SharedPreferences sharedPref = context.getSharedPreferences(Constant.Pref.PREF_FILE_NAME + "." + apiKey, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove(key);
        editor.apply();
    }

}
