package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class ActivityReferDptRequirement implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public ActivityReferDptRequirement createFromParcel(Parcel in) {
            return new ActivityReferDptRequirement(in);
        }

        public ActivityReferDptRequirement[] newArray(int size) {
            return new ActivityReferDptRequirement[size];
        }
    };

    private BigDecimal depositAmount = BigDecimal.ZERO;
    private BigDecimal fixBonusAmount = BigDecimal.ZERO;
    private BigDecimal moneyPercentage = BigDecimal.ZERO;
    private BigDecimal watergateMultiplier = BigDecimal.ZERO;
    private BigDecimal extraBonusAmount = BigDecimal.ZERO;
    private BigDecimal maxDistributeAmount = BigDecimal.ZERO;
    private Integer bType;
    private Integer cType;

    public ActivityReferDptRequirement() {
    }

    public static ActivityReferDptRequirement newInstance(JSONObject rootObject) {
        ActivityReferDptRequirement item = new ActivityReferDptRequirement();
        item.depositAmount = BigDecimalUtil.optBigDecimal(rootObject, "deposit_amount", BigDecimal.ZERO);
        item.fixBonusAmount = BigDecimalUtil.optBigDecimal(rootObject, "fix_bonus_amount", BigDecimal.ZERO);
        item.moneyPercentage = BigDecimalUtil.optBigDecimal(rootObject, "money_percentage", BigDecimal.ZERO);
        item.watergateMultiplier = BigDecimalUtil.optBigDecimal(rootObject, "watergate_multiplier", BigDecimal.ZERO);
        item.extraBonusAmount = BigDecimalUtil.optBigDecimal(rootObject, "extra_bonus_amount", BigDecimal.ZERO);
        item.maxDistributeAmount = BigDecimalUtil.optBigDecimal(rootObject, "max_distribute_amount", BigDecimal.ZERO);
        item.bType = rootObject.optInt("btype");
        item.cType = rootObject.optInt("ctype");
        return item;
    }


    public ActivityReferDptRequirement(Parcel in) {
        depositAmount = new BigDecimal(in.readString());
        fixBonusAmount = new BigDecimal(in.readString());
        moneyPercentage = new BigDecimal(in.readString());
        watergateMultiplier = new BigDecimal(in.readString());
        extraBonusAmount = new BigDecimal(in.readString());
        maxDistributeAmount = new BigDecimal(in.readString());
        bType = in.readInt();
        cType = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(depositAmount.toString());
        dest.writeString(fixBonusAmount.toString());
        dest.writeString(moneyPercentage.toString());
        dest.writeString(watergateMultiplier.toString());
        dest.writeString(extraBonusAmount.toString());
        dest.writeString(maxDistributeAmount.toString());
        dest.writeInt(bType);
        dest.writeInt(cType);


    }

    public static Creator getCREATOR() {
        return CREATOR;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getFixBonusAmount() {
        return fixBonusAmount;
    }

    public void setFixBonusAmount(BigDecimal fixBonusAmount) {
        this.fixBonusAmount = fixBonusAmount;
    }

    public BigDecimal getMoneyPercentage() {
        return moneyPercentage;
    }

    public void setMoneyPercentage(BigDecimal moneyPercentage) {
        this.moneyPercentage = moneyPercentage;
    }

    public BigDecimal getWatergateMultiplier() {
        return watergateMultiplier;
    }

    public void setWatergateMultiplier(BigDecimal watergateMultiplier) {
        this.watergateMultiplier = watergateMultiplier;
    }

    public BigDecimal getExtraBonusAmount() {
        return extraBonusAmount;
    }

    public void setExtraBonusAmount(BigDecimal extraBonusAmount) {
        this.extraBonusAmount = extraBonusAmount;
    }

    public BigDecimal getMaxDistributeAmount() {
        return maxDistributeAmount;
    }

    public void setMaxDistributeAmount(BigDecimal maxDistributeAmount) {
        this.maxDistributeAmount = maxDistributeAmount;
    }

    public Integer getbType() {
        return bType;
    }

    public void setbType(Integer bType) {
        this.bType = bType;
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }
}