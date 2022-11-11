package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.SubmitBankTransferResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class SubmitBankTransferAPI extends CoreRequest {

    private String ppid;
    private String optionId;
    private String depositUser;
    private String amount;
    private String bank;
    private String utmCode;
    private String ac;
    private String formData;
    private String pgDepositUserName;
    private String protocol;

    @Override
    protected String getAction() {
        return Action.submitBankTransfer;
    }

    SubmitBankTransferAPI() {
        super();
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("ppid", ppid);
            jsonData.put("optionid", optionId);
            jsonData.put("deposituser", depositUser);
            jsonData.put("amount", amount);
            jsonData.put("bank", bank);
            jsonData.put("utm_code", utmCode);
            jsonData.put("ac", ac);
            jsonData.put("formData", formData);
            jsonData.put("pgdepositusername", pgDepositUserName);
            jsonData.put("protocol", protocol);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<SubmitBankTransferResult> requestRx(final Context context) {
        return super.baseExecute(context).map(SubmitBankTransferResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(submitBankTransferResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((SubmitBankTransferCallBack) kzingCallBack).onSuccess(submitBankTransferResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public SubmitBankTransferAPI addSubmitBankTransferCallBack(SubmitBankTransferCallBack submitBankTransferCallBack) {
        kzingCallBackList.add(submitBankTransferCallBack);
        return this;
    }

    public interface SubmitBankTransferCallBack extends KzingCallBack {
        void onSuccess(SubmitBankTransferResult submitBankTransferResult);
    }

    public void setPpid(String ppid) {
        this.ppid = ppid;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public void setDepositUser(String depositUser) {
        this.depositUser = depositUser;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setUtmCode(String utmCode) {
        this.utmCode = utmCode;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public void setFormData(String formData) {
        this.formData = formData;
    }

    public void setPgDepositUserName(String pgDepositUserName) {
        this.pgDepositUserName = pgDepositUserName;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}

