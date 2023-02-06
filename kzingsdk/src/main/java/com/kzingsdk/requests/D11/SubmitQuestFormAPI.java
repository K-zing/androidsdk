package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.QuestQuestion;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class SubmitQuestFormAPI extends BaseD11API {

    private String qgtId;
    private String sqtId;
    private String verifyCode;
    private ArrayList<String> coverList = new ArrayList<>();
    private ArrayList<QuestQuestion> questQuestionList = new ArrayList<>();

    SubmitQuestFormAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.submitQuestForm;
    }

    @Override
    protected Observable<String> validateParams() {
        if (qgtId == null) {
            return Observable.just("QgtId is missing");
        }
        if (sqtId == null) {
            return Observable.just("SqtId is missing");
        }
        if (verifyCode == null) {
            return Observable.just("VerifyCode is missing");
        }
        if (questQuestionList == null) {
            return Observable.just("QuestQuestionList is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("qgtid", qgtId);
            jsonData.put("sqtid", sqtId);
            jsonData.put("verifycode", verifyCode);
            if (coverList != null && !coverList.isEmpty()) {
                JSONObject coverObject = new JSONObject();
                JSONArray coverArray = new JSONArray();
                for (String cover : coverList) {
                    coverArray.put(cover);
                }
                coverObject.put("cover", coverArray);
                jsonData.put("cover", coverObject);
            }
            JSONObject mainObject = new JSONObject();
            JSONArray questArray = new JSONArray();
            for (QuestQuestion questQuestion : questQuestionList) {
                questArray.put(questQuestion.toAnswerObject());
            }
            mainObject.put("main", questArray);
            jsonData.put("remark", mainObject);
            jsonData.put("jsessionid", getSessionId());
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<Boolean> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> true);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ignored -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitQuestFormCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitQuestFormAPI addSubmitQuestFormCallBack(SubmitQuestFormCallBack submitQuestFormCallBack) {
        kzingCallBackList.add(submitQuestFormCallBack);
        return this;
    }

    public SubmitQuestFormAPI setQgtId(String qgtId) {
        this.qgtId = qgtId;
        return this;
    }

    public SubmitQuestFormAPI setSqtId(String sqtId) {
        this.sqtId = sqtId;
        return this;
    }

    public SubmitQuestFormAPI setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        return this;
    }

    public SubmitQuestFormAPI setCoverList(ArrayList<String> coverList) {
        this.coverList = coverList;
        return this;
    }

    public SubmitQuestFormAPI addCover(String cover) {
        this.coverList.add(cover);
        return this;
    }

    public SubmitQuestFormAPI clearCoverList() {
        this.coverList.clear();
        return this;
    }

    public SubmitQuestFormAPI setQuestQuestionList(ArrayList<QuestQuestion> questQuestionList) {
        this.questQuestionList = questQuestionList;
        return this;
    }

    public interface SubmitQuestFormCallBack extends KzingCallBack {
        void onSuccess();
    }
}
