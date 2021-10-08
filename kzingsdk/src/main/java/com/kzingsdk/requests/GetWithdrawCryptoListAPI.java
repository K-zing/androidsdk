package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.BonusReturn;
import com.kzingsdk.entity.WithdrawCrypto;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetWithdrawCryptoListAPI extends CoreRequest {

    GetWithdrawCryptoListAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getWithdrawCryptoList;
    }

    @Override
    public Observable<ArrayList<WithdrawCrypto>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            JSONArray response = jsonResponse.optJSONArray("response");
            ArrayList<WithdrawCrypto> withdrawCryptoList = new ArrayList<>();
            for (int i = 0; i < response.length(); i++) {
                withdrawCryptoList.add(WithdrawCrypto.newInstance(response.optJSONObject(i)));
            }
            return withdrawCryptoList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(withdrawCryptoList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetWithdrawCryptoListCallBack) kzingCallBack).onSuccess(withdrawCryptoList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetWithdrawCryptoListAPI addGetWithdrawCryptoListCallBack(GetWithdrawCryptoListCallBack getWithdrawCryptoListCallBack){
        kzingCallBackList.add(getWithdrawCryptoListCallBack);
        return this;
    }

    public interface GetWithdrawCryptoListCallBack extends KzingCallBack{
        void onSuccess(ArrayList<WithdrawCrypto> withdrawCryptoList);
    }
}

