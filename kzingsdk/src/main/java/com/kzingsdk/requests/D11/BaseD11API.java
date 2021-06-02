package com.kzingsdk.requests.D11;

import com.kzingsdk.core.CoreRequest;

public abstract class BaseD11API extends CoreRequest {

    BaseD11API() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.baseAction;
    }

}
