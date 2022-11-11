package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.GetFixAmountRangeResult;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class GetFixAmountRangeAPI extends CoreRequest {
    private String ppid;
    private String optionId;

    @Override
    protected String getAction() {
        return Action.getFixAmountRange;
    }

    GetFixAmountRangeAPI() {
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
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }
    @Override
    public Observable<GetFixAmountRangeResult> requestRx(final Context context) {
        return super.baseExecute(context).map(GetFixAmountRangeResult::newInstance);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getFixAmountRangeResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetFixAmountRangeCallBack) kzingCallBack).onSuccess(getFixAmountRangeResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetFixAmountRangeAPI addGetFixAmountRangeCallBack(GetFixAmountRangeCallBack getFixAmountRangeCallBack) {
        kzingCallBackList.add(getFixAmountRangeCallBack);
        return this;
    }

    public interface GetFixAmountRangeCallBack extends KzingCallBack {
        void onSuccess(GetFixAmountRangeResult getFixAmountRangeResult);
    }

    public void setPpid(String ppid) {
        this.ppid = ppid;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

}

