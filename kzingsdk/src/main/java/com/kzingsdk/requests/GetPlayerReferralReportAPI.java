package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetPlayerReferralReport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetPlayerReferralReportAPI extends CoreRequest {

    private String start;
    private String end;
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
            jsonData.put("start", start);
            jsonData.put("end", end);
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

    public GetPlayerReferralReportAPI setStart(String start) {
        this.start = start;
        return this;
    }

    public GetPlayerReferralReportAPI setEnd(String end) {
        this.end = end;
        return this;
    }

    public GetPlayerReferralReportAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}

