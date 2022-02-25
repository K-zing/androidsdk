package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RakebackRedeemHistory;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;

public class GetRakebackRedeemHistoryAPI extends CoreRequest {

    private Integer pageCount = 10;
    private Integer offset = 0;
    private Calendar startDateCalendar, endDateCalendar;
    private String gpid;
    private String currency;

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
            jsonData.put("pagecount", pageCount);
            jsonData.put("offset", offset);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<RakebackRedeemHistory>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<RakebackRedeemHistory> history = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            for (int i = 0; i < response.length(); i++) {
                history.add(RakebackRedeemHistory.newInstance(response.optJSONObject(i)));
            }
            return history;
        });
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

    public interface GetRakebackRedeemHistoryCallBack extends KzingCallBack {
        void onSuccess(ArrayList<RakebackRedeemHistory> activityHistory);
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


}

