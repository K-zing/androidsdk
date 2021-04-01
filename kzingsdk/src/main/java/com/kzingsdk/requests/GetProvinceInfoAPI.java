package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.Province;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;


public class GetProvinceInfoAPI extends CoreRequest {

    GetProvinceInfoAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getProvinceInfo;
    }

    @Override
    public Observable<ArrayList<Province>> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> {
            ArrayList<Province> provinceList = new ArrayList<>();
            JSONArray provincesArray = jsonResponse.optJSONArray("provinces");
            if (provincesArray != null) {
                for (int i = 0; i < provincesArray.length(); i++) {
                    provinceList.add(Province.newInstance(provincesArray.optJSONObject(i)));
                }
            }
            return provinceList;
        });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(provinceList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetProvinceInfoCallBack) kzingCallBack).onSuccess(provinceList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetProvinceInfoAPI addGetProvinceInfoCallBack(GetProvinceInfoCallBack getProvinceInfoCallBack) {
        kzingCallBackList.add(getProvinceInfoCallBack);
        return this;
    }

    public interface GetProvinceInfoCallBack extends KzingCallBack {
        void onSuccess(ArrayList<Province> provinceList);
    }

}
