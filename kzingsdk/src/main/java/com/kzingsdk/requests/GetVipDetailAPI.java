package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.VipDetail;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;


public class GetVipDetailAPI extends CoreRequest {

    private String currency;

    GetVipDetailAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getVipDetail;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("currency", currency);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<VipDetail> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> VipDetail.newInstance(jsonResponse.optJSONObject("response")));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(vipDetail -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetVipDetailCallBack) kzingCallBack).onSuccess(vipDetail);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetVipDetailAPI addGetVipDetailCallBack(GetVipDetailAPI.GetVipDetailCallBack getVipDetailCallBack) {
        kzingCallBackList.add(getVipDetailCallBack);
        return this;
    }

    public interface GetVipDetailCallBack extends KzingCallBack {
        void onSuccess(VipDetail vipDetail);
    }

    public GetVipDetailAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
