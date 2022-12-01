package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.GetCsHistoryResult;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import io.reactivex.Observable;

public class GetCsHistoryAPI extends BaseD11API {

    private String dno = "";
    private Integer curIndex = 1;
    private Calendar startDateCalendar = null;
    private Calendar endDateCalendar = null;
    GetCsHistoryAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getCsHistory;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("dno", dno);
            jsonData.put("curIndex", curIndex);
            if (startDateCalendar != null)
                jsonData.put("start", startDateCalendar.getTime().getTime() / 1000);
            if (endDateCalendar != null)
                jsonData.put("end", endDateCalendar.getTime().getTime() / 1000);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<GetCsHistoryResult> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    return GetCsHistoryResult.newInstance(jsonResponse.optJSONObject("data"));
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getCsHistoryResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCsHistoryCallBack) kzingCallBack).onSuccess(getCsHistoryResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCsHistoryAPI addGetCsHistoryCallBack(GetCsHistoryCallBack getCsHistoryCallBack) {
        kzingCallBackList.add(getCsHistoryCallBack);
        return this;
    }

    public GetCsHistoryAPI setDno(String dno) {
        this.dno = dno;
        return this;
    }

    public GetCsHistoryAPI setCurIndex(Integer curIndex) {
        this.curIndex = curIndex;
        return this;
    }

    public GetCsHistoryAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetCsHistoryAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    public interface GetCsHistoryCallBack extends KzingCallBack {
        void onSuccess(GetCsHistoryResult getCsHistoryResult);
    }

}
