package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import java.util.HashMap;

import io.reactivex.Observable;

public class GetSiteDomainAPI extends CoreRequest {

    GetSiteDomainAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getSiteDomain;
    }

    @Override
    public Observable<HashMap<String, String>> requestRx(Context context) {
        return Observable.just(new HashMap<>());
//        return super.baseExecute(context)
//                .map(jsonResponse -> {
//                    HashMap<String, String> configValueMap = new HashMap<>();
//                    JSONObject response = jsonResponse.optJSONObject("response");
//                    SharePrefUtil.putString(context, Constant.Pref.DOMAIN, response.toString());
//                    dynamicDomainChanged = true;
//                    return configValueMap;
//                }).doOnError(jsonResponse -> {
//                    SharePrefUtil.removeString(context, Constant.Pref.DOMAIN);
//                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(configValueMap -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetSiteDomainCallBack) kzingCallBack).onSuccess(configValueMap);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetSiteDomainAPI addGetSiteDomainCallBack(GetSiteDomainCallBack getSiteDomainCallBack) {
        kzingCallBackList.add(getSiteDomainCallBack);
        return this;
    }

    public interface GetSiteDomainCallBack extends KzingCallBack {
        void onSuccess(HashMap<String, String> configValueMap);
    }

}
