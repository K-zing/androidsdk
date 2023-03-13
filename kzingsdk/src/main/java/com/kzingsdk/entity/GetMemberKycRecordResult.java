package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetMemberKycRecordResult extends SimpleApiResult {

    private ArrayList<MemberKycRecord> memberKycRecordList = new ArrayList<>();

    public static GetMemberKycRecordResult newInstance(JSONObject rootObject) {
        SimpleApiResult simpleApiResult = SimpleApiResult.newInstance(rootObject);
        GetMemberKycRecordResult result = new GetMemberKycRecordResult();
        result.status = simpleApiResult.status;
        result.message = simpleApiResult.message;
        JSONArray dataArray = rootObject.optJSONArray("data");
        if (dataArray != null) {
            for (int i = 0; i < dataArray.length(); i++) {
                result.memberKycRecordList.add(MemberKycRecord.newInstance(dataArray.optJSONObject(i)));
            }
        }
        return result;
    }

    public ArrayList<MemberKycRecord> getMemberKycRecordList() {
        return memberKycRecordList;
    }

    public void setMemberKycRecordList(ArrayList<MemberKycRecord> memberKycRecordList) {
        this.memberKycRecordList = memberKycRecordList;
    }
}
