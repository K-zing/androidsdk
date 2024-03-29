package com.kzingsdk.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class RedPocketInfo implements Parcelable {

    public static final Creator CREATOR = new Creator() {
        public RedPocketInfo createFromParcel(Parcel in) {
            return new RedPocketInfo(in);
        }

        public RedPocketInfo[] newArray(int size) {
            return new RedPocketInfo[size];
        }
    };

    private Boolean hasRedPocketActivity = false;
    private Integer chance = 0;
    private Boolean isRedeemable = false;
    private String nextEventTime = "";
    private String floatingPosition = "";
    private String displayPage = "";
    private String displayType = "";
    private String notActiveReason = "";
    private String image = "";
    private String imgOption = "";
    private String isPublic = "";


    private Integer notActiveReasonCode = 0;
    private ArrayList<RedPocketTime> redPocketTimeList = new ArrayList<>();

    public RedPocketInfo() {

    }

    public RedPocketInfo(Parcel in) {
        hasRedPocketActivity = in.readInt() == 1;
        chance = in.readInt();
        isRedeemable = in.readInt() == 1;
        nextEventTime = in.readString();
        floatingPosition = in.readString();
        displayPage = in.readString();
        displayType = in.readString();
        notActiveReason = in.readString();
        image = in.readString();
        imgOption = in.readString();
        isPublic = in.readString();
        notActiveReasonCode = in.readInt();
        Object[] customObjects = in.readArray(RedPocketInfo.class.getClassLoader());
        redPocketTimeList = (ArrayList<RedPocketTime>) customObjects[0];
    }

    public static RedPocketInfo newInstance(JSONObject rootObject) {
        RedPocketInfo redPocketInfo = new RedPocketInfo();
        redPocketInfo.setHasRedPocketActivity(rootObject.optBoolean("hasRedPocketActivity"));
        redPocketInfo.setChance(rootObject.optInt("playerBalance"));
        redPocketInfo.setRedeemable(rootObject.optBoolean("active_rp_time"));
        redPocketInfo.setNextEventTime(rootObject.optString("next_event"));
        redPocketInfo.setFloatingPosition(rootObject.optString("floating_position", ""));
        redPocketInfo.setDisplayPage(rootObject.optString("display_page", ""));
        redPocketInfo.setDisplayType(rootObject.optString("display_type", ""));
        redPocketInfo.setNotActiveReason(rootObject.optString("not_active_reason"));
        redPocketInfo.setNotActiveReasonCode(rootObject.optInt("not_active_reason_code"));
        redPocketInfo.setIsPublic(rootObject.optString("ispublic"));

        JSONArray rpTimeArray = rootObject.optJSONArray("rpTime");
        if (rpTimeArray != null) {
            for (int i = 0; i < rpTimeArray.length(); i++) {
                redPocketInfo.redPocketTimeList.add(RedPocketTime.newInstance(rpTimeArray.optJSONObject(i)));

            }
        }
        JSONObject acDataObject = rootObject.optJSONObject("ac_data");
        if (acDataObject != null) {
            JSONObject rpActivityObject = acDataObject.optJSONObject("rp_activity");
            if (rpActivityObject != null) {
                redPocketInfo.setImage(rpActivityObject.optString("img_url"));
                redPocketInfo.setImgOption(rpActivityObject.optString("img_option"));
            }

        }
        return redPocketInfo;
    }

    public Boolean hasRedPocketActivity() {
        return hasRedPocketActivity;
    }

    public void setHasRedPocketActivity(Boolean hasRedPocketActivity) {
        this.hasRedPocketActivity = hasRedPocketActivity;
    }

    public Integer getChance() {
        return chance;
    }

    public void setChance(Integer chance) {
        this.chance = chance;
    }

    public Boolean isRedeemable() {
        return isRedeemable;
    }

    public void setRedeemable(Boolean redeemable) {
        isRedeemable = redeemable;
    }

    public String getNextEventTime() {
        return nextEventTime;
    }

    public void setNextEventTime(String nextEventTime) {
        this.nextEventTime = nextEventTime;
    }

    public String getFloatingPosition() {
        return floatingPosition;
    }

    public void setFloatingPosition(String floatingPosition) {
        this.floatingPosition = floatingPosition;
    }

    public String getDisplayPage() {
        return displayPage;
    }

    public void setDisplayPage(String displayPage) {
        this.displayPage = displayPage;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getNotActiveReason() {
        return notActiveReason;
    }

    public void setNotActiveReason(String notActiveReason) {
        this.notActiveReason = notActiveReason;
    }

    public Integer getNotActiveReasonCode() {
        return notActiveReasonCode;
    }

    public void setNotActiveReasonCode(Integer notActiveReasonCode) {
        this.notActiveReasonCode = notActiveReasonCode;
    }

    public ArrayList<RedPocketTime> getRedPocketTimeList() {
        return redPocketTimeList;
    }

    public void setRedPocketTimeList(ArrayList<RedPocketTime> redPocketTimeList) {
        this.redPocketTimeList = redPocketTimeList;
    }

    public String getImage() {
        return image;
    }

    public RedPocketInfo setImage(String image) {
        this.image = image;
        return this;
    }

    public String getImgOption() {
        return imgOption;
    }

    public RedPocketInfo setImgOption(String imgOption) {
        this.imgOption = imgOption;
        return this;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public RedPocketInfo setIsPublic(String isPublic) {
        this.isPublic = isPublic;
        return this;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(hasRedPocketActivity ? 1 : 0);
        dest.writeInt(chance);
        dest.writeInt(isRedeemable ? 1 : 0);
        dest.writeString(nextEventTime);
        dest.writeString(floatingPosition);
        dest.writeString(displayPage);
        dest.writeString(displayType);
        dest.writeString(notActiveReason);
        dest.writeString(image);
        dest.writeString(imgOption);
        dest.writeString(isPublic);
        dest.writeInt(notActiveReasonCode);
        Object[] customObjects = new Object[1];
        customObjects[0] = redPocketTimeList;
        dest.writeArray(customObjects);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "RedPocketInfo{" +
                "hasRedPocketActivity=" + hasRedPocketActivity +
                ", chance=" + chance +
                ", isRedeemable=" + isRedeemable +
                ", nextEventTime='" + nextEventTime + '\'' +
                '}';
    }
}

