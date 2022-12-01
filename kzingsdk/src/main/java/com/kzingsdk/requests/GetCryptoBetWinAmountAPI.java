package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CryptoBetWinAmount;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetCryptoBetWinAmountAPI extends CoreRequest {

    private String gpType;
    private String randomNum;
    private String start;
    private String end;
    private String skipFake;

    GetCryptoBetWinAmountAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getCryptoBetWinAmount;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gptype", gpType);
            if (randomNum != null)
                jsonData.put("random_num", randomNum);
            if (start != null)
                jsonData.put("start", start);
            if (end != null)
                jsonData.put("end", end);
            if (skipFake != null)
                jsonData.put("skip_fake", skipFake);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
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

    public GetCryptoBetWinAmountAPI setGpType(String gpType) {
        this.gpType = gpType;
        return this;
    }

    public GetCryptoBetWinAmountAPI setRandomNum(String randomNum) {
        this.randomNum = randomNum;
        return this;
    }

    public GetCryptoBetWinAmountAPI setStart(String start) {
        this.start = start;
        return this;
    }

    public GetCryptoBetWinAmountAPI setEnd(String end) {
        this.end = end;
        return this;
    }

    public GetCryptoBetWinAmountAPI setSkipFake(String skipFake) {
        this.skipFake = skipFake;
        return this;
    }

    public interface GetCryptoBetWinAmountCallBack extends KzingCallBack {
        void onSuccess(ArrayList<CryptoBetWinAmount> cryptoBetWinAmountList);
    }
}
