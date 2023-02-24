package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetAllTierRateResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetAllTierRateAPI extends CoreRequest {
    private String cryptoCurrency;

    GetAllTierRateAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getAllTierRate;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("cryptocurrency", cryptoCurrency);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<GetAllTierRateResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetAllTierRateResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetAllTierRateCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetAllTierRateAPI addGetAllTierRateCallBack(GetAllTierRateCallBack getAllTierRateCallBack) {
        kzingCallBackList.add(getAllTierRateCallBack);
        return this;
    }

    public interface GetAllTierRateCallBack extends KzingCallBack {
        void onSuccess(GetAllTierRateResult simpleApiResult);
    }

    public GetAllTierRateAPI setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
        return this;
    }

}

