package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.gameplatform.GamePlatform;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;

import io.reactivex.Observable;

public class TransferToGameAPI extends CoreRequest {

    public static final String TRANSFER_BACK = "10000";
    private String gpAccountId;
    private BigDecimal transferAmount;
    private Boolean isTransferAll = false;
    private Boolean transferByLimit = false;

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
            jsonData.put("transferall", isTransferAll);
            if (gpAccountId != null && !gpAccountId.equals(TRANSFER_BACK)) {
                jsonData.put("toid", gpAccountId);
            }
            if (transferAmount != null) {
                jsonData.put("transferAmount", transferAmount);
            }
            jsonData.put("transferByLimit", transferByLimit);
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

    public TransferToGameAPI setParamTransferAmount(BigDecimal transferAmount) throws NumberFormatException {
        this.transferAmount = transferAmount;
        return this;
    }

    public TransferToGameAPI setParamTransferAmount(String transferAmount) throws NumberFormatException {
        this.transferAmount = new BigDecimal(transferAmount).setScale(2, RoundingMode.HALF_UP);
        return this;
    }

    public TransferToGameAPI setParamTransferall(Boolean transferall) {
        this.isTransferAll = transferall;
        return this;
    }

    public TransferToGameAPI setTransferByLimit(Boolean transferByLimit) {
        this.transferByLimit = transferByLimit;
        return this;
    }
}

