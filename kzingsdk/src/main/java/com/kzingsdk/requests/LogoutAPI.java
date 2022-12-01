package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class LogoutAPI extends CoreRequest {

    LogoutAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.logout;
    }


    @Override
    public Observable<String> requestRx(Context context) {
        SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, null);
        SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, null);
        setLoginTokens(null, null);
        return Observable.just("Success");
    }


    @Override
    public void request(Context context) {
        requestRx(context).subscribe(stringResponse -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((LogoutCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public LogoutAPI addLogoutCallBack(LogoutAPI.LogoutCallBack logoutCallBack) {
        kzingCallBackList.add(logoutCallBack);
        return this;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("playername", "");
            jsonData.put("password", "");
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    public interface LogoutCallBack extends KzingCallBack {
        void onSuccess();
    }


}

