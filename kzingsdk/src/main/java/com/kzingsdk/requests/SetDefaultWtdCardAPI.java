package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SetDefaultWtdCardAPI extends CoreRequest {

    private String bankId;

    @Override
    protected String getAction() {
        return Action.setDefaultWtdCard;
    }

    SetDefaultWtdCardAPI() {
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
            jsonData.put("bankid", bankId);
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
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SetDefaultWtdCardCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SetDefaultWtdCardAPI addSetDefaultWtdCardCallBack(SetDefaultWtdCardCallBack setDefaultWtdCardCallBack) {
        kzingCallBackList.add(setDefaultWtdCardCallBack);
        return this;
    }

    public interface SetDefaultWtdCardCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult result);
    }

    public SetDefaultWtdCardAPI setBankId(String bankId) {
        this.bankId = bankId;
        return this;
    }
}

