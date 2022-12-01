package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.DptTransInfo;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CheckDptTransInfoAPI extends CoreRequest {

    private String dno;

    CheckDptTransInfoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.checkDptTransInfo;
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
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<DptTransInfo> requestRx(final Context context) {
        return super.baseExecute(context).map(DptTransInfo::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(dptTransInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((CheckDptTransInfoCallBack) kzingCallBack).onSuccess(dptTransInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CheckDptTransInfoAPI addCheckDptTransInfoCallBack(CheckDptTransInfoCallBack checkDptTransInfoCallBack) {
        kzingCallBackList.add(checkDptTransInfoCallBack);
        return this;
    }

    public CheckDptTransInfoAPI setDno(String dno) {
        this.dno = dno;
        return this;
    }

    public interface CheckDptTransInfoCallBack extends KzingCallBack {
        void onSuccess(DptTransInfo dptTransInfo);
    }
}

