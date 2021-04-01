package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.deposit.DepositOption;

import org.json.JSONObject;

import io.reactivex.Observable;

public class GetDepositOptionAPI extends CoreRequest {

    GetDepositOptionAPI() {
        super();
    }

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


}
