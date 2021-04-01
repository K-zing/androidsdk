package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CheckGiftRedeemableResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CheckGiftRedeemableAPI extends CoreRequest {

    CheckGiftRedeemableAPI() {
        super();
    }

    private String actid;
    private String giftId;

    @Override
    protected String getAction() {
        return Action.checkGiftRedeemable;
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
    public Observable<CheckGiftRedeemableResult> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> CheckGiftRedeemableResult.newInstance(jsonResponse.optJSONObject("response")));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(checkGiftRedeemableResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((CheckGiftRedeemableCallBack) kzingCallBack).onSuccess(checkGiftRedeemableResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CheckGiftRedeemableAPI addCheckGiftRedeemableCallBack(CheckGiftRedeemableCallBack checkGiftRedeembableCallBack) {
        kzingCallBackList.add(checkGiftRedeembableCallBack);
        return this;
    }

    public interface CheckGiftRedeemableCallBack extends KzingCallBack {
        void onSuccess(CheckGiftRedeemableResult checkGiftRedeemableResult);
    }

    /**
     * @param actid From {@link com.kzingsdk.entity.ActivityItem} returned by {@link GetActivityListAPI}
     */
    public CheckGiftRedeemableAPI setParamActid(String actid) {
        this.actid = actid;
        return this;
    }


    public CheckGiftRedeemableAPI setParamGiftId(String giftId) {
        this.giftId = giftId;
        return this;
    }


}
