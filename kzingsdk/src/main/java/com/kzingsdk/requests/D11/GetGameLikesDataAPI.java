package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.D11.GameLikesData;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetGameLikesDataAPI extends BaseD11API {

    GetGameLikesDataAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getGameLikesData;
    }


    @Override
    public Observable<ArrayList<GameLikesData>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<GameLikesData> gameLikesData = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null) {
                        for (int i = 0; i < response.length(); i++) {
                            gameLikesData.add(GameLikesData.newInstance(response.optJSONObject(i)));
                        }
                    }
                    return gameLikesData;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityItemList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetGameLikesDataCallBack) kzingCallBack).onSuccess(activityItemList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetGameLikesDataAPI addGetGameLikesDataCallBack(GetGameLikesDataCallBack getGameLikesDataCallBack) {
        kzingCallBackList.add(getGameLikesDataCallBack);
        return this;
    }

    public interface GetGameLikesDataCallBack extends KzingCallBack {
        void onSuccess(ArrayList<GameLikesData> gameLikesData);
    }

}
