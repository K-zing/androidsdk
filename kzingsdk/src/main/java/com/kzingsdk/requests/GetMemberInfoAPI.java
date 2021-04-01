package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MemberInfo;

import io.reactivex.Observable;

public class GetMemberInfoAPI extends CoreRequest {

    GetMemberInfoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getMemberInfo;
    }

    @Override
    public Observable<MemberInfo> requestRx(Context context) {
        return super.baseExecute(context).map(MemberInfo::newInstance);
    }


    @Override
    public void request(Context context) {
        requestRx(context).subscribe(memberInfo -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMemberInfoCallBack) kzingCallBack).onSuccess(memberInfo);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMemberInfoAPI addGetMemberInfoCallBack(GetMemberInfoAPI.GetMemberInfoCallBack getActivityListCallBack){
        kzingCallBackList.add(getActivityListCallBack);
        return this;
    }

    public interface GetMemberInfoCallBack extends KzingCallBack{
        void onSuccess(MemberInfo memberInfo);
    }
    

}
