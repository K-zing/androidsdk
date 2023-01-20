package com.kzingsdk.entity;

import android.content.Context;

import com.kzingsdk.entity.gameplatform.GamePlatformContainer;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class AllInOneResult {
    private MemberInfo memberInfo;
    private ClientInstantInfo clientInfo;
    private ArrayList<GamePlatformContainer> gamePlatformContainerList;
    private ArrayList<ActivityItem> activityItemList;
    private boolean isLogined = false;
    private AppUpdateInfo appUpdateInfo = new AppUpdateInfo();

    public static AllInOneResult newInstance(JSONObject jsonResponse, Context context) throws JSONException, IOException {
        AllInOneResult allInOneResult = new AllInOneResult();
        JSONObject appVersionObject = jsonResponse.optJSONObject("appVersion");
        if (appVersionObject != null) {
            allInOneResult.setAppUpdateInfo(AppUpdateInfo.newInstance(appVersionObject));
        }

        JSONObject siteInfoObject = jsonResponse.optJSONObject("siteInfo");
        if (siteInfoObject != null) {
            allInOneResult.setClientInfo(ClientInstantInfo.newInstance(siteInfoObject));
        }

        JSONObject memberInfoObject = jsonResponse.optJSONObject("memberInfo");
        if (memberInfoObject != null) {
            allInOneResult.isLogined = true;
            allInOneResult.setMemberInfo(MemberInfo.newInstanceFromWebapi(memberInfoObject));
            String vcToken = memberInfoObject.optString("vc", "");
            String ccToken = memberInfoObject.optString("cc", "");
            SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
            SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
        }

        ArrayList<GamePlatformContainer> containers = new ArrayList<>();
        JSONObject gamePlatformJSON = jsonResponse.optJSONObject("epGamePlatformList");
        if (gamePlatformJSON != null) {
            JSONArray gamePlatformArray = gamePlatformJSON.optJSONArray("data");
            if (gamePlatformArray != null) {
                for (int i = 0; i < gamePlatformArray.length(); i++) {
                    containers.add(GamePlatformContainer.newInstanceFromEp(gamePlatformArray.optJSONObject(i)));
                }
            }
        }
        allInOneResult.setGamePlatformContainerList(containers);
        ArrayList<ActivityItem> activityItemList = new ArrayList<>();
        JSONArray activityArray = jsonResponse.optJSONArray("activity");
        if (activityArray != null) {
            for (int i = 0; i < activityArray.length(); i++) {
                activityItemList.add(ActivityItem.newInstance(activityArray.optJSONObject(i)));
            }
            allInOneResult.setActivityItemList(activityItemList);
        }
        return allInOneResult;
    }

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public ClientInstantInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInstantInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public ArrayList<GamePlatformContainer> getGamePlatformContainerList() {
        return gamePlatformContainerList;
    }

    public void setGamePlatformContainerList(ArrayList<GamePlatformContainer> gamePlatformContainerList) {
        this.gamePlatformContainerList = gamePlatformContainerList;
    }

    public ArrayList<ActivityItem> getActivityItemList() {
        return activityItemList;
    }

    public void setActivityItemList(ArrayList<ActivityItem> activityItemList) {
        this.activityItemList = activityItemList;
    }

    public boolean isLogined() {
        return isLogined;
    }

    public void setLogined(boolean logined) {
        isLogined = logined;
    }

    public AppUpdateInfo getAppUpdateInfo() {
        return appUpdateInfo;
    }

    public void setAppUpdateInfo(AppUpdateInfo appUpdateInfo) {
        this.appUpdateInfo = appUpdateInfo;
    }
}