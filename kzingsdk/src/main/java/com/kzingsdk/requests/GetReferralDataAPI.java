package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.RecommendGames;
import com.kzingsdk.entity.ReferralData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetReferralDataAPI extends CoreRequest {

    GetReferralDataAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getReferralData;
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
    public Observable<ReferralData> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> ReferralData.newInstance(jsonResponse.optJSONObject("data")));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(referralData -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetReferralDataCallBack) kzingCallBack).onSuccess(referralData);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetReferralDataAPI addGetReferralDataCallBack(GetReferralDataCallBack getReferralDataCallBack) {
        kzingCallBackList.add(getReferralDataCallBack);
        return this;
    }

    public interface GetReferralDataCallBack extends KzingCallBack {
        void onSuccess(ReferralData referralData);
    }
}

