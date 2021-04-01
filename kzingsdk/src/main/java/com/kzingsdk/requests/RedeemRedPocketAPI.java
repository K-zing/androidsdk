package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RedPocketRedeemResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RedeemRedPocketAPI extends CoreRequest {

    RedeemRedPocketAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.redeemRedPocket;
    }


    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("actid", "");
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<RedPocketRedeemResult> requestRx(Context context) {
        return super.baseExecute(context).map(RedPocketRedeemResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(redPocketRedeemResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RedeemRedPocketCallBack) kzingCallBack).onSuccess(redPocketRedeemResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RedeemRedPocketAPI addRedeemRedPocketCallBack(RedeemRedPocketAPI.RedeemRedPocketCallBack redeemRedPocketCallBack) {
        kzingCallBackList.add(redeemRedPocketCallBack);
        return this;
    }

    public interface RedeemRedPocketCallBack extends KzingCallBack {
        void onSuccess(RedPocketRedeemResult redPocketRedeemResult);
    }

}
