package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.BonusReturn;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;

public class GetBounsListAPI extends CoreRequest {

    public GetBounsListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getBonusList;
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

    private int offset = 0;
    private int pageCount = 100;
    private Calendar startDateCalendar,endDateCalendar;

    @Override
    protected JSONObject generateParamsJson(){
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("offset", offset);
            jsonData.put("pageCount",pageCount);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end",Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<BonusReturn>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<BonusReturn> bonusReturnList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("response");
                    for (int i = 0; i < response.length(); i++) {
                        bonusReturnList.add(BonusReturn.newInstance(response.optJSONObject(i)));
                    }
                    return bonusReturnList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(bonusReturnList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetBounsListCallBack) kzingCallBack).onSuccess(bonusReturnList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetBounsListAPI addGetBounsListCallBack(GetBounsListAPI.GetBounsListCallBack GetBounsListCallBack){
        kzingCallBackList.add(GetBounsListCallBack);
        return this;
    }

    public interface GetBounsListCallBack extends KzingCallBack{
        void onSuccess(ArrayList<BonusReturn> bonusReturnList);
    }

    /**
     * @param startDateCalendar Start date of records search.
     */
    public GetBounsListAPI setParamStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    /**
     * @param endDateCalendar End date of records search.
     */
    public GetBounsListAPI setParamEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    /**
     * @param offset Number of record to offset.
     */
    public GetBounsListAPI setParamOffset(int offset) {
        this.offset = offset;
        return this;
    }

    /**
     * @param pageCount Number of record to show..
     */
    public GetBounsListAPI setParamPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }



}
