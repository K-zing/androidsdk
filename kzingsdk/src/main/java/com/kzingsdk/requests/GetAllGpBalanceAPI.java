package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class GetAllGpBalanceAPI extends CoreRequest {

    GetAllGpBalanceAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getAllGpBalance;
    }

    @Override
    public Observable<Map<String, GpBalanceStatus>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    Map<String, GpBalanceStatus> gpBalanceMap = new HashMap<>();
                    JSONArray response = jsonResponse.optJSONArray("gpBalances");
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject responseObject = response.optJSONObject(i);
                        gpBalanceMap.put(responseObject.optString("gpid"),
                                new GpBalanceStatus(responseObject.optString("val"), responseObject.optInt("status")));
                    }
                    return gpBalanceMap;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(gpBalanceMap -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetAllGpBalanceCallBack) kzingCallBack).onSuccess(gpBalanceMap);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetAllGpBalanceAPI addGetAllGpBalanceCallBack(GetAllGpBalanceCallBack getAllGpBalanceCallBack) {
        kzingCallBackList.add(getAllGpBalanceCallBack);
        return this;
    }

    public interface GetAllGpBalanceCallBack extends KzingCallBack {
        void onSuccess(Map<String, GpBalanceStatus> gpBalanceMap);
    }

    public static class GpBalanceStatus {
        private String value;
        private int status;

        public GpBalanceStatus(String value, int status) {
            this.value = value;
            this.status = status;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }


}
