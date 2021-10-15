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
                    ArrayList<CurrencyRate> gpBalanceMap = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("gpBalances");
                    for (int i = 0; i < response.length(); i++) {
                        gpBalanceMap.add(CurrencyRate.newInstance(response.optJSONObject(i)));
                    }
                    return gpBalanceMap;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(gpBalanceMap -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetAllCurrencyRateCallBack) kzingCallBack).onSuccess(gpBalanceMap);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetAllCurrencyRateAPI addGetAllCurrencyRateCallBack(GetAllCurrencyRateCallBack getAllCurrencyRateCallBack) {
        kzingCallBackList.add(getAllCurrencyRateCallBack);
        return this;
    }

    public interface GetAllCurrencyRateCallBack extends KzingCallBack {
        void onSuccess(ArrayList<CurrencyRate> gpBalanceMap);
    }

}
