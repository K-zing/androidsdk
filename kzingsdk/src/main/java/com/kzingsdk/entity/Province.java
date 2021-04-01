package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Province {
    protected String code = "";
    protected String name = "";
    protected ArrayList<Province> childrenList = new ArrayList<>();

    public static Province newInstance(JSONObject rootObject) {
        Province province = new Province();
        province.setCode(rootObject.optString("code"));
        province.setName(rootObject.optString("name"));
        JSONArray childrenArray = rootObject.optJSONArray("children");
        if (childrenArray != null) {
            for (int i = 0; i < childrenArray.length(); i++) {
                province.childrenList.add(Province.newInstance(childrenArray.optJSONObject(i)));
            }
        }
        return province;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Province> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(ArrayList<Province> childrenList) {
        this.childrenList = childrenList;
    }
}
