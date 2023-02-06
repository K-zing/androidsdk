package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.AtmOldBank;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class AtmOldBankGetBankCardAPI extends CoreRequest {


    AtmOldBankGetBankCardAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.atmOldBankGetBankCard;
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
    public Observable<ArrayList<AtmOldBank>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<AtmOldBank> lists = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("data");
            if (response != null) {
                for (int i = 0; i < response.length(); i++) {
                    lists.add(AtmOldBank.newInstance(response.optJSONObject(i)));
                }
            }
            return lists;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(atmOldBanks -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((AtmOldBankGetBankCardCallBack) kzingCallBack).onSuccess(atmOldBanks);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public AtmOldBankGetBankCardAPI addAtmOldBankGetBankCardCallBack(AtmOldBankGetBankCardCallBack atmOldBankGetBankCardCallBack) {
        kzingCallBackList.add(atmOldBankGetBankCardCallBack);
        return this;
    }

    public interface AtmOldBankGetBankCardCallBack extends KzingCallBack {
        void onSuccess(ArrayList<AtmOldBank> atmOldBanks);
    }

}

