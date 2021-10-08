package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;


public class GetEncryptKeyAPI extends CoreRequest {

    GetEncryptKeyAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getEncryptKey;
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> jsonResponse.optString("response"));
    }

    @Override
    protected JSONObject generateParamsJson() {
        try {
            JSONObject dataObject = new JSONObject();
            dataObject.put("getPrivateKey","");
            return dataObject;
//            return new JSONObject("{\"getPrivateKey\": \"\"}");
        } catch (JSONException e) {
        }
        return super.generateParamsJson();
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(dataRsaKey -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetEncryptKeyCallBack) kzingCallBack).onSuccess(dataRsaKey);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetEncryptKeyAPI addEncryptKeyCallBack(GetEncryptKeyCallBack getEncryptKeyCallBack){
        kzingCallBackList.add(getEncryptKeyCallBack);
        return this;
    }

    public interface GetEncryptKeyCallBack extends KzingCallBack{
        void onSuccess(String dataRsaKey);
    }

}
