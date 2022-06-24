package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ActivityItem;
import com.kzingsdk.entity.BonusPromotion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class BonusPromotionAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.bonusPromotion;
    }

    private String gpid = "";
    private String startDate = "";
    private String endDate = "";

    BonusPromotionAPI() {
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
            jsonData.put("gpid", gpid);
            jsonData.put("startdate", startDate);
            jsonData.put("enddate", endDate);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<BonusPromotion>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<BonusPromotion> bonusPromotionList = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("activities");
            for (int i = 0; i < response.length(); i++) {
                bonusPromotionList.add(BonusPromotion.newInstance(response.optJSONObject(i)));
            }
            return bonusPromotionList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(bonusPromotionList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((BonusPromotionCallBack) kzingCallBack).onSuccess(bonusPromotionList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public BonusPromotionAPI addBonusPromotionCallBack(BonusPromotionCallBack bonusPromotionCallBack) {
        kzingCallBackList.add(bonusPromotionCallBack);
        return this;
    }

    public interface BonusPromotionCallBack extends KzingCallBack {
        void onSuccess(ArrayList<BonusPromotion> bonusPromotionList);
    }


    public String getGpid() {
        return gpid;
    }

    public BonusPromotionAPI setGpid(String gpid) {
        this.gpid = gpid;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public BonusPromotionAPI setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public BonusPromotionAPI setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }
}

