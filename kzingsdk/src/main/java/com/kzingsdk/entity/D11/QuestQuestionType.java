package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class QuestQuestionType {

    private String sqtId;
    private String qgtId;
    private String sqTypeName;
    private String status;
    private String logoUrl;
    private Integer displayOrder;

    public QuestQuestionType() {

    }

    public static QuestQuestionType newInstance(JSONObject rootObject) {
        QuestQuestionType supportHelperGroup = new QuestQuestionType();
        supportHelperGroup.setSqtId(rootObject.optString("sqtid"));
        supportHelperGroup.setQgtId(rootObject.optString("qgtid"));
        supportHelperGroup.setSqTypeName(rootObject.optString("sqtypename"));
        supportHelperGroup.setStatus(rootObject.optString("status"));
        supportHelperGroup.setLogoUrl(rootObject.optString("logo_url"));
        supportHelperGroup.setDisplayOrder(rootObject.optInt("displayorder"));

        return supportHelperGroup;
    }

    public String getSqtId() {
        return sqtId;
    }

    public void setSqtId(String sqtId) {
        this.sqtId = sqtId;
    }

    public String getQgtId() {
        return qgtId;
    }

    public void setQgtId(String qgtId) {
        this.qgtId = qgtId;
    }

    public String getSqTypeName() {
        return sqTypeName;
    }

    public void setSqTypeName(String sqTypeName) {
        this.sqTypeName = sqTypeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}

