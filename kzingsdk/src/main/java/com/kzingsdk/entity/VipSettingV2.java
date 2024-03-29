package com.kzingsdk.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class VipSettingV2 {

    private List<String> promotionConditionList = new ArrayList<>();
    private List<String> relegationConditionList = new ArrayList<>();
    private List<String> vipExclusiveList = new ArrayList<>();
    private Boolean vipSettingSwitch = false;
    private ArrayList<VipSettingWater> vipWaterList = new ArrayList<>();
    private ArrayList<VipSettingRuleV2> vipSettingRuleV2List = new ArrayList<>();
    private String upLvlRangeOpt = "";
    private String upLvlRangeOptName = "";
    private String remainLvlRangeOpt = "";
    private String remainLvlRangeOptName = "";

    public static VipSettingV2 newInstance(JSONObject rootObject) {
        VipSettingV2 vipSetting = new VipSettingV2();
        String promotionConditions = rootObject.optString("promotionconditions");
        vipSetting.promotionConditionList = Arrays.asList(promotionConditions.split(","));
        String relegationConditions = rootObject.optString("relegationconditions");
        vipSetting.relegationConditionList = Arrays.asList(relegationConditions.split(","));
        String vipExclusives = rootObject.optString("vipexclusives");
        vipSetting.vipExclusiveList = Arrays.asList(vipExclusives.split(","));
        vipSetting.vipSettingSwitch = rootObject.optString("vipSettingSwitch", "OFF").equalsIgnoreCase("on");
        vipSetting.upLvlRangeOpt = rootObject.optString("upLvlRangeOpt");
        vipSetting.upLvlRangeOptName = rootObject.optString("upLvlRangeOptName");
        vipSetting.remainLvlRangeOpt = rootObject.optString("remainLvlRangeOpt");
        vipSetting.remainLvlRangeOptName = rootObject.optString("remainLvlRangeOptName");
        JSONArray vipwaterJSONArray = rootObject.optJSONArray("vipwater");
        if (vipwaterJSONArray != null) {
            for (int i = 0; i < vipwaterJSONArray.length(); i++) {
                vipSetting.vipWaterList.add(VipSettingWater.newInstance(vipwaterJSONArray.optJSONObject(i)));
            }
        }
        vipSetting.vipWaterList.sort(Comparator.comparingInt(o -> Integer.parseInt(o.getRank())));
        JSONArray rulesJSONArray = rootObject.optJSONArray("rules");
        if (rulesJSONArray != null) {
            for (int i = 0; i < rulesJSONArray.length(); i++) {
                vipSetting.vipSettingRuleV2List.add(VipSettingRuleV2.newInstance(rulesJSONArray.optJSONObject(i)));
            }
        }
        return vipSetting;
    }

    public List<String> getPromotionConditionList() {
        return promotionConditionList;
    }

    public void setPromotionConditionList(List<String> promotionConditionList) {
        this.promotionConditionList = promotionConditionList;
    }

    public List<String> getRelegationConditionList() {
        return relegationConditionList;
    }

    public void setRelegationConditionList(List<String> relegationConditionList) {
        this.relegationConditionList = relegationConditionList;
    }

    public List<String> getVipExclusiveList() {
        return vipExclusiveList;
    }

    public void setVipExclusiveList(List<String> vipExclusiveList) {
        this.vipExclusiveList = vipExclusiveList;
    }

    public Boolean getVipSettingSwitch() {
        return vipSettingSwitch;
    }

    public void setVipSettingSwitch(Boolean vipSettingSwitch) {
        this.vipSettingSwitch = vipSettingSwitch;
    }

    public ArrayList<VipSettingWater> getVipWaterList() {
        return vipWaterList;
    }

    public void setVipWaterList(ArrayList<VipSettingWater> vipWaterList) {
        this.vipWaterList = vipWaterList;
    }

    public ArrayList<VipSettingRuleV2> getVipSettingRuleV2List() {
        return vipSettingRuleV2List;
    }

    public void setVipSettingRuleV2List(ArrayList<VipSettingRuleV2> vipSettingRuleV2List) {
        this.vipSettingRuleV2List = vipSettingRuleV2List;
    }

    public String getUpLvlRangeOpt() {
        return upLvlRangeOpt;
    }

    public void setUpLvlRangeOpt(String upLvlRangeOpt) {
        this.upLvlRangeOpt = upLvlRangeOpt;
    }

    public String getUpLvlRangeOptName() {
        return upLvlRangeOptName;
    }

    public void setUpLvlRangeOptName(String upLvlRangeOptName) {
        this.upLvlRangeOptName = upLvlRangeOptName;
    }

    public String getRemainLvlRangeOpt() {
        return remainLvlRangeOpt;
    }

    public void setRemainLvlRangeOpt(String remainLvlRangeOpt) {
        this.remainLvlRangeOpt = remainLvlRangeOpt;
    }

    public String getRemainLvlRangeOptName() {
        return remainLvlRangeOptName;
    }

    public void setRemainLvlRangeOptName(String remainLvlRangeOptName) {
        this.remainLvlRangeOptName = remainLvlRangeOptName;
    }
}
