package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.WithdrawEWalletInfo;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetAllWithdrawEWalletsAPI extends CoreRequest {

    private String currency;

    GetAllWithdrawEWalletsAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getAllWithdrawEWallets;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("currency", currency);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<WithdrawEWalletInfo> requestRx(final Context context) {
        return super.baseExecute(context).map(WithdrawEWalletInfo::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(withdrawEWalletInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetAllWithdrawEWalletsCallBack) kzingCallBack).onSuccess(withdrawEWalletInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetAllWithdrawEWalletsAPI addGetAllWithdrawEWalletsCallBack(GetAllWithdrawEWalletsCallBack getAllWithdrawEWalletsCallBack) {
        kzingCallBackList.add(getAllWithdrawEWalletsCallBack);
        return this;
    }

    public interface GetAllWithdrawEWalletsCallBack extends KzingCallBack {
        void onSuccess(WithdrawEWalletInfo withdrawEWalletInfo);
    }

    public GetAllWithdrawEWalletsAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}

