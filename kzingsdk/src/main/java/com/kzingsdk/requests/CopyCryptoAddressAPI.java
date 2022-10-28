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

    @Override
    protected String getAction() {
        return Action.copyCryptoAddress;
    }

    CopyCryptoAddressAPI() {
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
                    ((GetTWDHistoryCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CopyCryptoAddressAPI addGetTWDHistoryCallBack(GetTWDHistoryCallBack getTWDHistoryCallBack) {
        kzingCallBackList.add(getTWDHistoryCallBack);
        return this;
    }

    public interface GetTWDHistoryCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCryptoAddress(String cryptoAddress) {
        this.cryptoAddress = cryptoAddress;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}

