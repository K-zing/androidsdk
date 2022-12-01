package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RakebackRedeemHistoryResult;
import com.kzingsdk.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import io.reactivex.Observable;

public class GetRakebackRedeemHistoryAPI extends CoreRequest {

    private Integer pageCount = 10;
    private Integer offset = 0;
    private Calendar startDateCalendar, endDateCalendar;
    private String gpid;
    private String currency;
    private String gpType;

    GetRakebackRedeemHistoryAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getRakebackRedeemHistory;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gpid", gpid);
            jsonData.put("currency", currency);
            jsonData.put("pageCount", pageCount);
            jsonData.put("offset", offset);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            if (gpType != null) {
                jsonData.put("gptype", gpType);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<RakebackRedeemHistoryResult> requestRx(final Context context) {
        return super.baseExecute(context).map(RakebackRedeemHistoryResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityHistory -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRakebackRedeemHistoryCallBack) kzingCallBack).onSuccess(activityHistory);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRakebackRedeemHistoryAPI addGetRakebackRedeemHistoryCallBack(GetRakebackRedeemHistoryCallBack getRakebackRedeemHistoryCallBack) {
        kzingCallBackList.add(getRakebackRedeemHistoryCallBack);
        return this;
    }

    public GetRakebackRedeemHistoryAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetRakebackRedeemHistoryAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    public GetRakebackRedeemHistoryAPI setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public GetRakebackRedeemHistoryAPI setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public GetRakebackRedeemHistoryAPI setGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }

    public GetRakebackRedeemHistoryAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public GetRakebackRedeemHistoryAPI setGpType(String gpType) {
        this.gpType = gpType;
        return this;
    }

    public interface GetRakebackRedeemHistoryCallBack extends KzingCallBack {
        void onSuccess(RakebackRedeemHistoryResult rakebackRedeemHistoryResult);
    }

}

