package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class FinishDepositAPI extends CoreRequest {

    public static final String FINISH = "1";
    public static final String FINISH_WITH_PROBLEM = "2";
    private String status = null;

    FinishDepositAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.finishDeposit;
    }

    @Override
    protected Observable<String> validateParams() {
        if (!status.equalsIgnoreCase(FINISH) && !status.equalsIgnoreCase(FINISH_WITH_PROBLEM)) {
            return Observable.just("Invalid status");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("status", status);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> true);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(success -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((FinishDepositCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public FinishDepositAPI addFinishDepositCallBack(FinishDepositCallBack finishDepositCallBack) {
        kzingCallBackList.add(finishDepositCallBack);
        return this;
    }

    public interface FinishDepositCallBack extends KzingCallBack {
        void onSuccess(Boolean success);
    }

    public String getStatus() {
        return status;
    }

    public FinishDepositAPI setParamStatus(String status) {
        this.status = status;
        return this;
    }
}
