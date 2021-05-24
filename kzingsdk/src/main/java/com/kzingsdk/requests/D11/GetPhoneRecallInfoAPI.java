package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.PhoneRecallInfo;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetPhoneRecallInfoAPI extends BaseD11API {

    GetPhoneRecallInfoAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getPhoneRecallInfo;
    }

    @Override
    public Observable<ArrayList<PhoneRecallInfo>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<PhoneRecallInfo> phoneRecallInfos = new ArrayList<>();
                    JSONObject response = jsonResponse.optJSONObject("data");
                    JSONObject response2 = response.optJSONObject("data");
                    JSONArray questArray = response2.optJSONArray("quests");
                    if (questArray != null) {
                        for (int i = 0; i < questArray.length(); i++) {
                            phoneRecallInfos.add(PhoneRecallInfo.newInstance(questArray.optJSONObject(i)));
                        }
                    }
                    return phoneRecallInfos;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(phoneRecallInfoList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetPhoneRecallInfoCallBack) kzingCallBack).onSuccess(phoneRecallInfoList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetPhoneRecallInfoAPI addGetPhoneRecallInfoCallBack(GetPhoneRecallInfoCallBack getPhoneRecallInfoCallBack) {
        kzingCallBackList.add(getPhoneRecallInfoCallBack);
        return this;
    }

    public interface GetPhoneRecallInfoCallBack extends KzingCallBack {
        void onSuccess(ArrayList<PhoneRecallInfo> phoneRecallInfoList);
    }

}
