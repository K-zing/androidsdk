package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CryptoDepositAddr;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetCryptoDepositAddr2API extends CoreRequest {

    private String ppid;
    private String platform;

    GetCryptoDepositAddr2API() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getCryptoDepositAddr2;
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
                    ((GetCryptoDepositAddr2CallBack) kzingCallBack).onSuccess(cryptoDepositAddr);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCryptoDepositAddr2API addGetCryptoDepositAddr2CallBack(GetCryptoDepositAddr2CallBack getCryptoDepositAddr2CallBack) {
        kzingCallBackList.add(getCryptoDepositAddr2CallBack);
        return this;
    }

    public interface GetCryptoDepositAddr2CallBack extends KzingCallBack {
        void onSuccess(CryptoDepositAddr cryptoDepositAddr);
    }


    public GetCryptoDepositAddr2API setPpid(String ppid) {
        this.ppid = ppid;
        return this;
    }

    public GetCryptoDepositAddr2API setPlatform(String platform) {
        this.platform = platform;
        return this;
    }
}

