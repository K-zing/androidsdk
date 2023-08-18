package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetCaptchaResult;
import com.kzingsdk.entity.RegParam;
import com.kzingsdk.entity.GetCaptchaResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetCaptchaAPI extends CoreRequest {

    GetCaptchaAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getCaptcha;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
//        JSONObject jsonData = super.generateParamsJson();
//        try {
//            jsonData.put("cover", cover);
//            return jsonData;
//        } catch (JSONException ignored) {
//        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<GetCaptchaResult> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            GetCaptchaResult result = GetCaptchaResult.newInstance(jsonResponse);
//            setSessionId(result.getSessionId());
            return result;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCaptchaCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCaptchaAPI addGetCaptchaCallBack(GetCaptchaCallBack getCaptchaCallBack) {
        kzingCallBackList.add(getCaptchaCallBack);
        return this;
    }

    public interface GetCaptchaCallBack extends KzingCallBack {
        void onSuccess(GetCaptchaResult result);
    }

    
}

