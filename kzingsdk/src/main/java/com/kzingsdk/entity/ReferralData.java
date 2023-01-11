package com.kzingsdk.entity;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;


public class ReferralData {

    private Integer toCheckRegistrationDate;
    private Integer toCheckCumulativeDeposit;
    private Integer toCheckCumulativeValidbet;
    private Integer toCheckEmailVerified;
    private Integer toCheckMobileVerified;
    private Integer passRegistrationDate;
    private Integer passCumulativeDeposit;
    private Integer passCumulativeValidbet;
    private Integer passEmailVerified;
    private Integer passMobileVerified;
    private Integer progressClickedCount;
    private Integer progressRegistrationCount;
    private Integer progressDepositCount;
    private BigDecimal minDepositAmount;
    private BigDecimal minValidbetAmount;
    private BigDecimal depositAmount;
    private BigDecimal validBetAmount;
    private BigDecimal totalBonus;
    private Long registrationDate;
    private String referralLink;
    private ArrayList<ReferralDataBonusTier> referralDataBonusTierList = new ArrayList<>();

    public ReferralData() {

    }

    public static ReferralData newInstance(JSONObject rootObject) {
        ReferralData profileImage = new ReferralData();
        profileImage.setToCheckRegistrationDate(rootObject.optInt("to_check_registration_date"));
        profileImage.setToCheckCumulativeDeposit(rootObject.optInt("to_check_cumulative_deposit"));
        profileImage.setToCheckCumulativeValidbet(rootObject.optInt("to_check_cumulative_validbet"));
        profileImage.setToCheckEmailVerified(rootObject.optInt("to_check_email_verified"));
        profileImage.setToCheckMobileVerified(rootObject.optInt("to_check_mobile_verified"));
        profileImage.setPassRegistrationDate(rootObject.optInt("pass_registration_date"));
        profileImage.setPassCumulativeDeposit(rootObject.optInt("pass_cumulative_deposit"));
        profileImage.setPassCumulativeValidbet(rootObject.optInt("pass_cumulative_validbet"));
        profileImage.setPassEmailVerified(rootObject.optInt("pass_email_verified"));
        profileImage.setPassMobileVerified(rootObject.optInt("pass_mobile_verified"));
        profileImage.setProgressClickedCount(rootObject.optInt("progress_clicked_count"));
        profileImage.setProgressRegistrationCount(rootObject.optInt("progress_registration_count"));
        profileImage.setProgressDepositCount(rootObject.optInt("progress_deposit_count"));
        profileImage.setMinDepositAmount(BigDecimalUtil.optBigDecimal(rootObject, "min_deposit_amount", BigDecimal.ZERO));
        profileImage.setMinValidbetAmount(BigDecimalUtil.optBigDecimal(rootObject, "min_validbet_amount", BigDecimal.ZERO));
        profileImage.setDepositAmount(BigDecimalUtil.optBigDecimal(rootObject, "deposit_amount", BigDecimal.ZERO));
        profileImage.setValidBetAmount(BigDecimalUtil.optBigDecimal(rootObject, "valid_bet_amount", BigDecimal.ZERO));
        profileImage.setTotalBonus(BigDecimalUtil.optBigDecimal(rootObject, "total_bonus", BigDecimal.ZERO));
        profileImage.setRegistrationDate(rootObject.optLong("registration_date"));
        profileImage.setReferralLink(rootObject.optString("referral_link"));
        JSONArray bonusTierArray = rootObject.optJSONArray("bonus_tier");
        if (bonusTierArray != null) {
            for (int i = 0; i < bonusTierArray.length(); i++) {
                profileImage.referralDataBonusTierList.add(ReferralDataBonusTier.newInstance(bonusTierArray.optJSONObject(i)));
            }
        }
        return profileImage;
    }

    public Integer getToCheckRegistrationDate() {
        return toCheckRegistrationDate;
    }

    public void setToCheckRegistrationDate(Integer toCheckRegistrationDate) {
        this.toCheckRegistrationDate = toCheckRegistrationDate;
    }

    public Integer getToCheckCumulativeDeposit() {
        return toCheckCumulativeDeposit;
    }

    public void setToCheckCumulativeDeposit(Integer toCheckCumulativeDeposit) {
        this.toCheckCumulativeDeposit = toCheckCumulativeDeposit;
    }

    public Integer getToCheckCumulativeValidbet() {
        return toCheckCumulativeValidbet;
    }

    public void setToCheckCumulativeValidbet(Integer toCheckCumulativeValidbet) {
        this.toCheckCumulativeValidbet = toCheckCumulativeValidbet;
    }

    public Integer getToCheckEmailVerified() {
        return toCheckEmailVerified;
    }

    public void setToCheckEmailVerified(Integer toCheckEmailVerified) {
        this.toCheckEmailVerified = toCheckEmailVerified;
    }

    public Integer getToCheckMobileVerified() {
        return toCheckMobileVerified;
    }

    public void setToCheckMobileVerified(Integer toCheckMobileVerified) {
        this.toCheckMobileVerified = toCheckMobileVerified;
    }

    public Integer getPassRegistrationDate() {
        return passRegistrationDate;
    }

    public void setPassRegistrationDate(Integer passRegistrationDate) {
        this.passRegistrationDate = passRegistrationDate;
    }

    public Integer getPassCumulativeDeposit() {
        return passCumulativeDeposit;
    }

    public void setPassCumulativeDeposit(Integer passCumulativeDeposit) {
        this.passCumulativeDeposit = passCumulativeDeposit;
    }

    public Integer getPassCumulativeValidbet() {
        return passCumulativeValidbet;
    }

    public void setPassCumulativeValidbet(Integer passCumulativeValidbet) {
        this.passCumulativeValidbet = passCumulativeValidbet;
    }

    public Integer getPassEmailVerified() {
        return passEmailVerified;
    }

    public void setPassEmailVerified(Integer passEmailVerified) {
        this.passEmailVerified = passEmailVerified;
    }

    public Integer getPassMobileVerified() {
        return passMobileVerified;
    }

    public void setPassMobileVerified(Integer passMobileVerified) {
        this.passMobileVerified = passMobileVerified;
    }

    public Integer getProgressClickedCount() {
        return progressClickedCount;
    }

    public void setProgressClickedCount(Integer progressClickedCount) {
        this.progressClickedCount = progressClickedCount;
    }

    public Integer getProgressRegistrationCount() {
        return progressRegistrationCount;
    }

    public void setProgressRegistrationCount(Integer progressRegistrationCount) {
        this.progressRegistrationCount = progressRegistrationCount;
    }

    public Integer getProgressDepositCount() {
        return progressDepositCount;
    }

    public void setProgressDepositCount(Integer progressDepositCount) {
        this.progressDepositCount = progressDepositCount;
    }

    public BigDecimal getMinDepositAmount() {
        return minDepositAmount;
    }

    public void setMinDepositAmount(BigDecimal minDepositAmount) {
        this.minDepositAmount = minDepositAmount;
    }

    public BigDecimal getMinValidbetAmount() {
        return minValidbetAmount;
    }

    public void setMinValidbetAmount(BigDecimal minValidbetAmount) {
        this.minValidbetAmount = minValidbetAmount;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getValidBetAmount() {
        return validBetAmount;
    }

    public void setValidBetAmount(BigDecimal validBetAmount) {
        this.validBetAmount = validBetAmount;
    }

    public BigDecimal getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(BigDecimal totalBonus) {
        this.totalBonus = totalBonus;
    }

    public Long getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Long registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getReferralLink() {
        return referralLink;
    }

    public void setReferralLink(String referralLink) {
        this.referralLink = referralLink;
    }

    public ArrayList<ReferralDataBonusTier> getReferralDataBonusTierList() {
        return referralDataBonusTierList;
    }

    public void setReferralDataBonusTierList(ArrayList<ReferralDataBonusTier> referralDataBonusTierList) {
        this.referralDataBonusTierList = referralDataBonusTierList;
    }
}

