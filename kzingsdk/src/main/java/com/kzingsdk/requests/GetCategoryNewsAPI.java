package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetCategoryNewsResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetCategoryNewsAPI extends CoreRequest {
    private String lang;
    private String catid;

    GetCategoryNewsAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getCategoryNews;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("lang", lang);
            jsonData.put("catid", catid);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<GetCategoryNewsResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetCategoryNewsResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCategoryNewsCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCategoryNewsAPI addGetCategoryNewsCallBack(GetCategoryNewsCallBack getCategoryNewsCallBack) {
        kzingCallBackList.add(getCategoryNewsCallBack);
        return this;
    }

    public interface GetCategoryNewsCallBack extends KzingCallBack {
        void onSuccess(GetCategoryNewsResult result);
    }

    public GetCategoryNewsAPI setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public GetCategoryNewsAPI setCatid(String catid) {
        this.catid = catid;
        return this;
    }
}

