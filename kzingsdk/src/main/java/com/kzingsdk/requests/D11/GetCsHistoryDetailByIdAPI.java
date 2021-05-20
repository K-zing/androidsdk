package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.CsHistoryDetail;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetCsHistoryDetailByIdAPI extends BaseD11API {

    GetCsHistoryDetailByIdAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getCsHistoryDetailById;
    }

    private String qhId;

    @Override
    protected Observable<String> validateParams() {
        if (qhId == null) {
            return Observable.just("QhId is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("qhid", qhId);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<ArrayList<CsHistoryDetail>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<CsHistoryDetail> csHistoryDetails = new ArrayList<>();
                    JSONObject response = jsonResponse.optJSONObject("data");
                    JSONArray main = response.optJSONArray("main");
                    if (main != null) {
                        for (int i = 0; i < main.length(); i++) {
                            csHistoryDetails.add(CsHistoryDetail.newInstance(main.optJSONObject(i)));
                        }
                    }
                    JSONArray extra = response.optJSONArray("extra");
                    if (extra != null) {
                        for (int i = 0; i < extra.length(); i++) {
                            csHistoryDetails.add(CsHistoryDetail.newInstance(extra.optJSONObject(i)));
                        }
                    }
                    return csHistoryDetails;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(csHistoryDetails -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCsHistoryDetailByIdCallBack) kzingCallBack).onSuccess(csHistoryDetails);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCsHistoryDetailByIdAPI addGetCsHistoryDetailByIdCallBack(GetCsHistoryDetailByIdCallBack getCsHistoryDetailByIdCallBack) {
        kzingCallBackList.add(getCsHistoryDetailByIdCallBack);
        return this;
    }

    public interface GetCsHistoryDetailByIdCallBack extends KzingCallBack {
        void onSuccess(ArrayList<CsHistoryDetail> csHistoryDetailList);
    }

    public GetCsHistoryDetailByIdAPI setQhId(String qhId) {
        this.qhId = qhId;
        return this;
    }
}
