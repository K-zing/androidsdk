package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.AllInOneResult;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ResumeAllInOneAPI extends CoreRequest {

    private String version = "";

    ResumeAllInOneAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.resumeAllInOne;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("version", version);
            jsonData.put("platform", PLATFORM_NAME);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<AllInOneResult> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            AllInOneResult allInOneResult = AllInOneResult.newInstance(jsonResponse, context);
            String vcToken, ccToken;
            if (allInOneResult.isLogined()) {
                JSONObject memberInfoObject = jsonResponse.optJSONObject("memberInfo");
                vcToken = memberInfoObject.optString("vc", "");
                ccToken = memberInfoObject.optString("cc", "");
            } else {
                vcToken = "";
                ccToken = "";
            }
            SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
            SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
            setLoginTokens(vcToken, ccToken);
            return allInOneResult;
        });
    }


    @Override
    public void request(Context context) {
        requestRx(context).subscribe(allInOneResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ResumeAllInOneCallBack) kzingCallBack).onSuccess(allInOneResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ResumeAllInOneAPI addResumeAllInOneCallBack(ResumeAllInOneCallBack resumeAllInOneCallBack) {
        kzingCallBackList.add(resumeAllInOneCallBack);
        return this;
    }

    public interface ResumeAllInOneCallBack extends KzingCallBack {
        void onSuccess(AllInOneResult allInOneResult);
    }

    public ResumeAllInOneAPI setVersion(String version) {
        this.version = version;
        return this;
    }
}

