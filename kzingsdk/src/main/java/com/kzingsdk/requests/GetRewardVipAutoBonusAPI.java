package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetRewardVipAutoBonusResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetRewardVipAutoBonusAPI extends CoreRequest {

    private String bonusType;
    private String currency;

    GetRewardVipAutoBonusAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getRewardVipAutoBonus;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("bonustype", bonusType);
            jsonData.put("currency", currency);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<GetRewardVipAutoBonusResult>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<GetRewardVipAutoBonusResult> lists = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            if (response != null)
                for (int i = 0; i < response.length(); i++) {
                    lists.add(GetRewardVipAutoBonusResult.newInstance(response.optJSONObject(i)));
                }
            return lists;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRewardVipAutoBonusCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRewardVipAutoBonusAPI addGetRewardVipAutoBonusCallBack(GetRewardVipAutoBonusCallBack getRewardVipAutoBonusCallBack) {
        kzingCallBackList.add(getRewardVipAutoBonusCallBack);
        return this;
    }

    public interface GetRewardVipAutoBonusCallBack extends KzingCallBack {
        void onSuccess(ArrayList<GetRewardVipAutoBonusResult> result);
    }

    public GetRewardVipAutoBonusAPI setBonusType(String bonusType) {
        this.bonusType = bonusType;
        return this;
    }

    public GetRewardVipAutoBonusAPI setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}

