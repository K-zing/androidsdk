package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import io.reactivex.Observable;

public class ReadMessageAPI extends CoreRequest {

    private Set<String> idSet = new HashSet<>();
    private boolean isReadAll = false;

    ReadMessageAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.readMessage;
    }

    @Override
    protected Observable<String> validateParams() {
        if (isReadAll) return super.validateParams();
        if (idSet == null || idSet.isEmpty()) {
            return Observable.just("Need at least one ID");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (isReadAll) {
                jsonData.put("id", "ALL");
            } else {
                JSONArray idArray = new JSONArray();
                for (String id : idSet) {
                    idArray.put(id);
                }
                jsonData.put("ids", idArray);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ignore -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ReadMessageCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ReadMessageAPI addReadMessageCallBack(ReadMessageAPI.ReadMessageCallBack readMessageCallBack) {
        kzingCallBackList.add(readMessageCallBack);
        return this;
    }

    public ReadMessageAPI setReadAll(boolean isReadAll) {
        this.isReadAll = isReadAll;
        return this;
    }

    public ReadMessageAPI addIds(Collection<String> idCollection) {
        this.idSet.addAll(idCollection);
        return this;
    }

    public interface ReadMessageCallBack extends KzingCallBack {
        void onSuccess();
    }
}
