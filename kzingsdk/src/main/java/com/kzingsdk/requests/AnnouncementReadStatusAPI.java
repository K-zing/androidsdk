package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.AnnouncementStatusApiResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class AnnouncementReadStatusAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.announcementReadStatus;
    }

    AnnouncementReadStatusAPI() {
        super();
    }

    private JSONArray announcementIdArray;

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("announcement_id", announcementIdArray);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<AnnouncementStatusApiResult> requestRx(final Context context) {
        return super.baseExecute(context).map(AnnouncementStatusApiResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(announcementStatusApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((AnnouncementReadStatusCallBack) kzingCallBack).onSuccess(announcementStatusApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public AnnouncementReadStatusAPI addAnnouncementReadStatusCallBack(AnnouncementReadStatusCallBack announcementReadStatusCallBack) {
        kzingCallBackList.add(announcementReadStatusCallBack);
        return this;
    }

    public interface AnnouncementReadStatusCallBack extends KzingCallBack {
        void onSuccess(AnnouncementStatusApiResult announcementStatusApiResult);
    }

    public AnnouncementReadStatusAPI setAnnouncementIdArray(JSONArray announcementIdArray) {
        this.announcementIdArray = announcementIdArray;
        return this;
    }
}

