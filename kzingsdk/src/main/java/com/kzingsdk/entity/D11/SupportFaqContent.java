package com.kzingsdk.entity.D11;

import org.json.JSONObject;


public class SupportFaqContent {

    private String question;
    private String answer;

    public SupportFaqContent() {

    }

    public static SupportFaqContent newInstance(JSONObject rootObject) {
        SupportFaqContent activityBonus = new SupportFaqContent();
        activityBonus.setQuestion(rootObject.optString("question"));
        activityBonus.setAnswer(rootObject.optString("answer"));
        return activityBonus;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

