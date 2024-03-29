package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ActivityForm;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class ApplyActivityAPI extends CoreRequest {

    private String actid;
    private String giftId;
    private String receipient;
    private String phone;
    private String area;
    private String address;
    private String formId;
    private ArrayList<ActivityForm> activityFormList;

    ApplyActivityAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.applyActivity;
    }

    @Override
    protected Observable<String> validateParams() {
        if (actid == null || actid.length() == 0) {
            return Observable.just("ActID is not valid");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("actid", actid);
            if (giftId != null)
                jsonData.put("giftId", giftId);
            if (receipient != null)
                jsonData.put("receipient", receipient);
            if (phone != null)
                jsonData.put("phone", phone);
            if (area != null)
                jsonData.put("area", area);
            if (address != null)
                jsonData.put("address", address);
            if (formId != null)
                jsonData.put("formid", formId);
            if (activityFormList != null) {
                JSONObject formData = new JSONObject();
                for (ActivityForm activityForm : activityFormList) {
                    formData.put(activityForm.getName(), activityForm.getAnswer());
                }
                jsonData.put("formdetail", formData);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> jsonResponse.optString("msg", "Success"));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityContent -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ActivityApplyCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ApplyActivityAPI addActivityApplyCallBack(ApplyActivityAPI.ActivityApplyCallBack activityApplyCallBack) {
        kzingCallBackList.add(activityApplyCallBack);
        return this;
    }

    /**
     * @param actid From {@link com.kzingsdk.entity.ActivityItem} returned by {@link GetActivityListAPI}
     */
    public ApplyActivityAPI setParamActid(String actid) {
        this.actid = actid;
        return this;
    }

    public ApplyActivityAPI setParamGiftId(String giftId) {
        this.giftId = giftId;
        return this;
    }

    public ApplyActivityAPI setParamReceipient(String receipient) {
        this.receipient = receipient;
        return this;
    }

    public ApplyActivityAPI setParamPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ApplyActivityAPI setParamArea(String area) {
        this.area = area;
        return this;
    }

    public ApplyActivityAPI setParamAddress(String address) {
        this.address = address;
        return this;
    }

    public ApplyActivityAPI setParamFormId(String formId) {
        this.formId = formId;
        return this;
    }

    public ApplyActivityAPI setActivityFormList(ArrayList<ActivityForm> activityFormList) {
        this.activityFormList = activityFormList;
        return this;
    }

    public interface ActivityApplyCallBack extends KzingCallBack {
        void onSuccess();
    }
}
