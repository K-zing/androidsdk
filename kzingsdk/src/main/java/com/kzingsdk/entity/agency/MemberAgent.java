package com.kzingsdk.entity.agency;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class MemberAgent {

    private String qrcode;
    private String referralCode;
    private String referralLink;
    private String appReferralLink;
    private BigDecimal commissionHistory;
    private BigDecimal commission;
    private AgentCommissionSummary agentCommissionSummary;

    public MemberAgent() {

    }

    public static MemberAgent newInstance(JSONObject rootObject) {
        MemberAgent memberAgent = new MemberAgent();
        memberAgent.setQrcode(rootObject.optString("qrcode"));
        memberAgent.setReferralCode(rootObject.optString("referralcode"));
        memberAgent.setReferralLink(rootObject.optString("referrallink"));
        memberAgent.setAppReferralLink(rootObject.optString("appreferrallink"));
        memberAgent.setCommissionHistory(BigDecimalUtil.optBigDecimal(rootObject, "agents_commission_history"));
        memberAgent.setCommission(BigDecimalUtil.optBigDecimal(rootObject, "agents_commission"));
        memberAgent.setAgentCommissionSummary(AgentCommissionSummary.newInstance(rootObject.optJSONObject("agents_info")));
        return memberAgent;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getReferralLink() {
        return referralLink;
    }

    public void setReferralLink(String referralLink) {
        this.referralLink = referralLink;
    }

    public BigDecimal getCommissionHistory() {
        return commissionHistory;
    }

    public void setCommissionHistory(BigDecimal commissionHistory) {
        this.commissionHistory = commissionHistory;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public AgentCommissionSummary getAgentCommissionSummary() {
        return agentCommissionSummary;
    }

    public void setAgentCommissionSummary(AgentCommissionSummary agentCommissionSummary) {
        this.agentCommissionSummary = agentCommissionSummary;
    }

    public String getAppReferralLink() {
        return appReferralLink;
    }

    public void setAppReferralLink(String appReferralLink) {
        this.appReferralLink = appReferralLink;
    }
}
