package com.kzingsdk.entity;

import com.kzingsdk.entity.gameplatform.GamePlatformType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class VipSettingV2 {

    private List<String> promotionConditionList = new ArrayList<>();
    private List<String> relegationConditionList = new ArrayList<>();
    private List<String> vipExclusiveList = new ArrayList<>();
    private Boolean vipSettingSwitch;
    private HashMap<Integer, String> vipWaterMap = new HashMap<>();
    private String maxWater = null;
    private ArrayList<VipSettingRuleV2> vipSettingRuleV2List = new ArrayList<>();


    public static VipSettingV2 newInstance(JSONObject rootObject) {
        VipSettingV2 vipSetting = new VipSettingV2();
        String promotionConditions = rootObject.optString("promotionconditions");
        vipSetting.promotionConditionList = Arrays.asList(promotionConditions.split(","));
        String relegationConditions = rootObject.optString("relegationconditions");
        vipSetting.relegationConditionList = Arrays.asList(relegationConditions.split(","));
        String vipExclusives = rootObject.optString("vipexclusives");
        vipSetting.vipExclusiveList = Arrays.asList(vipExclusives.split(","));
        vipSetting.vipSettingSwitch = rootObject.optString("vipSettingSwitch", "OFF").equalsIgnoreCase("on");
        vipSetting.vipWaterMap = new HashMap<>();
        JSONObject vipWaterJSONObject = rootObject.optJSONObject("vipwater");
        if (vipWaterJSONObject != null) {
            vipSetting.maxWater = vipWaterJSONObject.optString("maxwater");
            for (GamePlatformType type : GamePlatformType.values()) {
                if (!vipWaterJSONObject.has(type.getId() + "")) {
                    continue;
                }
                vipSetting.vipWaterMap.put(type.getId(), vipWaterJSONObject.optString(type.getId() + ""));
            }
        }
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

    public HashMap<Integer, String> getVipWaterMap() {
        return vipWaterMap;
    }

    public void setVipWaterMap(HashMap<Integer, String> vipWaterMap) {
        this.vipWaterMap = vipWaterMap;
    }

    public String getMaxWater() {
        return maxWater;
    }

    public void setMaxWater(String maxWater) {
        this.maxWater = maxWater;
    }

    public ArrayList<VipSettingRuleV2> getVipSettingRuleV2List() {
        return vipSettingRuleV2List;
    }

    public void setVipSettingRuleV2List(ArrayList<VipSettingRuleV2> vipSettingRuleV2List) {
        this.vipSettingRuleV2List = vipSettingRuleV2List;
    }
}
