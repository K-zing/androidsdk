package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CryptoDepositAddr;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetCryptoDepositAddrAPI extends CoreRequest implements RequireCurrency {

    private String currency;
    private String ppid;
    private String platform;

    GetCryptoDepositAddrAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getCryptoDepositAddr;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("ppid", ppid);
            jsonData.put("platform", platform);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<CryptoDepositAddr> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            return CryptoDepositAddr.newInstance(jsonResponse.optJSONObject("data"));
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(cryptoDepositAddr -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCryptoDepositAddrCallBack) kzingCallBack).onSuccess(cryptoDepositAddr);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCryptoDepositAddrAPI addGetCryptoDepositAddrCallBack(GetCryptoDepositAddrCallBack getCryptoDepositAddrCallBack) {
        kzingCallBackList.add(getCryptoDepositAddrCallBack);
        return this;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    public GetCryptoDepositAddrAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public GetCryptoDepositAddrAPI setPpid(String ppid) {
        this.ppid = ppid;
        return this;
    }

    public GetCryptoDepositAddrAPI setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public interface GetCryptoDepositAddrCallBack extends KzingCallBack {
        void onSuccess(CryptoDepositAddr cryptoDepositAddr);
    }
}

