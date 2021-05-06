package com.kzingsdk.entity.agency;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class AgentWithdrawal {

    private String brandId;
    private String currency;
    private String sno;
    private String dno;
    private String id;
    private String gpid;
    private String playerId;
    private String remark;
    private String playerName;
    private String sname;
    private BigDecimal amount;
    private BigDecimal nowBalance;
    private Integer bType;
    private Integer pType;
    private Integer isOk;
    private Long created;

    public AgentWithdrawal() {

    }

    public static AgentWithdrawal newInstance(JSONObject rootObject) {
        AgentWithdrawal agentCommissionSummary = new AgentWithdrawal();
        agentCommissionSummary.setBrandId(rootObject.optString("brandid"));
        agentCommissionSummary.setCurrency(rootObject.optString("currency"));
        agentCommissionSummary.setSno(rootObject.optString("sno"));
        agentCommissionSummary.setDno(rootObject.optString("dno"));
        agentCommissionSummary.setId(rootObject.optString("id"));
        agentCommissionSummary.setGpid(rootObject.optString("gpid"));
        agentCommissionSummary.setPlayerId(rootObject.optString("playerid"));
        agentCommissionSummary.setRemark(rootObject.optString("remark"));
        agentCommissionSummary.setPlayerName(rootObject.optString("playername"));
        agentCommissionSummary.setSname(rootObject.optString("sname"));
        agentCommissionSummary.setAmount(BigDecimalUtil.optBigDecimal(rootObject, "amount"));
        agentCommissionSummary.setNowBalance(BigDecimalUtil.optBigDecimal(rootObject, "nowbalance"));
        agentCommissionSummary.setBType(rootObject.optInt("btype"));
        agentCommissionSummary.setPType(rootObject.optInt("ptype"));
        agentCommissionSummary.setIsOk(rootObject.optInt("isok"));
        agentCommissionSummary.setCreated(rootObject.optLong("created"));
        return agentCommissionSummary;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getNowBalance() {
        return nowBalance;
    }

    public void setNowBalance(BigDecimal nowBalance) {
        this.nowBalance = nowBalance;
    }

    public Integer getBType() {
        return bType;
    }

    public void setBType(Integer bType) {
        this.bType = bType;
    }

    public Integer getPType() {
        return pType;
    }

    public void setPType(Integer pType) {
        this.pType = pType;
    }

    public Integer getIsOk() {
        return isOk;
    }

    public void setIsOk(Integer isOk) {
        this.isOk = isOk;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }
}

