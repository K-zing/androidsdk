package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.CsLink;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observable;

public class GetCommonCslinkAPI extends BaseD11API {

    GetCommonCslinkAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getCommonCslink;
    }

    public final String TOP = "top";
    public final String BOTTOM = "bottom";

    @Override
    public Observable<HashMap<String, CsLink>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    HashMap<String, CsLink> csLink = new HashMap<>();
                    JSONObject response = jsonResponse.optJSONObject("data");
                    if (response != null) {
                        csLink.put(TOP, CsLink.newInstance(response.optJSONObject(TOP)));
                        csLink.put(BOTTOM, CsLink.newInstance(response.optJSONObject(BOTTOM)));
                    }
                    return csLink;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(csLinkHashMap -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCommonCslinkCallBack) kzingCallBack).onSuccess(csLinkHashMap);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCommonCslinkAPI addGetCommonCslinkCallBack(GetCommonCslinkCallBack getCommonCslinkCallBack) {
        kzingCallBackList.add(getCommonCslinkCallBack);
        return this;
    }

    public interface GetCommonCslinkCallBack extends KzingCallBack {
        void onSuccess(HashMap<String, CsLink> csLink);
    }

}
