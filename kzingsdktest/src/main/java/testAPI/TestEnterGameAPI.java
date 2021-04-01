package testAPI;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;
import com.kzingsdk.requests.EnterGameAPI;
import com.kzingsdk.requests.KzingCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;

public class TestEnterGameAPI extends CoreRequest {

    @Override
    protected String getAction() {
        return "B531774";
    }

    @Override
    protected Observable<String> validateParams() {
        return super.validateParams();
    }

    @Override
    protected JSONObject generateParamsJson() {
        JSONObject jsonData = super.generateParamsJson();
        try {
            jsonData.put("gpid", "6560923780601");
            jsonData.put("gpaccountID", "6560923780600");
            jsonData.put("useragent", "Mozilla/5.0 (Linux; Android 10; CLT-L29 Build/HUAWEICLT-L29; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/87.0.4280.66 Mobile Safari/537.36");

            return jsonData;
        } catch (JSONException ignored) {
        }
        return super.generateParamsJson();
    }

    @Override
    public Observable<String> requestRx(Context context) {
        return super.baseExecute(context).map(jsonResponse -> jsonResponse.optString("url"));
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(url -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((EnterGameAPI.EnterGameCallBack) kzingCallBack).onSuccess(url);
                }
            }
        }, defaultOnErrorConsumer);
    }
}
