package com.kzingsdk.entity.D11;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class GetPhoneRecallInfoResult {


    private String startTime;
    private String endTime;
    private ArrayList<PhoneRecallInfo> phoneRecallInfoList = new ArrayList<>();

    public GetPhoneRecallInfoResult() {

    }

    public static GetPhoneRecallInfoResult newInstance(JSONObject rootObject) {
        GetPhoneRecallInfoResult getPhoneRecallInfoResult = new GetPhoneRecallInfoResult();

        getPhoneRecallInfoResult.setStartTime(rootObject.optString("starttime"));
        getPhoneRecallInfoResult.setEndTime(rootObject.optString("endtime"));
        JSONArray questArray = rootObject.optJSONArray("quests");
        if (questArray != null) {
            for (int i = 0; i < questArray.length(); i++) {
                getPhoneRecallInfoResult.phoneRecallInfoList.add(PhoneRecallInfo.newInstance(questArray.optJSONObject(i)));
            }
        }

        return getPhoneRecallInfoResult;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public ArrayList<PhoneRecallInfo> getPhoneRecallInfoList() {
        return phoneRecallInfoList;
    }

    public void setPhoneRecallInfoList(ArrayList<PhoneRecallInfo> phoneRecallInfoList) {
        this.phoneRecallInfoList = phoneRecallInfoList;
    }
}

