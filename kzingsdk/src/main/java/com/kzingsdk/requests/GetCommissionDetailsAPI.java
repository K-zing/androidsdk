package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.agency.AgentCommissionSummary;

import org.json.JSONObject;

import io.reactivex.Observable;

public class GetCommissionDetailsAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.getCommissionDetails;
    }

    GetCommissionDetailsAPI() {
        super();
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
    public Observable<GetCommissionDetailsResult> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse ->
                new GetCommissionDetailsResult(
                        AgentCommissionSummary.newInstance(jsonResponse.optJSONObject("latestcommission")),
                        AgentCommissionSummary.newInstance(jsonResponse.optJSONObject("prevcommission"))));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getCommissionDetailsResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCommissionDetailsCallBack) kzingCallBack).onSuccess(getCommissionDetailsResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCommissionDetailsAPI addGetCommissionDetailsCallBack(GetCommissionDetailsCallBack getCommissionDetailsCallBack) {
        kzingCallBackList.add(getCommissionDetailsCallBack);
        return this;
    }

    public interface GetCommissionDetailsCallBack extends KzingCallBack {
        void onSuccess(GetCommissionDetailsResult getCommissionDetailsResult);
    }

    public static class GetCommissionDetailsResult {
        private AgentCommissionSummary latestCommission;
        private AgentCommissionSummary prevCommission;

        public GetCommissionDetailsResult(AgentCommissionSummary latestCommission, AgentCommissionSummary prevCommission) {
            this.latestCommission = latestCommission;
            this.prevCommission = prevCommission;
        }

        public AgentCommissionSummary getLatestCommission() {
            return latestCommission;
        }

        public void setLatestCommission(AgentCommissionSummary latestCommission) {
            this.latestCommission = latestCommission;
        }

        public AgentCommissionSummary getPrevCommission() {
            return prevCommission;
        }

        public void setPrevCommission(AgentCommissionSummary prevCommission) {
            this.prevCommission = prevCommission;
        }
    }


}

