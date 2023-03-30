package com.kzingsdk.entity;

import com.kzingsdk.util.Constant;
import com.kzingsdk.util.SharePrefUtil;

import org.json.JSONObject;

public class LoginWebApiResult extends SimpleApiResult {

    protected MemberInfo memberInfo = null;
    protected String data = "";

    public static LoginWebApiResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        LoginWebApiResult result = new LoginWebApiResult();
        result.setMessage(simpleApiResult.getMessage());
        result.setStatus(simpleApiResult.getStatus());
        if (result.getStatus() != 0) {
            result.setData(rootObject.optString("data"));
            return result;
        }
        JSONObject dataObject = rootObject.optJSONObject("data");
        if (dataObject != null) {
            result.setMemberInfo(MemberInfo.newInstanceFromWebapi(dataObject));
        }
        return result;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }
}
