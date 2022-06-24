package com.kzingsdk.entity;

import org.json.JSONObject;


public class BonusPromotion {

    private String actid;
    private String actypeid;
    private String actname;
    private String actdesc;
    private String content;
    private String formid;
    private String cover;
    private String coveralt;
    private String cover_mobile;
    private String cover_panel;
    private String created;
    private String updated;
    private String status;
    private String displayorder;
    private String activeapply;
    private String pers;
    private String hotlvl;
    private String lbtime;
    private String lbtxt1;
    private String lbtxt2;
    private String redirect_to;
    private String redirect_url;
    private String activityrequesttype;
    private String included_calculation_platform;
    private String daysbeforejoin;
    private String lowestnegative;
    private String rescueratio;
    private String rescueratioflowmultiply;
    private String restricted_platform;
    private String request_highest_amount_each;
    private String request_highest_amount_daily;
    private String max_bonus;
    private String totaljoins;
    private String mobilecontent;
    private String persduration;
    private String ano;
    private String publishdate;
    private String expireddate;
    private String beforelogin;
    private String ac_data;
    private String ac_link_id;
    private String bg_color;
    private String bg_color_m;
    private String web_font_color;
    private String h5_font_color;
    private String fronttypeid;
    private String ispublic;
    private String resetperiod;
    private String groupid;
    private String displaystarttime;
    private String displayendtime;
    private String currency;
    private String targetusertype;
    private String maxtotaljoincount;
    private String selectedplayers;
    private String targetcountry;
    private String autorenew;
    private String remark;
    private String brandid;
    private String agents;
    private String grpnames;
    private String agentcodes;
    private String groupids;
    private String taggroupids;
    private String cgroupids;
    private String realdesc;
    private String realcontent;
    private String realname;
    private String realcover;
    private String realmcontent;
    private String realmcover;
    private String dno;
    private String applydate;
    private String getstatus;
    private String oriname;
    private String oriename;
    private String typename;
    private String bonusupdated;
    private String requirement;
    private String a;
    private String deposit_amount;
    private String available_dptAmt;
    private String isExpired;
    private String bonus;
    private String nextstageamt;
    private String RO;
    private boolean canJoin;
    private boolean submitwithdraw;
    private int percentage;
    private int expiredOn;

    public BonusPromotion() {

    }

    public static BonusPromotion newInstance(JSONObject rootObject) {
        BonusPromotion bonusPromotion = new BonusPromotion();
        bonusPromotion.setActid(rootObject.optString("actid", ""));
        bonusPromotion.setActypeid(rootObject.optString("actypeid", ""));
        bonusPromotion.setActname(rootObject.optString("actname", ""));
        bonusPromotion.setActdesc(rootObject.optString("actdesc", ""));
        bonusPromotion.setContent(rootObject.optString("content", ""));
        bonusPromotion.setFormid(rootObject.optString("formid", ""));
        bonusPromotion.setCover(rootObject.optString("cover", ""));
        bonusPromotion.setCoveralt(rootObject.optString("coveralt", ""));
        bonusPromotion.setCover_mobile(rootObject.optString("cover_mobile", ""));
        bonusPromotion.setCover_panel(rootObject.optString("cover_panel", ""));
        bonusPromotion.setCreated(rootObject.optString("created", ""));
        bonusPromotion.setUpdated(rootObject.optString("updated", ""));
        bonusPromotion.setStatus(rootObject.optString("status", ""));
        bonusPromotion.setDisplayorder(rootObject.optString("displayorder", ""));
        bonusPromotion.setActiveapply(rootObject.optString("activeapply", ""));
        bonusPromotion.setPers(rootObject.optString("pers", ""));
        bonusPromotion.setHotlvl(rootObject.optString("hotlvl", ""));
        bonusPromotion.setLbtime(rootObject.optString("lbtime", ""));
        bonusPromotion.setLbtxt1(rootObject.optString("lbtxt1", ""));
        bonusPromotion.setLbtxt2(rootObject.optString("lbtxt2", ""));
        bonusPromotion.setRedirect_to(rootObject.optString("redirect_to", ""));
        bonusPromotion.setRedirect_url(rootObject.optString("redirect_url", ""));
        bonusPromotion.setActivityrequesttype(rootObject.optString("activityrequesttype", ""));
        bonusPromotion.setIncluded_calculation_platform(rootObject.optString("included_calculation_platform", ""));
        bonusPromotion.setDaysbeforejoin(rootObject.optString("daysbeforejoin", ""));
        bonusPromotion.setLowestnegative(rootObject.optString("lowestnegative", ""));
        bonusPromotion.setRescueratio(rootObject.optString("rescueratio", ""));
        bonusPromotion.setRescueratioflowmultiply(rootObject.optString("rescueratioflowmultiply", ""));
        bonusPromotion.setRestricted_platform(rootObject.optString("restricted_platform", ""));
        bonusPromotion.setRequest_highest_amount_each(rootObject.optString("request_highest_amount_each", ""));
        bonusPromotion.setRequest_highest_amount_daily(rootObject.optString("request_highest_amount_daily", ""));
        bonusPromotion.setMax_bonus(rootObject.optString("max_bonus", ""));
        bonusPromotion.setTotaljoins(rootObject.optString("totaljoins", ""));
        bonusPromotion.setMobilecontent(rootObject.optString("mobilecontent", ""));
        bonusPromotion.setPersduration(rootObject.optString("persduration", ""));
        bonusPromotion.setAno(rootObject.optString("ano", ""));
        bonusPromotion.setPublishdate(rootObject.optString("publishdate", ""));
        bonusPromotion.setExpireddate(rootObject.optString("expireddate", ""));
        bonusPromotion.setBeforelogin(rootObject.optString("beforelogin", ""));
        bonusPromotion.setAc_data(rootObject.optString("ac_data", ""));
        bonusPromotion.setAc_link_id(rootObject.optString("ac_link_id", ""));
        bonusPromotion.setBg_color(rootObject.optString("bg_color", ""));
        bonusPromotion.setBg_color_m(rootObject.optString("bg_color_m", ""));
        bonusPromotion.setWeb_font_color(rootObject.optString("web_font_color", ""));
        bonusPromotion.setH5_font_color(rootObject.optString("h5_font_color", ""));
        bonusPromotion.setFronttypeid(rootObject.optString("fronttypeid", ""));
        bonusPromotion.setIspublic(rootObject.optString("ispublic", ""));
        bonusPromotion.setResetperiod(rootObject.optString("resetperiod", ""));
        bonusPromotion.setGroupid(rootObject.optString("groupid", ""));
        bonusPromotion.setDisplaystarttime(rootObject.optString("displaystarttime", ""));
        bonusPromotion.setDisplayendtime(rootObject.optString("displayendtime", ""));
        bonusPromotion.setCurrency(rootObject.optString("currency", ""));
        bonusPromotion.setTargetusertype(rootObject.optString("targetusertype", ""));
        bonusPromotion.setMaxtotaljoincount(rootObject.optString("maxtotaljoincount", ""));
        bonusPromotion.setSelectedplayers(rootObject.optString("selectedplayers", ""));
        bonusPromotion.setTargetcountry(rootObject.optString("targetcountry", ""));
        bonusPromotion.setAutorenew(rootObject.optString("autorenew", ""));
        bonusPromotion.setRemark(rootObject.optString("remark", ""));
        bonusPromotion.setBrandid(rootObject.optString("brandid", ""));
        bonusPromotion.setAgents(rootObject.optString("agents", ""));
        bonusPromotion.setGrpnames(rootObject.optString("grpnames", ""));
        bonusPromotion.setAgentcodes(rootObject.optString("agentcodes", ""));
        bonusPromotion.setGroupids(rootObject.optString("groupids", ""));
        bonusPromotion.setTaggroupids(rootObject.optString("taggroupids", ""));
        bonusPromotion.setCgroupids(rootObject.optString("cgroupids", ""));
        bonusPromotion.setRealdesc(rootObject.optString("realdesc", ""));
        bonusPromotion.setRealcontent(rootObject.optString("realcontent", ""));
        bonusPromotion.setRealname(rootObject.optString("realname", ""));
        bonusPromotion.setRealcover(rootObject.optString("realcover", ""));
        bonusPromotion.setRealmcontent(rootObject.optString("realmcontent", ""));
        bonusPromotion.setRealmcover(rootObject.optString("realmcover", ""));
        bonusPromotion.setDno(rootObject.optString("dno", ""));
        bonusPromotion.setApplydate(rootObject.optString("applydate", ""));
        bonusPromotion.setGetstatus(rootObject.optString("getstatus", ""));
        bonusPromotion.setOriname(rootObject.optString("oriname", ""));
        bonusPromotion.setOriename(rootObject.optString("oriename", ""));
        bonusPromotion.setTypename(rootObject.optString("typename", ""));
        bonusPromotion.setBonusupdated(rootObject.optString("bonusupdated", ""));
        bonusPromotion.setRequirement(rootObject.optString("requirement", ""));
        bonusPromotion.setA(rootObject.optString("a", ""));
        bonusPromotion.setDeposit_amount(rootObject.optString("deposit_amount", ""));
        bonusPromotion.setAvailable_dptAmt(rootObject.optString("available_dptAmt", ""));
        bonusPromotion.setIsExpired(rootObject.optString("isExpired", ""));
        bonusPromotion.setBonus(rootObject.optString("bonus", ""));
        bonusPromotion.setNextstageamt(rootObject.optString("nextstageamt", ""));
        bonusPromotion.setRO(rootObject.optString("RO", ""));
        bonusPromotion.setCanJoin(rootObject.optBoolean("canJoin", false));
        bonusPromotion.setSubmitwithdraw(rootObject.optBoolean("submitwithdraw", false));
        bonusPromotion.setPercentage(rootObject.optInt("percentage", 0));
        bonusPromotion.setExpiredOn(rootObject.optInt("expiredOn", 0));
        return bonusPromotion;
    }

    public String getActid() {
        return actid;
    }

    public void setActid(String actid) {
        this.actid = actid;
    }

    public String getActypeid() {
        return actypeid;
    }

    public void setActypeid(String actypeid) {
        this.actypeid = actypeid;
    }

    public String getActname() {
        return actname;
    }

    public void setActname(String actname) {
        this.actname = actname;
    }

    public String getActdesc() {
        return actdesc;
    }

    public void setActdesc(String actdesc) {
        this.actdesc = actdesc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCoveralt() {
        return coveralt;
    }

    public void setCoveralt(String coveralt) {
        this.coveralt = coveralt;
    }

    public String getCover_mobile() {
        return cover_mobile;
    }

    public void setCover_mobile(String cover_mobile) {
        this.cover_mobile = cover_mobile;
    }

    public String getCover_panel() {
        return cover_panel;
    }

    public void setCover_panel(String cover_panel) {
        this.cover_panel = cover_panel;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(String displayorder) {
        this.displayorder = displayorder;
    }

    public String getActiveapply() {
        return activeapply;
    }

    public void setActiveapply(String activeapply) {
        this.activeapply = activeapply;
    }

    public String getPers() {
        return pers;
    }

    public void setPers(String pers) {
        this.pers = pers;
    }

    public String getHotlvl() {
        return hotlvl;
    }

    public void setHotlvl(String hotlvl) {
        this.hotlvl = hotlvl;
    }

    public String getLbtime() {
        return lbtime;
    }

    public void setLbtime(String lbtime) {
        this.lbtime = lbtime;
    }

    public String getLbtxt1() {
        return lbtxt1;
    }

    public void setLbtxt1(String lbtxt1) {
        this.lbtxt1 = lbtxt1;
    }

    public String getLbtxt2() {
        return lbtxt2;
    }

    public void setLbtxt2(String lbtxt2) {
        this.lbtxt2 = lbtxt2;
    }

    public String getRedirect_to() {
        return redirect_to;
    }

    public void setRedirect_to(String redirect_to) {
        this.redirect_to = redirect_to;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public String getActivityrequesttype() {
        return activityrequesttype;
    }

    public void setActivityrequesttype(String activityrequesttype) {
        this.activityrequesttype = activityrequesttype;
    }

    public String getIncluded_calculation_platform() {
        return included_calculation_platform;
    }

    public void setIncluded_calculation_platform(String included_calculation_platform) {
        this.included_calculation_platform = included_calculation_platform;
    }

    public String getDaysbeforejoin() {
        return daysbeforejoin;
    }

    public void setDaysbeforejoin(String daysbeforejoin) {
        this.daysbeforejoin = daysbeforejoin;
    }

    public String getLowestnegative() {
        return lowestnegative;
    }

    public void setLowestnegative(String lowestnegative) {
        this.lowestnegative = lowestnegative;
    }

    public String getRescueratio() {
        return rescueratio;
    }

    public void setRescueratio(String rescueratio) {
        this.rescueratio = rescueratio;
    }

    public String getRescueratioflowmultiply() {
        return rescueratioflowmultiply;
    }

    public void setRescueratioflowmultiply(String rescueratioflowmultiply) {
        this.rescueratioflowmultiply = rescueratioflowmultiply;
    }

    public String getRestricted_platform() {
        return restricted_platform;
    }

    public void setRestricted_platform(String restricted_platform) {
        this.restricted_platform = restricted_platform;
    }

    public String getRequest_highest_amount_each() {
        return request_highest_amount_each;
    }

    public void setRequest_highest_amount_each(String request_highest_amount_each) {
        this.request_highest_amount_each = request_highest_amount_each;
    }

    public String getRequest_highest_amount_daily() {
        return request_highest_amount_daily;
    }

    public void setRequest_highest_amount_daily(String request_highest_amount_daily) {
        this.request_highest_amount_daily = request_highest_amount_daily;
    }

    public String getMax_bonus() {
        return max_bonus;
    }

    public void setMax_bonus(String max_bonus) {
        this.max_bonus = max_bonus;
    }

    public String getTotaljoins() {
        return totaljoins;
    }

    public void setTotaljoins(String totaljoins) {
        this.totaljoins = totaljoins;
    }

    public String getMobilecontent() {
        return mobilecontent;
    }

    public void setMobilecontent(String mobilecontent) {
        this.mobilecontent = mobilecontent;
    }

    public String getPersduration() {
        return persduration;
    }

    public void setPersduration(String persduration) {
        this.persduration = persduration;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getExpireddate() {
        return expireddate;
    }

    public void setExpireddate(String expireddate) {
        this.expireddate = expireddate;
    }

    public String getBeforelogin() {
        return beforelogin;
    }

    public void setBeforelogin(String beforelogin) {
        this.beforelogin = beforelogin;
    }

    public String getAc_data() {
        return ac_data;
    }

    public void setAc_data(String ac_data) {
        this.ac_data = ac_data;
    }

    public String getAc_link_id() {
        return ac_link_id;
    }

    public void setAc_link_id(String ac_link_id) {
        this.ac_link_id = ac_link_id;
    }

    public String getBg_color() {
        return bg_color;
    }

    public void setBg_color(String bg_color) {
        this.bg_color = bg_color;
    }

    public String getBg_color_m() {
        return bg_color_m;
    }

    public void setBg_color_m(String bg_color_m) {
        this.bg_color_m = bg_color_m;
    }

    public String getWeb_font_color() {
        return web_font_color;
    }

    public void setWeb_font_color(String web_font_color) {
        this.web_font_color = web_font_color;
    }

    public String getH5_font_color() {
        return h5_font_color;
    }

    public void setH5_font_color(String h5_font_color) {
        this.h5_font_color = h5_font_color;
    }

    public String getFronttypeid() {
        return fronttypeid;
    }

    public void setFronttypeid(String fronttypeid) {
        this.fronttypeid = fronttypeid;
    }

    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public String getResetperiod() {
        return resetperiod;
    }

    public void setResetperiod(String resetperiod) {
        this.resetperiod = resetperiod;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getDisplaystarttime() {
        return displaystarttime;
    }

    public void setDisplaystarttime(String displaystarttime) {
        this.displaystarttime = displaystarttime;
    }

    public String getDisplayendtime() {
        return displayendtime;
    }

    public void setDisplayendtime(String displayendtime) {
        this.displayendtime = displayendtime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTargetusertype() {
        return targetusertype;
    }

    public void setTargetusertype(String targetusertype) {
        this.targetusertype = targetusertype;
    }

    public String getMaxtotaljoincount() {
        return maxtotaljoincount;
    }

    public void setMaxtotaljoincount(String maxtotaljoincount) {
        this.maxtotaljoincount = maxtotaljoincount;
    }

    public String getSelectedplayers() {
        return selectedplayers;
    }

    public void setSelectedplayers(String selectedplayers) {
        this.selectedplayers = selectedplayers;
    }

    public String getTargetcountry() {
        return targetcountry;
    }

    public void setTargetcountry(String targetcountry) {
        this.targetcountry = targetcountry;
    }

    public String getAutorenew() {
        return autorenew;
    }

    public void setAutorenew(String autorenew) {
        this.autorenew = autorenew;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid;
    }

    public String getAgents() {
        return agents;
    }

    public void setAgents(String agents) {
        this.agents = agents;
    }

    public String getGrpnames() {
        return grpnames;
    }

    public void setGrpnames(String grpnames) {
        this.grpnames = grpnames;
    }

    public String getAgentcodes() {
        return agentcodes;
    }

    public void setAgentcodes(String agentcodes) {
        this.agentcodes = agentcodes;
    }

    public String getGroupids() {
        return groupids;
    }

    public void setGroupids(String groupids) {
        this.groupids = groupids;
    }

    public String getTaggroupids() {
        return taggroupids;
    }

    public void setTaggroupids(String taggroupids) {
        this.taggroupids = taggroupids;
    }

    public String getCgroupids() {
        return cgroupids;
    }

    public void setCgroupids(String cgroupids) {
        this.cgroupids = cgroupids;
    }

    public String getRealdesc() {
        return realdesc;
    }

    public void setRealdesc(String realdesc) {
        this.realdesc = realdesc;
    }

    public String getRealcontent() {
        return realcontent;
    }

    public void setRealcontent(String realcontent) {
        this.realcontent = realcontent;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRealcover() {
        return realcover;
    }

    public void setRealcover(String realcover) {
        this.realcover = realcover;
    }

    public String getRealmcontent() {
        return realmcontent;
    }

    public void setRealmcontent(String realmcontent) {
        this.realmcontent = realmcontent;
    }

    public String getRealmcover() {
        return realmcover;
    }

    public void setRealmcover(String realmcover) {
        this.realmcover = realmcover;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate;
    }

    public String getGetstatus() {
        return getstatus;
    }

    public void setGetstatus(String getstatus) {
        this.getstatus = getstatus;
    }

    public String getOriname() {
        return oriname;
    }

    public void setOriname(String oriname) {
        this.oriname = oriname;
    }

    public String getOriename() {
        return oriename;
    }

    public void setOriename(String oriename) {
        this.oriename = oriename;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getBonusupdated() {
        return bonusupdated;
    }

    public void setBonusupdated(String bonusupdated) {
        this.bonusupdated = bonusupdated;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(String deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public String getAvailable_dptAmt() {
        return available_dptAmt;
    }

    public void setAvailable_dptAmt(String available_dptAmt) {
        this.available_dptAmt = available_dptAmt;
    }

    public String getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(String isExpired) {
        this.isExpired = isExpired;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getNextstageamt() {
        return nextstageamt;
    }

    public void setNextstageamt(String nextstageamt) {
        this.nextstageamt = nextstageamt;
    }

    public String getRO() {
        return RO;
    }

    public void setRO(String RO) {
        this.RO = RO;
    }

    public boolean isCanJoin() {
        return canJoin;
    }

    public void setCanJoin(boolean canJoin) {
        this.canJoin = canJoin;
    }

    public boolean isSubmitwithdraw() {
        return submitwithdraw;
    }

    public void setSubmitwithdraw(boolean submitwithdraw) {
        this.submitwithdraw = submitwithdraw;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(int expiredOn) {
        this.expiredOn = expiredOn;
    }
}

