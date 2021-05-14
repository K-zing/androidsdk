package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.D11.WanBo;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetWanBoAPI extends CoreRequest {

    GetWanBoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getWanBo;
    }

    @Override
    public Observable<ArrayList<WanBo>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<WanBo> wanBos = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null) {
                        for (int i = 0; i < response.length(); i++) {
                            wanBos.add(WanBo.newInstance(response.optJSONObject(i)));
                        }
                    }
                    return wanBos;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(activityItemList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetWanBoCallBack) kzingCallBack).onSuccess(activityItemList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetWanBoAPI addGetWanBoCallBack(GetWanBoCallBack getWanBoCallBack) {
        kzingCallBackList.add(getWanBoCallBack);
        return this;
    }

    public interface GetWanBoCallBack extends KzingCallBack {
        void onSuccess(ArrayList<WanBo> activityItemList);
    }

}
