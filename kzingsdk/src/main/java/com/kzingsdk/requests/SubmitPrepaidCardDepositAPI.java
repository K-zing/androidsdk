package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

import io.reactivex.Observable;

public class SubmitPrepaidCardDepositAPI extends CoreRequest {

    private String serialid = null;

    SubmitPrepaidCardDepositAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitPrepaidCardDeposit;
    }


    @Override
    protected Observable<String> validateParams() {
        if (serialid == null) {
            return Observable.just("Serial ID is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("serialid", serialid);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<SubmitPrepaidCardDepositResult> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> new SubmitPrepaidCardDepositResult(jsonResponse.optString("msg"),
                BigDecimalUtil.optBigDecimal(jsonResponse, "amount", BigDecimal.ZERO)));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(submitPrepaidCardDepositResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitPrepaidCardDepositCallBack) kzingCallBack).onSuccess(submitPrepaidCardDepositResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitPrepaidCardDepositAPI addSubmitPrepaidCardDepositCallBack(SubmitPrepaidCardDepositCallBack submitPrepaidCardDepositCallBack) {
        kzingCallBackList.add(submitPrepaidCardDepositCallBack);
        return this;
    }

    public interface SubmitPrepaidCardDepositCallBack extends KzingCallBack {
        void onSuccess(SubmitPrepaidCardDepositResult submitPrepaidCardDepositResult);
    }


    public SubmitPrepaidCardDepositAPI setParamSerialId(String serialid) {
        this.serialid = serialid;
        return this;
    }

    public static class SubmitPrepaidCardDepositResult {
        private String msg;
        private BigDecimal amount;

        public SubmitPrepaidCardDepositResult(String msg, BigDecimal amount) {
            this.msg = msg;
            this.amount = amount;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
    }

}
