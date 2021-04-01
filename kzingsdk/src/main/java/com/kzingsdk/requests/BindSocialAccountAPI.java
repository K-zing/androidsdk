package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SocialRegisterPlatform;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class BindSocialAccountAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.bindSocialAccount;
    }

    BindSocialAccountAPI() {
        super();
    }

    private String socialId;
    private String platform;

    @Override
    protected Observable<String> validateParams() {
        if (socialId == null) {
            return Observable.just("SocialId is missing");
        }
        if (platform == null) {
            return Observable.just("Platform is missing");
        }
        return super.validateParams();
    }


    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("sid", socialId);
            jsonData.put("splatform", platform);
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
                    ((BindSocialAccountCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public BindSocialAccountAPI addBindSocialAccountCallBack(BindSocialAccountCallBack bindSocialAccountCallBack) {
        kzingCallBackList.add(bindSocialAccountCallBack);
        return this;
    }

    public interface BindSocialAccountCallBack extends KzingCallBack {
        void onSuccess();
    }

    public BindSocialAccountAPI setSocialId(String socialId) {
        this.socialId = socialId;
        return this;
    }

    public BindSocialAccountAPI setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public BindSocialAccountAPI setPlatform(SocialRegisterPlatform platform) {
        this.platform = platform.name();
        return this;
    }

}

