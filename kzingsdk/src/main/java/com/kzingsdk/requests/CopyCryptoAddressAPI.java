package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class CopyCryptoAddressAPI extends CoreRequest {

    private String currency;
    private String cryptoAddress;
    private String accountId;

    CopyCryptoAddressAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.copyCryptoAddress;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("currency", currency);
            jsonData.put("cryptoaddress", cryptoAddress);
            jsonData.put("accountid", accountId);
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
                    ((CopyCryptoAddressCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CopyCryptoAddressAPI addCopyCryptoAddressCallBack(CopyCryptoAddressCallBack copyCryptoAddressCallBack) {
        kzingCallBackList.add(copyCryptoAddressCallBack);
        return this;
    }

    public CopyCryptoAddressAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CopyCryptoAddressAPI setCryptoAddress(String cryptoAddress) {
        this.cryptoAddress = cryptoAddress;
        return this;
    }

    public CopyCryptoAddressAPI setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public interface CopyCryptoAddressCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }
}

