package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetSuperdoorDomainAPI extends CoreRequest {

    GetSuperdoorDomainAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getSuperdoorDomain;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<String>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<String> lists = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            if (response != null) {
                for (int i = 0; i < response.length(); i++) {
                    lists.add(response.optString(i));
                }
            }
            return lists;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(simpleApiResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSuperdoorDomainCallBack) kzingCallBack).onSuccess(simpleApiResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetSuperdoorDomainAPI addGetSuperdoorDomainCallBack(GetSuperdoorDomainCallBack getSuperdoorDomainCallBack) {
        kzingCallBackList.add(getSuperdoorDomainCallBack);
        return this;
    }

    public interface GetSuperdoorDomainCallBack extends KzingCallBack {
        void onSuccess(ArrayList<String> strings);
    }

}

