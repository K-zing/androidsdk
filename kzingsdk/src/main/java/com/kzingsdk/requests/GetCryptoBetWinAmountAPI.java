package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CryptoBetWinAmount;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetCryptoBetWinAmountAPI extends CoreRequest {

    GetCryptoBetWinAmountAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getCryptoBetWinAmount;
    }

    @Override
    public Observable<ArrayList<CryptoBetWinAmount>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<CryptoBetWinAmount> cryptoBetWinAmountList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    for (int i = 0; i < response.length(); i++) {
                        cryptoBetWinAmountList.add(CryptoBetWinAmount.newInstance(response.optJSONObject(i)));
                    }
                    return cryptoBetWinAmountList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(cryptoBetWinAmountList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCryptoBetWinAmountCallBack) kzingCallBack).onSuccess(cryptoBetWinAmountList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetCryptoBetWinAmountAPI addGetCryptoBetWinAmountCallBack(GetCryptoBetWinAmountCallBack getCryptoBetWinAmountCallBack) {
        kzingCallBackList.add(getCryptoBetWinAmountCallBack);
        return this;
    }

    public interface GetCryptoBetWinAmountCallBack extends KzingCallBack {
        void onSuccess(ArrayList<CryptoBetWinAmount> cryptoBetWinAmountList);
    }

}
