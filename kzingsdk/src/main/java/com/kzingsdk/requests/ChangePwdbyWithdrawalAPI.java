package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class ChangePwdbyWithdrawalAPI extends CoreRequest {

    private String wdpassword = null;
    private String password = null;
    private String playername = null;

    ChangePwdbyWithdrawalAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.changePwdbyWithdrawal;
    }

    @Override
    protected Observable<String> validateParams() {
        if (wdpassword == null) {
            return Observable.just("Wdpassword is missing");
        }
        if (password == null) {
            return Observable.just("Password is missing");
        }
        if (playername == null) {
            return Observable.just("Playername is missing");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("wdpassword", wdpassword);
            jsonData.put("pwd", password);
            jsonData.put("playername", playername);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<Boolean> requestRx(final Context context) {
        return super.baseExecute(context).map((result) -> true);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(success -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ChangePwdbyWithdrawalCallBack) kzingCallBack).onSuccess(success);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ChangePwdbyWithdrawalAPI addChangePwdbyWithdrawalCallBack(ChangePwdbyWithdrawalCallBack changePwdbyWithdrawalCallBack) {
        kzingCallBackList.add(changePwdbyWithdrawalCallBack);
        return this;
    }

    public ChangePwdbyWithdrawalAPI setWdpassword(String wdpassword) {
        this.wdpassword = wdpassword;
        return this;
    }

    public ChangePwdbyWithdrawalAPI setPassword(String password) {
        this.password = password;
        return this;
    }

    public ChangePwdbyWithdrawalAPI setPlayername(String playername) {
        this.playername = playername;
        return this;
    }

    public interface ChangePwdbyWithdrawalCallBack extends KzingCallBack {
        void onSuccess(Boolean success);
    }


}
