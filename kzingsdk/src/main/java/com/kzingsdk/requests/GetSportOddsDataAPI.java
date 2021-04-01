package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SportOddsData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;


public class GetSportOddsDataAPI extends CoreRequest {

    GetSportOddsDataAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        return super.generateParamsJson();
    }


    @Override
    protected String getAction() {
        return Action.getSportOddsData;
    }


    @Override
    public Observable<ArrayList<SportOddsData>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<SportOddsData> sportOddsDataList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("oddsData");
                    for (int i = 0; i < response.length(); i++) {
                        sportOddsDataList.add(SportOddsData.newInstance(response.optJSONObject(i)));
                    }
                    return sportOddsDataList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(sportOddsDataList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSportOddsDataCallBack) kzingCallBack).onSuccess(sportOddsDataList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetSportOddsDataAPI addGetSportOddsDataCallBack(GetSportOddsDataCallBack getSportOddsDataCallBack) {
        kzingCallBackList.add(getSportOddsDataCallBack);
        return this;
    }

    public interface GetSportOddsDataCallBack extends KzingCallBack {
        void onSuccess(ArrayList<SportOddsData> sportOddsDataList);
    }
}
