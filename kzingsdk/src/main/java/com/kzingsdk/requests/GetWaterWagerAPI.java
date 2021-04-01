package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.WaterWager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetWaterWagerAPI extends CoreRequest {


    @Override
    protected String getAction() {
        return Action.getWaterWager;
    }

    @Override
    protected JSONObject generateParamsJson() {
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<WaterWager>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<WaterWager> waterWagerArrayList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("total");
                    for (int i = 0; i < response.length(); i++) {
                        waterWagerArrayList.add(WaterWager.newInstance(response.optJSONObject(i)));
                    }
                    return waterWagerArrayList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(waterWagerArrayList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetWaterWagerCallBack) kzingCallBack).onSuccess(waterWagerArrayList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetWaterWagerAPI addGetWaterWagerCallBack(GetWaterWagerCallBack getWaterWagerCallBack) {
        kzingCallBackList.add(getWaterWagerCallBack);
        return this;
    }

    public interface GetWaterWagerCallBack extends KzingCallBack {
        void onSuccess(ArrayList<WaterWager> waterWagerArrayList);
    }


}
