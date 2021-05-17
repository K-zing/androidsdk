package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.D11.SupportFaqGroup;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetSupportFaqAPI extends BaseD11API {

    GetSupportFaqAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getSupportFaq;
    }

    private final String[] titleArray = new String[]{
            "accountGuide",
            "depositGuide",
            "gameGuide",
            "hotQuestion",
            "newRead",
            "promotionGuide",
            "techSupport",
            "withdrawalGuide"
    };

    @Override
    public Observable<ArrayList<SupportFaqGroup>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<SupportFaqGroup> supportFaqGroups = new ArrayList<>();
                    JSONObject response = jsonResponse.optJSONObject("data");
                    if (response != null) {
                        for (String s : titleArray) {
                            supportFaqGroups.add(SupportFaqGroup.newInstance(response.optJSONObject(s)));
                        }
                    }
                    return supportFaqGroups;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityItemList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSupportFaqCallBack) kzingCallBack).onSuccess(activityItemList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetSupportFaqAPI addGetSupportFaqCallBack(GetSupportFaqCallBack getSupportFaqCallBack) {
        kzingCallBackList.add(getSupportFaqCallBack);
        return this;
    }

    public interface GetSupportFaqCallBack extends KzingCallBack {
        void onSuccess(ArrayList<SupportFaqGroup> activityItemList);
    }

}
