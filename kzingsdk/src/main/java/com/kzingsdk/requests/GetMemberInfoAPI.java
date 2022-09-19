package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MemberInfo;

import org.json.JSONException;
import org.json.JSONObject;

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
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("useWebApi", true);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<MemberInfo> requestRx(Context context) {
        return super.baseExecute(context).map(MemberInfo::newInstanceFromWebapi);
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

    public GetMemberInfoAPI addGetMemberInfoCallBack(GetMemberInfoCallBack getMemberInfoCallBack) {
        kzingCallBackList.add(getMemberInfoCallBack);
        return this;
    }

    public interface GetMemberInfoCallBack extends KzingCallBack {
        void onSuccess(MemberInfo memberInfo);
    }


}
