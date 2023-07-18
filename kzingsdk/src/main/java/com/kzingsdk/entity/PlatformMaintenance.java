package com.kzingsdk.entity;

import org.json.JSONObject;

public class PlatformMaintenance {

    protected String name = "";
    protected String gametype = "";
    protected String content = "";
    protected String start = "";
    protected String end = "";

    public static PlatformMaintenance newInstance(JSONObject rootObject) {
        PlatformMaintenance result = new PlatformMaintenance();
        result.setName(rootObject.optString("name"));
        result.setGametype(rootObject.optString("gametype"));
        result.setContent(rootObject.optString("content"));
        result.setStart(rootObject.optString("start"));
        result.setEnd(rootObject.optString("end"));
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
