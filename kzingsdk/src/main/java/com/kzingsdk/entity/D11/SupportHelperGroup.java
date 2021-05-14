package com.kzingsdk.entity.D11;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class SupportHelperGroup {

    private String title;
    private ArrayList<SupportHelperContent> contentList = new ArrayList<>();

    public SupportHelperGroup() {

    }

    public static SupportHelperGroup newInstance(JSONObject rootObject) {
        SupportHelperGroup supportHelperGroup = new SupportHelperGroup();
        supportHelperGroup.setTitle(rootObject.optString("head_title"));
        JSONArray contentArray = rootObject.optJSONArray("funcation_data");
        if (contentArray != null) {
            for (int i = 0; i < contentArray.length(); i++) {
                supportHelperGroup.contentList.add(SupportHelperContent.newInstance(contentArray.optJSONObject(i)));
            }
        }
        return supportHelperGroup;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<SupportHelperContent> getContentList() {
        return contentList;
    }

    public void setContentList(ArrayList<SupportHelperContent> contentList) {
        this.contentList = contentList;
    }
}

