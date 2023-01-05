package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class UpdateProfileImagesAPI extends CoreRequest {
    private String sid;

    UpdateProfileImagesAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.updateProfileImages;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("sid", sid);
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
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((UpdateProfileImagesCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public UpdateProfileImagesAPI addUpdateProfileImagesCallBack(UpdateProfileImagesCallBack updateProfileImagesCallBack) {
        kzingCallBackList.add(updateProfileImagesCallBack);
        return this;
    }

    public interface UpdateProfileImagesCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }

    public UpdateProfileImagesAPI setSid(String sid) {
        this.sid = sid;
        return this;
    }
}

