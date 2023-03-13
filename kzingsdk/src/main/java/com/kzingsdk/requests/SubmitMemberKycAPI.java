package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;
import com.kzingsdk.entity.SubmitMemberKycResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitMemberKycAPI extends CoreRequest {
    private String cover;

    SubmitMemberKycAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.submitMemberKyc;
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
    public Observable<SubmitMemberKycResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SubmitMemberKycResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitMemberKycCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitMemberKycAPI addSubmitMemberKycCallBack(SubmitMemberKycCallBack submitMemberKycCallBack) {
        kzingCallBackList.add(submitMemberKycCallBack);
        return this;
    }

    public interface SubmitMemberKycCallBack extends KzingCallBack {
        void onSuccess(SubmitMemberKycResult result);
    }

    public SubmitMemberKycAPI setCover(String cover) {
        this.cover = cover;
        return this;
    }
}

