package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class DeleteMessageAPI extends CoreRequest {

    private List<String> idList = new ArrayList<>();

    DeleteMessageAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.deleteMessage;
    }

    @Override
    protected Observable<String> validateParams() {
        if (idList.size() == 0) {
            return Observable.just("IDs is empty");
        }
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            JSONArray idArray = new JSONArray();
            for (String id : idList) {
                idArray.put(id);
            }
            jsonData.put("ids", idArray);
            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> "Success");
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(message -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((DeleteMessageCallBack) kzingCallBack).onSuccess();
                }
            }
        }, defaultOnErrorConsumer);
    }

    public DeleteMessageAPI addDeleteMessageCallBack(DeleteMessageCallBack deleteMessageCallBack) {
        kzingCallBackList.add(deleteMessageCallBack);
        return this;
    }

    /**
     * @param id From {@link com.kzingsdk.entity.Message} returned by {@link GetMessageListAPI}
     */
    public DeleteMessageAPI addParamIds(String... id) {
        idList.addAll(Arrays.asList(id));
        return this;
    }

    public DeleteMessageAPI clearParamIds() {
        idList.clear();
        return this;
    }

    public interface DeleteMessageCallBack extends KzingCallBack {
        void onSuccess();
    }


}
