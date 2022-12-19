package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetMemberJoinableActivityListResult extends SimpleApiResult {

    private Boolean mainWallet;
    private ArrayList<ActivityItem> activityItemList = new ArrayList<>();

    public GetMemberJoinableActivityListResult() {

    }

    public static GetMemberJoinableActivityListResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        GetMemberJoinableActivityListResult result = new GetMemberJoinableActivityListResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        JSONObject responseObject = rootObject.optJSONObject("response");
        if (responseObject != null) {
            result.mainWallet = responseObject.optBoolean("mainwallet");
            JSONArray listArray = responseObject.optJSONArray("list");
            if (listArray != null) {
                for (int i = 0; i < listArray.length(); i++) {
                    result.activityItemList.add(ActivityItem.newInstance(listArray.optJSONObject(i)));
                }
            }
        }
        return result;
    }

    public Boolean getMainWallet() {
        return mainWallet;
    }

    public void setMainWallet(Boolean mainWallet) {
        this.mainWallet = mainWallet;
    }

    public ArrayList<ActivityItem> getActivityItemList() {
        return activityItemList;
    }

    public void setActivityItemList(ArrayList<ActivityItem> activityItemList) {
        this.activityItemList = activityItemList;
    }
}
