package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class GetRewardMemberDetailsResult extends SimpleApiResult {

    private String memberCode;
    private String userName;
    private String vipLevel;
    private BigDecimal pointBalance = BigDecimal.ZERO;

    public static GetRewardMemberDetailsResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        GetRewardMemberDetailsResult result = new GetRewardMemberDetailsResult();
        result.status = simpleApiResult.status;
        result.message = simpleApiResult.message;
        JSONObject dataJSON = rootObject.optJSONObject("data");
        if (dataJSON!=null) {
            result.memberCode = dataJSON.optString("memberCode");
            result.userName = dataJSON.optString("userName");
            result.vipLevel = dataJSON.optString("vipLevel");
            result.pointBalance = BigDecimalUtil.optBigDecimal(dataJSON, "pointBalance");
        }
        return result;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
    }

    public BigDecimal getPointBalance() {
        return pointBalance;
    }

    public void setPointBalance(BigDecimal pointBalance) {
        this.pointBalance = pointBalance;
    }
}
