package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetMessageListResult;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import io.reactivex.Observable;


public class GetMessageListAPI extends CoreRequest {

    private Integer pageCount = 10;
    private Integer offset = 0;
    private Calendar startDateCalendar, endDateCalendar;
    GetMessageListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getMessageList;
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
    public Observable<GetMessageListResult> requestRx(Context context) {
        return super.baseExecute(context)
                .map(GetMessageListResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(messageList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMessageListCallBack) kzingCallBack).onSuccess(messageList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMessageListAPI addGetMessageListCallBack(GetMessageListCallBack getMessageListCallBack) {
        kzingCallBackList.add(getMessageListCallBack);
        return this;
    }

    /**
     * @param startDateCalendar Start date of records search.
     */
    public GetMessageListAPI setParamStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    /**
     * @param endDateCalendar End date of records search.
     */
    public GetMessageListAPI setParamEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    /**
     * @param offset Number of record to offset.
     */
    public GetMessageListAPI setParamOffset(int offset) {
        this.offset = offset;
        return this;
    }

    /**
     * @param pageCount Number of record to show..
     */
    public GetMessageListAPI setParamPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public interface GetMessageListCallBack extends KzingCallBack {
        void onSuccess(GetMessageListResult messageList);
    }


}
