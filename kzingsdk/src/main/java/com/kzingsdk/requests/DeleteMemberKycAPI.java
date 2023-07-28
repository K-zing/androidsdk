package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class DeleteMemberKycAPI extends CoreRequest {
    private String id;

    DeleteMemberKycAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.deleteMemberKyc;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("id", id);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SimpleApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SimpleApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((DeleteMemberKycCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public DeleteMemberKycAPI addDeleteMemberKycCallBack(DeleteMemberKycCallBack deleteMemberKycCallBack) {
        kzingCallBackList.add(deleteMemberKycCallBack);
        return this;
    }

    public interface DeleteMemberKycCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult result);
    }

    public DeleteMemberKycAPI setId(String id) {
        this.id = id;
        return this;
    }
}

