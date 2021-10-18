package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CurrencyRate;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetAllCurrencyRateAPI extends CoreRequest {

    GetAllCurrencyRateAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getAllCurrencyRate;
    }

    @Override
    public Observable<ArrayList<CurrencyRate>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<CurrencyRate> currencyRateList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
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

    public interface GetAllCurrencyRateCallBack extends KzingCallBack {
        void onSuccess(ArrayList<CurrencyRate> currencyRateList);
    }

}
