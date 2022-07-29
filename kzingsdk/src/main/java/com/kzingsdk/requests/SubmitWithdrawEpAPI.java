package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.PlayerBankCard;
import com.kzingsdk.entity.WithdrawInfo;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitWithdrawEpAPI extends CoreRequest {

    private String amount;
    private String smsPhoneNo;
    private String smsPhoneNoCountry;
    private String smscode;
    private String usenew;
    private String wdbank;
    private String wdpassword;
    private String bankcode;
    private String card;
    private String account;
    private String addra;
    private String addrb;
    private String banknode;
    private String bankname;
    private String note;
    private String address;
    private String ifsccode;
    private String accid;
    private String accpw;
    private String extraparam;
    private String qpagreement;
    private String qaccount;
    private String qpaypg;

    SubmitWithdrawEpAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected String getAction() {
        return Action.submitWithdrawEp;
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("amount", amount);
            jsonData.put("smsPhoneNo", smsPhoneNo);
            jsonData.put("smsPhoneNoCountry", smsPhoneNoCountry);
            jsonData.put("smscode", smscode);
            jsonData.put("usenew", usenew);
            jsonData.put("wdbank", wdbank);
            jsonData.put("wdpassword", wdpassword);
            jsonData.put("bankcode", bankcode);
            jsonData.put("card", card);
            jsonData.put("account", account);
            jsonData.put("addra", addra);
            jsonData.put("addrb", addrb);
            jsonData.put("banknode", banknode);
            jsonData.put("bankname", bankname);
            jsonData.put("note", note);
            jsonData.put("address", address);
            jsonData.put("ifsccode", ifsccode);
            jsonData.put("accid", accid);
            jsonData.put("accpw", accpw);
            jsonData.put("extraparam", extraparam);
            jsonData.put("qpagreement", qpagreement);
            jsonData.put("qaccount", qaccount);
            jsonData.put("qpaypg", qpaypg);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> jsonResponse.optString("dno"));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(dno -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitWithdrawEpCallBack) kzingCallBack).onSuccess(dno);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitWithdrawEpAPI addSubmitWithdrawEpCallBack(SubmitWithdrawEpCallBack submitWithdrawEpCallBack) {
        kzingCallBackList.add(submitWithdrawEpCallBack);
        return this;
    }

    public interface SubmitWithdrawEpCallBack extends KzingCallBack {
        void onSuccess(String dno);
    }

    public SubmitWithdrawEpAPI setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public SubmitWithdrawEpAPI setSmsPhoneNo(String smsPhoneNo) {
        this.smsPhoneNo = smsPhoneNo;
        return this;
    }

    public SubmitWithdrawEpAPI setSmsPhoneNoCountry(String smsPhoneNoCountry) {
        this.smsPhoneNoCountry = smsPhoneNoCountry;
        return this;
    }

    public SubmitWithdrawEpAPI setSmscode(String smscode) {
        this.smscode = smscode;
        return this;
    }

    public SubmitWithdrawEpAPI setUsenew(String usenew) {
        this.usenew = usenew;
        return this;
    }

    public SubmitWithdrawEpAPI setWdbank(String wdbank) {
        this.wdbank = wdbank;
        return this;
    }

    public SubmitWithdrawEpAPI setWdpassword(String wdpassword) {
        this.wdpassword = wdpassword;
        return this;
    }

    public SubmitWithdrawEpAPI setBankcode(String bankcode) {
        this.bankcode = bankcode;
        return this;
    }

    public SubmitWithdrawEpAPI setCard(String card) {
        this.card = card;
        return this;
    }

    public SubmitWithdrawEpAPI setAccount(String account) {
        this.account = account;
        return this;
    }

    public SubmitWithdrawEpAPI setAddra(String addra) {
        this.addra = addra;
        return this;
    }

    public SubmitWithdrawEpAPI setAddrb(String addrb) {
        this.addrb = addrb;
        return this;
    }

    public SubmitWithdrawEpAPI setBanknode(String banknode) {
        this.banknode = banknode;
        return this;
    }

    public SubmitWithdrawEpAPI setBankname(String bankname) {
        this.bankname = bankname;
        return this;
    }

    public SubmitWithdrawEpAPI setNote(String note) {
        this.note = note;
        return this;
    }

    public SubmitWithdrawEpAPI setAddress(String address) {
        this.address = address;
        return this;
    }

    public SubmitWithdrawEpAPI setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
        return this;
    }

    public SubmitWithdrawEpAPI setAccid(String accid) {
        this.accid = accid;
        return this;
    }

    public SubmitWithdrawEpAPI setAccpw(String accpw) {
        this.accpw = accpw;
        return this;
    }

    public SubmitWithdrawEpAPI setExtraparam(String extraparam) {
        this.extraparam = extraparam;
        return this;
    }

    public SubmitWithdrawEpAPI setQpagreement(String qpagreement) {
        this.qpagreement = qpagreement;
        return this;
    }

    public SubmitWithdrawEpAPI setQaccount(String qaccount) {
        this.qaccount = qaccount;
        return this;
    }

    public SubmitWithdrawEpAPI setQpaypg(String qpaypg) {
        this.qpaypg = qpaypg;
        return this;
    }
}

