package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.QuestQuestion;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetQuestFormAPI extends BaseD11API {

    GetQuestFormAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getQuestForm;
    }

    private String sqtId;

    @Override
    protected Observable<String> validateParams() {
        if (sqtId == null) {
            return Observable.just("SqtId is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("sqtid", sqtId);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<ArrayList<QuestQuestion>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<QuestQuestion> questQuestionArrayList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null) {
                        for (int i = 0; i < response.length(); i++) {
                            questQuestionArrayList.add(QuestQuestion.newInstance(response.optJSONObject(i)));
                        }
                    }
                    return questQuestionArrayList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(questQuestion -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetQuestFormCallBack) kzingCallBack).onSuccess(questQuestion);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetQuestFormAPI addGetQuestFormCallBack(GetQuestFormCallBack getQuestFormCallBack) {
        kzingCallBackList.add(getQuestFormCallBack);
        return this;
    }

    public interface GetQuestFormCallBack extends KzingCallBack {
        void onSuccess(ArrayList<QuestQuestion> questQuestionList);
    }

    public GetQuestFormAPI setSqtId(String sqtId) {
        this.sqtId = sqtId;
        return this;
    }
}
