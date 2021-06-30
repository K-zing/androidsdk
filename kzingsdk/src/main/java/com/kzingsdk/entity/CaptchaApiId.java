package com.kzingsdk.entity;

import org.json.JSONObject;

public class CaptchaApiId {

    protected String agentLogin = "";
    protected String agentRegister = "";
    protected String other = "";
    protected String playerLogin = "";
    protected String playerRegister = "";

    public static CaptchaApiId newInstance(JSONObject rootObject) {
        CaptchaApiId bankCard = new CaptchaApiId();
        bankCard.setAgentLogin(rootObject.optString("agentLogin"));
        bankCard.setAgentRegister(rootObject.optString("agentRegister"));
        bankCard.setOther(rootObject.optString("other"));
        bankCard.setPlayerLogin(rootObject.optString("playerLogin"));
        bankCard.setPlayerRegister(rootObject.optString("playerRegister"));
        return bankCard;
    }

    public String getAgentLogin() {
        return agentLogin;
    }

    public void setAgentLogin(String agentLogin) {
        this.agentLogin = agentLogin;
    }

    public String getAgentRegister() {
        return agentRegister;
    }

    public void setAgentRegister(String agentRegister) {
        this.agentRegister = agentRegister;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPlayerLogin() {
        return playerLogin;
    }

    public void setPlayerLogin(String playerLogin) {
        this.playerLogin = playerLogin;
    }

    public String getPlayerRegister() {
        return playerRegister;
    }

    public void setPlayerRegister(String playerRegister) {
        this.playerRegister = playerRegister;
    }
}
