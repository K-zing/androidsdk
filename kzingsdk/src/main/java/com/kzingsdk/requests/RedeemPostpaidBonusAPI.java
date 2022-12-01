package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RedeemPostpaidBonusAPI extends CoreRequest {

    private String dno;

    RedeemPostpaidBonusAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.redeemPostpaidBonus;
    }

    @Override
    protected Observable<String> validateParams() {
        if (dno == null) {
            return Observable.just("DNO is missing");
        }
        return super.validateParams();
    }


    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("dno", dno);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(string -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RedeemPostpaidBonusCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RedeemPostpaidBonusAPI addRedeemPostpaidBonusCallBack(RedeemPostpaidBonusCallBack redeemPostpaidBonusCallBack) {
        kzingCallBackList.add(redeemPostpaidBonusCallBack);
        return this;
    }

    public RedeemPostpaidBonusAPI setDno(String dno) {
        this.dno = dno;
        return this;
    }


    public interface RedeemPostpaidBonusCallBack extends KzingCallBack {
        void onSuccess();
    }

}

