package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.AgentHistoryResult;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import io.reactivex.Observable;

public class GetAgentPlayerHistoryAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.getAgentPlayerHistory;
    }

    GetAgentPlayerHistoryAPI() {
        super();
    }

    private Calendar startDateCalendar, endDateCalendar;
    private Integer currentIndex = 1; //  (Starting from: 1)

    @Override
    protected Observable<String> validateParams() {
        if (currentIndex == null) {
            return Observable.just("CurrentIndex cannot be null");
        }
        if (startDateCalendar == null) {
            return Observable.just("Start date is missing");
        }
        if (endDateCalendar == null) {
            return Observable.just("End date is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("curIndex", currentIndex);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<AgentHistoryResult> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse ->
                AgentHistoryResult.newInstance(jsonResponse));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(agentHistoryResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetAgentPlayerHistoryCallBack) kzingCallBack).onSuccess(agentHistoryResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetAgentPlayerHistoryAPI addGetAgentPlayerHistoryCallBack(GetAgentPlayerHistoryCallBack getAgentPlayerHistoryCallBack) {
        kzingCallBackList.add(getAgentPlayerHistoryCallBack);
        return this;
    }

    public interface GetAgentPlayerHistoryCallBack extends KzingCallBack {
        void onSuccess(AgentHistoryResult agentHistoryResult);
    }


    public GetAgentPlayerHistoryAPI setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
        return this;
    }

    public GetAgentPlayerHistoryAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetAgentPlayerHistoryAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }


}

