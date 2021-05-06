package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.agency.AgentCommissionSummary;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;

public class GetMemberAgentSalesHistoryAPI extends CoreRequest {

    private String playerName = "";
    private Integer currentIndex = 1; //  (Starting from: 1)
    private Calendar startDateCalendar, endDateCalendar;

    @Override
    protected String getAction() {
        return Action.getMemberAgentSalesHistory;
    }

    GetMemberAgentSalesHistoryAPI() {
        super();
    }


    @Override
    protected Observable<String> validateParams() {
        if (currentIndex == null) {
            return Observable.just("CurrentIndex cannot be null");
        }
        if (playerName == null) {
            return Observable.just("PlayerName cannot be null");
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
            jsonData.put("playername", playerName);
            jsonData.put("curIndex", currentIndex);
            jsonData.put("start", Constant.DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.DATE_FORMAT.format(endDateCalendar.getTime()));
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<AgentCommissionSummary>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<AgentCommissionSummary> agentDownlineList = new ArrayList<>();
            JSONArray dataArray = jsonResponse.optJSONArray("data");
            if (dataArray != null && dataArray.length() > 0) {
                for (int i = 0; i < dataArray.length(); i++) {
                    agentDownlineList.add(AgentCommissionSummary.newInstance(dataArray.optJSONObject(i)));
                }
            }
            return agentDownlineList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(agentCommissionSummaryList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMemberAgentSalesHistoryCallBack) kzingCallBack).onSuccess(agentCommissionSummaryList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMemberAgentSalesHistoryAPI addGetMemberAgentSalesHistoryCallBack(GetMemberAgentSalesHistoryCallBack getMemberAgentSalesHistoryCallBack) {
        kzingCallBackList.add(getMemberAgentSalesHistoryCallBack);
        return this;
    }

    public interface GetMemberAgentSalesHistoryCallBack extends KzingCallBack {
        void onSuccess(ArrayList<AgentCommissionSummary> agentCommissionSummaryList);
    }

    public GetMemberAgentSalesHistoryAPI setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
        return this;
    }

    public GetMemberAgentSalesHistoryAPI setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public GetMemberAgentSalesHistoryAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetMemberAgentSalesHistoryAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

}

