package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CopyWritingContent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetCopyWritingContentByCategoryAPI extends CoreRequest {

    private int gameType = 0;
    private String order = "desc";
    private int limit = 50;

    GetCopyWritingContentByCategoryAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getCopyWritingContentByCategory;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gametype", gameType);
            jsonData.put("order", order);
            jsonData.put("limit", limit);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<ArrayList<CopyWritingContent>> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<CopyWritingContent> copyWritingContentList = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            if (response != null) {
                for (int i = 0; i < response.length(); i++) {
                    copyWritingContentList.add(CopyWritingContent.newInstance(response.optJSONObject(i)));
                }
            }
            return copyWritingContentList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(copyWritingContentList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCopyWritingContentByCategoryCallBack) kzingCallBack).onSuccess(copyWritingContentList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCopyWritingContentByCategoryAPI addGetCopyWritingContentByCategoryCallBack(GetCopyWritingContentByCategoryCallBack getCopyWritingContentByCategoryCallBack) {
        kzingCallBackList.add(getCopyWritingContentByCategoryCallBack);
        return this;
    }

    public int getGameType() {
        return gameType;
    }

    public GetCopyWritingContentByCategoryAPI setGameType(int gameType) {
        this.gameType = gameType;
        return this;
    }

    public String getOrder() {
        return order;
    }

    public GetCopyWritingContentByCategoryAPI setOrder(String order) {
        this.order = order;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public GetCopyWritingContentByCategoryAPI setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public interface GetCopyWritingContentByCategoryCallBack extends KzingCallBack {
        void onSuccess(ArrayList<CopyWritingContent> copyWritingContentList);
    }
}
