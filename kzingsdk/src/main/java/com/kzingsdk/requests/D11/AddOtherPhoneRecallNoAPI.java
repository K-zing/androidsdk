package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class AddOtherPhoneRecallNoAPI extends BaseD11API {

    private String phoneNo;
    private String phoneCountry;

    AddOtherPhoneRecallNoAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.addOtherPhoneRecallNo;
    }

    @Override
    protected Observable<String> validateParams() {
        if (phoneNo == null) {
            return Observable.just("PhoneNo is missing");
        }
        if (phoneCountry == null) {
            return Observable.just("PhoneCountry is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("phoneNo", phoneNo);
            jsonData.put("phoneCountry", phoneCountry);
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
                    ((AddOtherPhoneRecallNoCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public AddOtherPhoneRecallNoAPI addAddOtherPhoneRecallNoCallBack(AddOtherPhoneRecallNoCallBack addOtherPhoneRecallNoCallBack) {
        kzingCallBackList.add(addOtherPhoneRecallNoCallBack);
        return this;
    }

    public AddOtherPhoneRecallNoAPI setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public AddOtherPhoneRecallNoAPI setPhoneCountry(String phoneCountry) {
        this.phoneCountry = phoneCountry;
        return this;
    }

    public interface AddOtherPhoneRecallNoCallBack extends KzingCallBack {
        void onSuccess();
    }
}
