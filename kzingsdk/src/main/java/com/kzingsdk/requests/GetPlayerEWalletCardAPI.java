package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.EWalletCard;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetPlayerEWalletCardAPI extends CoreRequest {

    GetPlayerEWalletCardAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getPlayerEWalletCard;
    }

    @Override
    public Observable<ArrayList<EWalletCard>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<EWalletCard> eWalletCardArrayList = new ArrayList<>();
            JSONArray cardsArray = jsonResponse.optJSONArray("cards");
            if (cardsArray != null) {
                for (int i = 0; i < cardsArray.length(); i++) {
                    eWalletCardArrayList.add(EWalletCard.newInstance(cardsArray.optJSONObject(i)));
                }
            }
            return eWalletCardArrayList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(eWalletCardArrayList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetPlayerEWalletCardCallBack) kzingCallBack).onSuccess(eWalletCardArrayList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetPlayerEWalletCardAPI addGetPlayerEWalletCardCallBack(GetPlayerEWalletCardCallBack getPlayerEWalletCardCallBack) {
        kzingCallBackList.add(getPlayerEWalletCardCallBack);
        return this;
    }

    public interface GetPlayerEWalletCardCallBack extends KzingCallBack {
        void onSuccess(ArrayList<EWalletCard> eWalletCardArrayList);
    }


}

