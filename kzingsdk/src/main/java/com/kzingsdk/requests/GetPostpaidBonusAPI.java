package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.PostpaidBonus;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetPostpaidBonusAPI extends CoreRequest {

    GetPostpaidBonusAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getPostpaidBonus;
    }

    @Override
    public Observable<ArrayList<PostpaidBonus>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<PostpaidBonus> postpaidBonusList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("activities");
                    for (int i = 0; i < response.length(); i++) {
                        postpaidBonusList.add(PostpaidBonus.newInstance(response.optJSONObject(i)));
                    }
                    return postpaidBonusList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(postpaidBonusList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetPostpaidBonusCallBack) kzingCallBack).onSuccess(postpaidBonusList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetPostpaidBonusAPI addGetPostpaidBonusCallBack(GetPostpaidBonusCallBack getPostpaidBonusCallBack) {
        kzingCallBackList.add(getPostpaidBonusCallBack);
        return this;
    }

    public interface GetPostpaidBonusCallBack extends KzingCallBack {
        void onSuccess(ArrayList<PostpaidBonus> postpaidBonusList);
    }

}
