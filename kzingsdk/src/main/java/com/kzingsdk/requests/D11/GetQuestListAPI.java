package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.QuestQuestionGroup;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetQuestListAPI extends BaseD11API {

    GetQuestListAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getQuestList;
    }


    @Override
    public Observable<ArrayList<QuestQuestionGroup>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<QuestQuestionGroup> questQuestionGroupArrayList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null) {
                        for (int i = 0; i < response.length(); i++) {
                            questQuestionGroupArrayList.add(QuestQuestionGroup.newInstance(response.optJSONObject(i)));
                        }
                    }
                    return questQuestionGroupArrayList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(questQuestionGroup -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetQuestListCallBack) kzingCallBack).onSuccess(questQuestionGroup);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetQuestListAPI addGetQuestListCallBack(GetQuestListCallBack getQuestListCallBack) {
        kzingCallBackList.add(getQuestListCallBack);
        return this;
    }

    public interface GetQuestListCallBack extends KzingCallBack {
        void onSuccess(ArrayList<QuestQuestionGroup> questQuestionGroupList);
    }

}
