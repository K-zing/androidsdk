package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ActivityBonusPoint;

import io.reactivex.Observable;


public class GetActivityBonusPointAPI extends CoreRequest {

    GetActivityBonusPointAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getActivityBonusPoint;
    }


    @Override
    public Observable<ActivityBonusPoint> requestRx(Context context) {
        return super.baseExecute(context).map(ActivityBonusPoint::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityBonusPoint -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetActivityBonusPointCallBack) kzingCallBack).onSuccess(activityBonusPoint);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetActivityBonusPointAPI addGetActivityBonusPointCallBack(GetActivityBonusPointAPI.GetActivityBonusPointCallBack getActivityBonusPointCallBack) {
        kzingCallBackList.add(getActivityBonusPointCallBack);
        return this;
    }

    public interface GetActivityBonusPointCallBack extends KzingCallBack {
        void onSuccess(ActivityBonusPoint activityBonusPoint);
    }


}
