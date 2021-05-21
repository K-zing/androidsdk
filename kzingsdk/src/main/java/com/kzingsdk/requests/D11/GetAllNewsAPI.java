package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.entity.D11.D11News;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GetAllNewsAPI extends BaseD11API {

    GetAllNewsAPI() {
        super();
    }

    @Override
    protected String getD11Action() {
        return Action.getAllNews;
    }


    @Override
    public Observable<ArrayList<D11News>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<D11News> d11News = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null) {
                        for (int i = 0; i < response.length(); i++) {
                            d11News.add(D11News.newInstance(response.optJSONObject(i)));
                        }
                    }
                    return d11News;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(d11News -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetAllNewsCallBack) kzingCallBack).onSuccess(d11News);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetAllNewsAPI addGetAllNewsCallBack(GetAllNewsCallBack getAllNewsCallBack) {
        kzingCallBackList.add(getAllNewsCallBack);
        return this;
    }

    public interface GetAllNewsCallBack extends KzingCallBack {
        void onSuccess(ArrayList<D11News> d11News);
    }

}
