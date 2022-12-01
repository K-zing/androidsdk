package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.MobilePopupV2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetMobilePopupV2API extends CoreRequest {

    GetMobilePopupV2API() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getMobilePopupV2;
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
    public Observable<ArrayList<MobilePopupV2>> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<MobilePopupV2> mobilePopupV2List = new ArrayList<>();
            JSONArray dataArray = jsonResponse.optJSONArray("data");
            if (dataArray != null) {
                for (int i = 0; i < dataArray.length(); i++) {
                    MobilePopupV2 mobilePopupV2 = MobilePopupV2.newInstance(dataArray.optJSONObject(i));
                    mobilePopupV2List.add(mobilePopupV2);
                }
            }
            return mobilePopupV2List;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(mobilePopupV2List -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetMobilePopupV2CallBack) kzingCallBack).onSuccess(mobilePopupV2List);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetMobilePopupV2API addGetMobilePopupV2CallBack(GetMobilePopupV2CallBack getMobilePopupV2CallBack) {
        kzingCallBackList.add(getMobilePopupV2CallBack);
        return this;
    }

    public interface GetMobilePopupV2CallBack extends KzingCallBack {
        void onSuccess(ArrayList<MobilePopupV2> mobilePopupV2List);
    }


}
