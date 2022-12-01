package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RebateDetail;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;

public class GetRebateDetailAPI extends CoreRequest {

    private String gpid;
    private Calendar startDateCalendar;
    private Calendar endDateCalendar;
    private String currency;
    private Integer offset = 0;
    private Integer pageCount = 20;
    GetRebateDetailAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getRebateDetail;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }


    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gpid", gpid);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            jsonData.put("currency", currency);
            jsonData.put("offset", offset);
            jsonData.put("pageCount", pageCount);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<RebateDetail>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<RebateDetail> rankTierArrayList = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            if (response != null) {
                for (int i = 0; i < response.length(); i++) {
                    rankTierArrayList.add(RebateDetail.newInstance(response.optJSONObject(i)));
                }
            }
            return rankTierArrayList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(rebateDetailList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRebateDetailCallBack) kzingCallBack).onSuccess(rebateDetailList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRebateDetailAPI addGetRebateDetailCallBack(GetRebateDetailCallBack getRebateDetailCallBack) {
        kzingCallBackList.add(getRebateDetailCallBack);
        return this;
    }

    public String getGpid() {
        return gpid;
    }

    public GetRebateDetailAPI setGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }

    public GetRebateDetailAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetRebateDetailAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public GetRebateDetailAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public GetRebateDetailAPI setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public GetRebateDetailAPI setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public interface GetRebateDetailCallBack extends KzingCallBack {
        void onSuccess(ArrayList<RebateDetail> rebateDetailList);
    }
}

