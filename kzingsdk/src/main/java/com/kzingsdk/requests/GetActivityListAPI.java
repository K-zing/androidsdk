package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ActivityItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetActivityListAPI extends CoreRequest {

    private String isDeposit;


    GetActivityListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getActivityList;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("isdeposit", isDeposit);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<ArrayList<ActivityItem>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<ActivityItem> activityItemList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("response");
                    for (int i = 0; i < response.length(); i++) {
                        activityItemList.add(ActivityItem.newInstance(response.optJSONObject(i)));
                    }
                    return activityItemList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityItemList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetActivityListCallBack) kzingCallBack).onSuccess(activityItemList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetActivityListAPI addGetActivityListCallBack(GetActivityListCallBack getActivityListCallBack) {
        kzingCallBackList.add(getActivityListCallBack);
        return this;
    }

    public GetActivityListAPI setIsDeposit(String isDeposit) {
        this.isDeposit = isDeposit;
        return this;
    }

    public interface GetActivityListCallBack extends KzingCallBack {
        void onSuccess(ArrayList<ActivityItem> activityItemList);
    }
}
