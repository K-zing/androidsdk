package com.kzingsdk.requests;

import com.kzingsdk.core.KzingException;

public interface KzingCallBack {
    void onFailure(KzingException kzingException);
}
