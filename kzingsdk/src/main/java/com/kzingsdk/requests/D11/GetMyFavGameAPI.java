package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.D11.GameLikesData;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashSet;

import io.reactivex.Observable;

public class GetMyFavGameAPI extends CoreRequest {

    GetMyFavGameAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getMyFavGame;
    }


    @Override
    public Observable<HashSet<String>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    HashSet<String> favGameSet = new HashSet<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null) {
                        JSONArray gpArray = response.optJSONObject(0).optJSONArray("gp");
                        if (gpArray != null) {
                            for (int i = 0; i < gpArray.length(); i++) {
                                favGameSet.add(gpArray.optJSONObject(0).optString("gpid"));
                            }
                        }
                    }
                    return favGameSet;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityItemList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMyFavGameCallBack) kzingCallBack).onSuccess(activityItemList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMyFavGameAPI addGetMyFavGameCallBack(GetMyFavGameCallBack getMyFavGameCallBack) {
        kzingCallBackList.add(getMyFavGameCallBack);
        return this;
    }

    public interface GetMyFavGameCallBack extends KzingCallBack {
        void onSuccess(HashSet<String> favGameSet);
    }

}
