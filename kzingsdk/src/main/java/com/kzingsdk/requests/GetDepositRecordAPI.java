package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetDepositRecordResult;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import io.reactivex.Observable;


public class GetDepositRecordAPI extends CoreRequest implements RequireCurrency {

    private Integer pageCount = 10;
    private Integer offset = 0;
    private Calendar startDateCalendar, endDateCalendar;
    private String currency;
    private String status;
    GetDepositRecordAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
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
            jsonData.put("type", "D");
            jsonData.put("pageCount", pageCount);
            jsonData.put("offset", offset);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            if (status != null)
                jsonData.put("status", status);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    protected String getAction() {
        return Action.getDHistoryList;
    }

    @Override
    public Observable<GetDepositRecordResult> requestRx(Context context) {
        return super.baseExecute(context)
                .map(GetDepositRecordResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getDepositRecordResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetDepositRecordCallBack) kzingCallBack).onSuccess(getDepositRecordResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetDepositRecordAPI addGetDepositRecordCallBack(GetDepositRecordAPI.GetDepositRecordCallBack GetDepositRecordCallBack) {
        kzingCallBackList.add(GetDepositRecordCallBack);
        return this;
    }

    /**
     * @param startDateCalendar Start date of records search.
     */
    public GetDepositRecordAPI setParamStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    /**
     * @param endDateCalendar End date of records search.
     */
    public GetDepositRecordAPI setParamEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    /**
     * @param offset Number of record to offset.
     */
    public GetDepositRecordAPI setParamOffset(int offset) {
        this.offset = offset;
        return this;
    }

    /**
     * @param pageCount Number of record to show..
     */
    public GetDepositRecordAPI setParamPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public GetDepositRecordAPI setParamCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public GetDepositRecordAPI setParamStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    public interface GetDepositRecordCallBack extends KzingCallBack {
        void onSuccess(GetDepositRecordResult getDepositRecordResult);
    }

}
