package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.D11.D11HotGame;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetD11HotGameAPI extends CoreRequest {

    GetD11HotGameAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getHotGame;
    }


    @Override
    public Observable<ArrayList<D11HotGame>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<D11HotGame> d11HotGame = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null) {
                        for (int i = 0; i < response.length(); i++) {
                            d11HotGame.add(D11HotGame.newInstance(response.optJSONObject(i)));
                        }
                    }
                    return d11HotGame;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityItemList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetD11HotGameCallBack) kzingCallBack).onSuccess(activityItemList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetD11HotGameAPI addGetD11HotGameCallBack(GetD11HotGameCallBack getD11HotGameCallBack) {
        kzingCallBackList.add(getD11HotGameCallBack);
        return this;
    }

    public interface GetD11HotGameCallBack extends KzingCallBack {
        void onSuccess(ArrayList<D11HotGame> d11HotGame);
    }

}
