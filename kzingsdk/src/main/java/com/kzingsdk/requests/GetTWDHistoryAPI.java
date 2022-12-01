package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetTWDHistoryResult;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import io.reactivex.Observable;

public class GetTWDHistoryAPI extends CoreRequest {

    private Integer pageCount = 10;
    private Integer offset = 0;
    private String status;
    private String type;
    private Calendar startDateCalendar, endDateCalendar;

    GetTWDHistoryAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getTWDHistory;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("pageCount", pageCount);
            jsonData.put("offset", offset);
            jsonData.put("status", status);
            jsonData.put("type", type);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<GetTWDHistoryResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetTWDHistoryResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetTWDHistoryCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetTWDHistoryAPI addGetTWDHistoryCallBack(GetTWDHistoryCallBack getTWDHistoryCallBack) {
        kzingCallBackList.add(getTWDHistoryCallBack);
        return this;
    }

    public GetTWDHistoryAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetTWDHistoryAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    public GetTWDHistoryAPI setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public GetTWDHistoryAPI setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public GetTWDHistoryAPI setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public GetTWDHistoryAPI setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public GetTWDHistoryAPI setStatus(String status) {
        this.status = status;
        return this;
    }

    public GetTWDHistoryAPI setType(String type) {
        this.type = type;
        return this;
    }

    public interface GetTWDHistoryCallBack extends KzingCallBack {
        void onSuccess(GetTWDHistoryResult simpleApiResult);
    }
}

