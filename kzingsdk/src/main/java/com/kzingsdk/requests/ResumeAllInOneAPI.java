package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.AllInOneResult;
import com.kzingsdk.entity.gameplatform.GamePlatformType;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ResumeAllInOneAPI extends CoreRequest {

    private String version = "";

    private Boolean showAll = false;
    private Boolean platformOnly = false;
    private GamePlatformType gpType = null;
    private Boolean showChild = false;
    private Boolean skipSiteInfo = false;
    private Boolean skipGame = false;
    private Boolean skipActivity = false;
    private Boolean skipCheckVersion = false;

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
            jsonData.put("useEpGame", true);
            jsonData.put("showall", showAll ? 1 : 0);
            jsonData.put("platformonly", platformOnly ? 1 : 0);
            jsonData.put("gptype", gpType == null ? 0 : gpType.getId());
            jsonData.put("showchild", showChild ? 1 : 0);
            jsonData.put("skipSiteInfo", skipSiteInfo);
            jsonData.put("skipGame", skipGame);
            jsonData.put("skipActivity", skipActivity);
            jsonData.put("skipCheckVersion", skipCheckVersion);
            jsonData.put("useWebApi", true);
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

    public ResumeAllInOneAPI setShowAll(Boolean showAll) {
        this.showAll = showAll;
        return this;
    }

    public ResumeAllInOneAPI setPlatformOnly(Boolean platformOnly) {
        this.platformOnly = platformOnly;
        return this;
    }


    /**
     * @param gpType Pass null to get all
     */
    public ResumeAllInOneAPI setGpType(GamePlatformType gpType) {
        this.gpType = gpType;
        return this;
    }

    public ResumeAllInOneAPI setShowChild(Boolean showChild) {
        this.showChild = showChild;
        return this;
    }

    public ResumeAllInOneAPI setSkipSiteInfo(Boolean skipSiteInfo) {
        this.skipSiteInfo = skipSiteInfo;
        return this;
    }

    public ResumeAllInOneAPI setSkipGame(Boolean skipGame) {
        this.skipGame = skipGame;
        return this;
    }

    public ResumeAllInOneAPI setSkipActivity(Boolean skipActivity) {
        this.skipActivity = skipActivity;
        return this;
    }

    public ResumeAllInOneAPI setSkipCheckVersion(Boolean skipCheckVersion) {
        this.skipCheckVersion = skipCheckVersion;
        return this;
    }
}



