package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.deposit.ThirdPartyPayment;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetThirdPartySettingAPI extends CoreRequest {

    private ThirdPartyPayment thirdPartyPayment = null;

    GetThirdPartySettingAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getThirdPartySetting;
    }


    @Override
    protected Observable<String> validateParams() {

        if (thirdPartyPayment == null) {
            return Observable.just("ThirdPartyPayment is missing");
        }
        if (thirdPartyPayment.getOptionId() == null || thirdPartyPayment.getOptionId().length() == 0) {
            return Observable.just("Option ID is missing. ThirdPartyPayment object is invalid.");
        }
        if (thirdPartyPayment.getId() == null || thirdPartyPayment.getId().length() == 0) {
            return Observable.just("ThirdPartyPayment ID is missing. ThirdPartyPayment object is invalid.");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("optionid", thirdPartyPayment.getOptionId());
            jsonData.put("ppid", thirdPartyPayment.getId());
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<ThirdPartyPayment> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            thirdPartyPayment.importSettingFromJson(jsonResponse);
            return thirdPartyPayment;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(thirdPartyPayment -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetThirdPartySettingCallBack) kzingCallBack).onSuccess(thirdPartyPayment);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetThirdPartySettingAPI addGetThirdPartySettingCallBack(GetThirdPartySettingCallBack getThirdPartySettingCallBack) {
        kzingCallBackList.add(getThirdPartySettingCallBack);
        return this;
    }

    public GetThirdPartySettingAPI setParamThirdPartyPayment(ThirdPartyPayment thirdPartyPayment) {
        this.thirdPartyPayment = thirdPartyPayment;
        return this;
    }

    public interface GetThirdPartySettingCallBack extends KzingCallBack {
        void onSuccess(ThirdPartyPayment thirdPartyPayment);
    }


}
