package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.AllRewardVip;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;

import io.reactivex.Observable;

public class GetWithdrawAmountRangeAPI extends CoreRequest {

    GetWithdrawAmountRangeAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getWithdrawAmountRange;
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
    public Observable<ArrayList<String>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<String> lists = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            if (response != null)
                for (int i = 0; i < response.length(); i++) {
                    lists.add(response.optString(i));
                }
            return lists;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(amountRangeList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetWithdrawAmountRangeCallBack) kzingCallBack).onSuccess(amountRangeList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetWithdrawAmountRangeAPI addGetWithdrawAmountRangeCallBack(GetWithdrawAmountRangeCallBack getWithdrawAmountRangeCallBack) {
        kzingCallBackList.add(getWithdrawAmountRangeCallBack);
        return this;
    }

    public interface GetWithdrawAmountRangeCallBack extends KzingCallBack {
        void onSuccess(ArrayList<String> amountRangeList);
    }

}

