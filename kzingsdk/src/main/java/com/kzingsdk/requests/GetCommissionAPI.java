package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.agency.AgentCommission;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetCommissionAPI extends CoreRequest {

    GetCommissionAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getCommission;
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
    public Observable<ArrayList<AgentCommission>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<AgentCommission> agentCommissionList = new ArrayList<>();
            JSONArray commissionsArray = jsonResponse.optJSONArray("commissions");
            if (commissionsArray != null && commissionsArray.length() > 0) {
                for (int i = 0; i < commissionsArray.length(); i++) {
                    agentCommissionList.add(AgentCommission.newInstance(commissionsArray.optJSONObject(i)));
                }
            }

            return agentCommissionList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(agentCommissionList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCommissionCallBack) kzingCallBack).onSuccess(agentCommissionList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCommissionAPI addGetCommissionCallBack(GetCommissionCallBack getCommissionCallBack) {
        kzingCallBackList.add(getCommissionCallBack);
        return this;
    }

    public interface GetCommissionCallBack extends KzingCallBack {
        void onSuccess(ArrayList<AgentCommission> agentCommissionList);
    }

}

