package com.kzingsdk.entity.D11;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class SupportFaqGroup {

    private Integer uid;
    private String title;
    private ArrayList<SupportFaqContent> contentList = new ArrayList<>();

    public SupportFaqGroup() {

    }

    public static SupportFaqGroup newInstance(JSONObject rootObject) {
        SupportFaqGroup supportHelperGroup = new SupportFaqGroup();
        supportHelperGroup.setUid(rootObject.optInt("uid"));
        supportHelperGroup.setTitle(rootObject.optString("tabName"));
        JSONArray contentArray = rootObject.optJSONArray("questionList");
        if (contentArray != null) {
            for (int i = 0; i < contentArray.length(); i++) {
                supportHelperGroup.contentList.add(SupportFaqContent.newInstance(contentArray.optJSONObject(i)));
            }
        }
        return supportHelperGroup;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<SupportFaqContent> getContentList() {
        return contentList;
    }

    public void setContentList(ArrayList<SupportFaqContent> contentList) {
        this.contentList = contentList;
    }
}

