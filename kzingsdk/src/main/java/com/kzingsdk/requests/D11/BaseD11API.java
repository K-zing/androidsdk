package com.kzingsdk.requests.D11;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.entity.D11.D11HotGame;
import com.kzingsdk.entity.WithdrawField;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;

public abstract class BaseD11API extends CoreRequest {

    BaseD11API() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.baseAction;
    }

}
