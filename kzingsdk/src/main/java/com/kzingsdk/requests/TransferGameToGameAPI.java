package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.gameplatform.GamePlatform;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

import io.reactivex.Observable;

public class TransferGameToGameAPI extends CoreRequest {

    private String fromGpAccountId;
    private String toGpAccountId;
    private Double transferAmount;

    TransferGameToGameAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.transferGameToGame;
    }

    @Override
    protected Observable<String> validateParams() {
        if (fromGpAccountId == null) {
            return Observable.just("From GP Account ID is missing");
        }
        if (toGpAccountId == null) {
            return Observable.just("To GP Account ID is missing");
        }
        if (transferAmount == null) {
            return Observable.just("Transfer amount missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("fromid", fromGpAccountId);
            jsonData.put("toid", toGpAccountId);
            jsonData.put("transferAmount", transferAmount);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(siteInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((TransferToGameCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public TransferGameToGameAPI addTransferToGameCallBack(TransferToGameCallBack transferToGameCallBack) {
        kzingCallBackList.add(transferToGameCallBack);
        return this;
    }

    public interface TransferToGameCallBack extends KzingCallBack {
        void onSuccess();
    }

    /**
     * @param fromGpAccountId is equal to {@link GamePlatform#getGpAccountId()}.
     */
    public TransferGameToGameAPI setParamFromGpAccountId(String fromGpAccountId) {
        this.fromGpAccountId = fromGpAccountId;
        return this;
    }

    /**
     * @param toGpAccountId is equal to {@link GamePlatform#getGpAccountId()}.
     */
    public TransferGameToGameAPI setParamToGpAccountId(String toGpAccountId) {
        this.toGpAccountId = toGpAccountId;
        return this;
    }

    /**
     * @param transferAmount Optional. Default transfer all balance in player's account to target game platform. Auto round down to two decimals.
     */
    public TransferGameToGameAPI setParamTransferAmount(Double transferAmount) throws NumberFormatException {
        BigDecimal a = new BigDecimal(transferAmount);
        BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_DOWN);
        this.transferAmount = roundOff.doubleValue();
        return this;
    }

}

