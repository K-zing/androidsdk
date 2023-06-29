package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CheckGiftRedeemableWebapiResult;
import com.kzingsdk.entity.CheckGiftRedeemableWebapiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CheckGiftRedeemableWebapiAPI extends CoreRequest {

    private String actid;
    private String giftId;

    CheckGiftRedeemableWebapiAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.checkGiftRedeemableWebapi;
    }

    @Override
    protected Observable<String> validateParams() {
        if (actid == null || actid.length() == 0) {
            return Observable.just("ActID is not valid");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("actid", actid);
            jsonData.put("giftId", giftId);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<CheckGiftRedeemableWebapiResult> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> CheckGiftRedeemableWebapiResult.newInstance(jsonResponse.optJSONObject("response")));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(CheckGiftRedeemableWebapiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((CheckGiftRedeemableCallBack) kzingCallBack).onSuccess(CheckGiftRedeemableWebapiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CheckGiftRedeemableWebapiAPI addCheckGiftRedeemableCallBack(CheckGiftRedeemableCallBack checkGiftRedeembableCallBack) {
        kzingCallBackList.add(checkGiftRedeembableCallBack);
        return this;
    }

    public CheckGiftRedeemableWebapiAPI setParamActid(String actid) {
        this.actid = actid;
        return this;
    }

    public CheckGiftRedeemableWebapiAPI setParamGiftId(String giftId) {
        this.giftId = giftId;
        return this;
    }


    public interface CheckGiftRedeemableCallBack extends KzingCallBack {
        void onSuccess(CheckGiftRedeemableWebapiResult CheckGiftRedeemableWebapiResult);
    }


}
