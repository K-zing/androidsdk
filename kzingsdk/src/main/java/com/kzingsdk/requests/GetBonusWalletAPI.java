package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

import io.reactivex.Observable;

public class GetBonusWalletAPI extends CoreRequest {

    GetBonusWalletAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getBonusWallet;
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
    public Observable<BigDecimal> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            return BigDecimalUtil.optBigDecimal(jsonResponse, "data", BigDecimal.ZERO);
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(data -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetBonusWalletCallBack) kzingCallBack).onSuccess(data);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetBonusWalletAPI addGetBonusWalletCallBack(GetBonusWalletCallBack getBonusWalletCallBack) {
        kzingCallBackList.add(getBonusWalletCallBack);
        return this;
    }

    public interface GetBonusWalletCallBack extends KzingCallBack {
        void onSuccess(BigDecimal data);
    }


}
