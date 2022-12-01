package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.CsLink;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONObject;

import io.reactivex.Observable;

public class GetRandomCslinkAPI extends BaseD11API {

    public final String TOP = "top";
    public final String BOTTOM = "bottom";

    GetRandomCslinkAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getRandomCslink;
    }

    @Override
    public Observable<CsLink> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    JSONObject response = jsonResponse.optJSONObject("data");
                    return CsLink.newInstance(response);
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(csLink -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetRandomCslinkCallBack) kzingCallBack).onSuccess(csLink);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetRandomCslinkAPI addGetRandomCslinkCallBack(GetRandomCslinkCallBack getRandomCslinkCallBack) {
        kzingCallBackList.add(getRandomCslinkCallBack);
        return this;
    }

    public interface GetRandomCslinkCallBack extends KzingCallBack {
        void onSuccess(CsLink csLink);
    }

}
