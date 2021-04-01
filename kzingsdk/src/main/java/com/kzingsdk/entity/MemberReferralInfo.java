package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;


public class MemberReferralInfo implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public MemberReferralInfo createFromParcel(Parcel in) {
            return new MemberReferralInfo(in);
        }

        public MemberReferralInfo[] newArray(int size) {
            return new MemberReferralInfo[size];
        }
    };
    private String cover;
    private String content;
    private Integer referCount = 0;
    private Integer firstDepositCount = 0;
    private BigDecimal todayBonusAmount = BigDecimal.ZERO;
    private BigDecimal bonusAmount = BigDecimal.ZERO;

    public MemberReferralInfo() {

    }

    public static MemberReferralInfo newInstance(JSONObject rootObject) {
        MemberReferralInfo memberReferralInfo = new MemberReferralInfo();
        memberReferralInfo.setCover(rootObject.optString("cover"));
        try {
            memberReferralInfo.setContent(URLDecoder.decode(rootObject.optString("content"), "UTF-8"));
        } catch (UnsupportedEncodingException ignored) {
        }
        memberReferralInfo.setTodayBonusAmount(BigDecimalUtil.optBigDecimal(rootObject, "todayBonusAmount", BigDecimal.ZERO));
        memberReferralInfo.setBonusAmount(BigDecimalUtil.optBigDecimal(rootObject, "bonusAmount", BigDecimal.ZERO));
        memberReferralInfo.setReferCount(rootObject.optInt("referCount", 0));
        memberReferralInfo.setFirstDepositCount(rootObject.optInt("firstDepositCount", 0));
        return memberReferralInfo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReferCount() {
        return referCount;
    }

    public void setReferCount(Integer referCount) {
        this.referCount = referCount;
    }

    public Integer getFirstDepositCount() {
        return firstDepositCount;
    }

    public void setFirstDepositCount(Integer firstDepositCount) {
        this.firstDepositCount = firstDepositCount;
    }

    public BigDecimal getTodayBonusAmount() {
        return todayBonusAmount;
    }

    public void setTodayBonusAmount(BigDecimal todayBonusAmount) {
        this.todayBonusAmount = todayBonusAmount;
    }

    public BigDecimal getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public MemberReferralInfo(Parcel in) {
        cover = in.readString();
        content = in.readString();
        referCount = in.readInt();
        firstDepositCount = in.readInt();
        todayBonusAmount = new BigDecimal(in.readString());
        bonusAmount = new BigDecimal(in.readString());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cover);
        dest.writeString(content);
        dest.writeInt(referCount);
        dest.writeInt(firstDepositCount);
        dest.writeString(todayBonusAmount.toString());
        dest.writeString(bonusAmount.toString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

}

