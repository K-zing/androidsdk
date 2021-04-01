package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MemberReferralInfo;

import io.reactivex.Observable;

public class GetMemberReferralAPI extends CoreRequest {

    GetMemberReferralAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getMemberReferral;
    }

    @Override
    public Observable<MemberReferralInfo> requestRx(Context context) {
        return super.baseExecute(context)
                .map(MemberReferralInfo::newInstance)
                ;
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(memberReferralInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMemberReferralCallBack) kzingCallBack).onSuccess(memberReferralInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMemberReferralAPI addGetMemberReferralCallBack(GetMemberReferralCallBack getMemberReferralCallBack) {
        kzingCallBackList.add(getMemberReferralCallBack);
        return this;
    }

    public interface GetMemberReferralCallBack extends KzingCallBack {
        void onSuccess(MemberReferralInfo memberReferralInfo);
    }

}
