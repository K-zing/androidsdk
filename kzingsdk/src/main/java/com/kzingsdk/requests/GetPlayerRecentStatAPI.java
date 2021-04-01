package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.PlayerStat;

import io.reactivex.Observable;


public class GetPlayerRecentStatAPI extends CoreRequest {

    GetPlayerRecentStatAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getPlayerRecentStat;
    }

    @Override
    public Observable<PlayerStat> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> PlayerStat.newInstance(jsonResponse.optJSONObject("response").optJSONObject("playerStat")));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(playerStat -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetPlayerRecentStatCallBack) kzingCallBack).onSuccess(playerStat);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetPlayerRecentStatAPI addGetPlayerRecentStatCallBack(GetPlayerRecentStatAPI.GetPlayerRecentStatCallBack getPlayerRecentStatCallBack) {
        kzingCallBackList.add(getPlayerRecentStatCallBack);
        return this;
    }

    public interface GetPlayerRecentStatCallBack extends KzingCallBack {
        void onSuccess(PlayerStat playerStat);
    }


}
