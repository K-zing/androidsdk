package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class EditBankCardAPI extends CoreRequest {

    EditBankCardAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.editBankCard;
    }

    private String wdbankid;

    private String note = null;
    private String ifsccode = null;

    @Override
    protected Observable<String> validateParams() {
        if (wdbankid == null || wdbankid.length() == 0) {
            return Observable.just("ID is not valid");
        }
        if (note == null && ifsccode == null) {
            return Observable.just("You need to edit something");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("wdbankid", wdbankid);
            if (note != null) {
                jsonData.put("note", note);
            }
            if (ifsccode != null) {
                jsonData.put("ifsccode", ifsccode);
            }
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }


    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(ignore -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((EditBankCardCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public EditBankCardAPI addEditBankCardCallBack(EditBankCardAPI.EditBankCardCallBack editBankCardCallBack) {
        kzingCallBackList.add(editBankCardCallBack);
        return this;
    }

    public interface EditBankCardCallBack extends KzingCallBack {
        void onSuccess();
    }

    public EditBankCardAPI addWdBankId(String wdbankid) {
        this.wdbankid = wdbankid;
        return this;
    }

    public EditBankCardAPI setNote(String note) {
        this.note = note;
        return this;
    }

    public EditBankCardAPI setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
        return this;
    }
}
