package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SimpleApiResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class UploadProfileImagesAPI extends CoreRequest {
    private String cover;

    UploadProfileImagesAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.uploadProfileImages;
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
    public Observable<SimpleApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SimpleApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((UploadProfileImagesCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public UploadProfileImagesAPI addUploadProfileImagesCallBack(UploadProfileImagesCallBack uploadProfileImagesCallBack) {
        kzingCallBackList.add(uploadProfileImagesCallBack);
        return this;
    }

    public interface UploadProfileImagesCallBack extends KzingCallBack {
        void onSuccess(SimpleApiResult simpleApiResult);
    }

    public UploadProfileImagesAPI setCover(String cover) {
        this.cover = cover;
        return this;
    }
}

