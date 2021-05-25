package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.CsHistoryDetail;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class SubmitAdditionalQuestFormAPI extends BaseD11API {

    SubmitAdditionalQuestFormAPI() {
        super();
    }

    private String qhId;
    private ArrayList<String> coverList = new ArrayList<>();
    private ArrayList<CsHistoryDetail> csHistoryDetailList = new ArrayList<>();

    @Override
    protected String getD11Action() {
        return Action.submitAdditionalQuestForm;
    }

    @Override
    protected Observable<String> validateParams() {
        if (qhId == null) {
            return Observable.just("QhId is missing");
        }
        if (csHistoryDetailList == null) {
            return Observable.just("CsHistoryDetailList is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("qhid", qhId);
            if (coverList != null && !coverList.isEmpty()) {
                JSONObject coverObject = new JSONObject();
                JSONArray coverArray = new JSONArray();
                for (String cover : coverList) {
                    coverArray.put(cover);
                }
                coverObject.put("cover", coverArray);
                jsonData.put("cover", coverObject);
            }
            JSONArray questArray = new JSONArray();
            for (int i = 0; i < csHistoryDetailList.size(); i++) {
                CsHistoryDetail csHistoryDetail = csHistoryDetailList.get(i);
                if (!csHistoryDetail.isExtra()) continue;
                if (csHistoryDetail.getType().equalsIgnoreCase("img") && csHistoryDetail.getValue().length() == 0)
                    continue;
                JSONObject answerJSON = new JSONObject();
                answerJSON.put("id", csHistoryDetail.getId());
                answerJSON.put("value", csHistoryDetail.getValue());
                questArray.put(answerJSON);
            }
            jsonData.put("data", questArray);
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
                    ((SubmitAdditionalQuestFormCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitAdditionalQuestFormAPI addSubmitAdditionalQuestFormCallBack(SubmitAdditionalQuestFormCallBack submitAdditionalQuestFormCallBack) {
        kzingCallBackList.add(submitAdditionalQuestFormCallBack);
        return this;
    }

    public interface SubmitAdditionalQuestFormCallBack extends KzingCallBack {
        void onSuccess();
    }

    public SubmitAdditionalQuestFormAPI setQhId(String qhId) {
        this.qhId = qhId;
        return this;
    }

    public SubmitAdditionalQuestFormAPI setCoverList(ArrayList<String> coverList) {
        this.coverList = coverList;
        return this;
    }

    public SubmitAdditionalQuestFormAPI addCover(String cover) {
        this.coverList.add(cover);
        return this;
    }

    public SubmitAdditionalQuestFormAPI clearCoverList() {
        this.coverList.clear();
        return this;
    }

    public SubmitAdditionalQuestFormAPI setCsHistoryDetailList(ArrayList<CsHistoryDetail> csHistoryDetailList) {
        this.csHistoryDetailList = csHistoryDetailList;
        return this;
    }
}
