package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RewardTransHistory;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;

public class GetRewardTransHistoryAPI extends CoreRequest {

    private Integer pageCount = 10;
    private Integer offset = 0;
    private Calendar startDateCalendar, endDateCalendar;

    GetRewardTransHistoryAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getRewardTransHistory;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("pagecount", pageCount);
            jsonData.put("offset", offset);
            jsonData.put("start", startDateCalendar.getTime().getTime() / 1000);
            jsonData.put("end", endDateCalendar.getTime().getTime() / 1000);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<RewardTransHistory>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<RewardTransHistory> lists = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            if (response != null)
                for (int i = 0; i < response.length(); i++) {
                    lists.add(RewardTransHistory.newInstance(response.optJSONObject(i)));
                }
            return lists;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(rewardTransHistoryList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRewardTransHistoryCallBack) kzingCallBack).onSuccess(rewardTransHistoryList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRewardTransHistoryAPI addGetRewardTransHistoryCallBack(GetRewardTransHistoryCallBack getRewardTransHistoryCallBack) {
        kzingCallBackList.add(getRewardTransHistoryCallBack);
        return this;
    }

    public interface GetRewardTransHistoryCallBack extends KzingCallBack {
        void onSuccess(ArrayList<RewardTransHistory> rewardTransHistoryList);
    }

    public GetRewardTransHistoryAPI setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public GetRewardTransHistoryAPI setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public GetRewardTransHistoryAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetRewardTransHistoryAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }
}

