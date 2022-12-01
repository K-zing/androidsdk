package com.kzingsdk.requests.K36;

import android.content.Context;

import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

import io.reactivex.Observable;

public class ActivityTransferBonusAPI extends BaseK36API {

    private String actid;
    private String gpid;
    private BigDecimal amount = BigDecimal.ZERO;
    private boolean transfer = false;
    ActivityTransferBonusAPI() {
        super();
    }

    @Override
    protected String getK36Action() {
        return Action.activityTransferBonus;
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
            jsonData.put("gpid", gpid);
            jsonData.put("amount", amount.toString());
            jsonData.put("transfer", transfer);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    return true;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ignored -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ActivityTransferBonusAPICallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ActivityTransferBonusAPI addActivityTransferBonusAPICallBack(ActivityTransferBonusAPICallBack activityTransferBonusAPICallBack) {
        kzingCallBackList.add(activityTransferBonusAPICallBack);
        return this;
    }

    public ActivityTransferBonusAPI setActid(String actid) {
        this.actid = actid;
        return this;
    }

    public ActivityTransferBonusAPI setGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }

    public ActivityTransferBonusAPI setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public ActivityTransferBonusAPI setTransfer(boolean transfer) {
        this.transfer = transfer;
        return this;
    }

    public interface ActivityTransferBonusAPICallBack extends KzingCallBack {
        void onSuccess();
    }
}
