package com.kzingsdk.requests;

import android.content.Context;

import com.kzingsdk.core.CoreRequest;

import io.reactivex.Observable;

public class ConnectionSpeedTestAPI extends CoreRequest {

    private long startTime;

    ConnectionSpeedTestAPI() {
        super();
        startTime = System.currentTimeMillis();
    }

    @Override
    protected String getAction() {
        return Action.connectionSpeedTest;
    }

    @Override
    public Observable<Long> requestRx(final Context context) {
        return super.baseExecute(context).map(jsonResponse -> System.currentTimeMillis() - startTime);
    }

    @Override
    public void request(Context context) {
        requestRx(context).subscribe(time -> {
            if (kzingCallBackList.size() > 0) {
                for (KzingCallBack kzingCallBack : kzingCallBackList) {
                    ((ConnectionSpeedTestCallBack) kzingCallBack).onSuccess(time);
                }
            }
        }, defaultOnErrorConsumer);
    }

    public ConnectionSpeedTestAPI addConnectionSpeedTestCallBack(ConnectionSpeedTestCallBack connectionSpeedTestCallBack) {
        kzingCallBackList.add(connectionSpeedTestCallBack);
        return this;
    }

    public interface ConnectionSpeedTestCallBack extends KzingCallBack {
        void onSuccess(Long time);
    }

}
