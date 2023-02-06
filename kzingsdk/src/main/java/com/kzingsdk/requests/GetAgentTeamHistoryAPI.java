package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.AgentHistoryResult;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import io.reactivex.Observable;

public class GetAgentTeamHistoryAPI extends CoreRequest {

    private Calendar startDateCalendar, endDateCalendar;
    private Integer currentIndex = 1; //  (Starting from: 1)
    private String agent;

    GetAgentTeamHistoryAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getAgentTeamHistory;
    }

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
            jsonData.put("agent", agent);
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
                    ((GetAgentTeamHistoryCallBack) kzingCallBack).onSuccess(agentHistoryResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetAgentTeamHistoryAPI addGetAgentTeamHistoryCallBack(GetAgentTeamHistoryCallBack getAgentTeamHistoryCallBack) {
        kzingCallBackList.add(getAgentTeamHistoryCallBack);
        return this;
    }

    public GetAgentTeamHistoryAPI setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
        return this;
    }

    public GetAgentTeamHistoryAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetAgentTeamHistoryAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    public GetAgentTeamHistoryAPI setAgent(String agent) {
        this.agent = agent;
        return this;
    }

    public interface GetAgentTeamHistoryCallBack extends KzingCallBack {
        void onSuccess(AgentHistoryResult agentHistoryResult);
    }
}

