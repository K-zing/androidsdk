package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetMemberRewardVipResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetMemberRewardVipAPI extends CoreRequest {

    GetMemberRewardVipAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getMemberRewardVip;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    public Observable<GetMemberRewardVipResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetMemberRewardVipResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(result -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMemberRewardVipCallBack) kzingCallBack).onSuccess(result);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMemberRewardVipAPI addGetMemberRewardVipCallBack(GetMemberRewardVipCallBack getMemberRewardVipCallBack) {
        kzingCallBackList.add(getMemberRewardVipCallBack);
        return this;
    }

    public interface GetMemberRewardVipCallBack extends KzingCallBack {
        void onSuccess(GetMemberRewardVipResult result);
    }
}

