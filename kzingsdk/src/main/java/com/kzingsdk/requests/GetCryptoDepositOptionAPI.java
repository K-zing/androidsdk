package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CryptoDepositOption;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetCryptoDepositOptionAPI extends CoreRequest implements RequireCurrency {

    private String currency;

    GetCryptoDepositOptionAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getCryptoDepositOption;
    }

    @Override
    public Observable<ArrayList<CryptoDepositOption>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<CryptoDepositOption> cryptoTransactions = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            if (response != null)
                for (int i = 0; i < response.length(); i++) {
                    cryptoTransactions.add(CryptoDepositOption.newInstance(response.optJSONObject(i)));
                }
            return cryptoTransactions;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(cryptoDepositOption -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCryptoDepositOptionCallBack) kzingCallBack).onSuccess(cryptoDepositOption);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCryptoDepositOptionAPI addGetCryptoDepositOptionCallBack(GetCryptoDepositOptionCallBack getCryptoDepositOptionCallBack) {
        kzingCallBackList.add(getCryptoDepositOptionCallBack);
        return this;
    }

    @Override
    public String getCurrency() {
        return currency;
    }


    public GetCryptoDepositOptionAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }


    public interface GetCryptoDepositOptionCallBack extends KzingCallBack {
        void onSuccess(ArrayList<CryptoDepositOption> cryptoDepositOption);
    }
}

