package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetCategoryNewsResult extends SimpleApiResult {

    protected ArrayList<CategoryNews> newsCategoryList = new ArrayList<>();

    public static GetCategoryNewsResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        GetCategoryNewsResult result = new GetCategoryNewsResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        JSONArray dataArray = rootObject.optJSONArray("data");
        if (dataArray != null) {
            for (int i = 0; i < dataArray.length(); i++) {
                result.newsCategoryList.add(CategoryNews.newInstance(dataArray.optJSONObject(i)));
            }
        }
        return result;
    }

    public ArrayList<CategoryNews> getNewsCategoryList() {
        return newsCategoryList;
    }

    public void setNewsCategoryList(ArrayList<CategoryNews> newsCategoryList) {
        this.newsCategoryList = newsCategoryList;
    }
}
