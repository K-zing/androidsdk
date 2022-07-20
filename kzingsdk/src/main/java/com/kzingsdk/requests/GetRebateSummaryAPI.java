package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RebateSummary;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetRebateSummaryAPI extends CoreRequest {

    private String type;
    private String start;
    private String end;
    private String currency;

    @Override
    protected String getAction() {
        return Action.getRebateSummary;
    }

    GetRebateSummaryAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("type", type);
            jsonData.put("start", start);
            jsonData.put("end", end);
            jsonData.put("currency", currency);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<RebateSummary> requestRx(final Context context) {
        return super.baseExecute(context).map(RebateSummary::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(rebateSummary -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRebateSummaryCallBack) kzingCallBack).onSuccess(rebateSummary);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRebateSummaryAPI addGetRebateSummaryCallBack(GetRebateSummaryCallBack getRebateSummaryCallBack) {
        kzingCallBackList.add(getRebateSummaryCallBack);
        return this;
    }

    public interface GetRebateSummaryCallBack extends KzingCallBack {
        void onSuccess(RebateSummary rebateSummary);
    }

    public String getType() {
        return type;
    }

    public GetRebateSummaryAPI setType(String type) {
        this.type = type;
        return this;
    }

    public String getStart() {
        return start;
    }

    public GetRebateSummaryAPI setStart(String start) {
        this.start = start;
        return this;
    }

    public String getEnd() {
        return end;
    }

    public GetRebateSummaryAPI setEnd(String end) {
        this.end = end;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public GetRebateSummaryAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }


}

