package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.kzingsdk.requests.ApplyActivityAPI;
import com.kzingsdk.util.BigDecimalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class ActivityItem implements Parcelable {


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ActivityItem createFromParcel(Parcel in) {
            return new ActivityItem(in);
        }

        public ActivityItem[] newArray(int size) {
            return new ActivityItem[size];
        }
    };
    private RedirectType redirectType = RedirectType.ACTIVITY;
    private String actId;
    private ActivityType activityType;
    private ActivityType activityFrontType;
    private String actName;
    private String actDesc;
    private String content;
    private String cover;
    private String created;
    private boolean canJoin;
    private boolean isGift;
    private String show;
    private String redirectUrl = "";
    private String bgColor;
    private String fontColor;
    private String originalActTypeId;
    private ArrayList<String> groupNames = new ArrayList<>();
    private int displayOrder = 0;
    private long publishDate;
    private long expiredDate;
    private ActivityGift activityGift;
    private ActivityReferDpt activityReferDpt;//5009
    private ActivitySignIn7Days activitySignIn7Days;
    private boolean isPublic;
    private int applyStatus;
    private BigDecimal availableDptAmt;
    private boolean showProgressBar = false;
    private int applyPeriod = 0;
    private BigDecimal depositAmount = BigDecimal.ZERO;
    private BigDecimal fixBonusAmount = BigDecimal.ZERO;
    private boolean isPostPaidReward = false;
    private int expiredDays = 0;
    private long displayStartTime;
    private long displayEndTime;
    private String keyFeature;
    private HashSet<String> restrictedPlatform = new HashSet<>();
    private String currency;

    public ActivityItem() {

    }

    public ActivityItem(Parcel in) {
        actId = in.readString();
        actName = in.readString();
        actDesc = in.readString();
        content = in.readString();
        cover = in.readString();
        created = in.readString();
        canJoin = in.readInt() == 1;
        isGift = in.readInt() == 1;
        show = in.readString();
        Object[] objectArray = in.readArray(ActivityItem.class.getClassLoader());
        activityType = (ActivityType) objectArray[0];
        activityGift = (ActivityGift) objectArray[1];
        groupNames = (ArrayList<String>) objectArray[2];
        activityReferDpt = (ActivityReferDpt) objectArray[3];
        activityFrontType = (ActivityType) objectArray[4];
        activitySignIn7Days = (ActivitySignIn7Days) objectArray[5];
        restrictedPlatform = (HashSet<String>) objectArray[6];
        redirectUrl = in.readString();
        redirectType = RedirectType.valueOf(in.readString());
        displayOrder = in.readInt();
        publishDate = in.readLong();
        expiredDate = in.readLong();
        bgColor = in.readString();
        fontColor = in.readString();
        isPublic = in.readInt() == 1;
        applyStatus = in.readInt();
        availableDptAmt = new BigDecimal(in.readString());
        showProgressBar = in.readInt() == 1;
        applyPeriod = in.readInt();
        depositAmount = new BigDecimal(in.readString());
        fixBonusAmount = new BigDecimal(in.readString());
        isPostPaidReward = in.readInt() == 1;
        expiredDays = in.readInt();
        displayStartTime = in.readLong();
        displayEndTime = in.readLong();
        keyFeature = in.readString();
        currency = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(actId);
        dest.writeString(actName);
        dest.writeString(actDesc);
        dest.writeString(content);
        dest.writeString(cover);
        dest.writeString(created);
        dest.writeInt(canJoin ? 1 : 0);
        dest.writeInt(isGift ? 1 : 0);
        dest.writeString(show);
        dest.writeArray(new Object[]{
                activityType,
                activityGift,
                groupNames,
                activityReferDpt,
                activityFrontType,
                activitySignIn7Days,
                restrictedPlatform,
        });
        dest.writeString(redirectUrl);
        dest.writeString(redirectType.name().toUpperCase());
        dest.writeInt(displayOrder);
        dest.writeLong(publishDate);
        dest.writeLong(expiredDate);
        dest.writeString(bgColor);
        dest.writeString(fontColor);
        dest.writeInt(isPublic ? 1 : 0);
        dest.writeInt(applyStatus);
        dest.writeString(availableDptAmt.toString());
        dest.writeInt(showProgressBar ? 1 : 0);
        dest.writeInt(applyPeriod);
        dest.writeString(depositAmount.toString());
        dest.writeString(fixBonusAmount.toString());
        dest.writeInt(isPostPaidReward ? 1 : 0);
        dest.writeInt(expiredDays);
        dest.writeLong(displayStartTime);
        dest.writeLong(displayEndTime);
        dest.writeString(keyFeature);
        dest.writeString(currency);

    }


    public static ActivityItem newInstance(JSONObject rootObject) {
        ActivityItem item = new ActivityItem();
        item.setActId(rootObject.optString("actid"));
        item.setActivityType(ActivityType.newInstance(rootObject));
        item.setActivityFrontType(ActivityType.newFrontTypeInstance(rootObject));
        item.setActName(rootObject.optString("actname"));
        item.setActDesc(rootObject.optString("actdesc"));
        item.setContent(rootObject.optString("content"));
        item.setCover(rootObject.optString("cover"));
        item.setCreated(rootObject.optString("created"));
        item.setCurrency(rootObject.optString("currency"));
        item.setCanJoin(rootObject.optBoolean("canJoin"));
        item.setIsGift(rootObject.optBoolean("isGift"));
        item.setShow(rootObject.optString("show"));
        item.setDisplayOrder(rootObject.optInt("displayorder", 0));
        item.setRedirectType(RedirectType.valueOf(rootObject.optString("redirect_to").toUpperCase()));
        item.setRedirectUrl(rootObject.optString("redirect_url"));
        item.setBgColor(rootObject.optString("bgColor"));
        item.setFontColor(rootObject.optString("fontColor"));
        item.setOriginalActTypeId(rootObject.optString("originalacttypeid"));
        item.setPublishDate(rootObject.optLong("publishdate", 0L));
        item.setExpiredDate(rootObject.optLong("expireddate", 0L));
        item.setIsPublic(rootObject.optString("ispublic", "1").equalsIgnoreCase("1"));
        item.setApplyStatus(rootObject.optInt("applyStatus", 0));
        item.setAvailableDptAmt(BigDecimalUtil.optBigDecimal(rootObject, "available_dptAmt"));
        item.setDisplayStartTime(rootObject.optLong("displaystarttime"));
        item.setDisplayEndTime(rootObject.optLong("displayendtime"));
        item.setKeyFeature(rootObject.optString("keyfeature"));

        String restrictedPlatformArrayString = rootObject.optString("restricted_platform");
        String[] restrictedPlatformArray = restrictedPlatformArrayString.split(",");
        item.restrictedPlatform.addAll(Arrays.asList(restrictedPlatformArray));

        JSONArray groupNamesJSONArray = rootObject.optJSONArray("groupnames");
        for (int i = 0; i < groupNamesJSONArray.length(); i++) {
            item.getGroupNames().add(groupNamesJSONArray.optString(i));
        }
        JSONObject acDataJSONObject = rootObject.optJSONObject("ac_data");
        if (acDataJSONObject != null) {
            if (item.getOriginalActTypeId().equalsIgnoreCase("5009")) {
                item.setActivityReferDpt(ActivityReferDpt.newInstance(acDataJSONObject));
            }
            if (acDataJSONObject.optJSONArray("gift_requirement") != null) {
                item.setActivityGift(ActivityGift.newInstance(acDataJSONObject));
            }
            if (acDataJSONObject.optJSONArray("signin7days_requirement") != null) {
                item.setActivitySignIn7Days(ActivitySignIn7Days.newInstance(acDataJSONObject));
            }
            item.setShowProgressBar(acDataJSONObject.optString("progressbar", "0").equalsIgnoreCase("1"));
            item.setApplyPeriod(acDataJSONObject.optInt("apply_period", 1));
            JSONArray dptRequirementArray = acDataJSONObject.optJSONArray("dpt_requirement");
            if (dptRequirementArray != null && dptRequirementArray.length() > 0) {
                JSONObject dptRequirementObject = dptRequirementArray.optJSONObject(0);
                item.setDepositAmount(BigDecimalUtil.optBigDecimal(dptRequirementObject, "deposit_amount"));
                item.setFixBonusAmount(BigDecimalUtil.optBigDecimal(dptRequirementObject, "fix_bonus_amount"));
            }
            item.setIsPostPaidReward(acDataJSONObject.optString("ispostpaidreward", "0").equalsIgnoreCase("1"));
            item.setExpiredDays(acDataJSONObject.optInt("expireddays", 0));
        }
        return item;
    }


    private void setCanJoin(boolean canJoin) {
        this.canJoin = canJoin;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getActDesc() {
        return actDesc;
    }

    public void setActDesc(String actDesc) {
        this.actDesc = actDesc;
    }

    public String getActId() {
        return actId;
    }

    private void setActId(String actId) {
        this.actId = actId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public ArrayList<String> getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(ArrayList<String> groupNames) {
        this.groupNames = groupNames;
    }

    /**
     * @return {@link ApplyActivityAPI} will return error when it is false.
     */
    public boolean canJoin() {
        return canJoin;
    }

    /**
     * @return In HTML format for displaying in webview.
     */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return Banner URL of the activity.
     */
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCreated() {
        return created;
    }

    private void setCreated(String created) {
        this.created = created;
    }

    /**
     * @return Display words of current activity status of player.
     */
    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    /**
     * @return Group of the activity.
     */
    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    /**
     * @return Action of clicking the activity. Controlled by activity editor on CS backend.
     */
    public RedirectType getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(RedirectType redirectType) {
        this.redirectType = redirectType;
    }

    public ActivityType getActivityFrontType() {
        return activityFrontType;
    }

    public void setActivityFrontType(ActivityType activityFrontType) {
        this.activityFrontType = activityFrontType;
    }

    /**
     * @return Return an URL when {@link ActivityItem#getRedirectType} is {@link RedirectType#WEB}
     */
    public String getRedirectUrl() {
        if (redirectUrl.equals("")) {
            return redirectUrl;
        }
        if (!redirectUrl.startsWith("http://") && !redirectUrl.startsWith("https://")) {
            return "http://" + redirectUrl;
        }
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(long publishDate) {
        this.publishDate = publishDate;
    }

    public long getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(long expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getOriginalActTypeId() {
        return originalActTypeId;
    }

    public void setOriginalActTypeId(String originalActTypeId) {
        this.originalActTypeId = originalActTypeId;
    }

    public ActivityGift getActivityGift() {
        return activityGift;
    }

    public void setActivityGift(ActivityGift activityGift) {
        this.activityGift = activityGift;
    }

    public ActivitySignIn7Days getActivitySignIn7Days() {
        return activitySignIn7Days;
    }

    public void setActivitySignIn7Days(ActivitySignIn7Days activitySignIn7Days) {
        this.activitySignIn7Days = activitySignIn7Days;
    }

    public boolean isGift() {
        return isGift;
    }

    public void setIsGift(boolean gift) {
        isGift = gift;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public ActivityReferDpt getActivityReferDpt() {
        return activityReferDpt;
    }

    public void setActivityReferDpt(ActivityReferDpt activityReferDpt) {
        this.activityReferDpt = activityReferDpt;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public int getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(int applyStatus) {
        this.applyStatus = applyStatus;
    }

    public BigDecimal getAvailableDptAmt() {
        return availableDptAmt;
    }

    public void setAvailableDptAmt(BigDecimal availableDptAmt) {
        this.availableDptAmt = availableDptAmt;
    }

    public boolean isShowProgressBar() {
        return showProgressBar;
    }

    public void setShowProgressBar(boolean showProgressBar) {
        this.showProgressBar = showProgressBar;
    }

    public int getApplyPeriod() {
        return applyPeriod;
    }

    public void setApplyPeriod(int applyPeriod) {
        this.applyPeriod = applyPeriod;
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

    public boolean isPostPaidReward() {
        return isPostPaidReward;
    }

    public void setIsPostPaidReward(boolean postPaidReward) {
        isPostPaidReward = postPaidReward;
    }

    public int getExpiredDays() {
        return expiredDays;
    }

    public void setExpiredDays(int expiredDays) {
        this.expiredDays = expiredDays;
    }

    public long getDisplayStartTime() {
        return displayStartTime;
    }

    public void setDisplayStartTime(long displayStartTime) {
        this.displayStartTime = displayStartTime;
    }

    public long getDisplayEndTime() {
        return displayEndTime;
    }

    public void setDisplayEndTime(long displayEndTime) {
        this.displayEndTime = displayEndTime;
    }

    public String getKeyFeature() {
        return keyFeature;
    }

    public void setKeyFeature(String keyFeature) {
        this.keyFeature = keyFeature;
    }

    public HashSet<String> getRestrictedPlatform() {
        return restrictedPlatform;
    }

    public void setRestrictedPlatform(HashSet<String> restrictedPlatform) {
        this.restrictedPlatform = restrictedPlatform;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "ActivityItem{" +
                "redirectType=" + redirectType +
                ", actId='" + actId + '\'' +
                ", activityType=" + activityType +
                ", actName='" + actName + '\'' +
                ", actDesc='" + actDesc + '\'' +
                ", content='" + content + '\'' +
                ", cover='" + cover + '\'' +
                ", created='" + created + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", expiredDate='" + expiredDate + '\'' +
                ", canJoin=" + canJoin +
                ", show='" + show + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                ", displayOrder=" + displayOrder +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public enum RedirectType {
        ACTIVITY, WEB
    }

    public static class ActivityType implements Parcelable {

        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
            public ActivityType createFromParcel(Parcel in) {
                return new ActivityType(in);
            }

            public ActivityType[] newArray(int size) {
                return new ActivityType[size];
            }
        };
        private String actTypeId;
        private String actTypeName;
        private Integer displayOrder;

        public ActivityType() {

        }

        public ActivityType(Parcel in) {

            actTypeId = in.readString();
            actTypeName = in.readString();
            displayOrder = in.readInt();

        }

        public static ActivityType newInstance(JSONObject rootObject) {
            ActivityType item = new ActivityType();
            item.setActTypeId(rootObject.optString("actypeid"));
            item.setActTypeName(rootObject.optString("actypename"));
            item.setDisplayOrder(rootObject.optInt("displayorder"));
            return item;
        }

        public static ActivityType newFrontTypeInstance(JSONObject rootObject) {
            ActivityType item = new ActivityType();
            item.setActTypeId(rootObject.optString("fronttypeid"));
            item.setActTypeName(rootObject.optString("fronttypename"));
            item.setDisplayOrder(rootObject.optInt("fronttypedisplayorder"));
            return item;
        }

        public String getActTypeId() {
            return actTypeId;
        }

        public void setActTypeId(String actTypeId) {
            this.actTypeId = actTypeId;
        }

        public String getActTypeName() {
            return actTypeName;
        }

        public void setActTypeName(String actTypeName) {
            this.actTypeName = actTypeName;
        }

        public Integer getDisplayOrder() {
            return displayOrder;
        }

        public void setDisplayOrder(Integer displayOrder) {
            this.displayOrder = displayOrder;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(actTypeId);
            dest.writeString(actTypeName);
            dest.writeInt(displayOrder);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public String toString() {
            return "ActivityType{" +
                    "actTypeId='" + actTypeId + '\'' +
                    ", actTypeName='" + actTypeName + '\'' +
                    ", displayOrder='" + displayOrder + '\'' +
                    '}';
        }
    }


}