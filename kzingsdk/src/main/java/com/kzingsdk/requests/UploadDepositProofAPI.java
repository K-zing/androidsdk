package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class UploadDepositProofAPI extends CoreRequest {
    private String dno;
    private String depositSlip;

    UploadDepositProofAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.uploadDepositProof;
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
            jsonData.put("depositslip", depositSlip);
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
                    ((UploadDepositProofCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public UploadDepositProofAPI addUploadDepositProofCallBack(UploadDepositProofCallBack uploadDepositProofCallBack) {
        kzingCallBackList.add(uploadDepositProofCallBack);
        return this;
    }

    public UploadDepositProofAPI setDno(String dno) {
        this.dno = dno;
        return this;
    }

    public UploadDepositProofAPI setDepositSlip(String depositSlip) {
        this.depositSlip = depositSlip;
        return this;
    }

    public interface UploadDepositProofCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }
}

