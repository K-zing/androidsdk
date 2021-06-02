package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.agency.AgentWithdrawal;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;

public class GetMemberAgentWithdrawalAPI extends CoreRequest {

    private Integer currentIndex = 1; //  (Starting from: 1)
    private Calendar startDateCalendar, endDateCalendar;

    @Override
    protected String getAction() {
        return Action.getMemberAgentWithdrawal;
    }

    GetMemberAgentWithdrawalAPI() {
        super();
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
            jsonData.put("curIndex", currentIndex);
            jsonData.put("start", Constant.DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.DATE_FORMAT.format(endDateCalendar.getTime()));
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<AgentWithdrawal>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<AgentWithdrawal> agentDownlineList = new ArrayList<>();
            JSONArray dataArray = jsonResponse.optJSONArray("data");
            if (dataArray != null && dataArray.length() > 0) {
                for (int i = 0; i < dataArray.length(); i++) {
                    agentDownlineList.add(AgentWithdrawal.newInstance(dataArray.optJSONObject(i)));
                }
            }
            return agentDownlineList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(agentWithdrawalList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMemberAgentWithdrawalCallBack) kzingCallBack).onSuccess(agentWithdrawalList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMemberAgentWithdrawalAPI addGetMemberAgentWithdrawalCallBack(GetMemberAgentWithdrawalCallBack getMemberAgentWithdrawalCallBack) {
        kzingCallBackList.add(getMemberAgentWithdrawalCallBack);
        return this;
    }

    public interface GetMemberAgentWithdrawalCallBack extends KzingCallBack {
        void onSuccess(ArrayList<AgentWithdrawal> agentWithdrawalList);
    }

    public GetMemberAgentWithdrawalAPI setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
        return this;
    }

    public GetMemberAgentWithdrawalAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetMemberAgentWithdrawalAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

}

