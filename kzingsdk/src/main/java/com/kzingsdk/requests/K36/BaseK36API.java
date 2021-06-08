package com.kzingsdk.requests.K36;

import com.kzingsdk.core.CoreRequest;

public abstract class BaseK36API extends CoreRequest {

    BaseK36API() {
        super();
    }

    @Override
    protected String getAction() {
        return Action.baseAction;
    }

}
