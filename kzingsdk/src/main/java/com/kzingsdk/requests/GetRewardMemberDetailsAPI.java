package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetRewardMemberDetailsResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetRewardMemberDetailsAPI extends CoreRequest {
    private String cover;

    GetRewardMemberDetailsAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getRewardMemberDetails;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("cover", cover);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<GetRewardMemberDetailsResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetRewardMemberDetailsResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRewardMemberDetailsCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRewardMemberDetailsAPI addGetRewardMemberDetailsCallBack(GetRewardMemberDetailsCallBack getRewardMemberDetailsCallBack) {
        kzingCallBackList.add(getRewardMemberDetailsCallBack);
        return this;
    }

    public interface GetRewardMemberDetailsCallBack extends KzingCallBack {
        void onSuccess(GetRewardMemberDetailsResult simpleApiResult);
    }

    public GetRewardMemberDetailsAPI setCover(String cover) {
        this.cover = cover;
        return this;
    }
}

