package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ActivityItem;
import com.kzingsdk.entity.Banner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetBannersAPI extends CoreRequest {

    GetBannersAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getBanners;
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
    public Observable<ArrayList<Banner>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<Banner> bannerArrayList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    for (int i = 0; i < response.length(); i++) {
                        bannerArrayList.add(Banner.newInstance(response.optJSONObject(i)));
                    }
                    return bannerArrayList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(bannerList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetBannersCallBack) kzingCallBack).onSuccess(bannerList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetBannersAPI addGetBannersCallBack(GetBannersCallBack getBannersCallBack) {
        kzingCallBackList.add(getBannersCallBack);
        return this;
    }

    public interface GetBannersCallBack extends KzingCallBack {
        void onSuccess(ArrayList<Banner> bannerList);
    }

}
