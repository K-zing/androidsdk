package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.CryptoTransaction;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;

public class CryptoGetTransactionAPI extends CoreRequest {

    private Calendar startDateCalendar, endDateCalendar;
    private int offset = 0;
    private int pageCount = 20;

    CryptoGetTransactionAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.cryptoGetTransaction;
    }

    @Override
    protected Observable<String> validateParams() {
        if (startDateCalendar == null) {
            return Observable.just("Start date is missing");
        }
        if (endDateCalendar == null) {
            return Observable.just("End date is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("pagecount", pageCount);
            jsonData.put("offset", offset);
            jsonData.put("start", Constant.FULL_DATE_FORMAT.format(startDateCalendar.getTime()));
            jsonData.put("end", Constant.FULL_DATE_FORMAT.format(endDateCalendar.getTime()));
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<CryptoTransaction>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<CryptoTransaction> cryptoTransactions = new ArrayList<>();
            JSONArray response = jsonResponse.optJSONArray("response");
            for (int i = 0; i < response.length(); i++) {
                cryptoTransactions.add(CryptoTransaction.newInstance(response.optJSONObject(i)));
            }
            return cryptoTransactions;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(cryptoTransactions -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetCryptoTransactionsCallBack) kzingCallBack).onSuccess(cryptoTransactions);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public CryptoGetTransactionAPI addGetCryptoTransactionsCallBack(GetCryptoTransactionsCallBack cryptoGetTransactionCallBack) {
        kzingCallBackList.add(cryptoGetTransactionCallBack);
        return this;
    }

    public CryptoGetTransactionAPI setStartDateCalendar(Calendar startDateCalendar) {
        this.startDateCalendar = startDateCalendar;
        return this;
    }

    public CryptoGetTransactionAPI setEndDateCalendar(Calendar endDateCalendar) {
        this.endDateCalendar = endDateCalendar;
        return this;
    }

    public CryptoGetTransactionAPI setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public CryptoGetTransactionAPI setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public interface GetCryptoTransactionsCallBack extends KzingCallBack {
        void onSuccess(ArrayList<CryptoTransaction> cryptoTransactions);
    }

}

