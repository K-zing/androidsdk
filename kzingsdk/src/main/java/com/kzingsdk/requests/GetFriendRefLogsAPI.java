package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetFriendRefLogResult;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashSet;

import io.reactivex.Observable;

public class GetFriendRefLogsAPI extends CoreRequest {

    private HashSet<Integer> statusSet = new HashSet<>();
    private int page = 1;
    private Calendar startDateCalendar, endDateCalendar;

    GetFriendRefLogsAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getFriendRefLogs;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            //default 7 days
            if (startDateCalendar != null && endDateCalendar != null) {
                jsonData.put("start", Constant.DATE_FORMAT.format(startDateCalendar.getTime()));
                jsonData.put("end", Constant.DATE_FORMAT.format(endDateCalendar.getTime()));
            }
            if (statusSet != null && !statusSet.isEmpty()) {
                String statusString = "";
                for (Integer status : statusSet) {
                    statusString += status + ",";
                }
                statusString = statusString.substring(0, statusString.length() - 1);
                jsonData.put("status", statusString);
            }
            jsonData.put("page", page);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<GetFriendRefLogResult> requestRx(Context context) {
        return super.baseExecute(context)
                .map(GetFriendRefLogResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getFriendRefLogResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetFriendRefLogsCallBack) kzingCallBack).onSuccess(getFriendRefLogResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetFriendRefLogsAPI addGetFriendRefLogsCallBack(GetFriendRefLogsCallBack getFriendRefLogsCallBack) {
        kzingCallBackList.add(getFriendRefLogsCallBack);
        return this;
    }

    public GetFriendRefLogsAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetFriendRefLogsAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    public GetFriendRefLogsAPI setPage(int page) {
        this.page = Math.max(page, 1);
        return this;
    }

    public GetFriendRefLogsAPI addStatus(Integer status) {
        this.statusSet.add(status);
        return this;
    }


    public interface GetFriendRefLogsCallBack extends KzingCallBack {
        void onSuccess(GetFriendRefLogResult getFriendRefLogResult);
    }


}
