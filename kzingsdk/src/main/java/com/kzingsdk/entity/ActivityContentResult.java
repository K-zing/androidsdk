package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;


public class ActivityContentResult {

    private String webviewContent;
    private ArrayList<ActivityForm> activityFormList = new ArrayList<>();

    public ActivityContentResult() {

    }

    public static ActivityContentResult newInstance(JSONObject rootObject) {
        ActivityContentResult activityContentResult = new ActivityContentResult();
        try {
            activityContentResult.setWebviewContent(URLDecoder.decode(rootObject.optString("response"), "UTF-8"));
        } catch (UnsupportedEncodingException ignored) {
        }
        JSONArray formDataArray = rootObject.optJSONArray("formData");
        if (formDataArray!=null){
            for(int i = 0 ; i < formDataArray.length();i++){
                activityContentResult.activityFormList.add(ActivityForm.newInstance(formDataArray.optJSONObject(i)));
            }
        }

        return activityContentResult;
    }

    public String getWebviewContent() {
        return webviewContent;
    }

    public void setWebviewContent(String webviewContent) {
        this.webviewContent = webviewContent;
    }

    public ArrayList<ActivityForm> getActivityFormList() {
        return activityFormList;
    }

    public void setActivityFormList(ArrayList<ActivityForm> activityFormList) {
        this.activityFormList = activityFormList;
    }
}

