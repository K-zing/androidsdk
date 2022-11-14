package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetPGLiveConversionRateResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetPGLiveConversionRateAPI extends CoreRequest {

    private String ppid;
    private String currencyFrom;
    private String currencyTo;



    @Override
    protected String getAction() {
        return Action.getPGLiveConversionRate;
    }

    GetPGLiveConversionRateAPI() {
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
            jsonData.put("ppid", ppid);
            jsonData.put("currency_from",currencyFrom);
            jsonData.put("currency_to",currencyTo);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }
    @Override
    public Observable<GetPGLiveConversionRateResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetPGLiveConversionRateResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getPGLiveConversionRateResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetPGLiveConversionRateCallBack) kzingCallBack).onSuccess(getPGLiveConversionRateResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetPGLiveConversionRateAPI addGetPGLiveConversionRateCallBack(GetPGLiveConversionRateCallBack getPGLiveConversionRateCallBack) {
        kzingCallBackList.add(getPGLiveConversionRateCallBack);
        return this;
    }

    public interface GetPGLiveConversionRateCallBack extends KzingCallBack {
        void onSuccess(GetPGLiveConversionRateResult getPGLiveConversionRateResult);
    }

    public GetPGLiveConversionRateAPI setPpid(String ppid) {
        this.ppid = ppid;
        return this;
    }

    public GetPGLiveConversionRateAPI setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
        return this;
    }

    public GetPGLiveConversionRateAPI setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
        return this;
    }
}

