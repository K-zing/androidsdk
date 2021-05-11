package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class MemberAgentWithdrawAPI extends CoreRequest {

    MemberAgentWithdrawAPI() {
        super();
    }

    private Double amount = 0d;

    @Override
    protected String getAction() {
        return Action.memberAgentWithdraw;
    }

    @Override
    protected Observable<String> validateParams() {
        if (amount <= 0) {
            return Observable.just("Amount cannot be lower than 0.");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("amount", amount);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(message -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((MemberAgentWithdrawCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public MemberAgentWithdrawAPI addMemberAgentWithdrawCallBack(MemberAgentWithdrawCallBack memberAgentWithdrawCallBack) {
        kzingCallBackList.add(memberAgentWithdrawCallBack);
        return this;
    }

    public interface MemberAgentWithdrawCallBack extends KzingCallBack {
        void onSuccess();
    }

    public MemberAgentWithdrawAPI setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

}
