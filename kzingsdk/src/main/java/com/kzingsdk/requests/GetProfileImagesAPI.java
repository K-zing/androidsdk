package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.ProfileImage;
import com.kzingsdk.util.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import io.reactivex.Observable;

public class GetProfileImagesAPI extends CoreRequest {

    public GetProfileImagesAPI() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.getProfileImages;
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        return super.generateParamsJson();
    }

    @Override
    public Observable<ArrayList<ProfileImage>> requestRx(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> {
                    ArrayList<ProfileImage> profileImages = new ArrayList<>();
                    JSONArray response = jsonResponse.optJSONArray("data");
                    if (response != null) {
                        for (int i = 0; i < response.length(); i++) {
                            profileImages.add(ProfileImage.newInstance(response.optJSONObject(i)));
                        }
                    }
                    return profileImages;
                });
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(bonusReturnList -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((GetProfileImagesCallBack) kzingCallBack).onSuccess(bonusReturnList);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public GetProfileImagesAPI addGetProfileImagesCallBack(GetProfileImagesAPI.GetProfileImagesCallBack GetProfileImagesCallBack) {
        kzingCallBackList.add(GetProfileImagesCallBack);
        return this;
    }

    public interface GetProfileImagesCallBack extends KzingCallBack {
        void onSuccess(ArrayList<ProfileImage> bonusReturnList);
    }


}
