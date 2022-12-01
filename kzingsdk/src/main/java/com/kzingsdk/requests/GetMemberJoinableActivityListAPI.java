package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetMemberJoinableActivityListResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetMemberJoinableActivityListAPI extends CoreRequest {

    private String gpAccountId;


    GetMemberJoinableActivityListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getMemberJoinableActivityList;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gpaccountid", gpAccountId);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<GetMemberJoinableActivityListResult> requestRx(Context context) {
        return super.baseExecute(context)
                .map(GetMemberJoinableActivityListResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityItemList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMemberJoinableActivityListCallBack) kzingCallBack).onSuccess(activityItemList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMemberJoinableActivityListAPI addGetMemberJoinableActivityListCallBack(GetMemberJoinableActivityListCallBack getMemberJoinableActivityListCallBack) {
        kzingCallBackList.add(getMemberJoinableActivityListCallBack);
        return this;
    }

    public GetMemberJoinableActivityListAPI setGpAccountId(String gpAccountId) {
        this.gpAccountId = gpAccountId;
        return this;
    }

    public interface GetMemberJoinableActivityListCallBack extends KzingCallBack {
        void onSuccess(GetMemberJoinableActivityListResult result);
    }
}
