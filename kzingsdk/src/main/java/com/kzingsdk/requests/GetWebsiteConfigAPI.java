package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Observable;

public class GetWebsiteConfigAPI extends CoreRequest {

    GetWebsiteConfigAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getWebsiteConfig;
    }

    @Override
    public Observable<HashMap<String, String>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    HashMap<String, String> configValueMap = new HashMap<>();
                    JSONArray configs = jsonResponse.optJSONArray("configs");
                    for (int i = 0; i < configs.length(); i++) {
                        JSONObject configObject = configs.optJSONObject(i);
                        configValueMap.put(configObject.optString("itemKey"), configObject.optString("itemValue"));
                    }
                    return configValueMap;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(configValueMap -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetWebsiteConfigCallBack) kzingCallBack).onSuccess(configValueMap);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetWebsiteConfigAPI addGetWebsiteConfigCallBack(GetWebsiteConfigCallBack getWebsiteConfigCallBack) {
        kzingCallBackList.add(getWebsiteConfigCallBack);
        return this;
    }

    public interface GetWebsiteConfigCallBack extends KzingCallBack {
        void onSuccess(HashMap<String, String> configValueMap);
    }

}
