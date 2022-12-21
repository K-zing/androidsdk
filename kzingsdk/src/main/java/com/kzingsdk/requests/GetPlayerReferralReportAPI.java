package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetPlayerReferralReport;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;

public class GetPlayerReferralReportAPI extends CoreRequest {

    private Calendar startDateCalendar, endDateCalendar;
    private String currency;

    GetPlayerReferralReportAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getPlayerReferralReport;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("start", Constant.DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.DATE_FORMAT.format(endDateCalendar.getTime()));
            jsonData.put("currency", currency);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<GetPlayerReferralReport>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<GetPlayerReferralReport> lists = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            for (int i = 0; i < response.length(); i++) {
                lists.add(GetPlayerReferralReport.newInstance(response.optJSONObject(i)));
            }
            return lists;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetPlayerReferralReportCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetPlayerReferralReportAPI addGetPlayerReferralReportCallBack(GetPlayerReferralReportCallBack getPlayerReferralReportCallBack) {
        kzingCallBackList.add(getPlayerReferralReportCallBack);
        return this;
    }

    public interface GetPlayerReferralReportCallBack extends KzingCallBack {
        void onSuccess(ArrayList<GetPlayerReferralReport> result);
    }

    public GetPlayerReferralReportAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetPlayerReferralReportAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    public GetPlayerReferralReportAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}

