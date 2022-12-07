package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class GetRewardVipAutoBonusResult {

    private String id;
    private String levelCode;
    private String levelName;
    private String vipId;
    private String bonusType;
    private String bOption;
    private String currency;
    private String brandId;
    private Integer dayReg;
    private BigDecimal deposit1;
    private BigDecimal bet1;
    private BigDecimal company1;
    private BigDecimal deposit7;
    private BigDecimal bet7;
    private BigDecimal company7;
    private BigDecimal deposit30;
    private BigDecimal bet30;
    private BigDecimal company30;
    private BigDecimal depositAll;
    private BigDecimal betAll;
    private BigDecimal companyAll;
    private BigDecimal reward;

    public static GetRewardVipAutoBonusResult newInstance(JSONObject rootObject) {
        GetRewardVipAutoBonusResult getDepositRecordResult = new GetRewardVipAutoBonusResult();
        getDepositRecordResult.id = rootObject.optString("id");
        getDepositRecordResult.levelCode = rootObject.optString("levelCode");
        getDepositRecordResult.levelName = rootObject.optString("levelName");
        getDepositRecordResult.vipId = rootObject.optString("vipid");
        getDepositRecordResult.bonusType = rootObject.optString("bonustype");
        getDepositRecordResult.bOption = rootObject.optString("b_option");
        getDepositRecordResult.currency = rootObject.optString("currency");
        getDepositRecordResult.brandId = rootObject.optString("brandId");
        getDepositRecordResult.dayReg = rootObject.optInt("dayreg");
        getDepositRecordResult.deposit1 = BigDecimalUtil.optBigDecimal(rootObject, "deposit1");
        getDepositRecordResult.bet1 = BigDecimalUtil.optBigDecimal(rootObject, "bet1");
        getDepositRecordResult.company1 = BigDecimalUtil.optBigDecimal(rootObject, "company1");
        getDepositRecordResult.deposit7 = BigDecimalUtil.optBigDecimal(rootObject, "deposit7");
        getDepositRecordResult.bet7 = BigDecimalUtil.optBigDecimal(rootObject, "bet7");
        getDepositRecordResult.company7 = BigDecimalUtil.optBigDecimal(rootObject, "company7");
        getDepositRecordResult.deposit30 = BigDecimalUtil.optBigDecimal(rootObject, "deposit30");
        getDepositRecordResult.bet30 = BigDecimalUtil.optBigDecimal(rootObject, "bet30");
        getDepositRecordResult.company30 = BigDecimalUtil.optBigDecimal(rootObject, "company30");
        getDepositRecordResult.depositAll = BigDecimalUtil.optBigDecimal(rootObject, "depositall");
        getDepositRecordResult.betAll = BigDecimalUtil.optBigDecimal(rootObject, "betall");
        getDepositRecordResult.companyAll = BigDecimalUtil.optBigDecimal(rootObject, "companyall");
        getDepositRecordResult.reward = BigDecimalUtil.optBigDecimal(rootObject, "reward");
        return getDepositRecordResult;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getVipId() {
        return vipId;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId;
    }

    public String getBonusType() {
        return bonusType;
    }

    public void setBonusType(String bonusType) {
        this.bonusType = bonusType;
    }

    public String getbOption() {
        return bOption;
    }

    public void setbOption(String bOption) {
        this.bOption = bOption;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public Integer getDayReg() {
        return dayReg;
    }

    public void setDayReg(Integer dayReg) {
        this.dayReg = dayReg;
    }

    public BigDecimal getDeposit1() {
        return deposit1;
    }

    public void setDeposit1(BigDecimal deposit1) {
        this.deposit1 = deposit1;
    }

    public BigDecimal getBet1() {
        return bet1;
    }

    public void setBet1(BigDecimal bet1) {
        this.bet1 = bet1;
    }

    public BigDecimal getCompany1() {
        return company1;
    }

    public void setCompany1(BigDecimal company1) {
        this.company1 = company1;
    }

    public BigDecimal getDeposit7() {
        return deposit7;
    }

    public void setDeposit7(BigDecimal deposit7) {
        this.deposit7 = deposit7;
    }

    public BigDecimal getBet7() {
        return bet7;
    }

    public void setBet7(BigDecimal bet7) {
        this.bet7 = bet7;
    }

    public BigDecimal getCompany7() {
        return company7;
    }

    public void setCompany7(BigDecimal company7) {
        this.company7 = company7;
    }

    public BigDecimal getDeposit30() {
        return deposit30;
    }

    public void setDeposit30(BigDecimal deposit30) {
        this.deposit30 = deposit30;
    }

    public BigDecimal getBet30() {
        return bet30;
    }

    public void setBet30(BigDecimal bet30) {
        this.bet30 = bet30;
    }

    public BigDecimal getCompany30() {
        return company30;
    }

    public void setCompany30(BigDecimal company30) {
        this.company30 = company30;
    }

    public BigDecimal getDepositAll() {
        return depositAll;
    }

    public void setDepositAll(BigDecimal depositAll) {
        this.depositAll = depositAll;
    }

    public BigDecimal getBetAll() {
        return betAll;
    }

    public void setBetAll(BigDecimal betAll) {
        this.betAll = betAll;
    }

    public BigDecimal getCompanyAll() {
        return companyAll;
    }

    public void setCompanyAll(BigDecimal companyAll) {
        this.companyAll = companyAll;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }
}

