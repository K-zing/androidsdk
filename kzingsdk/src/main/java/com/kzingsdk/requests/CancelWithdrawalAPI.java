package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CancelWithdrawalResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CancelWithdrawalAPI extends CoreRequest {

    private String dno;

    CancelWithdrawalAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.cancelWithdrawal;
    }

    @Override
    protected Observable<String> validateParams() {
        if (dno == null || dno.length() == 0) {
            return Observable.just("DNO is not valid");
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
    public Observable<CancelWithdrawalResult> requestRx(Context context) {
        return super.baseExecute(context).map(CancelWithdrawalResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(cancelWithdrawalResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((CancelWithdrawalCallBack) kzingCallBack).onSuccess(cancelWithdrawalResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CancelWithdrawalAPI addCancelWithdrawalCallBack(CancelWithdrawalAPI.CancelWithdrawalCallBack cancelWithdrawalCallBack) {
        kzingCallBackList.add(cancelWithdrawalCallBack);
        return this;
    }

    public CancelWithdrawalAPI setParamDno(String dno) {
        this.dno = dno;
        return this;
    }

    public interface CancelWithdrawalCallBack extends KzingCallBack {
        void onSuccess(CancelWithdrawalResult cancelWithdrawalResult);
    }

}
