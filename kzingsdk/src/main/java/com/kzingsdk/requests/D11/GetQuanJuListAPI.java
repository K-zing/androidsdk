package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.QuanJu;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetQuanJuListAPI extends BaseD11API {

    GetQuanJuListAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getQuanJuList;
    }


    @Override
    public Observable<ArrayList<QuanJu>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<QuanJu> quanJuArrayList = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null) {
                        for (int i = 0; i < response.length(); i++) {
                            quanJuArrayList.add(QuanJu.newInstance(response.optJSONObject(i)));
                        }
                    }
                    return quanJuArrayList;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(quanJu -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetQuanJuListCallBack) kzingCallBack).onSuccess(quanJu);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetQuanJuListAPI addGetQuanJuListCallBack(GetQuanJuListCallBack getQuanJuListCallBack) {
        kzingCallBackList.add(getQuanJuListCallBack);
        return this;
    }

    public interface GetQuanJuListCallBack extends KzingCallBack {
        void onSuccess(ArrayList<QuanJu> quanJuList);
    }

}
