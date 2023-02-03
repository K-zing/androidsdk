package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.WebsiteContentConfig;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetWebsiteContentConfigAPI extends CoreRequest {

    GetWebsiteContentConfigAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getWebsiteContentConfig;
    }

    @Override
    public Observable<ArrayList<WebsiteContentConfig>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<WebsiteContentConfig> currencyRateList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null)
                        for (int i = 0; i < response.length(); i++) {
                            currencyRateList.add(WebsiteContentConfig.newInstance(response.optJSONObject(i)));
                        }
                    return currencyRateList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(websiteContentConfigs -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetWebsiteContentConfigCallBack) kzingCallBack).onSuccess(websiteContentConfigs);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetWebsiteContentConfigAPI addGetWebsiteContentConfigCallBack(GetWebsiteContentConfigCallBack getWebsiteContentConfigCallBack) {
        kzingCallBackList.add(getWebsiteContentConfigCallBack);
        return this;
    }

    public interface GetWebsiteContentConfigCallBack extends KzingCallBack {
        void onSuccess(ArrayList<WebsiteContentConfig> websiteContentConfigs);
    }

}
