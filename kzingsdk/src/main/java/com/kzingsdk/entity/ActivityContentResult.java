package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;


public class ActivityContentResult {

    private String webviewContent;
    private String formTitle;
    private String formHeader;
    private String formTitleColor;
    private ArrayList<ActivityForm> activityFormList = new ArrayList<>();

    public ActivityContentResult() {

    }

    public static ActivityContentResult newInstance(JSONObject rootObject) {
        ActivityContentResult activityContentResult = new ActivityContentResult();
        try {
            activityContentResult.setWebviewContent(URLDecoder.decode(rootObject.optString("response"), "UTF-8"));
        } catch (UnsupportedEncodingException ignored) {
        }
        JSONObject formDataObject = rootObject.optJSONObject("formData");
        if (formDataObject != null) {
            activityContentResult.setFormTitle(rootObject.optString("formtitle"));
            activityContentResult.setFormHeader(rootObject.optString("formheader"));
            activityContentResult.setFormTitleColor(rootObject.optString("formtitlecolor"));
            JSONArray fieldsArray = rootObject.optJSONArray("fields");
            if (fieldsArray != null) {
                for (int i = 0; i < fieldsArray.length(); i++) {
                    activityContentResult.activityFormList.add(ActivityForm.newInstance(fieldsArray.optJSONObject(i)));
                }
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

    public String getFormTitle() {
        return formTitle;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    public String getFormHeader() {
        return formHeader;
    }

    public void setFormHeader(String formHeader) {
        this.formHeader = formHeader;
    }

    public String getFormTitleColor() {
        return formTitleColor;
    }

    public void setFormTitleColor(String formTitleColor) {
        this.formTitleColor = formTitleColor;
    }

    public ArrayList<ActivityForm> getActivityFormList() {
        return activityFormList;
    }

    public void setActivityFormList(ArrayList<ActivityForm> activityFormList) {
        this.activityFormList = activityFormList;
    }
}

