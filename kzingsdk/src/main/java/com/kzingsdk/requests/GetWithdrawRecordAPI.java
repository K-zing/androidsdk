package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.WithdrawRecord;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;


public class GetWithdrawRecordAPI extends CoreRequest implements RequireCurrency {

    GetWithdrawRecordAPI() {
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
            jsonData.put("type", "W");
            jsonData.put("pageCount", pageCount);
            jsonData.put("offset", offset);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    protected String getAction() {
        return Action.getWHistoryList;
    }

    private Integer pageCount = 10;
    private Integer offset = 0;
    private Calendar startDateCalendar, endDateCalendar;
    private String currency;

    @Override
    public Observable<ArrayList<WithdrawRecord>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<WithdrawRecord> withdrawRecordList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("response");
                    for (int i = 0; i < response.length(); i++) {
                        withdrawRecordList.add(WithdrawRecord.newInstance(response.optJSONObject(i)));
                    }
                    return withdrawRecordList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(withdrawRecordList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetWithdrawRecordCallBack) kzingCallBack).onSuccess(withdrawRecordList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetWithdrawRecordAPI addGetWithdrawRecordCallBack(GetWithdrawRecordCallBack getWithdrawRecordCallBack) {
        kzingCallBackList.add(getWithdrawRecordCallBack);
        return this;
    }

    public interface GetWithdrawRecordCallBack extends KzingCallBack {
        void onSuccess(ArrayList<WithdrawRecord> withdrawRecordList);
    }

    /**
     * @param startDateCalendar Start date of records search.
     */
    public GetWithdrawRecordAPI setParamStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    /**
     * @param endDateCalendar End date of records search.
     */
    public GetWithdrawRecordAPI setParamEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    /**
     * @param offset Number of record to offset.
     */
    public GetWithdrawRecordAPI setParamOffset(int offset) {
        this.offset = offset;
        return this;
    }

    /**
     * @param pageCount Number of record to show..
     */
    public GetWithdrawRecordAPI setParamPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public GetWithdrawRecordAPI setParamCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

}
