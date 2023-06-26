package com.kzingsdk.entity;

import org.json.JSONObject;

public class CategoryNews {

    private int id = 0;
    private int order = 0;
    private String name = "";

"id": "24",
"datetime": "1686499200",
"web_fname": "i20230663e0ce3c5a9a43a884aaa95c6cc342c9.png",
    public static CategoryNews newInstance(JSONObject rootObject) {
        CategoryNews result = new CategoryNews();
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
