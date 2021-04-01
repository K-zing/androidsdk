package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.deposit.DepositFormField;
import com.kzingsdk.entity.deposit.DepositFormFieldRow;
import com.kzingsdk.entity.deposit.ThirdPartyPayment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetDepositFormFieldsAPI extends CoreRequest {

    private ThirdPartyPayment thirdPartyPayment = null;

    GetDepositFormFieldsAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getDepositFormFields;
    }


    @Override
    protected Observable<String> validateParams() {

        if (thirdPartyPayment == null) {
            return Observable.just("ArrayList<DepositFormFieldRow> is missing");
        }
        if (thirdPartyPayment.getFormType() == null || thirdPartyPayment.getFormType().length() == 0) {
            return Observable.just("FormType is missing. ArrayList<DepositFormFieldRow> object is invalid.");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("formtype", thirdPartyPayment.getFormType());
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<ArrayList<DepositFormFieldRow>> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<DepositFormFieldRow> rowArrayList = new ArrayList<>();
            ArrayList<DepositFormField> fieldArrayList = new ArrayList<>();
            JSONArray rowsArray = jsonResponse.optJSONArray("rows");
            if (rowsArray != null) {
                for (int i = 0; i < rowsArray.length(); i++) {
                    rowArrayList.add(DepositFormFieldRow.newInstance(rowsArray.optJSONObject(i)));
                }
            }
            JSONArray fieldsArray = jsonResponse.optJSONArray("field");
            if (fieldsArray != null) {
                for (int i = 0; i < fieldsArray.length(); i++) {
                    fieldArrayList.add(DepositFormField.newInstance(fieldsArray.optJSONObject(i)));
                }
            }
            for (DepositFormField depositFormField : fieldArrayList) {
                for (DepositFormFieldRow depositFormFieldRow : rowArrayList) {
                    if (depositFormField.getRowId() == depositFormFieldRow.getRowId()) {
                        depositFormFieldRow.getFieldArrayList().add(depositFormField);
                        break;
                    }
                }
            }
            return rowArrayList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(rowArrayList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetDepositFormFieldsCallBack) kzingCallBack).onSuccess(rowArrayList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetDepositFormFieldsAPI addGetDepositFormFieldsCallBack(GetDepositFormFieldsCallBack getDepositFormFieldsCallBack) {
        kzingCallBackList.add(getDepositFormFieldsCallBack);
        return this;
    }

    public interface GetDepositFormFieldsCallBack extends KzingCallBack {
        void onSuccess(ArrayList<DepositFormFieldRow> rowArrayList);
    }

    public GetDepositFormFieldsAPI setThirdPartyPayment(ThirdPartyPayment thirdPartyPayment) {
        this.thirdPartyPayment = thirdPartyPayment;
        return this;
    }


}
