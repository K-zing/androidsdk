package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class PostpaidBonus {

    private String formId;
    private String h5FontColor;
    private String bonus;
    private String selectedPlayers;
    private String activityRequestType;
    private String acLinkId;
    private String cover;
    private BigDecimal maxBonus;
    private boolean isPublic;
    private BigDecimal percentage;
    private String coverAlt;
    private String coverMobile;
    private String actDesc;
    private BigDecimal persDuration;
    private String dno;
    private String nextStageAmt;
    private Long lbTime;
    private String realCover;
    private String groupId;
    private String actId;
    private String realMContent;
    private Integer daysBeforeJoin;
    private String runEveryday;
    private boolean isBeforeLogin;
    private BigDecimal rescueRatioFlowMultiply;
    private String redirectUrl;
    private String status;
    private String redeemStatus;
    private String pers;
    private String realMCover;
    private Integer totalJoins;
    private BigDecimal requestHighestAmountDaily;
    private String resetPeriod;
    private String displayStartTime;
    private String content;
    private String webFontColor;
    private String redirectTo;
    private Long expiredDate;
    private String lbTxt1;
    private String includedCalculationPlatform;
    private String brandId;
    private String activeapply;
    private String publishdate;
    private String bgColorM;
    private String currency;
    private String canJoin;
    private String actypeId;
    private String frontTypeId;
    private String lbTxt2;
    private String actName;
    private String tagGroupIds;
    private String depositAmount;
    private String ano;
    private String availableDptAmt;
    private String displayorder;
    private String realdesc;
    private String restrictedPlatform;
    private String requestHighestAmountEach;
    private String realContent;
    private String agents;
    private String realName;
    private BigDecimal lowestNegative;
    private String bg_color;
    private BigDecimal rescueRatio;
    private Long displayEndTime;
    private String groupids;
    private String agentCodes;
    private String grpNames;
    private String targetUserType;
    private Boolean isExpired;
    private Long expiredOn;
    private String mobileContent;
    private Integer hotLvl;
    private Long updated;

    public static PostpaidBonus newInstance(JSONObject rootObject) {
        PostpaidBonus bankCard = new PostpaidBonus();
        bankCard.setFormId(rootObject.optString("formid"));
        bankCard.setH5FontColor(rootObject.optString("h5_font_color"));
        bankCard.setBonus(rootObject.optString("bonus"));
        bankCard.setSelectedPlayers(rootObject.optString("selectedplayers"));
        bankCard.setActivityRequestType(rootObject.optString("activityrequesttype"));
        bankCard.setAcLinkId(rootObject.optString("ac_link_id"));
        bankCard.setCover(rootObject.optString("cover"));
        bankCard.setMaxBonus(BigDecimalUtil.optBigDecimal(rootObject, "max_bonus"));
        bankCard.setPublic(rootObject.optString("ispublic", "0").equalsIgnoreCase("1"));
        bankCard.setPercentage(BigDecimalUtil.optBigDecimal(rootObject, "percentage"));
        bankCard.setCoverAlt(rootObject.optString("coveralt"));
        bankCard.setCoverMobile(rootObject.optString("cover_mobile"));
        bankCard.setActDesc(rootObject.optString("actdesc"));
        bankCard.setPersDuration(BigDecimalUtil.optBigDecimal(rootObject, "persduration"));
        bankCard.setDno(rootObject.optString("dno"));
        bankCard.setNextStageAmt(rootObject.optString("nextstageamt"));
        bankCard.setLbTime(rootObject.optLong("lbtime"));
        bankCard.setRealCover(rootObject.optString("realcover"));
        bankCard.setGroupId(rootObject.optString("groupid"));
        bankCard.setActId(rootObject.optString("actid"));
        bankCard.setRealMContent(rootObject.optString("realmcontent"));
        bankCard.setDaysBeforeJoin(rootObject.optInt("daysbeforejoin"));
        bankCard.setRunEveryday(rootObject.optString("run_everyday"));
        bankCard.setBeforeLogin(rootObject.optString("beforelogin", "0").equalsIgnoreCase("1"));
        bankCard.setRescueRatioFlowMultiply(BigDecimalUtil.optBigDecimal(rootObject, "rescueratioflowmultiply"));
        bankCard.setRedirectUrl(rootObject.optString("redirect_url"));
        bankCard.setStatus(rootObject.optString("status"));
        bankCard.setRedeemStatus(rootObject.optString("redeemstatus"));
        bankCard.setPers(rootObject.optString("pers"));
        bankCard.setRealMCover(rootObject.optString("realmcover"));
        bankCard.setTotalJoins(rootObject.optInt("totaljoins"));
        bankCard.setRequestHighestAmountDaily(BigDecimalUtil.optBigDecimal(rootObject, "request_highest_amount_daily"));
        bankCard.setResetPeriod(rootObject.optString("resetperiod"));
        bankCard.setDisplayStartTime(rootObject.optString("displaystarttime"));
        bankCard.setContent(rootObject.optString("content"));
        bankCard.setWebFontColor(rootObject.optString("web_font_color"));
        bankCard.setRedirectTo(rootObject.optString("redirect_to"));
        bankCard.setExpiredDate(rootObject.optLong("expireddate"));
        bankCard.setLbTxt1(rootObject.optString("lbtxt1"));
        bankCard.setIncludedCalculationPlatform(rootObject.optString("included_calculation_platform"));
        bankCard.setBrandId(rootObject.optString("brandid"));
        bankCard.setActiveapply(rootObject.optString("activeapply"));
        bankCard.setPublishdate(rootObject.optString("publishdate"));
        bankCard.setBgColorM(rootObject.optString("bg_color_m"));
        bankCard.setCurrency(rootObject.optString("currency"));
        bankCard.setCanJoin(rootObject.optString("canJoin"));
        bankCard.setActypeId(rootObject.optString("actypeid"));
        bankCard.setFrontTypeId(rootObject.optString("fronttypeid"));
        bankCard.setLbTxt2(rootObject.optString("lbtxt2"));
        bankCard.setActName(rootObject.optString("actname"));
        bankCard.setTagGroupIds(rootObject.optString("taggroupids"));
        bankCard.setDepositAmount(rootObject.optString("deposit_amount"));
        bankCard.setAno(rootObject.optString("ano"));
        bankCard.setAvailableDptAmt(rootObject.optString("available_dptAmt"));
        bankCard.setDisplayorder(rootObject.optString("displayorder"));
        bankCard.setRealdesc(rootObject.optString("realdesc"));
        bankCard.setRestrictedPlatform(rootObject.optString("restricted_platform"));
        bankCard.setRequestHighestAmountEach(rootObject.optString("request_highest_amount_each"));
        bankCard.setRealContent(rootObject.optString("realcontent"));
        bankCard.setAgents(rootObject.optString("agents"));
        bankCard.setRealName(rootObject.optString("realname"));
        bankCard.setLowestNegative(BigDecimalUtil.optBigDecimal(rootObject, "lowestnegative"));
        bankCard.setBg_color(rootObject.optString("bg_color"));
        bankCard.setRescueRatio(BigDecimalUtil.optBigDecimal(rootObject, "rescueratio"));
        bankCard.setDisplayEndTime(rootObject.optLong("displayendtime"));
        bankCard.setGroupids(rootObject.optString("groupids"));
        bankCard.setAgentCodes(rootObject.optString("agentcodes"));
        bankCard.setGrpNames(rootObject.optString("grpnames"));
        bankCard.setTargetUserType(rootObject.optString("targetusertype"));
        bankCard.setExpired(rootObject.optString("isExpired", "0").equalsIgnoreCase("1"));
        bankCard.setExpiredOn(rootObject.optLong("expiredOn", 0L));
        bankCard.setMobileContent(rootObject.optString("mobilecontent"));
        bankCard.setHotLvl(rootObject.optInt("hotlvl"));
        bankCard.setUpdated(rootObject.optLong("updated"));

        return bankCard;
    }


    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getH5FontColor() {
        return h5FontColor;
    }

    public void setH5FontColor(String h5FontColor) {
        this.h5FontColor = h5FontColor;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getSelectedPlayers() {
        return selectedPlayers;
    }

    public void setSelectedPlayers(String selectedPlayers) {
        this.selectedPlayers = selectedPlayers;
    }

    public String getActivityRequestType() {
        return activityRequestType;
    }

    public void setActivityRequestType(String activityRequestType) {
        this.activityRequestType = activityRequestType;
    }

    public String getAcLinkId() {
        return acLinkId;
    }

    public void setAcLinkId(String acLinkId) {
        this.acLinkId = acLinkId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public BigDecimal getMaxBonus() {
        return maxBonus;
    }

    public void setMaxBonus(BigDecimal maxBonus) {
        this.maxBonus = maxBonus;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getCoverAlt() {
        return coverAlt;
    }

    public void setCoverAlt(String coverAlt) {
        this.coverAlt = coverAlt;
    }

    public String getCoverMobile() {
        return coverMobile;
    }

    public void setCoverMobile(String coverMobile) {
        this.coverMobile = coverMobile;
    }

    public String getActDesc() {
        return actDesc;
    }

    public void setActDesc(String actDesc) {
        this.actDesc = actDesc;
    }

    public BigDecimal getPersDuration() {
        return persDuration;
    }

    public void setPersDuration(BigDecimal persDuration) {
        this.persDuration = persDuration;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getNextStageAmt() {
        return nextStageAmt;
    }

    public void setNextStageAmt(String nextStageAmt) {
        this.nextStageAmt = nextStageAmt;
    }

    public Long getLbTime() {
        return lbTime;
    }

    public void setLbTime(Long lbTime) {
        this.lbTime = lbTime;
    }

    public String getRealCover() {
        return realCover;
    }

    public void setRealCover(String realCover) {
        this.realCover = realCover;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getRealMContent() {
        return realMContent;
    }

    public void setRealMContent(String realMContent) {
        this.realMContent = realMContent;
    }

    public Integer getDaysBeforeJoin() {
        return daysBeforeJoin;
    }

    public void setDaysBeforeJoin(Integer daysBeforeJoin) {
        this.daysBeforeJoin = daysBeforeJoin;
    }

    public String getRunEveryday() {
        return runEveryday;
    }

    public void setRunEveryday(String runEveryday) {
        this.runEveryday = runEveryday;
    }

    public boolean isBeforeLogin() {
        return isBeforeLogin;
    }

    public void setBeforeLogin(boolean beforeLogin) {
        isBeforeLogin = beforeLogin;
    }

    public BigDecimal getRescueRatioFlowMultiply() {
        return rescueRatioFlowMultiply;
    }

    public void setRescueRatioFlowMultiply(BigDecimal rescueRatioFlowMultiply) {
        this.rescueRatioFlowMultiply = rescueRatioFlowMultiply;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRedeemStatus() {
        return redeemStatus;
    }

    public void setRedeemStatus(String redeemStatus) {
        this.redeemStatus = redeemStatus;
    }

    public String getPers() {
        return pers;
    }

    public void setPers(String pers) {
        this.pers = pers;
    }

    public String getRealMCover() {
        return realMCover;
    }

    public void setRealMCover(String realMCover) {
        this.realMCover = realMCover;
    }

    public Integer getTotalJoins() {
        return totalJoins;
    }

    public void setTotalJoins(Integer totalJoins) {
        this.totalJoins = totalJoins;
    }

    public BigDecimal getRequestHighestAmountDaily() {
        return requestHighestAmountDaily;
    }

    public void setRequestHighestAmountDaily(BigDecimal requestHighestAmountDaily) {
        this.requestHighestAmountDaily = requestHighestAmountDaily;
    }

    public String getResetPeriod() {
        return resetPeriod;
    }

    public void setResetPeriod(String resetPeriod) {
        this.resetPeriod = resetPeriod;
    }

    public String getDisplayStartTime() {
        return displayStartTime;
    }

    public void setDisplayStartTime(String displayStartTime) {
        this.displayStartTime = displayStartTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWebFontColor() {
        return webFontColor;
    }

    public void setWebFontColor(String webFontColor) {
        this.webFontColor = webFontColor;
    }

    public String getRedirectTo() {
        return redirectTo;
    }

    public void setRedirectTo(String redirectTo) {
        this.redirectTo = redirectTo;
    }

    public Long getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Long expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getLbTxt1() {
        return lbTxt1;
    }

    public void setLbTxt1(String lbTxt1) {
        this.lbTxt1 = lbTxt1;
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

    public String getActiveapply() {
        return activeapply;
    }

    public void setActiveapply(String activeapply) {
        this.activeapply = activeapply;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getBgColorM() {
        return bgColorM;
    }

    public void setBgColorM(String bgColorM) {
        this.bgColorM = bgColorM;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCanJoin() {
        return canJoin;
    }

    public void setCanJoin(String canJoin) {
        this.canJoin = canJoin;
    }

    public String getActypeId() {
        return actypeId;
    }

    public void setActypeId(String actypeId) {
        this.actypeId = actypeId;
    }

    public String getFrontTypeId() {
        return frontTypeId;
    }

    public void setFrontTypeId(String frontTypeId) {
        this.frontTypeId = frontTypeId;
    }

    public String getLbTxt2() {
        return lbTxt2;
    }

    public void setLbTxt2(String lbTxt2) {
        this.lbTxt2 = lbTxt2;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getTagGroupIds() {
        return tagGroupIds;
    }

    public void setTagGroupIds(String tagGroupIds) {
        this.tagGroupIds = tagGroupIds;
    }

    public String getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getAvailableDptAmt() {
        return availableDptAmt;
    }

    public void setAvailableDptAmt(String availableDptAmt) {
        this.availableDptAmt = availableDptAmt;
    }

    public String getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(String displayorder) {
        this.displayorder = displayorder;
    }

    public String getRealdesc() {
        return realdesc;
    }

    public void setRealdesc(String realdesc) {
        this.realdesc = realdesc;
    }

    public String getRestrictedPlatform() {
        return restrictedPlatform;
    }

    public void setRestrictedPlatform(String restrictedPlatform) {
        this.restrictedPlatform = restrictedPlatform;
    }

    public String getRequestHighestAmountEach() {
        return requestHighestAmountEach;
    }

    public void setRequestHighestAmountEach(String requestHighestAmountEach) {
        this.requestHighestAmountEach = requestHighestAmountEach;
    }

    public String getRealContent() {
        return realContent;
    }

    public void setRealContent(String realContent) {
        this.realContent = realContent;
    }

    public String getAgents() {
        return agents;
    }

    public void setAgents(String agents) {
        this.agents = agents;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public BigDecimal getLowestNegative() {
        return lowestNegative;
    }

    public void setLowestNegative(BigDecimal lowestNegative) {
        this.lowestNegative = lowestNegative;
    }

    public String getBg_color() {
        return bg_color;
    }

    public void setBg_color(String bg_color) {
        this.bg_color = bg_color;
    }

    public BigDecimal getRescueRatio() {
        return rescueRatio;
    }

    public void setRescueRatio(BigDecimal rescueRatio) {
        this.rescueRatio = rescueRatio;
    }

    public Long getDisplayEndTime() {
        return displayEndTime;
    }

    public void setDisplayEndTime(Long displayEndTime) {
        this.displayEndTime = displayEndTime;
    }

    public String getGroupids() {
        return groupids;
    }

    public void setGroupids(String groupids) {
        this.groupids = groupids;
    }

    public String getAgentCodes() {
        return agentCodes;
    }

    public void setAgentCodes(String agentCodes) {
        this.agentCodes = agentCodes;
    }

    public String getGrpNames() {
        return grpNames;
    }

    public void setGrpNames(String grpNames) {
        this.grpNames = grpNames;
    }

    public String getTargetUserType() {
        return targetUserType;
    }

    public void setTargetUserType(String targetUserType) {
        this.targetUserType = targetUserType;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }

    public String getMobileContent() {
        return mobileContent;
    }

    public void setMobileContent(String mobileContent) {
        this.mobileContent = mobileContent;
    }

    public Integer getHotLvl() {
        return hotLvl;
    }

    public void setHotLvl(Integer hotLvl) {
        this.hotLvl = hotLvl;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Long getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(Long expiredOn) {
        this.expiredOn = expiredOn;
    }
}
