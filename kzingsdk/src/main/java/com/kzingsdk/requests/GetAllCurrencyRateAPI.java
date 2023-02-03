package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CurrencyRate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetAllCurrencyRateAPI extends CoreRequest {

    private Integer forDisplay = null;

    GetAllCurrencyRateAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getAllCurrencyRate;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (forDisplay != null)
                jsonData.put("fordisplay", forDisplay);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<ArrayList<CurrencyRate>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<CurrencyRate> currencyRateList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null)
                        for (int i = 0; i < response.length(); i++) {
                            currencyRateList.add(CurrencyRate.newInstance(response.optJSONObject(i)));
                        }
                    return currencyRateList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(currencyRateList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetAllCurrencyRateCallBack) kzingCallBack).onSuccess(currencyRateList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetAllCurrencyRateAPI addGetAllCurrencyRateCallBack(GetAllCurrencyRateCallBack getAllCurrencyRateCallBack) {
        kzingCallBackList.add(getAllCurrencyRateCallBack);
        return this;
    }

    public GetAllCurrencyRateAPI setForDisplay(Integer forDisplay) {
        this.forDisplay = forDisplay;
        return this;
    }

    public interface GetAllCurrencyRateCallBack extends KzingCallBack {
        void onSuccess(ArrayList<CurrencyRate> currencyRateList);
    }
}
