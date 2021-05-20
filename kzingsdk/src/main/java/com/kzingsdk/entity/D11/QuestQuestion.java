package com.kzingsdk.entity.D11;

import org.json.JSONException;
import org.json.JSONObject;


public class QuestQuestion {


    private String sqdId;
    private String detail;
    private String qType;
    private String value;
    private Integer mandatory;
    //No one can tell what format is expected. So the only way I can do is return string. Detail please find @adam15work
    private String extraInfo;

    public QuestQuestion() {

    }

    public static QuestQuestion newInstance(JSONObject rootObject) {
        QuestQuestion supportHelperGroup = new QuestQuestion();
        supportHelperGroup.setSqdId(rootObject.optString("sqdid"));
        supportHelperGroup.setDetail(rootObject.optString("detail"));
        supportHelperGroup.setQType(rootObject.optString("qtype"));
        supportHelperGroup.setMandatory(rootObject.optInt("mandatory"));
        supportHelperGroup.setExtraInfo(rootObject.optString("extrainfo"));
        return supportHelperGroup;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSqdId() {
        return sqdId;
    }

    public void setSqdId(String sqdId) {
        this.sqdId = sqdId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getQType() {
        return qType;
    }

    public void setQType(String qType) {
        this.qType = qType;
    }

    public Integer getMandatory() {
        return mandatory;
    }

    public void setMandatory(Integer mandatory) {
        this.mandatory = mandatory;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public JSONObject toAnswerObject() {
        JSONObject answer = new JSONObject();
        try {
            answer.put("i", sqdId);
            answer.put("t", qType);
            answer.put("v", value);
        } catch (JSONException ignored) {
        }
        return answer;

    }

}


