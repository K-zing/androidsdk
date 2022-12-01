package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.agency.AgentDownline;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetMemberAgentAllDownLineAPI extends CoreRequest {

    GetMemberAgentAllDownLineAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getMemberAgentAllDownLine;
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
    public Observable<ArrayList<AgentDownline>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<AgentDownline> agentDownlineList = new ArrayList<>();
            JSONArray commissionsArray = jsonResponse.optJSONArray("downlines");
            if (commissionsArray != null && commissionsArray.length() > 0) {
                for (int i = 0; i < commissionsArray.length(); i++) {
                    agentDownlineList.add(AgentDownline.newInstance(commissionsArray.optJSONObject(i)));
                }
            }

            return agentDownlineList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(agentDownlineList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMemberAgentAllDownLineCallBack) kzingCallBack).onSuccess(agentDownlineList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMemberAgentAllDownLineAPI addGetMemberAgentAllDownLineCallBack(GetMemberAgentAllDownLineCallBack getMemberAgentAllDownLineCallBack) {
        kzingCallBackList.add(getMemberAgentAllDownLineCallBack);
        return this;
    }

    public interface GetMemberAgentAllDownLineCallBack extends KzingCallBack {
        void onSuccess(ArrayList<AgentDownline> agentDownlineList);
    }

}

