package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class UpdatePanAPI extends CoreRequest {

    UpdatePanAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.updatePan;
    }

    private String pan;

    @Override
    protected Observable<String> validateParams() {
        if (pan == null || pan.length() == 0) {
            return Observable.just("PAN is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("pan", pan);
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
                    ((UpdatePanCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public UpdatePanAPI addUpdatePanCallBack(UpdatePanAPI.UpdatePanCallBack updatePanCallBack) {
        kzingCallBackList.add(updatePanCallBack);
        return this;
    }

    public interface UpdatePanCallBack extends KzingCallBack {
        void onSuccess();
    }

    public UpdatePanAPI setPan(String pan) {
        this.pan = pan;
        return this;
    }
}
