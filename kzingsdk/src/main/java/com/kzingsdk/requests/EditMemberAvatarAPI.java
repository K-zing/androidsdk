package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class EditMemberAvatarAPI extends CoreRequest {


    private String avatarId = null;

    EditMemberAvatarAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.editMemberAvatar;
    }

    @Override
    protected Observable<String> validateParams() {
        if (avatarId == null) {
            return Observable.just("AvatarId is missing.");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("avatarId", avatarId);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(string -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((EditMemberAvatarCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public EditMemberAvatarAPI addEditMemberAvatarCallBack(EditMemberAvatarCallBack EditMemberAvatarCallBack) {
        kzingCallBackList.add(EditMemberAvatarCallBack);
        return this;
    }

    public interface EditMemberAvatarCallBack extends KzingCallBack {
        void onSuccess();
    }


    public EditMemberAvatarAPI setParamAvatarId(String avatarId) {
        this.avatarId = avatarId;
        return this;
    }
}

