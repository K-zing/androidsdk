package com.kzingsdk.entity.K36;

import com.kzingsdk.entity.gameplatform.SimpleGamePlatform;
import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;


public class TransferBonusActivity {

    private String actId;
    private String actName;
    private String content;
    private String targetUser;
    private String activityPeriod;
    private ArrayList<SimpleGamePlatform> simpleGamePlatformArrayList = new ArrayList<>();
    private ArrayList<TransferBonusActivityAcData> transferBonusActivityAcDataArrayList = new ArrayList<>();

    public TransferBonusActivity() {

    }

    public static TransferBonusActivity newInstance(JSONObject rootObject) {
        TransferBonusActivity transferBonusActivity = new TransferBonusActivity();
        transferBonusActivity.setActId(rootObject.optString("actid"));
        transferBonusActivity.setActName(rootObject.optString("actname"));
        transferBonusActivity.setContent(rootObject.optString("content"));
        transferBonusActivity.setTargetUser(rootObject.optString("targetuser"));
        transferBonusActivity.setActivityPeriod(rootObject.optString("activityperiod"));
        JSONArray platformArray = rootObject.optJSONArray("platform");
        if (platformArray != null) {
            for(int i = 0 ; i < platformArray.length();i++){
                JSONObject dataObject = platformArray.optJSONObject(i);
                transferBonusActivity.simpleGamePlatformArrayList.add(SimpleGamePlatform.newInstance(dataObject));
            }
        }
        JSONArray acDataArray = rootObject.optJSONArray("ac_data");
        if (acDataArray != null) {
            for(int i = 0 ; i < acDataArray.length();i++){
                JSONObject dataObject = acDataArray.optJSONObject(i);
                transferBonusActivity.transferBonusActivityAcDataArrayList.add(TransferBonusActivityAcData.newInstance(dataObject));
            }
        }
        return transferBonusActivity;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(String targetUser) {
        this.targetUser = targetUser;
    }

    public String getActivityPeriod() {
        return activityPeriod;
    }

    public void setActivityPeriod(String activityPeriod) {
        this.activityPeriod = activityPeriod;
    }

    public ArrayList<SimpleGamePlatform> getSimpleGamePlatformArrayList() {
        return simpleGamePlatformArrayList;
    }

    public void setSimpleGamePlatformArrayList(ArrayList<SimpleGamePlatform> simpleGamePlatformArrayList) {
        this.simpleGamePlatformArrayList = simpleGamePlatformArrayList;
    }

    public ArrayList<TransferBonusActivityAcData> getTransferBonusActivityAcDataArrayList() {
        return transferBonusActivityAcDataArrayList;
    }

    public void setTransferBonusActivityAcDataArrayList(ArrayList<TransferBonusActivityAcData> transferBonusActivityAcDataArrayList) {
        this.transferBonusActivityAcDataArrayList = transferBonusActivityAcDataArrayList;
    }
}


