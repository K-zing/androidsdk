package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.TransferRecord;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;



public class GetTransferRecordAPI extends CoreRequest {


    GetTransferRecordAPI() {
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
            jsonData.put("type","T");
            jsonData.put("pageCount",pageCount);
            jsonData.put("offset",offset);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end",Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    protected String getAction() {
        return Action.getTHistoryList;
    }

    private Integer pageCount = 10;
    private Integer offset = 0;
    private Calendar startDateCalendar,endDateCalendar;

    @Override
    public Observable<ArrayList<TransferRecord>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<TransferRecord> transferRecordList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("response");
                    for (int i = 0; i < response.length(); i++) {
                        transferRecordList.add(TransferRecord.newInstance(response.optJSONObject(i)));
                    }
                    return transferRecordList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(transferRecords -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetTransferRecordCallBack) kzingCallBack).onSuccess(transferRecords);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetTransferRecordAPI addGetDepositRecordCallBack(GetTransferRecordCallBack getTransferRecordCallBack){
        kzingCallBackList.add(getTransferRecordCallBack);
        return this;
    }

    public interface GetTransferRecordCallBack extends KzingCallBack{
        void onSuccess(ArrayList<TransferRecord> transferRecordList);
    }

    /**
     * @param startDateCalendar Start date of records search.
     */
    public GetTransferRecordAPI setParamStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    /**
     * @param endDateCalendar End date of records search.
     */
    public GetTransferRecordAPI setParamEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }
    /**
     * @param offset Number of record to offset.
     */
    public GetTransferRecordAPI setParamOffset(int offset) {
        this.offset = offset;
        return this;
    }

    /**
     * @param pageCount Number of record to show..
     */
    public GetTransferRecordAPI setParamPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }



}
