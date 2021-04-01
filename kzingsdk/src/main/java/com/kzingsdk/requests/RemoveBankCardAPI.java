package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class RemoveBankCardAPI extends CoreRequest {

    RemoveBankCardAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.removeBankCard;
    }

    private String wdbankid;

    @Override
    protected Observable<String> validateParams() {
        if (wdbankid == null || wdbankid.length() == 0) {
            return Observable.just("ID is not valid");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("wdbankid", wdbankid);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ignore -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((RemoveBankCardCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public RemoveBankCardAPI addRemoveBankCardCallBack(RemoveBankCardAPI.RemoveBankCardCallBack removeBankCardCallBack) {
        kzingCallBackList.add(removeBankCardCallBack);
        return this;
    }

    public interface RemoveBankCardCallBack extends KzingCallBack {
        void onSuccess();
    }

    public RemoveBankCardAPI addWdBankId(String wdbankid) {
        this.wdbankid = wdbankid;
        return this;
    }

}
