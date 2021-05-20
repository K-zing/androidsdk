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

    SubmitQuestFormAPI() {
        super();
    }

    private String qgtId;
    private String sqtId;
    private String verifyCode;
    private String cover;
    private ArrayList<QuestQuestion> questQuestionList = new ArrayList<>();

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
            JSONArray questArray = new JSONArray();
            jsonData.put("qgtid", qgtId);
            jsonData.put("sqtid", sqtId);
            jsonData.put("verifycode", verifyCode);
            if (cover != null)
                jsonData.put("cover", cover);

            for (QuestQuestion questQuestion : questQuestionList) {
                questArray.put(questQuestion.toAnswerObject());
            }
            jsonData.put("main", questArray);
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

    public interface SubmitQuestFormCallBack extends KzingCallBack {
        void onSuccess();
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

    public SubmitQuestFormAPI setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public SubmitQuestFormAPI setQuestQuestionList(ArrayList<QuestQuestion> questQuestionList) {
        this.questQuestionList = questQuestionList;
        return this;
    }
}
