package com.kzingsdk.entity.D11;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class QuestQuestionGroup {

    private String qgtId;
    private String qTypeName;
    private Integer status;
    private Integer displayOrder;
    private ArrayList<QuestQuestionType> questQuestionTypeList = new ArrayList<>();

    public QuestQuestionGroup() {

    }

    public static QuestQuestionGroup newInstance(JSONObject rootObject) {
        QuestQuestionGroup questQuestionGroup = new QuestQuestionGroup();
        questQuestionGroup.setQgtId(rootObject.optString("qgtid"));
        questQuestionGroup.setQTypeName(rootObject.optString("qtypename"));
        questQuestionGroup.setStatus(rootObject.optInt("status"));
        questQuestionGroup.setDisplayOrder(rootObject.optInt("displayorder"));
        JSONArray contentArray = rootObject.optJSONArray("questionList");
        if (contentArray != null) {
            for (int i = 0; i < contentArray.length(); i++) {
                questQuestionGroup.questQuestionTypeList.add(QuestQuestionType.newInstance(contentArray.optJSONObject(i)));
            }
        }
        return questQuestionGroup;
    }

    public String getQgtId() {
        return qgtId;
    }

    public void setQgtId(String qgtId) {
        this.qgtId = qgtId;
    }

    public String getQTypeName() {
        return qTypeName;
    }

    public void setQTypeName(String qTypeName) {
        this.qTypeName = qTypeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public ArrayList<QuestQuestionType> getQuestQuestionTypeList() {
        return questQuestionTypeList;
    }

    public void setQuestQuestionTypeList(ArrayList<QuestQuestionType> questQuestionTypeList) {
        this.questQuestionTypeList = questQuestionTypeList;
    }
}

