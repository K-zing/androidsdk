package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.WithdrawField;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetWithdrawFieldsAPI extends CoreRequest {

    private String ppid;

    GetWithdrawFieldsAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getWithdrawFields;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("ppid", ppid);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<WithdrawField>> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<WithdrawField> withdrawFieldList = new ArrayList<>();
            JSONArray fieldsArray = jsonResponse.optJSONArray("fields");
            if (fieldsArray != null) {
                for (int i = 0; i < fieldsArray.length(); i++) {
                    withdrawFieldList.add(WithdrawField.newInstance(fieldsArray.optJSONObject(i)));
                }
            }
            return withdrawFieldList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(withdrawFieldList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetWithdrawFieldsCallBack) kzingCallBack).onSuccess(withdrawFieldList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetWithdrawFieldsAPI addGetWithdrawFieldsCallBack(GetWithdrawFieldsCallBack getWithdrawFieldsCallBack) {
        kzingCallBackList.add(getWithdrawFieldsCallBack);
        return this;
    }

    public GetWithdrawFieldsAPI setPpid(String ppid) {
        this.ppid = ppid;
        return this;
    }

    public interface GetWithdrawFieldsCallBack extends KzingCallBack {
        void onSuccess(ArrayList<WithdrawField> withdrawFieldList);
    }
}

