package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.DownloadAppItem;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetDownloadAppListAPI extends CoreRequest {

    public GetDownloadAppListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getDownloadAppList;
    }
    
    @Override
    public Observable<ArrayList<DownloadAppItem>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<DownloadAppItem> downAppList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("response");
                    for (int i = 0; i < response.length(); i++) {
                        downAppList.add(DownloadAppItem.newInstance(response.optJSONObject(i)));
                    }
                    return downAppList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(downAppList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetDownloadAppListCallBack) kzingCallBack).onSuccess(downAppList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetDownloadAppListAPI addGetBounsListCallBack(GetDownloadAppListCallBack getDownloadAppListCallBack){
        kzingCallBackList.add(getDownloadAppListCallBack);
        return this;
    }

    public interface GetDownloadAppListCallBack extends KzingCallBack{
        void onSuccess(ArrayList<DownloadAppItem> downAppList);
    }

}
