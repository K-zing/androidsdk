package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.AutoRankInfo;
import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import io.reactivex.Observable;

public class GetAutoRankInfoAPI extends CoreRequest {

    GetAutoRankInfoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getAutoRankInfo;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    public Observable<GetAutoRankInfoResponse> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            return GetAutoRankInfoResponse.newInstance(jsonResponse.optJSONObject("response"));
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getAutoRankInfoResponse -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetAutoRankInfoCallBack) kzingCallBack).onSuccess(getAutoRankInfoResponse);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetAutoRankInfoAPI addGetAutoRankInfoCallBack(GetAutoRankInfoCallBack getAutoRankInfoCallBack) {
        kzingCallBackList.add(getAutoRankInfoCallBack);
        return this;
    }

    public interface GetAutoRankInfoCallBack extends KzingCallBack {
        void onSuccess(GetAutoRankInfoResponse getAutoRankInfoResponse);
    }

    public static class GetAutoRankInfoResponse {
        private AutoRankInfo ctAutoRankInfo;
        private AutoRankInfo ntAutoRankInfo;

        public static GetAutoRankInfoResponse newInstance(JSONObject rootObject) {
            GetAutoRankInfoResponse getAutoRankInfoResponse = new GetAutoRankInfoResponse();
            AutoRankInfo ctAutoRankInfo = new AutoRankInfo();
            ctAutoRankInfo.setLv(rootObject.optString("ct_lv"));
            ctAutoRankInfo.setTurnover(BigDecimalUtil.optBigDecimal(rootObject, "ct_turnover"));
            ctAutoRankInfo.setReward(BigDecimalUtil.optBigDecimal(rootObject, "ct_reward"));
            ctAutoRankInfo.setNftReward(BigDecimalUtil.optBigDecimal(rootObject, "ct_nftreward"));
            ctAutoRankInfo.setMonthlyReward(BigDecimalUtil.optBigDecimal(rootObject, "ct_monthlyreward"));
            ctAutoRankInfo.setBirthdayReward(BigDecimalUtil.optBigDecimal(rootObject, "ct_birthdayreward"));
            AutoRankInfo ntAutoRankInfo = new AutoRankInfo();
            ntAutoRankInfo.setLv(rootObject.optString("nt_lv"));
            ntAutoRankInfo.setTurnover(BigDecimalUtil.optBigDecimal(rootObject, "nt_turnover"));
            ntAutoRankInfo.setReward(BigDecimalUtil.optBigDecimal(rootObject, "nt_reward"));
            ntAutoRankInfo.setNftReward(BigDecimalUtil.optBigDecimal(rootObject, "nt_nftreward"));
            ntAutoRankInfo.setMonthlyReward(BigDecimalUtil.optBigDecimal(rootObject, "nt_monthlyreward"));
            ntAutoRankInfo.setBirthdayReward(BigDecimalUtil.optBigDecimal(rootObject, "nt_birthdayreward"));
            getAutoRankInfoResponse.ctAutoRankInfo = ctAutoRankInfo;
            getAutoRankInfoResponse.ntAutoRankInfo = ntAutoRankInfo;
            return getAutoRankInfoResponse;
        }

        public AutoRankInfo getCtAutoRankInfo() {
            return ctAutoRankInfo;
        }

        public void setCtAutoRankInfo(AutoRankInfo ctAutoRankInfo) {
            this.ctAutoRankInfo = ctAutoRankInfo;
        }

        public AutoRankInfo getNtAutoRankInfo() {
            return ntAutoRankInfo;
        }

        public void setNtAutoRankInfo(AutoRankInfo ntAutoRankInfo) {
            this.ntAutoRankInfo = ntAutoRankInfo;
        }
    }

}
