package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetNewsCategoryResult extends SimpleApiResult {

    protected ArrayList<NewsCategory> newsCategoryList = new ArrayList<>();

    public static GetNewsCategoryResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        GetNewsCategoryResult result = new GetNewsCategoryResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        JSONArray dataArray = rootObject.optJSONArray("data");
        if (dataArray != null) {
            for (int i = 0; i < dataArray.length(); i++) {
                result.newsCategoryList.add(NewsCategory.newInstance(dataArray.optJSONObject(i)));
            }
        }
        return result;
    }

    public ArrayList<NewsCategory> getNewsCategoryList() {
        return newsCategoryList;
    }

    public void setNewsCategoryList(ArrayList<NewsCategory> newsCategoryList) {
        this.newsCategoryList = newsCategoryList;
    }
}
