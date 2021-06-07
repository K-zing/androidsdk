package com.kzingsdk.requests.K36;

import android.content.Context;

import com.kzingsdk.entity.K36.K36ActivityInfo;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Observable;

public class GetNewComerActivityAPI extends BaseK36API {

    GetNewComerActivityAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getNewComerActivity;
    }

    public static final String[] actTypeIds = new String[]{
            "5012",
            "5013",
            "6000",
            "6001",
            "6002"
    };

    @Override
    public Observable<HashMap<String, GetNewComerActivityResult>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    HashMap<String, GetNewComerActivityResult> getNewComerActivityResultMap = new HashMap<>();
                    for (String actTypeId : actTypeIds) {
                        JSONObject typeObject = jsonResponse.optJSONObject(actTypeId);
                        if (typeObject != null) {
                            getNewComerActivityResultMap.put(actTypeId, GetNewComerActivityResult.newInstance(typeObject));
                        }
                    }
                    return getNewComerActivityResultMap;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(getNewComerActivityResultMap -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetNewComerActivityAPICallBack) kzingCallBack).onSuccess(getNewComerActivityResultMap);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetNewComerActivityAPI addGetNewComerActivityAPICallBack(GetNewComerActivityAPICallBack getNewComerActivityAPICallBack) {
        kzingCallBackList.add(getNewComerActivityAPICallBack);
        return this;
    }

    public interface GetNewComerActivityAPICallBack extends KzingCallBack {
        void onSuccess(HashMap<String, GetNewComerActivityResult> getNewComerActivityResultMap);
    }

    public static class GetNewComerActivityResult {

        private String actId;
        private Integer status;
        private String msg;
        private K36ActivityInfo k36ActivityInfo;

        public static GetNewComerActivityResult newInstance(JSONObject rootObject) {
            GetNewComerActivityResult getNewComerActivityResult = new GetNewComerActivityResult();
            getNewComerActivityResult.setActId(rootObject.optString("actid"));
            getNewComerActivityResult.setStatus(rootObject.optInt("status"));
            getNewComerActivityResult.setMsg(rootObject.optString("msg"));
            JSONObject resultObject = rootObject.optJSONObject("result");
            if (resultObject != null) {
                getNewComerActivityResult.k36ActivityInfo = K36ActivityInfo.newInstance(resultObject);
            }
            return getNewComerActivityResult;
        }

        public String getActId() {
            return actId;
        }

        public void setActId(String actId) {
            this.actId = actId;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public K36ActivityInfo getK36ActivityInfo() {
            return k36ActivityInfo;
        }

        public void setK36ActivityInfo(K36ActivityInfo k36ActivityInfo) {
            this.k36ActivityInfo = k36ActivityInfo;
        }
    }

}
