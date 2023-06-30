package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class CheckGiftRedeemableWebapi {

    private String refNo;
    private String giftId;
    private String actId;
    private String playerId;
    private String calcMethod;
    private String currency;
    private String giftName;
    private String giftPicUrl;
    private String courierNo;
    private String includedCalculationPlatform;
    private String brandId;
    private String sno;
    private BigDecimal requirementAmount;
    private BigDecimal resultAmount;
    private BigDecimal giftCost;
    private BigDecimal remainAmount;
    private BigDecimal watergateAmount;
    private Integer playerRedeemStatus;
    private Integer depositValidHours;
    private Integer calcTotalDepositHour;
    private Long startTime;
    private Long endTime;
    private Long approveTime;
    private Long deliverTime;
    private Long redeemTime;
    private Long validBefore;
    private Long rejectTime;
    private Long created;
    private Long updated;
    private Boolean isRedPacket;
    private Boolean isCalcTotalDeposit;
    private Boolean redPacket;

    public CheckGiftRedeemableWebapi() {

    }

    public static CheckGiftRedeemableWebapi newInstance(JSONObject rootObject) {
        CheckGiftRedeemableWebapi result = new CheckGiftRedeemableWebapi();
        result.setRefNo(rootObject.optString("refno", ""));
        result.setGiftId(rootObject.optString("giftid", ""));
        result.setActId(rootObject.optString("actid", ""));
        result.setPlayerId(rootObject.optString("playerid", ""));
        result.setCalcMethod(rootObject.optString("calcmethod", ""));
        result.setCurrency(rootObject.optString("currency", ""));
        result.setGiftName(rootObject.optString("giftname", ""));
        result.setGiftPicUrl(rootObject.optString("giftpicurl", ""));
        result.setCourierNo(rootObject.optString("courierno", ""));
        result.setIncludedCalculationPlatform(rootObject.optString("included_calculation_platform", ""));
        result.setBrandId(rootObject.optString("brandid", ""));
        result.setSno(rootObject.optString("sno", ""));
        result.setRequirementAmount(BigDecimalUtil.optBigDecimal(rootObject, "requirementamount", BigDecimal.ZERO));
        result.setResultAmount(BigDecimalUtil.optBigDecimal(rootObject, "resultamount", BigDecimal.ZERO));
        result.setGiftCost(BigDecimalUtil.optBigDecimal(rootObject, "giftcost", BigDecimal.ZERO));
        result.setRemainAmount(BigDecimalUtil.optBigDecimal(rootObject, "remainAmount", BigDecimal.ZERO));
        result.setWatergateAmount(BigDecimalUtil.optBigDecimal(rootObject, "watergateamount", BigDecimal.ZERO));
        result.setPlayerRedeemStatus(rootObject.optInt("playerredeemstatus", 0));
        result.setDepositValidHours(rootObject.optInt("depositvalidhours", 0));
        result.setCalcTotalDepositHour(rootObject.optInt("calctotaldeposithour", 0));
        result.setStartTime(rootObject.optLong("starttime", 0));
        result.setEndTime(rootObject.optLong("endtime", 0));
        result.setApproveTime(rootObject.optLong("approvetime", 0));
        result.setDeliverTime(rootObject.optLong("delivertime", 0));
        result.setRedeemTime(rootObject.optLong("redeemtime", 0));
        result.setValidBefore(rootObject.optLong("validBefore", 0));
        result.setRejectTime(rootObject.optLong("rejecttime", 0));
        result.setCreated(rootObject.optLong("created", 0));
        result.setUpdated(rootObject.optLong("updated", 0));
        result.setIsRedPacket(rootObject.optInt("isredpacket", 0) == 1);
        result.setCalcTotalDeposit(rootObject.optBoolean("iscalctotaldeposit", false));
        result.setRedPacket(rootObject.optBoolean("redpacket", false));
        return result;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getCalcMethod() {
        return calcMethod;
    }

    public void setCalcMethod(String calcMethod) {
        this.calcMethod = calcMethod;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftPicUrl() {
        return giftPicUrl;
    }

    public void setGiftPicUrl(String giftPicUrl) {
        this.giftPicUrl = giftPicUrl;
    }

    public String getCourierNo() {
        return courierNo;
    }

    public void setCourierNo(String courierNo) {
        this.courierNo = courierNo;
    }

    public String getIncludedCalculationPlatform() {
        return includedCalculationPlatform;
    }

    public void setIncludedCalculationPlatform(String includedCalculationPlatform) {
        this.includedCalculationPlatform = includedCalculationPlatform;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public BigDecimal getRequirementAmount() {
        return requirementAmount;
    }

    public void setRequirementAmount(BigDecimal requirementAmount) {
        this.requirementAmount = requirementAmount;
    }

    public BigDecimal getResultAmount() {
        return resultAmount;
    }

    public void setResultAmount(BigDecimal resultAmount) {
        this.resultAmount = resultAmount;
    }

    public BigDecimal getGiftCost() {
        return giftCost;
    }

    public void setGiftCost(BigDecimal giftCost) {
        this.giftCost = giftCost;
    }

    public BigDecimal getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }

    public BigDecimal getWatergateAmount() {
        return watergateAmount;
    }

    public void setWatergateAmount(BigDecimal watergateAmount) {
        this.watergateAmount = watergateAmount;
    }

    public Integer getPlayerRedeemStatus() {
        return playerRedeemStatus;
    }

    public void setPlayerRedeemStatus(Integer playerRedeemStatus) {
        this.playerRedeemStatus = playerRedeemStatus;
    }

    public Integer getDepositValidHours() {
        return depositValidHours;
    }

    public void setDepositValidHours(Integer depositValidHours) {
        this.depositValidHours = depositValidHours;
    }

    public Integer getCalcTotalDepositHour() {
        return calcTotalDepositHour;
    }

    public void setCalcTotalDepositHour(Integer calcTotalDepositHour) {
        this.calcTotalDepositHour = calcTotalDepositHour;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Long approveTime) {
        this.approveTime = approveTime;
    }

    public Long getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Long deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Long getRedeemTime() {
        return redeemTime;
    }

    public void setRedeemTime(Long redeemTime) {
        this.redeemTime = redeemTime;
    }

    public Long getValidBefore() {
        return validBefore;
    }

    public void setValidBefore(Long validBefore) {
        this.validBefore = validBefore;
    }

    public Long getRejectTime() {
        return rejectTime;
    }

    public void setRejectTime(Long rejectTime) {
        this.rejectTime = rejectTime;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Boolean getRedPacket() {
        return redPacket;
    }

    public void setRedPacket(Boolean redPacket) {
        redPacket = redPacket;
    }

    public Boolean getIsRedPacket() {
        return isRedPacket;
    }

    public void setIsRedPacket(Boolean isRedPacket) {
        isRedPacket = isRedPacket;
    }

    public Boolean getCalcTotalDeposit() {
        return isCalcTotalDeposit;
    }

    public void setCalcTotalDeposit(Boolean calcTotalDeposit) {
        isCalcTotalDeposit = calcTotalDeposit;
    }
}
