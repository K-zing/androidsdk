package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.AllRewardVip;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetAllRewardVipAPI extends CoreRequest {

    GetAllRewardVipAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getAllRewardVip;
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
    public Observable<ArrayList<AllRewardVip>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<AllRewardVip> lists = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            for (int i = 0; i < response.length(); i++) {
                lists.add(AllRewardVip.newInstance(response.optJSONObject(i)));
            }
            return lists;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetAllRewardVipCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetAllRewardVipAPI addGetAllRewardVipCallBack(GetAllRewardVipCallBack getAllRewardVipCallBack) {
        kzingCallBackList.add(getAllRewardVipCallBack);
        return this;
    }

    public interface GetAllRewardVipCallBack extends KzingCallBack {
        void onSuccess(ArrayList<AllRewardVip> result);
    }
}

