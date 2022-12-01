package com.kzingsdk.requests.K36;

import android.content.Context;

import com.kzingsdk.entity.K36.GetNewComerActivityResult;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Observable;

public class GetNewComerActivityAPI extends BaseK36API {

    public static final String[] actTypeIds = new String[]{
            "5012",
            "5013",
            "6000",
            "6001",
            "6002"
    };

    GetNewComerActivityAPI() {
        super();
    }

    @Override
    protected String getK36Action() {
        return Action.getNewComerActivity;
    }

    @Override
    public Observable<HashMap<String, GetNewComerActivityResult>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    HashMap<String, GetNewComerActivityResult> getNewComerActivityResultMap = new HashMap<>();
                    for (String actTypeId : actTypeIds) {
                        JSONObject typeObject = jsonResponse.optJSONObject(actTypeId);
                        if (typeObject != null) {
                            getNewComerActivityResultMap.put(actTypeId, GetNewComerActivityResult.newInstance(typeObject));
                        }
                    }
                    return getNewComerActivityResultMap;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getNewComerActivityResultMap -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetNewComerActivityAPICallBack) kzingCallBack).onSuccess(getNewComerActivityResultMap);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetNewComerActivityAPI addGetNewComerActivityAPICallBack(GetNewComerActivityAPICallBack getNewComerActivityAPICallBack) {
        kzingCallBackList.add(getNewComerActivityAPICallBack);
        return this;
    }

    public interface GetNewComerActivityAPICallBack extends KzingCallBack {
        void onSuccess(HashMap<String, GetNewComerActivityResult> getNewComerActivityResultMap);
    }


}
