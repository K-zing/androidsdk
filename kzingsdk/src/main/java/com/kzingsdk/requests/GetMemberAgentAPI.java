package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.agency.MemberAgent;

import org.json.JSONObject;

import io.reactivex.Observable;

public class GetMemberAgentAPI extends CoreRequest {

    GetMemberAgentAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getMemberAgent;
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
    public Observable<MemberAgent> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            return MemberAgent.newInstance(jsonResponse);
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(memberAgent -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((MemberAgentCallBack) kzingCallBack).onSuccess(memberAgent);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMemberAgentAPI addMemberAgentCallBack(MemberAgentCallBack memberAgentCallBack) {
        kzingCallBackList.add(memberAgentCallBack);
        return this;
    }

    public interface MemberAgentCallBack extends KzingCallBack {
        void onSuccess(MemberAgent memberAgent);
    }

}

