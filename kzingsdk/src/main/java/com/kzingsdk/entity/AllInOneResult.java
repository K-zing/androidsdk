package com.kzingsdk.entity;

import android.content.Context;

import com.kzingsdk.entity.gameplatform.GamePlatformContainer;
import com.kzingsdk.entity.gameplatform.GamePlatformCreator;
import com.kzingsdk.util.Constant;
import com.kzingsdk.util.GzipUtil;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class AllInOneResult {
    private MemberInfo memberInfo;
    private ClientInfo clientInfo;
    private ArrayList<GamePlatformContainer> gamePlatformContainerList;
    private ArrayList<ActivityItem> activityItemList;
    private boolean isLogined = false;

    public static AllInOneResult newInstance(JSONObject jsonResponse, Context context) throws JSONException, IOException {
        AllInOneResult allInOneResult = new AllInOneResult();
        allInOneResult.setClientInfo(ClientInfo.newInstance(jsonResponse.optJSONObject("siteInfo")));

        JSONObject memberInfoObject = jsonResponse.optJSONObject("memberInfo");
        if (memberInfoObject != null) {
            allInOneResult.isLogined = true;
            allInOneResult.setMemberInfo(MemberInfo.newInstance(jsonResponse.optJSONObject("memberInfo")));
            String vcToken = memberInfoObject.optString("vc", "");
            String ccToken = memberInfoObject.optString("cc", "");
            SharePrefUtil.putString(context, Constant.Pref.VCTOKEN, vcToken);
            SharePrefUtil.putString(context, Constant.Pref.CCTOKEN, ccToken);
        }

        final GamePlatformCreator gamePlatformCreator = new GamePlatformCreator();
        JSONArray gamePlatformArray = jsonResponse.optJSONArray("gamePlatformList");
        gamePlatformCreator.setContainerJsonArray(gamePlatformArray);

        SharePrefUtil.putString(context, Constant.Pref.GAMEPLATFORM, gamePlatformArray.toString());
        String gamePlatformChildArray = jsonResponse.optString("gamePlatformChildList");
        String subGame = GzipUtil.decompress(gamePlatformChildArray);
        SharePrefUtil.putString(context, Constant.Pref.GAMEPLATFORMCHILD, subGame);
        gamePlatformCreator.setSubGameJsonObject(new JSONArray(subGame));
        allInOneResult.setGamePlatformContainerList(gamePlatformCreator.build());

        ArrayList<ActivityItem> activityItemList = new ArrayList<>();
        JSONArray activityArray = jsonResponse.optJSONArray("activity");
        for (int i = 0; i < activityArray.length(); i++) {
            activityItemList.add(ActivityItem.newInstance(activityArray.optJSONObject(i)));
        }
        allInOneResult.setActivityItemList(activityItemList);
        return allInOneResult;
    }

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
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
}