package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitAtmDepositV2API extends CoreRequest {

    private String depositUser;
    private String cTransNo;
    private String bcid;
    private Double cAmount;
    private Double cryptoRate;
    private String address;

    @Override
    protected String getAction() {
        return Action.submitAtmDepositV2;
    }

    SubmitAtmDepositV2API() {
        super();
    }


    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("deposituser", depositUser);
            jsonData.put("ctransno", cTransNo);
            jsonData.put("bcid", bcid);
            jsonData.put("camount", cAmount);
            jsonData.put("crypto_rate", cryptoRate);
            jsonData.put("address", address);
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
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitAtmDepositV2CallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitAtmDepositV2API addSubmitAtmDepositV2CallBack(SubmitAtmDepositV2CallBack submitAtmDepositV2CallBack) {
        kzingCallBackList.add(submitAtmDepositV2CallBack);
        return this;
    }

    public interface SubmitAtmDepositV2CallBack extends KzingCallBack {
        void onSuccess();
    }

    public SubmitAtmDepositV2API setDepositUser(String depositUser) {
        this.depositUser = depositUser;
        return this;
    }

    public SubmitAtmDepositV2API setCTransNo(String cTransNo) {
        this.cTransNo = cTransNo;
        return this;
    }

    public SubmitAtmDepositV2API setBcid(String bcid) {
        this.bcid = bcid;
        return this;
    }

    public SubmitAtmDepositV2API setCAmount(Double cAmount) {
        this.cAmount = cAmount;
        return this;
    }

    public SubmitAtmDepositV2API setCryptoRate(Double cryptoRate) {
        this.cryptoRate = cryptoRate;
        return this;
    }

    public SubmitAtmDepositV2API setAddress(String address) {
        this.address = address;
        return this;
    }
}

