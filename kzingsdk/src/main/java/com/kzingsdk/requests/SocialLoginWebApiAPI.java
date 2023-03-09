package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MemberInfo;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SocialLoginWebApiAPI extends CoreRequest {

    private String socialId;
    private String token;
    private String platform = "";
    private String provider = "";
    private String providerId = "";

    SocialLoginWebApiAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.socialLoginWebApi;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("socialid", socialId);
            jsonData.put("splatform", platform);
            jsonData.put("token", token);
            if (provider != null) {
                jsonData.put("provider", provider);
            }
            if (providerId != null) {
                jsonData.put("providerid", providerId);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<MemberInfo> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
                    String vcToken = jsonResponse.optString("vc", "");
                    String ccToken = jsonResponse.optString("cc", "");
                    SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
                    SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
                    setLoginTokens(vcToken, ccToken);
                    return MemberInfo.newInstanceFromWebapi(jsonResponse);
                })
                .doOnNext(response -> {
                    new GetSiteDomainAPI()
                            .requestRx(context)
                            .subscribe(jsonResponse -> {
                            }, ignored -> {
                            });
                })
                ;
    }


    @Override
    public void request(Context context) {
        requestRx(context).subscribe(memberInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SocialLoginWebCallBack) kzingCallBack).onSuccess(memberInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public interface SocialLoginWebCallBack extends KzingCallBack {
        void onSuccess(MemberInfo memberInfo);
    }

    public SocialLoginWebApiAPI addLoginWebApiCallBack(SocialLoginWebCallBack socialLoginWebApiCallBack) {
        kzingCallBackList.add(socialLoginWebApiCallBack);
        return this;
    }

    public SocialLoginWebApiAPI setSocialId(String socialId) {
        this.socialId = socialId;
        return this;
    }

    public SocialLoginWebApiAPI setToken(String token) {
        this.token = token;
        return this;
    }

    public SocialLoginWebApiAPI setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public SocialLoginWebApiAPI setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public SocialLoginWebApiAPI setProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }
}
