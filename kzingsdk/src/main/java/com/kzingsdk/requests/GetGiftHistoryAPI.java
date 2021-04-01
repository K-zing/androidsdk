package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GiftHistory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;

public class GetGiftHistoryAPI extends CoreRequest {

    private Calendar startDateCalendar, endDateCalendar;

    @Override
    protected String getAction() {
        return Action.getGiftHistory;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (startDateCalendar != null) {
                jsonData.put("start", startDateCalendar.getTime().getTime() / 1000);
            }
            if (endDateCalendar != null) {
                jsonData.put("end", endDateCalendar.getTime().getTime() / 1000);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<GiftHistory>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<GiftHistory> giftHistoryArrayList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("response");
                    for (int i = 0; i < response.length(); i++) {
                        giftHistoryArrayList.add(GiftHistory.newInstance(response.optJSONObject(i)));
                    }
                    return giftHistoryArrayList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(giftHistoryArrayList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetGiftHistoryCallBack) kzingCallBack).onSuccess(giftHistoryArrayList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetGiftHistoryAPI addGetGiftHistoryCallBack(GetGiftHistoryCallBack getGiftHistoryCallBack) {
        kzingCallBackList.add(getGiftHistoryCallBack);
        return this;
    }

    public interface GetGiftHistoryCallBack extends KzingCallBack {
        void onSuccess(ArrayList<GiftHistory> giftHistoryArrayList);
    }

    public GetGiftHistoryAPI setParamStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public GetGiftHistoryAPI setParamEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

}
