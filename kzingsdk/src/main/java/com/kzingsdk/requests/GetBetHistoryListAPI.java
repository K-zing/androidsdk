package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.HistoryListSummary;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public class GetBetHistoryListAPI extends CoreRequest implements RequireCurrency {

    public static final String ALL = "10000";

    private String gpid = ALL;
    private Integer page = 1;
    private String currency;
    private String gpType;
    private Calendar startDateCalendar, endDateCalendar;

    GetBetHistoryListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getBetHistoryList;
    }

    @Override
    protected Observable<String> validateParams() {
        if (page == null) {
            return Observable.just("Page cannot be null");
        }
        if (gpid == null) {
            return Observable.just("GPID cannot be null");
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
            jsonData.put("page", page);
            jsonData.put("realgpid", gpid);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            jsonData.put("startTime", Constant.TIME_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("endTime", Constant.TIME_FORMAT.format(endDateCalendar.getTime()));
            jsonData.put("gptype", gpType);
            if (currency != null)
                jsonData.put("currency", currency);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<HistoryListSummary> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> HistoryListSummary.newInstance(jsonResponse.optJSONObject("response")));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(historyListSummary -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetBetHistoryListCallBack) kzingCallBack).onSuccess(historyListSummary);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetBetHistoryListAPI addGetBetHistoryListCallBack(GetBetHistoryListCallBack getBetHistoryListCallBack) {
        kzingCallBackList.add(getBetHistoryListCallBack);
        return this;
    }

    public GetBetHistoryListAPI setParamGpId(String gpId) {
        if (gpId.equals(ALL)) {
            this.gpid = "10000";
        } else
            this.gpid = gpId;
        return this;
    }

    /**
     * @param page Currently forced to show maximum 20 record once. Start from 1.
     */
    public GetBetHistoryListAPI setParamPage(@NonNull Integer page) {
        if (page < 1) {
            page = 1;
        }
        this.page = page;
        return this;
    }

    /**
     * @param startDateCalendar Start date of records search.
     */
    public GetBetHistoryListAPI setParamStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    /**
     * @param endDateCalendar End date of records search.
     */
    public GetBetHistoryListAPI setParamEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    public GetBetHistoryListAPI setParamCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public GetBetHistoryListAPI setGpType(String gpType) {
        this.gpType = gpType;
        return this;
    }

    public interface GetBetHistoryListCallBack extends KzingCallBack {
        void onSuccess(HistoryListSummary historyListSummary);
    }
}
