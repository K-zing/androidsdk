package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ActivityHistory;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;

public class GetActivityHistoryAPI extends CoreRequest {

    private Integer pageCount = 10;
    private Integer offset = 0;
    private String status;
    private Calendar startDateCalendar, endDateCalendar;

    GetActivityHistoryAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getActivityHistory;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("pagecount", pageCount);
            jsonData.put("offset", offset);
            jsonData.put("status", status);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<ActivityHistory>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<ActivityHistory> actHistories = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            for (int i = 0; i < response.length(); i++) {
                actHistories.add(ActivityHistory.newInstance(response.optJSONObject(i)));
            }
            return actHistories;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityHistory -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetActivityHistoryCallBack) kzingCallBack).onSuccess(activityHistory);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetActivityHistoryAPI addGetActivityHistoryCallBack(GetActivityHistoryCallBack getActivityHistoryCallBack) {
        kzingCallBackList.add(getActivityHistoryCallBack);
        return this;
    }

    public GetActivityHistoryAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetActivityHistoryAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    public GetActivityHistoryAPI setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public GetActivityHistoryAPI setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public GetActivityHistoryAPI setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public GetActivityHistoryAPI setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public GetActivityHistoryAPI setStatus(String status) {
        this.status = status;
        return this;
    }


    public interface GetActivityHistoryCallBack extends KzingCallBack {
        void onSuccess(ArrayList<ActivityHistory> activityHistory);
    }

}

