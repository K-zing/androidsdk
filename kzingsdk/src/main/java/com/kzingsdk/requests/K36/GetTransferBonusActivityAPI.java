package com.kzingsdk.requests.K36;

import android.content.Context;

import com.kzingsdk.entity.K36.TransferBonusActivity;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONObject;

import io.reactivex.Observable;

public class GetTransferBonusActivityAPI extends BaseK36API {

    GetTransferBonusActivityAPI() {
        super();
    }

    @Override
    protected String getK36Action() {
        return Action.getTransferBonusActivity;
    }

    @Override
    public Observable<GetTransferBonusActivityResult> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    return GetTransferBonusActivityResult.newInstance(jsonResponse);
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getTransferBonusActivityResult -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetTransferBonusActivityAPICallBack) kzingCallBack).onSuccess(getTransferBonusActivityResult);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetTransferBonusActivityAPI addGetTransferBonusActivityAPICallBack(GetTransferBonusActivityAPICallBack getTransferBonusActivityAPICallBack) {
        kzingCallBackList.add(getTransferBonusActivityAPICallBack);
        return this;
    }

    public interface GetTransferBonusActivityAPICallBack extends KzingCallBack {
        void onSuccess(GetTransferBonusActivityResult getTransferBonusActivityResult);
    }

    public static class GetTransferBonusActivityResult {

        private int status;
        private TransferBonusActivity transferBonusActivity;


        public static GetTransferBonusActivityResult newInstance(JSONObject rootObject) {
            GetTransferBonusActivityResult getTransferBonusActivityResult = new GetTransferBonusActivityResult();
            getTransferBonusActivityResult.status = rootObject.optInt("status");
            getTransferBonusActivityResult.transferBonusActivity = TransferBonusActivity.newInstance(rootObject.optJSONObject("data"));
            return getTransferBonusActivityResult;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public TransferBonusActivity getTransferBonusActivity() {
            return transferBonusActivity;
        }

        public void setTransferBonusActivity(TransferBonusActivity transferBonusActivity) {
            this.transferBonusActivity = transferBonusActivity;
        }
    }


}
