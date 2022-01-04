package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CancelPostpaidBonusAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.cancelPostpaidBonus;
    }

    CancelPostpaidBonusAPI() {
        super();
    }

    private String dno;

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
                    ((CancelPostpaidBonusCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CancelPostpaidBonusAPI addCancelPostpaidBonusCallBack(CancelPostpaidBonusCallBack cancelPostpaidBonusCallBack) {
        kzingCallBackList.add(cancelPostpaidBonusCallBack);
        return this;
    }

    public interface CancelPostpaidBonusCallBack extends KzingCallBack {
        void onSuccess();
    }

    public CancelPostpaidBonusAPI setDno(String dno) {
        this.dno = dno;
        return this;
    }
}

