package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.deposit.DepositOption;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetDepositOptionAPI extends CoreRequest {

    GetDepositOptionAPI() {
        super();
    }

    private boolean isV2 = false;

    @Override
    protected String getAction() {
        return Action.getDepositOption;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("isV2", isV2);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<DepositOption> requestRx(Context context) {
        return super.baseExecute(context).map(DepositOption::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(depositOption -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetDepositOptionCallBack) kzingCallBack).onSuccess(depositOption);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetDepositOptionAPI addGetDepositOptionCallBack(GetDepositOptionCallBack getDepositOptionCallBack) {
        kzingCallBackList.add(getDepositOptionCallBack);
        return this;
    }

    public interface GetDepositOptionCallBack extends KzingCallBack {
        void onSuccess(DepositOption depositOption);
    }

    public GetDepositOptionAPI setV2(boolean v2) {
        isV2 = v2;
        return this;
    }
}
