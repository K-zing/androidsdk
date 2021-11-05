package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.deposit.ThirdPartyPaymentBank;
import com.kzingsdk.entity.deposit.ThirdPartyPaymentSubmitAction;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitThirdPartyDepositAPI extends CoreRequest {

    private ThirdPartyPaymentBank thirdPartyPaymentBank = null;
    private Double amount = 0d;
    private JSONObject formData = null;
    private String activityId = null;

    SubmitThirdPartyDepositAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitThirdPartyDeposit;
    }

    @Override
    protected Observable<String> validateParams() {
        if (amount <= 0) {
            return Observable.just("Deposit amount must be bigger than 0.");
        }
        if (thirdPartyPaymentBank == null) {
            return Observable.just("ThirdPartyPaymentBank is missing");
        }
        if (thirdPartyPaymentBank.getId() == null) {
            return Observable.just("Channel ID is null. ThirdPartyPaymentBank object is invalid.");
        }
        if (thirdPartyPaymentBank.getParent().getOptionId() == null || thirdPartyPaymentBank.getParent().getOptionId().length() == 0) {
            return Observable.just("Option ID is missing. ThirdPartyPaymentBank.parent object is invalid.");
        }
        if (thirdPartyPaymentBank.getParent().getId() == null || thirdPartyPaymentBank.getParent().getId().length() == 0) {
            return Observable.just("ThirdPartyPayment ID is missing. ThirdPartyPaymentBank.parent object is invalid.");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("bank", thirdPartyPaymentBank.getId());
            jsonData.put("optionid", thirdPartyPaymentBank.getParent().getOptionId());
            jsonData.put("ppid", thirdPartyPaymentBank.getParent().getId());
            jsonData.put("amount", amount);
            if (formData != null) {
                jsonData.put("formData", formData);
            }
            return jsonData;
        } catch (JSONException ignored) {

        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<ThirdPartyPaymentSubmitAction> requestRx(Context context) {
        return super.baseExecute(context).map(ThirdPartyPaymentSubmitAction::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(thirdPartyPaymentSubmitAction -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitThirdPartyDepositCallBack) kzingCallBack).onSuccess(thirdPartyPaymentSubmitAction);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitThirdPartyDepositAPI addSubmitThirdPartyDepositCallBack(SubmitThirdPartyDepositCallBack submitThirdPartyDepositCallBack) {
        kzingCallBackList.add(submitThirdPartyDepositCallBack);
        return this;
    }

    public interface SubmitThirdPartyDepositCallBack extends KzingCallBack {
        void onSuccess(ThirdPartyPaymentSubmitAction thirdPartyPaymentSubmitAction);
    }

    public SubmitThirdPartyDepositAPI setParamThirdPartyPaymentBank(ThirdPartyPaymentBank thirdPartyPaymentBank) {
        this.thirdPartyPaymentBank = thirdPartyPaymentBank;
        return this;
    }

    public SubmitThirdPartyDepositAPI setParamAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public SubmitThirdPartyDepositAPI setParamFormData(JSONObject formData) {
        this.formData = formData;
        return this;
    }

    public SubmitThirdPartyDepositAPI setParamActivityId(String activityId) {
        if (formData == null) {
            formData = new JSONObject();
        }
        try {
            formData.put("actid", activityId);
        } catch (JSONException ignored) {
        }
        this.activityId = activityId;
        return this;
    }
}
