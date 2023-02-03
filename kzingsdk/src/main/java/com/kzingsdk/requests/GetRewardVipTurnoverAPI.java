package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetRewardVipTurnoverResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetRewardVipTurnoverAPI extends CoreRequest {

    private String vipId;

    GetRewardVipTurnoverAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getRewardVipTurnover;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("vipid", vipId);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<ArrayList<GetRewardVipTurnoverResult>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<GetRewardVipTurnoverResult> lists = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            if (response != null)
                for (int i = 0; i < response.length(); i++) {
                    lists.add(GetRewardVipTurnoverResult.newInstance(response.optJSONObject(i)));
                }
            return lists;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRewardVipTurnoverCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRewardVipTurnoverAPI addGetRewardVipTurnoverCallBack(GetRewardVipTurnoverCallBack getRewardVipTurnoverCallBack) {
        kzingCallBackList.add(getRewardVipTurnoverCallBack);
        return this;
    }

    public GetRewardVipTurnoverAPI setVipId(String vipId) {
        this.vipId = vipId;
        return this;
    }

    public interface GetRewardVipTurnoverCallBack extends KzingCallBack {
        void onSuccess(ArrayList<GetRewardVipTurnoverResult> result);
    }
}

