package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.DepositRecord;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;


public class GetDepositRecordAPI extends CoreRequest {

    GetDepositRecordAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        if(startDateCalendar == null){
            return Observable.just("Start date is missing");
        }
        if(endDateCalendar == null){
            return Observable.just("End date is missing");
        }
        return super.validateParams();
    }
    @Override
    protected JSONObject generateParamsJson(){
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("type","D");
            jsonData.put("pageCount",pageCount);
            jsonData.put("offset",offset);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end",Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            if (currency != null) {
                jsonData.put("currency", currency);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    protected String getAction() {
        return Action.getDHistoryList;
    }

    private Integer pageCount = 10;
    private Integer offset = 0;
    private Calendar startDateCalendar,endDateCalendar;
    private String currency;

    @Override
    public Observable<ArrayList<DepositRecord>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<DepositRecord> depositRecordList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("response");
                    for (int i = 0; i < response.length(); i++) {
                        depositRecordList.add(DepositRecord.newInstance(response.optJSONObject(i)));
                    }
                    return depositRecordList;
                });
    }
    @Override
    public void request(Context context) {
        requestRx(context).subscribe(depositRecordList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetDepositRecordCallBack) kzingCallBack).onSuccess(depositRecordList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetDepositRecordAPI addGetDepositRecordCallBack(GetDepositRecordAPI.GetDepositRecordCallBack GetDepositRecordCallBack){
        kzingCallBackList.add(GetDepositRecordCallBack);
        return this;
    }

    public interface GetDepositRecordCallBack extends KzingCallBack{
        void onSuccess(ArrayList<DepositRecord> depositRecordList);
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



}
