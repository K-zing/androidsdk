package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class UpdateWtdPGStatusAPI extends CoreRequest {
    private String dno;
    private String nextStatus;

    UpdateWtdPGStatusAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.updateWtdPGStatus;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("dno", dno);
            jsonData.put("nextStatus", nextStatus);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SimpleApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SimpleApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((UpdateWtdPGStatusCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public UpdateWtdPGStatusAPI addUpdateWtdPGStatusCallBack(UpdateWtdPGStatusCallBack updateWtdPGStatusCallBack) {
        kzingCallBackList.add(updateWtdPGStatusCallBack);
        return this;
    }

    public UpdateWtdPGStatusAPI setDno(String dno) {
        this.dno = dno;
        return this;
    }

    public UpdateWtdPGStatusAPI setNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
        return this;
    }

    public interface UpdateWtdPGStatusCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }
}

