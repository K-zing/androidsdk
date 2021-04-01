package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.gameplatform.GamePlatform;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

import io.reactivex.Observable;

public class TransferToGameAPI extends CoreRequest {

    public static final String TRANSFER_BACK = "10000";
    private String gpAccountId;
    private Double transferAmount;

    TransferToGameAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.transferToGame;
    }

    @Override
    protected Observable<String> validateParams() {
        if (gpAccountId == null) {
            return Observable.just("GPID is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (gpAccountId != null && !gpAccountId.equals(TRANSFER_BACK)) {
                jsonData.put("toid", gpAccountId);
            }
            if (transferAmount != null) {
                jsonData.put("transferAmount", transferAmount);
            }
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

    public TransferToGameAPI addTransferToGameCallBack(TransferToGameCallBack transferToGameCallBack) {
        kzingCallBackList.add(transferToGameCallBack);
        return this;
    }

    public interface TransferToGameCallBack extends KzingCallBack {
        void onSuccess();
    }

    /**
     * @param gpAccountId is equal to {@link GamePlatform#getGpAccountId()}. {@link TransferToGameAPI#TRANSFER_BACK} to get back all balance from all GamePlatforms.
     */
    public TransferToGameAPI setParamGpAccountId(String gpAccountId) {
        this.gpAccountId = gpAccountId;
        return this;
    }

    /**
     * @param transferAmount Optional. Default transfer all balance in player's account to target game platform. Auto round down to two decimals.
     */
    public TransferToGameAPI setParamTransferAmount(Double transferAmount) throws NumberFormatException {
        BigDecimal a = new BigDecimal(transferAmount);
        BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_DOWN);
        this.transferAmount = roundOff.doubleValue();
        return this;
    }

}

