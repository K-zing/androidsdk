package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.math.BigDecimal;


public class GiftHistory implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public GiftHistory createFromParcel(Parcel in) {
            return new GiftHistory(in);
        }

        public GiftHistory[] newArray(int size) {
            return new GiftHistory[size];
        }
    };
    private String refNo;
    private String giftId;
    private String actId;
    private String actName;
    private String calcMethod;
    private String depositValidHours;
    private boolean isCalcTotalDeposit;
    private int calcTotalDepositHour;
    private String giftName;
    private String giftPicUrl;
    private BigDecimal requirementAmount = BigDecimal.ZERO;
    private BigDecimal resultAmount = BigDecimal.ZERO;
    private long created;
    private long startTime;
    private long endTime;
    private long redeemTime;
    private String courierNo;
    private String playerRedeemStatus;
    private String sno;
    private String playerRedeemStatusName;


    public GiftHistory() {

    }

    public static GiftHistory newInstance(JSONObject rootObject) {
        GiftHistory item = new GiftHistory();
        item.setRefNo(rootObject.optString("refno"));
        item.setGiftId(rootObject.optString("giftid"));
        item.setActId(rootObject.optString("actid"));
        item.setActName(rootObject.optString("actname"));
        item.setCalcMethod(rootObject.optString("calcmethod"));
        item.setDepositValidHours(rootObject.optString("depositvalidhours"));
        item.setIsCalcTotalDeposit(rootObject.optString("iscalctotaldeposit").equalsIgnoreCase("1"));
        item.setCalcTotalDepositHour(rootObject.optInt("calctotaldeposithour"));
        item.setGiftName(rootObject.optString("giftname"));
        item.setGiftPicUrl(rootObject.optString("giftpicurl"));
        item.setRequirementAmount(BigDecimalUtil.optBigDecimal(rootObject, "requirementamount", BigDecimal.ZERO));
        item.setResultAmount(BigDecimalUtil.optBigDecimal(rootObject, "resultamount", BigDecimal.ZERO));
        item.setCreated(rootObject.optLong("created"));
        item.setStartTime(rootObject.optLong("starttime"));
        item.setEndTime(rootObject.optLong("endtime"));
        item.setRedeemTime(rootObject.optLong("redeemtime"));
        item.setCourierNo(rootObject.optString("courierno"));
        item.setPlayerRedeemStatus(rootObject.optString("playerredeemstatus"));
        item.setSno(rootObject.optString("sno"));
        item.setPlayerRedeemStatusName(rootObject.optString("playerredeemstatusname"));
        return item;
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

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getCalcMethod() {
        return calcMethod;
    }

    public void setCalcMethod(String calcMethod) {
        this.calcMethod = calcMethod;
    }

    public String getDepositValidHours() {
        return depositValidHours;
    }

    public void setDepositValidHours(String depositValidHours) {
        this.depositValidHours = depositValidHours;
    }

    public boolean isCalcTotalDeposit() {
        return isCalcTotalDeposit;
    }

    public void setIsCalcTotalDeposit(boolean calcTotalDeposit) {
        isCalcTotalDeposit = calcTotalDeposit;
    }

    public int getCalcTotalDepositHour() {
        return calcTotalDepositHour;
    }

    public void setCalcTotalDepositHour(int calcTotalDepositHour) {
        this.calcTotalDepositHour = calcTotalDepositHour;
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

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getRedeemTime() {
        return redeemTime;
    }

    public void setRedeemTime(long redeemTime) {
        this.redeemTime = redeemTime;
    }

    public String getCourierNo() {
        return courierNo;
    }

    public void setCourierNo(String courierNo) {
        this.courierNo = courierNo;
    }

    public String getPlayerRedeemStatus() {
        return playerRedeemStatus;
    }

    public void setPlayerRedeemStatus(String playerRedeemStatus) {
        this.playerRedeemStatus = playerRedeemStatus;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getPlayerRedeemStatusName() {
        return playerRedeemStatusName;
    }

    public void setPlayerRedeemStatusName(String playerRedeemStatusName) {
        this.playerRedeemStatusName = playerRedeemStatusName;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(refNo);
        dest.writeString(giftId);
        dest.writeString(actId);
        dest.writeString(actName);
        dest.writeString(calcMethod);
        dest.writeString(depositValidHours);
        dest.writeInt(isCalcTotalDeposit ? 1 : 0);
        dest.writeInt(calcTotalDepositHour);
        dest.writeString(giftName);
        dest.writeString(giftPicUrl);
        dest.writeString(requirementAmount.toString());
        dest.writeString(resultAmount.toString());
        dest.writeLong(created);
        dest.writeLong(startTime);
        dest.writeLong(endTime);
        dest.writeLong(redeemTime);
        dest.writeString(courierNo);
        dest.writeString(playerRedeemStatus);
        dest.writeString(sno);
        dest.writeString(playerRedeemStatusName);
    }

    public GiftHistory(Parcel in) {
        refNo = in.readString();
        giftId = in.readString();
        actId = in.readString();
        actName = in.readString();
        calcMethod = in.readString();
        depositValidHours = in.readString();
        isCalcTotalDeposit = in.readInt() == 1;
        calcTotalDepositHour = in.readInt();
        giftName = in.readString();
        giftPicUrl = in.readString();
        requirementAmount = new BigDecimal(in.readString());
        resultAmount = new BigDecimal(in.readString());
        created = in.readLong();
        startTime = in.readLong();
        endTime = in.readLong();
        redeemTime = in.readLong();
        courierNo = in.readString();
        playerRedeemStatus = in.readString();
        sno = in.readString();
        playerRedeemStatusName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "GiftHistory{" +
                "refNo='" + refNo + '\'' +
                ", giftId='" + giftId + '\'' +
                ", actId='" + actId + '\'' +
                ", actName='" + actName + '\'' +
                ", calcMethod='" + calcMethod + '\'' +
                ", depositValidHours='" + depositValidHours + '\'' +
                ", isCalcTotalDeposit=" + isCalcTotalDeposit +
                ", calcTotalDepositHour=" + calcTotalDepositHour +
                ", giftName='" + giftName + '\'' +
                ", giftPicUrl='" + giftPicUrl + '\'' +
                ", requirementAmount=" + requirementAmount +
                ", resultAmount=" + resultAmount +
                ", created=" + created +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", redeemTime=" + redeemTime +
                ", courierNo='" + courierNo + '\'' +
                ", playerRedeemStatus='" + playerRedeemStatus + '\'' +
                ", sno='" + sno + '\'' +
                '}';
    }
}
