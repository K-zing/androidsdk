package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class ActivityForm {

    private String type;
    private String placeholder;
    private String name;
    private Boolean required;
    private ArrayList<String> selectionList = new ArrayList<>();
    private String answer;

    public ActivityForm() {

    }

    public static ActivityForm newInstance(JSONObject rootObject) {
        ActivityForm activityForm = new ActivityForm();
        activityForm.setType(rootObject.optString("type"));
        activityForm.setPlaceholder(rootObject.optString("placeholder"));
        activityForm.setName(rootObject.optString("name"));
        activityForm.setRequired(rootObject.optBoolean("required"));
        JSONArray selectionArray = rootObject.optJSONArray("selection");
        if (selectionArray!=null){
            for(int i = 0 ; i < selectionArray.length();i++){
                activityForm.selectionList.add(selectionArray.optString(i));
            }
        }
        return activityForm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public ArrayList<String> getSelectionList() {
        return selectionList;
    }

    public void setSelectionList(ArrayList<String> selectionList) {
        this.selectionList = selectionList;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

