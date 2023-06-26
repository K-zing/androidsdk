package com.kzingsdk.entity;

import org.json.JSONObject;

public class NewsCategory {

    private int id = 0;
    private int order = 0;
    private String name = "";

    public static NewsCategory newInstance(JSONObject rootObject) {
        NewsCategory result = new NewsCategory();
        result.setId(rootObject.optInt("id"));
        result.setOrder(rootObject.optInt("order"));
        result.setName(rootObject.optString("name"));
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
