package com.kzingsdk.entity;

import org.json.JSONObject;

public class IpBlockSetting {

    private String country;
    private String ip;
    private boolean block;

    public static IpBlockSetting newInstance(JSONObject rootObject) {
        IpBlockSetting ipBlockSetting = new IpBlockSetting();
        ipBlockSetting.setCountry(rootObject.optString("country"));
        ipBlockSetting.setIp(rootObject.optString("ip"));
        ipBlockSetting.setBlock(rootObject.optBoolean("block"));
        return ipBlockSetting;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
}
