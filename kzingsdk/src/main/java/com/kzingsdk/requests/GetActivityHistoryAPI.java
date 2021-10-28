package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ActivityHistory;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetActivityHistoryAPI extends CoreRequest {

    GetActivityHistoryAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getActivityHistory;
    }

    @Override
    public Observable<ArrayList<ActivityHistory>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<ActivityHistory> actHistories = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            for (int i = 0; i < response.length(); i++) {
                actHistories.add(ActivityHistory.newInstance(response.optJSONObject(i)));
            }
            return actHistories;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityHistory -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetActivityHistoryCallBack) kzingCallBack).onSuccess(activityHistory);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetActivityHistoryAPI addGetActivityHistoryCallBack(GetActivityHistoryCallBack getActivityHistoryCallBack) {
        kzingCallBackList.add(getActivityHistoryCallBack);
        return this;
    }

    public interface GetActivityHistoryCallBack extends KzingCallBack {
        void onSuccess(ArrayList<ActivityHistory> activityHistory);
    }
}

