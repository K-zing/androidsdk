package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class VipDetail {

    private ArrayList<VipGpRate> vipGpRateList = new ArrayList<>();
    private ArrayList<VipSetting> vipSettingList = new ArrayList<>();

    public static VipDetail newInstance(JSONObject rootObject) {
        VipDetail vipDetail = new VipDetail();
        JSONArray vipGpRatesArray = rootObject.optJSONArray("vipGpRates");
        JSONArray vipSettingArray = rootObject.optJSONArray("vipSetting");
        for (int i = 0; i < vipGpRatesArray.length(); i++) {
            vipDetail.vipGpRateList.add(VipGpRate.newInstance(vipGpRatesArray.optJSONObject(i)));
        }

        for (int i = 0; i < vipSettingArray.length(); i++) {
            vipDetail.vipSettingList.add(VipSetting.newInstance(vipSettingArray.optJSONObject(i)));
        }
        return vipDetail;
    }

    public ArrayList<VipGpRate> getVipGpRateList() {
        return vipGpRateList;
    }

    public void setVipGpRateList(ArrayList<VipGpRate> vipGpRateList) {
        this.vipGpRateList = vipGpRateList;
    }

    public ArrayList<VipSetting> getVipSettingList() {
        return vipSettingList;
    }

    public void setVipSettingList(ArrayList<VipSetting> vipSettingList) {
        this.vipSettingList = vipSettingList;
    }
}
