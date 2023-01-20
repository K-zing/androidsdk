package com.kzingsdk.entity;

import com.kzingsdk.entity.gameplatform.GamePlatformType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class VipSettingRuleV2 {

    private String id;
    private String lang;
    private String title;
    private String content;
    private Integer order;

    public static VipSettingRuleV2 newInstance(JSONObject rootObject) {
        VipSettingRuleV2 vipSettingRuleV2 = new VipSettingRuleV2();
        vipSettingRuleV2.id = rootObject.optString("id");
        vipSettingRuleV2.lang = rootObject.optString("lang");
        vipSettingRuleV2.title = rootObject.optString("title");
        vipSettingRuleV2.content = rootObject.optString("content");
        vipSettingRuleV2.order = rootObject.optInt("order");
        return vipSettingRuleV2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
