package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetPanDepositListAPI extends CoreRequest {

    GetPanDepositListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getPanDepositList;
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
    public Observable<ArrayList<String>> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            JSONArray idArray = jsonResponse.optJSONArray("idList");
            ArrayList<String> idList = new ArrayList<>();
            if (idArray != null) {
                for (int i = 0; i < idArray.length(); i++) {
                    idList.add(idArray.optString(i));
                }
            }
            return idList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(idList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetPanDepositListCallBack) kzingCallBack).onSuccess(idList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetPanDepositListAPI addGetPanDepositListCallBack(GetPanDepositListAPI.GetPanDepositListCallBack getPanDepositListCallBack) {
        kzingCallBackList.add(getPanDepositListCallBack);
        return this;
    }

    public interface GetPanDepositListCallBack extends KzingCallBack {
        void onSuccess(ArrayList<String> idList);
    }
}
