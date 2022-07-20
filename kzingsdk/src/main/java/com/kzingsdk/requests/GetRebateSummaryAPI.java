package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RebateSummary;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import io.reactivex.Observable;

public class GetRebateSummaryAPI extends CoreRequest {

    private String type;
    private Calendar startDateCalendar;
    private Calendar endDateCalendar;
    private String currency;

    @Override
    protected String getAction() {
        return Action.getRebateSummary;
    }

    GetRebateSummaryAPI() {
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
            jsonData.put("type", type);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            jsonData.put("currency", currency);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<RebateSummary> requestRx(final Context context) {
        return super.baseExecute(context).map(RebateSummary::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(rebateSummary -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRebateSummaryCallBack) kzingCallBack).onSuccess(rebateSummary);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRebateSummaryAPI addGetRebateSummaryCallBack(GetRebateSummaryCallBack getRebateSummaryCallBack) {
        kzingCallBackList.add(getRebateSummaryCallBack);
        return this;
    }

    public interface GetRebateSummaryCallBack extends KzingCallBack {
        void onSuccess(RebateSummary rebateSummary);
    }

    public String getType() {
        return type;
    }

    public GetRebateSummaryAPI setType(String type) {
        this.type = type;
        return this;
    }

    public GetRebateSummaryAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetRebateSummaryAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public GetRebateSummaryAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }


}

