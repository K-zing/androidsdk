package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CopyWritingContent;
import com.kzingsdk.entity.MobileFloatingWindow;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetMobileFloatingWindowV2API extends CoreRequest {

    @Override
    protected String getAction() {
        return Action.getMobileFloatingWindowV2;
    }

    GetMobileFloatingWindowV2API() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }


    @Override
    protected JSONObject generateParamsJson() {
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<MobileFloatingWindow>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<MobileFloatingWindow> mobileFloatingWindows = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            if (response != null) {
                for (int i = 0; i < response.length(); i++) {
                    mobileFloatingWindows.add(MobileFloatingWindow.newInstance(response.optJSONObject(i)));
                }
            }
            return mobileFloatingWindows;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(mobileFloatingWindowList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMobileFloatingWindowV2CallBack) kzingCallBack).onSuccess(mobileFloatingWindowList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMobileFloatingWindowV2API addGetMobileFloatingWindowV2CallBack(GetMobileFloatingWindowV2CallBack getMobileFloatingWindowV2CallBack) {
        kzingCallBackList.add(getMobileFloatingWindowV2CallBack);
        return this;
    }

    public interface GetMobileFloatingWindowV2CallBack extends KzingCallBack {
        void onSuccess(ArrayList<MobileFloatingWindow> mobileFloatingWindowList);
    }
}

