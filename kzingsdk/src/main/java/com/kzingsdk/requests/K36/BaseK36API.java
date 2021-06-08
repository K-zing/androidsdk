package com.kzingsdk.requests.K36;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.K36.TransferBonusActivity;

import org.json.JSONObject;

import io.reactivex.Observable;

public abstract class BaseK36API extends CoreRequest {

    BaseK36API() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.baseAction;
    }

    @Override
    public Observable<JSONObject> baseExecute(Context context) {
        return super.baseExecute(context)
                .map(jsonResponse -> jsonResponse.optJSONObject("data"));
    }

}
