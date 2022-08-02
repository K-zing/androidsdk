package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.BetHistorySummary;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import io.reactivex.Observable;

public class GetBetHistorySummaryAPI extends CoreRequest {

    private Calendar startDateCalendar;
    private Calendar endDateCalendar;
    private String currency;
    private String gpType;

    @Override
    protected String getAction() {
        return Action.getBetHistorySummary;
    }

    GetBetHistorySummaryAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            jsonData.put("currency", currency);
            jsonData.put("gptype", gpType);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<BetHistorySummary> requestRx(final Context context) {
        return super.baseExecute(context).map(BetHistorySummary::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(rebateSummary -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetBetHistorySummaryCallBack) kzingCallBack).onSuccess(rebateSummary);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetBetHistorySummaryAPI addGetBetHistorySummaryCallBack(GetBetHistorySummaryCallBack getBetHistorySummaryCallBack) {
        kzingCallBackList.add(getBetHistorySummaryCallBack);
        return this;
    }

    public interface GetBetHistorySummaryCallBack extends KzingCallBack {
        void onSuccess(BetHistorySummary betHistorySummary);
    }

    public GetBetHistorySummaryAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetBetHistorySummaryAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public GetBetHistorySummaryAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }


}

