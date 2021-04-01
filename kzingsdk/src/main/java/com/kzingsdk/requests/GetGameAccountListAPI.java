package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.gameplatform.GamePlatformAccount;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetGameAccountListAPI extends CoreRequest {

    GetGameAccountListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getGamePlatformAccountList;
    }

    @Override
    public Observable<ArrayList<GamePlatformAccount>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<GamePlatformAccount> gamePlatformAccountList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("gpAccounts");
                    for (int i = 0; i < response.length(); i++) {
                        gamePlatformAccountList.add(GamePlatformAccount.newInstance(response.optJSONObject(i)));
                    }
                    return gamePlatformAccountList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(gamePlatformAccountList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetGamePlatformAccountCallBack) kzingCallBack).onSuccess(gamePlatformAccountList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetGameAccountListAPI addGetGamePlatformAccountCallBack(GetGamePlatformAccountCallBack getGamePlatformAccountCallBack) {
        kzingCallBackList.add(getGamePlatformAccountCallBack);
        return this;
    }

    public interface GetGamePlatformAccountCallBack extends KzingCallBack {
        void onSuccess(ArrayList<GamePlatformAccount> gamePlatformAccountList);
    }

}
