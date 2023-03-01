package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.entity.SocialRegisterPlatform;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SocialRegisterAPI extends RegAccountAPI {


    private String socialId;
    private String platform;
    private String provider;
    private String providerId;

    SocialRegisterAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.socialRegister;
    }

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
            jsonData.put("socialid", socialId);
            jsonData.put("splatform", platform);
            if (provider != null) {
                jsonData.put("provider", provider);
            }
            if (providerId != null) {
                jsonData.put("providerId", providerId);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            JSONObject responseObject = jsonResponse.optJSONObject("response");
            String vcToken = responseObject.optString("vc", "");
            String ccToken = responseObject.optString("cc", "");
            SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
            SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
            setLoginTokens(vcToken, ccToken);
            return "Success";
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(string -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SocialRegisterCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SocialRegisterAPI addSocialRegisterCallBack(SocialRegisterCallBack socialRegisterCallBack) {
        kzingCallBackList.add(socialRegisterCallBack);
        return this;
    }

    public SocialRegisterAPI setSocialId(String socialId) {
        this.socialId = socialId;
        return this;
    }

    public SocialRegisterAPI setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public SocialRegisterAPI setPlatform(SocialRegisterPlatform platform) {
        this.platform = platform.name();
        return this;
    }

    public SocialRegisterAPI setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public SocialRegisterAPI setProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public interface SocialRegisterCallBack extends KzingCallBack {
        void onSuccess();
    }

}

