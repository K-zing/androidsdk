package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;

public class VipSetting implements Parcelable {

    private String groupId;
    private String groupName;
    private Integer rankLevel;
    private Integer withdrawTimes;
    private BigDecimal monthReward = BigDecimal.ZERO;
    private BigDecimal dailyReward = BigDecimal.ZERO;
    private BigDecimal weeklyReward = BigDecimal.ZERO;
    private BigDecimal birthReward = BigDecimal.ZERO;
    private BigDecimal withdrawDailyMaxLimit = BigDecimal.ZERO;
    private BigDecimal autoLevelReward = BigDecimal.ZERO;
    private BigDecimal autoUpTargetDeposit = BigDecimal.ZERO;
    private BigDecimal autoUpTargetBet = BigDecimal.ZERO;
    private BigDecimal autoRemainTargetBet = BigDecimal.ZERO;

    public VipSetting() {
    }

    public static VipSetting newInstance(JSONObject rootObject) {
        VipSetting vipSetting = new VipSetting();
        vipSetting.groupId = rootObject.optString("groupId");
        vipSetting.groupName = rootObject.optString("groupName");
        vipSetting.rankLevel = rootObject.optInt("ranklevel", 0);
        vipSetting.withdrawTimes = rootObject.optInt("wtdtimes", 0);
        vipSetting.monthReward = BigDecimalUtil.optBigDecimal(rootObject, "monthReward", BigDecimal.ZERO);
        vipSetting.dailyReward = BigDecimalUtil.optBigDecimal(rootObject, "dailyReward", BigDecimal.ZERO);
        vipSetting.weeklyReward = BigDecimalUtil.optBigDecimal(rootObject, "weeklyReward", BigDecimal.ZERO);
        vipSetting.birthReward = BigDecimalUtil.optBigDecimal(rootObject, "birthReward", BigDecimal.ZERO);
        vipSetting.withdrawDailyMaxLimit = BigDecimalUtil.optBigDecimal(rootObject, "withdrawDailyMaxLimit", BigDecimal.ZERO);
        vipSetting.autoLevelReward = BigDecimalUtil.optBigDecimal(rootObject, "autoLevelReward", BigDecimal.ZERO);
        vipSetting.autoUpTargetDeposit = BigDecimalUtil.optBigDecimal(rootObject, "autoUpTargetDeposit", BigDecimal.ZERO);
        vipSetting.autoUpTargetBet = BigDecimalUtil.optBigDecimal(rootObject, "autoUpTargetBet", BigDecimal.ZERO);
        vipSetting.autoRemainTargetBet = BigDecimalUtil.optBigDecimal(rootObject, "autoRemainTargetBet", BigDecimal.ZERO);
        return vipSetting;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getWithdrawTimes() {
        return withdrawTimes;
    }

    public void setWithdrawTimes(Integer withdrawTimes) {
        this.withdrawTimes = withdrawTimes;
    }

    public BigDecimal getMonthReward() {
        return monthReward;
    }

    public void setMonthReward(BigDecimal monthReward) {
        this.monthReward = monthReward;
    }

    public BigDecimal getDailyReward() {
        return dailyReward;
    }

    public void setDailyReward(BigDecimal dailyReward) {
        this.dailyReward = dailyReward;
    }

    public BigDecimal getWeeklyReward() {
        return weeklyReward;
    }

    public void setWeeklyReward(BigDecimal weeklyReward) {
        this.weeklyReward = weeklyReward;
    }

    public BigDecimal getBirthReward() {
        return birthReward;
    }

    public void setBirthReward(BigDecimal birthReward) {
        this.birthReward = birthReward;
    }

    public BigDecimal getWithdrawDailyMaxLimit() {
        return withdrawDailyMaxLimit;
    }

    public void setWithdrawDailyMaxLimit(BigDecimal withdrawDailyMaxLimit) {
        this.withdrawDailyMaxLimit = withdrawDailyMaxLimit;
    }

    public BigDecimal getAutoLevelReward() {
        return autoLevelReward;
    }

    public void setAutoLevelReward(BigDecimal autoLevelReward) {
        this.autoLevelReward = autoLevelReward;
    }

    public BigDecimal getAutoUpTargetDeposit() {
        return autoUpTargetDeposit;
    }

    public void setAutoUpTargetDeposit(BigDecimal autoUpTargetDeposit) {
        this.autoUpTargetDeposit = autoUpTargetDeposit;
    }

    public BigDecimal getAutoUpTargetBet() {
        return autoUpTargetBet;
    }

    public void setAutoUpTargetBet(BigDecimal autoUpTargetBet) {
        this.autoUpTargetBet = autoUpTargetBet;
    }

    public BigDecimal getAutoRemainTargetBet() {
        return autoRemainTargetBet;
    }

    public void setAutoRemainTargetBet(BigDecimal autoRemainTargetBet) {
        this.autoRemainTargetBet = autoRemainTargetBet;
    }

    public Integer getRankLevel() {
        return rankLevel;
    }

    public void setRankLevel(Integer rankLevel) {
        this.rankLevel = rankLevel;
    }

    protected VipSetting(Parcel in) {
        groupId = in.readString();
        groupName = in.readString();
        rankLevel = in.readInt();
        withdrawTimes = in.readInt();
        monthReward = new BigDecimal(in.readString());
        dailyReward = new BigDecimal(in.readString());
        weeklyReward = new BigDecimal(in.readString());
        birthReward = new BigDecimal(in.readString());
        withdrawDailyMaxLimit = new BigDecimal(in.readString());
        autoLevelReward = new BigDecimal(in.readString());
        autoUpTargetDeposit = new BigDecimal(in.readString());
        autoUpTargetBet = new BigDecimal(in.readString());
        autoRemainTargetBet = new BigDecimal(in.readString());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(groupId);
        dest.writeString(groupName);
        dest.writeInt(rankLevel);
        dest.writeInt(withdrawTimes);
        dest.writeString(monthReward.toString());
        dest.writeString(dailyReward.toString());
        dest.writeString(weeklyReward.toString());
        dest.writeString(birthReward.toString());
        dest.writeString(withdrawDailyMaxLimit.toString());
        dest.writeString(autoLevelReward.toString());
        dest.writeString(autoUpTargetDeposit.toString());
        dest.writeString(autoUpTargetBet.toString());
        dest.writeString(autoRemainTargetBet.toString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VipSetting> CREATOR = new Creator<VipSetting>() {
        @Override
        public VipSetting createFromParcel(Parcel in) {
            return new VipSetting(in);
        }

        @Override
        public VipSetting[] newArray(int size) {
            return new VipSetting[size];
        }
    };


}
