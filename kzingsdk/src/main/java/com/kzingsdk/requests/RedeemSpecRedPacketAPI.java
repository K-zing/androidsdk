package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RedeemSpecRedPacketResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RedeemSpecRedPacketAPI extends CoreRequest {

    RedeemSpecRedPacketAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.redeemSpecRedPacket;
    }

    private String actid;

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
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<RedeemSpecRedPacketResult> requestRx(Context context) {
        return super.baseExecute(context).map(RedeemSpecRedPacketResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(redeemSpecRedPacketResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RedeemSpecRedPacketCallBack) kzingCallBack).onSuccess(redeemSpecRedPacketResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RedeemSpecRedPacketAPI addRedeemSpecRedPacketCallBack(RedeemSpecRedPacketCallBack redeemSpecRedPacketCallBack) {
        kzingCallBackList.add(redeemSpecRedPacketCallBack);
        return this;
    }

    public interface RedeemSpecRedPacketCallBack extends KzingCallBack {
        void onSuccess(RedeemSpecRedPacketResult redeemSpecRedPacketResult);
    }

    public RedeemSpecRedPacketAPI setActid(String actid) {
        this.actid = actid;
        return this;
    }

}
