package com.kzingsdk.entity.agency;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class AgentDownline {

    private String parent;
    private Integer level;
    private String name;
    private String id;

    public AgentDownline() {

    }

    public static AgentDownline newInstance(JSONObject rootObject) {
        AgentDownline memberAgent = new AgentDownline();
        memberAgent.setParent(rootObject.optString("parent"));
        memberAgent.setLevel(rootObject.optInt("level"));
        memberAgent.setName(rootObject.optString("name"));
        memberAgent.setId(rootObject.optString("id"));
        return memberAgent;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

