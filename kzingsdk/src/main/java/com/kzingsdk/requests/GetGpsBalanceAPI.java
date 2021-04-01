package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.reactivex.Observable;

public class GetGpsBalanceAPI extends CoreRequest {

    GetGpsBalanceAPI() {
        super();
    }

    private Set<String> gpAccountSet = new HashSet<>();

    @Override
    protected String getAction() {
        return Action.getGpsBalance;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            if (gpAccountSet == null || gpAccountSet.size() == 0) {
                jsonData.put("gps", new JSONArray());
            } else {
                JSONArray gpsArray = new JSONArray();
                for (String gpAccountId : gpAccountSet) {
                    gpsArray.put(gpAccountId);
                }
                jsonData.put("gps", gpsArray);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<Map<String, String>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    Map<String, String> gpBalanceMap = new HashMap<>();
                    JSONArray response = jsonResponse.optJSONArray("gpBalances");
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject responseObject = response.optJSONObject(i);
                        gpBalanceMap.put(responseObject.optString("gpid"), responseObject.optString("val"));
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

    public GetGpsBalanceAPI addGetAllGpBalanceCallBack(GetAllGpBalanceCallBack getAllGpBalanceCallBack) {
        kzingCallBackList.add(getAllGpBalanceCallBack);
        return this;
    }

    public interface GetAllGpBalanceCallBack extends KzingCallBack {
        void onSuccess(Map<String, String> gpBalanceMap);
    }

    public GetGpsBalanceAPI addGpAccountId(String gpAccountId) {
        gpAccountSet.add(gpAccountId);
        return this;
    }

}
