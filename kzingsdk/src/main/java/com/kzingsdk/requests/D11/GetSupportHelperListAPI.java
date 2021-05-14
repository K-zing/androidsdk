package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.D11.SupportHelperGroup;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetSupportHelperListAPI extends CoreRequest {

    GetSupportHelperListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getSupportHelperList;
    }

    @Override
    public Observable<ArrayList<SupportHelperGroup>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<SupportHelperGroup> supportHelperGroups = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null) {
                        for (int i = 0; i < response.length(); i++) {
                            supportHelperGroups.add(SupportHelperGroup.newInstance(response.optJSONObject(i)));
                        }
                    }
                    return supportHelperGroups;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityItemList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSupportHelperListCallBack) kzingCallBack).onSuccess(activityItemList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetSupportHelperListAPI addGetSupportHelperListCallBack(GetSupportHelperListCallBack getSupportHelperListCallBack) {
        kzingCallBackList.add(getSupportHelperListCallBack);
        return this;
    }

    public interface GetSupportHelperListCallBack extends KzingCallBack {
        void onSuccess(ArrayList<SupportHelperGroup> activityItemList);
    }

}
