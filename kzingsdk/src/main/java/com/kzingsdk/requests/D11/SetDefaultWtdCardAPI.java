package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SetDefaultWtdCardAPI extends BaseD11API {

    SetDefaultWtdCardAPI() {
        super();
    }

    private String bankId;

    @Override
    protected String getD11Action() {
        return Action.setDefaultWtdCard;
    }

    @Override
    protected Observable<String> validateParams() {
        if (bankId == null) {
            return Observable.just("BankId is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("bankid", bankId);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> true);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ignored -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SetDefaultWtdCardCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SetDefaultWtdCardAPI addSetDefaultWtdCardCallBack(SetDefaultWtdCardCallBack setDefaultWtdCardCallBack) {
        kzingCallBackList.add(setDefaultWtdCardCallBack);
        return this;
    }

    public interface SetDefaultWtdCardCallBack extends KzingCallBack {
        void onSuccess();
    }

    public SetDefaultWtdCardAPI setBankId(String bankId) {
        this.bankId = bankId;
        return this;
    }

}
