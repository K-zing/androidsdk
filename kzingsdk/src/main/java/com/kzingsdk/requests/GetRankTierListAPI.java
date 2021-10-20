package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.D11.QuestQuestion;
import com.kzingsdk.entity.RankTier;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetRankTierListAPI extends CoreRequest implements RequireCurrency {

    GetRankTierListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getRankTierList;
    }


    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    public Observable<ArrayList<RankTier>> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<RankTier> rankTierArrayList = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("response");
            if (response != null) {
                for (int i = 0; i < response.length(); i++) {
                    rankTierArrayList.add(RankTier.newInstance(response.optJSONObject(i)));
                }
            }
            return rankTierArrayList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(rankTierList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRankTierListCallBack) kzingCallBack).onSuccess(rankTierList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRankTierListAPI addGetRankTierListCallBack(GetRankTierListCallBack getRankTierListCallBack) {
        kzingCallBackList.add(getRankTierListCallBack);
        return this;
    }

    private String currency;

    @Override
    public String getCurrency() {
        return currency;
    }

    public interface GetRankTierListCallBack extends KzingCallBack {
        void onSuccess(ArrayList<RankTier> rankTierList);
    }

    public GetRankTierListAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

}
